/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Manejadores.DB;

import Modelo.Entidades.Cambio;
import Modelo.Entidades.Cuenta;
import Modelo.Entidades.Usuarios.Cajero;
import Modelo.Entidades.Usuarios.Cliente;
import Modelo.Entidades.Usuarios.Gerente;
import Modelo.Herramientas.Transformador;
import Modelo.Kit;
import Modelo.ListaEnlazada;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author phily
 */
public class Buscador {
    private Connection conexion = ManejadorDB.darConexion();     
    private Transformador transformador = new Transformador();
    private Kit herramientas = new Kit();
    
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
    }//DEPRECATED!!!!
    
    public Cliente buscarCliente(String codigo){
        String buscar = "SELECT * FROM Cliente WHERE codigo = ?";
        
        try(PreparedStatement instrucciones = conexion.prepareStatement(buscar, ResultSet.TYPE_SCROLL_SENSITIVE, 
                        ResultSet.CONCUR_UPDATABLE)){//, Statement.RETURN_GENERATED_KEYS, esto va en creación xD
            int codigoCliente = Integer.parseInt(codigo);
            
            instrucciones.setInt(1, codigoCliente);            

            return transformador.transformarACliente(instrucciones.executeQuery());//no creo que se salte la revisión de la excepción al colocarlo así...
            
        }catch(SQLException | NumberFormatException e){
            System.out.println("Error al buscar al CLIENTE: "+ e.getMessage());
        }
        return null;
    }
    
    public Cajero buscarCajero(String codigo){
        String buscar = "SELECT * FROM Cajero WHERE codigo = ?";
        
        try(PreparedStatement instrucciones = conexion.prepareStatement(buscar, ResultSet.TYPE_SCROLL_SENSITIVE, 
                        ResultSet.CONCUR_UPDATABLE)){
            
            int codigoCliente = Integer.parseInt(codigo);
            
            instrucciones.setInt(1, codigoCliente);
            return transformador.transformarACajero(instrucciones.executeQuery());
            
        }catch(SQLException | NumberFormatException e){
            System.out.println("Error al buscar al CAJERO: "+ e.getMessage());
        }
        return null;
    }
    
    public Gerente buscarGerente(String codigo){
        String buscar = "SELECT * FROM Gerente WHERE codigo = ?";
        
        try(PreparedStatement instrucciones = conexion.prepareStatement(buscar, ResultSet.TYPE_SCROLL_SENSITIVE, 
                        ResultSet.CONCUR_UPDATABLE)){
            
            int codigoGerente = Integer.parseInt(codigo);
            
            instrucciones.setInt(1, codigoGerente);
            return transformador.transformarAGerente(instrucciones.executeQuery());
            
        }catch(SQLException | NumberFormatException e){
            System.out.println("Error al buscar al GERENTE: "+ e.getMessage());
        }
        return null;
    }
    
    public ListaEnlazada<Cambio> buscarHistorialCambiosCliente(int codigo, int codigoGerente){
        String buscar ="SELECT * FROM Cambios_Cliente WHERE codigoCliente = ? AND gerenteACargo = ? AND fecha = "+ herramientas.darFechaActualString();
        
        try(PreparedStatement instrucciones = conexion.prepareStatement(buscar, ResultSet.TYPE_SCROLL_SENSITIVE, 
                        ResultSet.CONCUR_UPDATABLE)){
         
            instrucciones.setInt(1, codigo);
            instrucciones.setInt(2, codigoGerente);
            
            instrucciones.executeQuery();
            
        } catch (SQLException ex) {
            Logger.getLogger(Buscador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public int buscarCodigoDueno(String numeroCuenta){
        String buscar = "SELECT codigoDueno FROM Cuentas_Propias WHERE numeroCuenta = ?";
        
        try(PreparedStatement instrucciones = conexion.prepareStatement(buscar, ResultSet.TYPE_SCROLL_SENSITIVE, 
                        ResultSet.CONCUR_UPDATABLE)){
        
            int numeroDeCuenta = Integer.parseInt(numeroCuenta);
            
            instrucciones.setInt(1, numeroDeCuenta);
            
            ResultSet resultado = instrucciones.executeQuery();
            
            resultado.first();
            return resultado.getInt(1);
            
        } catch (SQLException | NumberFormatException e) {
            System.out.println("Error al buscar código del dueño a partir del #Cta:" + e.getMessage());
        }
        return 0;    
    } 
    
    public int buscarSaldoActual(String numeroCuenta){
        String buscar ="SELECT monto FROM Cuentas_Propias WHERE numeroCuenta = ?";
        
        try(PreparedStatement instrucciones = conexion.prepareStatement(buscar, ResultSet.TYPE_SCROLL_SENSITIVE, 
                        ResultSet.CONCUR_UPDATABLE)){
            int numeroDeCuenta = Integer.parseInt(numeroCuenta);
            
            instrucciones.setInt(1, numeroDeCuenta);
            
            ResultSet resultado = instrucciones.executeQuery();
            
            resultado.first();
            return resultado.getInt(1);//como solo extraje 1 columna entonces por eso puedo hacerlo así, sino, tendría que saber las posiciones en las que se encuentran... es proceso de siempre xD                        
            
        } catch (SQLException | NumberFormatException e) {
            System.out.println("Error al buscar SALDO ACTUAL: "+ e.getMessage());
        }
        return -1;    
    }
    
    public Cliente buscarClienteSolicitanteRetiro(String CUI){
        String buscar = "SELECT * FROM Cliente WHERE DPI = ?";
        
        try(PreparedStatement instrucciones = conexion.prepareStatement(buscar, ResultSet.TYPE_SCROLL_SENSITIVE, 
                        ResultSet.CONCUR_UPDATABLE)){//, Statement.RETURN_GENERATED_KEYS, esto va en creación xD
            int dpi = Integer.parseInt(CUI);
            
            instrucciones.setInt(1, dpi);            

            return transformador.transformarACliente(instrucciones.executeQuery());//no creo que se salte la revisión de la excepción al colocarlo así...
            
        }catch(SQLException | NumberFormatException e){
            System.out.println("Error al buscar al SOLICITANTE de RETIRO: "+ e.getMessage());
        }
        return null;
    }
    
    public Cuenta[] buscarCuentas(int codigoCliente){
        String buscar="SELECT * FROM Cuentas_Propias WHERE codigoDueno = ?";
        
        try(PreparedStatement instrucciones = conexion.prepareStatement(buscar, ResultSet.TYPE_SCROLL_SENSITIVE, 
                ResultSet.CONCUR_UPDATABLE)){
            instrucciones.setInt(1, codigoCliente);           
            
            return transformador.transformarACuentas(instrucciones.executeQuery());
            
        }catch (SQLException e) {
            System.out.println("Error al buscar las cuentas del SOLICITANTE de RETIRO"+ e.getMessage());
        }
        return null;        
    }//si lo hubieras pensado un poco más te hubieras dado cuenta que hubiera sioo mejor devolver una lista, por el hecho de que esto mismo sería necesitado después, pero por esto te diste cuetna que requieres 1 buscador para lo que necesiten los trabajadores y uno para lo que necesite el cliente...   
  
    
}
