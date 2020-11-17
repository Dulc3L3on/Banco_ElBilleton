/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Manejadores.DB;

import Modelo.Entidades.Cuenta;
import Modelo.Herramientas.Transformador;
import Modelo.ListaEnlazada;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author phily
 */
public class BuscadorParaCliente {
    Connection conexion = ManejadorDB.darConexion();
    Transformador transformador = new Transformador();
    
    public ListaEnlazada<Integer> buscarNumeroCuentasPropias(String codigoCliente){//puesto que se ejecuta desde la parte en la que está logueado el usuario...
        ListaEnlazada<Integer> listadoNumerosDeCuenta = new ListaEnlazada<>();
        String buscar ="SELECT * FROM Cuentas_Propias WHERE codigoDueno =  ?";
                
        try(PreparedStatement instrucciones = conexion.prepareStatement(buscar, ResultSet.TYPE_SCROLL_SENSITIVE, 
                ResultSet.CONCUR_UPDATABLE)){ 
            int codigoDelCliente = Integer.parseInt(codigoCliente);
            
            instrucciones.setInt(1, codigoDelCliente);
            
            transformador.transformarAListaDeNumerosCuenta(instrucciones.executeQuery(), listadoNumerosDeCuenta);
            return listadoNumerosDeCuenta;
        } catch (SQLException e) {
            System.out.println("Error al buscar numeros de cuentas PROPIAS: "+e.getMessage());
        }        
        return new ListaEnlazada<>();//pero jamás llegará aquí xd, pues el codigoDelCLiente, siempre que ahya apertirado
    }
    
    public ListaEnlazada<Integer> buscarCuentasDeTerceros(String codigoCliente){
        ListaEnlazada<Integer> listadoNumeroCuentasRelacionadas = new ListaEnlazada();//gracias a esta lista no habrá problema con el hecho de la existencia [o mejor dicho posesión] de cuentas para el cliente en cuestión xD
        
        buscarCuentasSolicitudesEnviadasAceptadas(listadoNumeroCuentasRelacionadas, codigoCliente);
        buscarCuentasSolicitudesRecibidasAceptadas(listadoNumeroCuentasRelacionadas, codigoCliente);
        
        return listadoNumeroCuentasRelacionadas;//así se devuelvenpor completo todas las otras cuentas asociadas al cliente en cuestión...
    }
    
    
    private void buscarCuentasSolicitudesEnviadasAceptadas(ListaEnlazada<Integer> listadoCuentas, String codigoCliente){
      String buscar ="SELECT * FROM Asociacion WHERE numeroCuentaSolicitante = ? AND estado = ?";
      
      try(PreparedStatement instrucciones = conexion.prepareStatement(buscar, ResultSet.TYPE_SCROLL_SENSITIVE, 
                ResultSet.CONCUR_UPDATABLE)){
          int codigoDelCliente = Integer.parseInt(codigoCliente);
          
          instrucciones.setInt(1, codigoDelCliente);
          instrucciones.setString(2, "aceptada");//también pudo colocarse directamente en la cadena que se empleará para hacer la búsqueda...
          
          transformador.transformarAListaDeNumerosCuenta(instrucciones.executeQuery(), listadoCuentas);                    
      } catch (SQLException e) {
           System.out.println("Error al buscar CUENTAS de solicitudes enviadas aceptadas: "+ e.getMessage());
      }           
    }
    
    private void buscarCuentasSolicitudesRecibidasAceptadas(ListaEnlazada<Integer> listadoCuentas, String codigoCliente){
      String buscar = "SELECT * FROM Asociacion WHERE numeroCuentaSolicitado = ? AND estado = ?";
    
      try(PreparedStatement instrucciones = conexion.prepareStatement(buscar, ResultSet.TYPE_SCROLL_SENSITIVE, 
                ResultSet.CONCUR_UPDATABLE)){
          int codigoDelCliente = Integer.parseInt(codigoCliente);
          
          instrucciones.setInt(1, codigoDelCliente);
          instrucciones.setString(2, "aceptada");//también pudo colocarse directamente en la cadena que se empleará para hacer la búsqueda...
          
          transformador.transformarAListaDeNumerosCuenta(instrucciones.executeQuery(), listadoCuentas);                    
      } catch (SQLException e) {
           System.out.println("Error al buscar CUENTAS de solicitudes enviadas aceptadas: "+ e.getMessage());
      }      
    }    
    
    public int buscarAsociacion(String numeroCuentaCLiente1, String numeroCuetnaCliente2, int posicionCliente1, int posicionCliente2){//1 cliente = solicitante, 2. cliente = solicitado...
        String[] tipoRelacion ={"numeroCuentaSolicitante", "numeroCuentaSolicitado"};                
        String buscar = "SELECT numeroIntentos FROM Asociacion WHERE "+ tipoRelacion[posicionCliente1] + " = ? AND "+tipoRelacion[posicionCliente2]+" = ?";
        
        try(PreparedStatement instrucciones = conexion.prepareStatement(buscar, ResultSet.TYPE_SCROLL_SENSITIVE, 
                ResultSet.CONCUR_UPDATABLE)){
            
            instrucciones.setInt(1, posicionCliente1);
            instrucciones.setInt(2, posicionCliente2);
            
            ResultSet resultado = instrucciones.executeQuery();
            resultado.first();
            return resultado.getInt(1);            
            
        }catch(SQLException e){
            System.out.println("Error al buscar la asociacion: "+ e.getMessage());
        }
        return -1;    
    }
    
}
