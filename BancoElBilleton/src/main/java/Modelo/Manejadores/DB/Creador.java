/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Manejadores.DB;

import Modelo.Entidades.Cajero;
import Modelo.Herramientas.Conversor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author phily
 */
public class Creador {
    private Connection conexion = ManejadorDB.darConexion();               
    private Conversor conversor = new Conversor();
    
    public Cajero crearCajero(String datosUsuario[]){
        String crear ="INSERT INTO Cajero (codigo, nombre, DPI, direccion, sexo, password, turno) VALUES(?,?,?,?,?,?,?)";              
        
        try(PreparedStatement instrucciones = conexion.prepareStatement(crear)){            
            
            instrucciones.setInt(1, 126227);//codigo [sera eli]            
            instrucciones.setString(2, datosUsuario[0]);//nombre
            instrucciones.setString(3, datosUsuario[1]);//DPI
            instrucciones.setString(4, datosUsuario[2]);//direccion
            instrucciones.setString(5, datosUsuario[3]);//sexo
            instrucciones.setString(6, "contrasenia");//password [será susti, por lo que devuleva el método generador de contraseñas...]
            instrucciones.setString(7, datosUsuario[4]);//turno
            
            instrucciones.executeUpdate();
            return conversor.convertirACajero(datosUsuario, 12345, "contrasenia");
            
        }catch(SQLException sqlE){
            System.out.println("Error al crear el cajero: "+ sqlE.getMessage());            
        }                              
        return null;
    }//el valor que devolverá, será numérico, puesto que es autoincrementable, 
    //entonces para utilizar el mismo método de buscador para hallar la contraseña [al loguearse]...
    //lo harás luego de tener la carga de datos...
    
    public boolean crearCliente(){
    
        
        return false;
    }
    
    public boolean crearCuenta(){
    
        
        return false;
    }
    
}
