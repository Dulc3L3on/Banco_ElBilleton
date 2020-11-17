/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Herramientas;

import Modelo.Entidades.Cuenta;
import Modelo.Entidades.Usuarios.Cajero;
import Modelo.Entidades.Usuarios.Cliente;
import Modelo.Entidades.Usuarios.Gerente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author phily
 */
public class Transformador {
 
    public String transformarAContrasenia(ResultSet resultado){
    
        
        
        return null;
    }
    
    
    public Cliente transformarACliente(ResultSet resultado){
        try {
            resultado.first();
            
            return new Cliente(resultado.getInt(1),resultado.getString(2),
                    resultado.getString(3), resultado.getString(4), resultado.getString(5),
                    resultado.getString(6), resultado.getString(7), resultado.getString(8));
        } catch (SQLException ex) {
            System.out.println("Error al transformar a CLIENTE: "+ ex.getMessage());
        }        
        return null;
    }
    
    public Cajero transformarACajero(ResultSet resultado){
        try{
            resultado.first();
            
            return new Cajero(resultado.getInt(1), resultado.getString(2), resultado.getString(3),
                 resultado.getString(4), resultado.getString(5), resultado.getString(6), resultado.getString(7));
        }catch(SQLException ex){
            System.out.println("Error al transformar al CAJERO: "+ ex.getMessage());
        }
        return null;
    }

      public Gerente transformarAGerente(ResultSet resultado){
        try{
            resultado.first();
            
            return new Gerente(resultado.getInt(1), resultado.getString(2), resultado.getString(3),
                 resultado.getString(4), resultado.getString(5), resultado.getString(6), resultado.getString(7));
        }catch(SQLException ex){
            System.out.println("Error al transformar al GERENTE: "+ ex.getMessage());
        }
        return null;
    }
    
    /*DEPRECATED!!!*/
    public String[] transformarDatosCliente(ResultSet resultado){//deprecated xD al menos para la modificacion...
        String datosCliente[] = new String[8];//tendrá el mismo orden que en la DB [el cual es igual al constructor del CLiente]
        try {
            resultado.first();
            
            datosCliente[0] = String.valueOf(resultado.getInt(1));
            datosCliente[1] = resultado.getString(2);//nombre
            datosCliente[2] = resultado.getString(3);//CUI
            datosCliente[3] = resultado.getString(4);//pathDPI
            datosCliente[4] = resultado.getString(5);//direccion
            datosCliente[5] = resultado.getString(6);//sexo
            datosCliente[6] = resultado.getString(7);//password
            datosCliente[7] = resultado.getString(8);//birth
            
           return datosCliente;                    
        } catch (SQLException ex) {
            System.out.println("Error al transformar a CLIENTE: "+ ex.getMessage());
        } 
        return null;       
    }
    
    public Cuenta[] transformarACuentas(ResultSet resultado){
        Cuenta[] cuentas;
        
        try{
            resultado.last();
            
            cuentas = new Cuenta[resultado.getRow()];
            resultado.first();
            
            for (int cuentaActual = 0; cuentaActual < cuentas.length; cuentaActual++) {
                cuentas[cuentaActual] = new Cuenta(resultado.getInt(1), resultado.getInt(2), resultado.getInt(3), resultado.getString(4));
                
                resultado.next();
            }
            return cuentas;                
        } catch (SQLException e) {
            System.out.println("Error al transformar las CUENTAS: "+ e.getMessage());
        }
        return null;        
    }
}
