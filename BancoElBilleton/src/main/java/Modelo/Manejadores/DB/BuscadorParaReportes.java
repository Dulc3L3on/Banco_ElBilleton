/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Manejadores.DB;

import Modelo.Entidades.Cambio;
import Modelo.Entidades.Transaccion;
import Modelo.Herramientas.Transformador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author phily
 */
public class BuscadorParaReportes {
    Connection conexion = ManejadorDB.darConexion();
    Transformador transformador = new Transformador();
    
    public List<Cambio> buscarHistorialDeCambios(int codigoUsuario){
        String buscar = "SELECT * FROM Cambios_Cliente WHERE clienteCambiado = ?";
        
        try(PreparedStatement instrucciones = conexion.prepareStatement(buscar, 
                ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)){            
            
            instrucciones.setInt(1, codigoUsuario);           
            
            return transformador.transformarAListaDeCambios(instrucciones.executeQuery());                        
        } catch (SQLException ex) {
            System.out.println("Error al recuperar el LISTADO de CAMBIOS");
        }
        return null;//dudo que llegue aquí xD... eso serí lo mejor xD
    }
    
    public List<Transaccion> buscar15MasGrandes(int codigoCliente){
       String buscar ="SELECT * FROM Transaccion WHERE codigo = ? AND fecha BETWEEN 2019-01-01 AND 2019-12-31";
       
       try(PreparedStatement instrucciones = conexion.prepareStatement(buscar, 
                ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)){
           instrucciones.setInt(1, codigoCliente);
           
           return transformador.transformarAListaDeTransacciones(instrucciones.executeQuery());
           
       }catch(SQLException ex){
           System.out.println("Error al recuperar las 15 más grandes");
       }
       return null;
    }
}
