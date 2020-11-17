/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Herramientas;

import Modelo.Entidades.Cambio;
import Modelo.Entidades.Cuenta;
import Modelo.Entidades.Transaccion;
import Modelo.Entidades.Usuarios.Cajero;
import Modelo.Entidades.Usuarios.Cliente;
import Modelo.Entidades.Usuarios.Gerente;
import Modelo.ListaEnlazada;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
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
    
    public void transformarAListaDeNumerosCuenta(ResultSet resultado, ListaEnlazada<Integer> listadoNumeroCuentas){                
        try{
            resultado.first();
            
            while(resultado.next()){
                listadoNumeroCuentas.anadirAlFinal(resultado.getInt(1));
            }                       
        }catch(SQLException e){
            System.out.println("Error al transformar #Cuenta:"+e.getMessage());
        }    
    }//es decir que puede deolver: una lista vacía, una lista "a medias" y la lista completa de los números de cuenta... [la lista vacía solo sucedería cuando la lista recibida en los paráms, aún no haya recibido algo con anteioreidad.
    
    public List<Cambio> transformarAListaDeCambios(ResultSet resultado){
        List<Cambio> listadoDeCambios = new LinkedList<>();
        
        try{
            resultado.first();
            
            while(resultado.next()){
                listadoDeCambios.add(new Cambio(resultado.getString(1), resultado.getString(2), 
                        resultado.getInt(3), resultado.getString(4), resultado.getString(5), resultado.getString(6)));
            }                        
        }catch(SQLException sqlE){
            System.out.println("Error al transformar a LISTADO de cambios: "+ sqlE.getMessage());
        }
        return listadoDeCambios;
    }
    
     public List<Transaccion> transformarAListaDeTransacciones(ResultSet resultado){
        List<Transaccion> listadoDeCambios = new LinkedList<>();
        
        try{
            resultado.first();
            
            while(resultado.next()){
                listadoDeCambios.add(new Transaccion(resultado.getInt(1), resultado.getInt(2), resultado.getString(3),
                resultado.getInt(4), resultado.getString(5), resultado.getString(6), resultado.getInt(7)));
            }                        
        }catch(SQLException sqlE){
            System.out.println("Error al transformar a LISTADO de cambios: "+ sqlE.getMessage());
        }
        return listadoDeCambios;
    }
}
