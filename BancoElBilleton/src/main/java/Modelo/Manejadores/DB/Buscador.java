/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Manejadores.DB;

import Modelo.Herramientas.Transformador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author phily
 */
public class Buscador {
    private Connection conexion = ManejadorDB.darConexion();     
    private Transformador transformador = new Transformador();
    
    /**
     * Va a traer la contraseña, según el codigo de 
     * usuario ingresado
     * @param codigoUsuario
     * @param tipoUsuario
     */
    public String buscarContrasenia(String codigoUsuario, String tipoUsuario){
        String buscar ="SELECT password FROM "+ tipoUsuario +" WHERE codigo = ?";
        
        try(PreparedStatement instrucciones = conexion.prepareStatement(buscar)){
            int codigo = Integer.parseInt(codigoUsuario);
            
            instrucciones.setInt(1, codigo);            
            
           return transformador.transformarAContrasenia(instrucciones.executeQuery());//así solo se ejeuctará si todo salió bien... xD
            
        }catch(SQLException SQLe){
            System.out.println("Error al buscar contraseña de usuario: "+ SQLe.getMessage());//Esto se informará con la pág de R// a quien se redirecciona por medio del doGet...
        }        
        return null;
    }
}
