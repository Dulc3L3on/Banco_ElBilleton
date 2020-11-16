/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Manejadores.DB;

import Modelo.Entidades.Usuarios.Cajero;
import Modelo.Entidades.Usuarios.Cliente;
import Modelo.Entidades.Usuarios.Gerente;
import Modelo.Herramientas.Conversor;
import Modelo.Kit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author phily
 */
public class Actualizador {
    private Connection conexion = ManejadorDB.darConexion();  
    private Conversor conversor = new Conversor();
    private Kit herramienta = new Kit();
        
    public boolean actualizarCliente(String[] datos, Cliente clienteAntiguo){
        String actualizar="INSERT INTO Cliente(codigo, nombre, DPI, pathDPI, direccion, sexo, password)"
        + " VALUES(?,?,?,?,?,?,?) ON DUPLICATE KEY UPDATE nombre = ?, pathDPI = ?, direccion = ?, password = ?";
        
        try(PreparedStatement instrucciones = conexion.prepareStatement(actualizar)){                        
            String encripatada = herramienta.encriptarContrasenia(datos[3]);
            
            instrucciones.setInt(1, clienteAntiguo.darCodigo());
            instrucciones.setString(2, datos[0]);
            instrucciones.setString(3, clienteAntiguo.darDPI());
            instrucciones.setString(4, datos[1]);
            instrucciones.setString(5, datos[2]);
            instrucciones.setString(6, clienteAntiguo.darSexo());
            instrucciones.setString(7, encripatada);//si implementas lo de la contra alea, np habrá problema, puesto que antes de entra aquí reemplazo el dato [que era = a lo que estaba en el input...]
            instrucciones.setString(8, datos[0]);
            instrucciones.setString(9, datos[1]);
            instrucciones.setString(10, datos[2]);
            instrucciones.setString(11, encripatada);
            
            instrucciones.executeUpdate();
            return true;            
        }catch(SQLException | NumberFormatException e){
            System.out.println("Error al actualizar al CLIENTE: "+ e.getMessage());
        }                
        return false;
    }
    
    public boolean actualizarCajero(String[] datos, Cajero cajeroAntiguo){
        String actualizar="INSERT INTO Cajero(codigo, nombre, DPI, direccion, sexo, password, turno)"
                + "VALUES (?,?,?,?,?,?,?) ON DUPLICATE KEY UPDATE nombre = ?, direccion = ?, password = ?, turno = ?";
        
        try(PreparedStatement instrucciones = conexion.prepareStatement(actualizar)){
            String encripatada = herramienta.encriptarContrasenia(datos[2]);
            
            instrucciones.setInt(1, cajeroAntiguo.darCodigo());//codigo
            instrucciones.setString(2, datos[0]);//nombre
            instrucciones.setString(3, cajeroAntiguo.darDPI());//DPI
            instrucciones.setString(4, datos[1]);//direccion
            instrucciones.setString(5, cajeroAntiguo.darSexo());//sexo
            instrucciones.setString(6, encripatada);//password
            instrucciones.setString(7, datos[3]);//turno
            instrucciones.setString(8, datos[0]);//nombre
            instrucciones.setString(9, datos[1]);//direccion
            instrucciones.setString(10, encripatada);//password
            instrucciones.setString(11, datos[3]);//turno
            
            instrucciones.executeUpdate();
            return true;            
        }catch(SQLException | NumberFormatException e){
            System.out.println("Error al actualizar al Cajero: " + e.getMessage());
        }
        return false;
    }
    
    public boolean actualizarGerente(String[] datos, Gerente gerenteAntiguo){
          String actualizar="INSERT INTO Gerente(codigo, nombre, DPI, direccion, sexo, password, turno)"
                + "VALUES (?,?,?,?,?,?,?) ON DUPLICATE KEY UPDATE nombre = ?, direccion = ?, password = ?, turno = ?";
        
        try(PreparedStatement instrucciones = conexion.prepareStatement(actualizar)){
            String encripatada = herramienta.encriptarContrasenia(datos[2]);
            
            instrucciones.setInt(1, gerenteAntiguo.darCodigo());//codigo
            instrucciones.setString(2, datos[0]);//nombre
            instrucciones.setString(3, gerenteAntiguo.darDPI());//DPI
            instrucciones.setString(4, datos[1]);//direccion
            instrucciones.setString(5, gerenteAntiguo.darSexo());//sexo
            instrucciones.setString(6, encripatada);//password
            instrucciones.setString(7, datos[3]);//turno
            instrucciones.setString(8, datos[0]);//nombre
            instrucciones.setString(9, datos[1]);//direccion
            instrucciones.setString(10, encripatada);//password
            instrucciones.setString(11, datos[3]);//turno
            
            instrucciones.executeUpdate();
            return true;            
        }catch(SQLException | NumberFormatException e){
            System.out.println("Error al actualizar al Cajero: " + e.getMessage());
        }
        return false;
    }
    
    
    //al actualizar al gerente también debes encripar la contra que ingresse y recuerd desencripat al momento de mosntrar en los campos del PERIL!!!
    //es decri para algunoa casos [cliente y cajero] en la pantalla de modificacion...
}
    //Ahí revisas el método de desencripatación que se incorporó a las modificaciones...