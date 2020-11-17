/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Manejadores.DB;

import Modelo.Entidades.Cambio;
import Modelo.Entidades.Transaccion;
import Modelo.Herramientas.Conversor;
import Modelo.Kit;
import Modelo.ListaEnlazada;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author phily
 */
public class Registrador {
    private Connection conexion = ManejadorDB.darConexion();               
    private Kit herramientas = new Kit();
    Conversor conversor = new Conversor();
    ListaEnlazada<Cambio> listaCambiosAgregados = new ListaEnlazada<>();
    ListaEnlazada<Cambio> listaCambiosErrados = new ListaEnlazada<>();  
    ListaEnlazada<ListaEnlazada<Cambio>> listadoDeListados = new ListaEnlazada<>();
    
    public void registrarCambioCliente(int codigoGerente, String tipoCambio, String datoAntiguo, String nuevoDato, int codigoClienteCambiado){       
        String hora = herramientas.darHoraActual();
        String registrar = "INSERT INTO Cambios_Cliente (fecha, hora, gerenteACargo, tipoDeCambio, clienteCambiado, datoAnterior, datoNuevo)"
                + " VALUES (?,?,?,?,?,?,?)";
        
        try(PreparedStatement instrucciones = conexion.prepareStatement(registrar)){            
            instrucciones.setString(1, herramientas.darFechaActualString());//fecha
            instrucciones.setString(2,hora);//hora
            instrucciones.setInt(3, codigoGerente);//codigo Gerente
            instrucciones.setString(4, tipoCambio);//tipo cambio
            instrucciones.setInt(5, codigoClienteCambiado);//codigo entidad cambiada...
            instrucciones.setString(6, datoAntiguo);//dato antiguo
            instrucciones.setString(7, nuevoDato);//datoNuevo            
            
            instrucciones.executeUpdate();
            listaCambiosAgregados.anadirAlFinal(new Cambio(herramientas.darFechaActualString(), hora, codigoGerente, tipoCambio, datoAntiguo, nuevoDato));
            
        }catch(SQLException | NumberFormatException e){
            System.out.println("Error al registrar cambios del cliente: "+ e.getMessage());
            listaCambiosErrados.anadirAlFinal(new Cambio(herramientas.darFechaActualString(), hora, codigoGerente, tipoCambio, datoAntiguo, nuevoDato));
        }
    }
    
    public void registrarCambioCajero(int codigoGerente, String tipoCambio, String datoAntiguo, String nuevoDato, int codigoCajeroCambiado){
    String hora = herramientas.darHoraActual();
        String registrar = "INSERT INTO Cambios_Cajero (fecha, hora, gerenteACargo, tipoDeCambio, cajeroCambiado, datoAnterior, datoNuevo)"
                + " VALUES (?,?,?,?,?,?,?)";
        
        try(PreparedStatement instrucciones = conexion.prepareStatement(registrar)){            
            instrucciones.setString(1, herramientas.darFechaActualString());//fecha
            instrucciones.setString(2,hora);//hora
            instrucciones.setInt(3, codigoGerente);//codigo Gerente
            instrucciones.setString(4, tipoCambio);//tipo cambio
            instrucciones.setInt(5, codigoCajeroCambiado);//codigo entidad cambiada...
            instrucciones.setString(6, datoAntiguo);//dato antiguo
            instrucciones.setString(7, nuevoDato);//datoNuevo            
            
            instrucciones.executeUpdate();
            listaCambiosAgregados.anadirAlFinal(new Cambio(herramientas.darFechaActualString(), hora, codigoGerente, tipoCambio, datoAntiguo, nuevoDato));
            
        }catch(SQLException | NumberFormatException e){
            System.out.println("Error al registrar cambios del cliente: "+ e.getMessage());
            listaCambiosErrados.anadirAlFinal(new Cambio(herramientas.darFechaActualString(), hora, codigoGerente, tipoCambio, datoAntiguo, nuevoDato));
        }
    }
    
    public void registrarCambioGerente(int codigoGerente, String tipoCambio, String datoAntiguo, String nuevoDato){
     String hora = herramientas.darHoraActual();
        String registrar = "INSERT INTO Cambios_Gerente (fecha, hora, codigoGerente, tipoDeCambio, datoAnterior, datoNuevo)"
                + " VALUES (?,?,?,?,?,?)";
        
        try(PreparedStatement instrucciones = conexion.prepareStatement(registrar)){            
            instrucciones.setString(1, herramientas.darFechaActualString());//fecha
            instrucciones.setString(2,hora);//hora
            instrucciones.setInt(3, codigoGerente);//codigo Gerente
            instrucciones.setString(4, tipoCambio);//tipo cambio            
            instrucciones.setString(5, datoAntiguo);//dato antiguo
            instrucciones.setString(6, nuevoDato);//datoNuevo            
            
            instrucciones.executeUpdate();
            listaCambiosAgregados.anadirAlFinal(new Cambio(herramientas.darFechaActualString(), hora, codigoGerente, tipoCambio, datoAntiguo, nuevoDato));
            
        }catch(SQLException | NumberFormatException e){
            System.out.println("Error al registrar cambios del cliente: "+ e.getMessage());
            listaCambiosErrados.anadirAlFinal(new Cambio(herramientas.darFechaActualString(), hora, codigoGerente, tipoCambio, datoAntiguo, nuevoDato));
        }
    }
    
    public Transaccion registrarTrasaccion(int codigoCajero, String numeroCuenta, String monto, String tipo){
    String registrar = "INSERT INTO Transaccion (codigo, numeroCuentaAfectada, "
                + "tipoTransaccion, monto, fecha, hora, codigoCajero) VALUES (?,?,?,?,?,?,?)";
        
        try(PreparedStatement instrucciones = conexion.prepareStatement(registrar)){
            int numeroDeCuenta = Integer.parseInt(numeroCuenta);                 
            int montoDeposito = Integer.parseInt(monto);
            String hora = herramientas.darHoraActual();
            
            instrucciones.setInt(1, 1247773);//codigo de la transaccion [autoIncre...]       
            instrucciones.setInt(2, numeroDeCuenta);
            instrucciones.setString(3, tipo);// == deposito [para el otro debes usar debito...]
            instrucciones.setInt(4, montoDeposito);
            instrucciones.setString(5, herramientas.darFechaActualString());
            instrucciones.setString(6, hora);
            instrucciones.setInt(7, codigoCajero);
            
            instrucciones.executeUpdate();
            return conversor.convertirATransaccion(1247773, numeroDeCuenta, "deposito", montoDeposito, herramientas.darFechaActualString(), hora, codigoCajero);
            
        } catch (SQLException | NumberFormatException e) {
            System.out.println("Error al REGISTRAR el deposito: " + e.getMessage());
        }
        return null;        
    }
    
    public ListaEnlazada<ListaEnlazada<Cambio>> darListaDeListados(){
        if(!listaCambiosAgregados.estaVacia()){
            listadoDeListados.anadirAlFinal(listaCambiosAgregados);
        }
        if(!listaCambiosErrados.estaVacia()){
            listadoDeListados.anadirAlFinal(listaCambiosErrados);
        }              
        return listadoDeListados;
    }
    
    public ListaEnlazada<Cambio> darListaAgregados(){
        return listaCambiosAgregados;
    }
    
    public ListaEnlazada<Cambio> darListaErrados(){
        return listaCambiosErrados;
    }  
    
}
