/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Manejadores.DB;

import Modelo.Entidades.Cambio;
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
    ListaEnlazada<Cambio> listaCambiosAgregados = new ListaEnlazada<>();
    ListaEnlazada<Cambio> listaCambiosErrados = new ListaEnlazada<>();  
    ListaEnlazada<ListaEnlazada<Cambio>> listadoDeListados = new ListaEnlazada<>();
    
    public void registrarCambioCliente(int codigoGerente, String tipoCambio, String datoAntiguo, String nuevoDato, int codigoEntidadCambiada){       
        String hora = herramientas.darHoraActual();
        String registrar = "INSERT INTO Cambios_Cliente (fecha, hora, gerenteACargo, tipoDeCambio, clienteCambiado, datoAnterior, datoNuevo)"
                + " VALUES (?,?,?,?,?,?,?)";
        
        try(PreparedStatement instrucciones = conexion.prepareStatement(registrar)){            
            instrucciones.setString(1, herramientas.darFechaActualString());//fecha
            instrucciones.setString(2,hora);//hora
            instrucciones.setInt(3, codigoGerente);//codigo Gerente
            instrucciones.setString(4, tipoCambio);//tipo cambio
            instrucciones.setInt(5, codigoEntidadCambiada);//codigo entidad cambiada...
            instrucciones.setString(6, datoAntiguo);//dato antiguo
            instrucciones.setString(7, nuevoDato);//datoNuevo            
            
            instrucciones.executeUpdate();
            listaCambiosAgregados.anadirAlFinal(new Cambio(herramientas.darFechaActualString(), hora, codigoGerente, tipoCambio, datoAntiguo, nuevoDato));
            
        }catch(SQLException | NumberFormatException e){
            System.out.println("Error al registrar cambios del cliente: "+ e.getMessage());
            listaCambiosErrados.anadirAlFinal(new Cambio(herramientas.darFechaActualString(), hora, codigoGerente, tipoCambio, datoAntiguo, nuevoDato));
        }
    }
    
    public void registrarCambioCajero(){
    
    }
    
    public void registrarCambioGerente(){
    
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
