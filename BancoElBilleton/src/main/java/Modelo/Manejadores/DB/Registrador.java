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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
    String registrar = "INSERT INTO Transaccion (numeroCuentaAfectada, "
                + "tipoTransaccion, monto, fecha, hora, codigoCajero) VALUES (?,?,?,?,?,?)";
        
        try(PreparedStatement instrucciones = conexion.prepareStatement(registrar, Statement.RETURN_GENERATED_KEYS)){
            int numeroDeCuenta = Integer.parseInt(numeroCuenta);                 
            int montoDeposito = Integer.parseInt(monto);
            String hora = herramientas.darHoraActual();            
                
            instrucciones.setInt(1, numeroDeCuenta);
            instrucciones.setString(2, tipo);// == deposito [para el otro debes usar debito...]
            instrucciones.setInt(3, montoDeposito);
            instrucciones.setString(4, herramientas.darFechaActualString());
            instrucciones.setString(5, hora);
            instrucciones.setInt(6, codigoCajero);
            
            instrucciones.executeUpdate();
            
            ResultSet resultado= instrucciones.getGeneratedKeys();            
            resultado.first();
            return conversor.convertirATransaccion(resultado.getInt(1), numeroDeCuenta, "deposito", montoDeposito, herramientas.darFechaActualString(), hora, codigoCajero);
            
        } catch (SQLException | NumberFormatException e) {
            System.out.println("Error al REGISTRAR el"+ tipo +":"  + e.getMessage());
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
