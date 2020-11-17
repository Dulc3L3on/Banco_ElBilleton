/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Manejadores.DB;

import Modelo.Entidades.Cuenta;
import Modelo.Entidades.Usuarios.Cajero;
import Modelo.Entidades.Usuarios.Cliente;
import Modelo.Entidades.Usuarios.Gerente;
import Modelo.Herramientas.Conversor;
import Modelo.Kit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author phily
 */
public class Creador {
    private Connection conexion = ManejadorDB.darConexion();               
    private Conversor conversor = new Conversor();
    private Kit herramientas = new Kit();
    
    public Cajero crearCajero(String datosUsuario[]){
        String crear ="INSERT INTO Cajero (nombre, DPI, direccion, sexo, password, turno) VALUES(?,?,?,?,?,?)";              
        String contrasenia = "contrasenia";
        
        try(PreparedStatement instrucciones = conexion.prepareStatement(crear, Statement.RETURN_GENERATED_KEYS)){                        
                      
            instrucciones.setString(1, datosUsuario[0]);//nombre
            instrucciones.setString(2, datosUsuario[1]);//DPI
            instrucciones.setString(3, datosUsuario[2]);//direccion
            instrucciones.setString(4, datosUsuario[3]);//sexo
            instrucciones.setString(5, herramientas.encriptarContrasenia(contrasenia));//password [será susti, por lo que devuleva el método generador de contraseñas...]
            instrucciones.setString(6, datosUsuario[4]);//turno
            
            instrucciones.executeUpdate();//Recuerda que debes recueprar el numero de código y la contra la obtendrás del método que se encarga de generarla aleatoriamente...

            ResultSet resultado = instrucciones.getGeneratedKeys();
            resultado.first();
            return conversor.convertirACajero(datosUsuario, resultado.getInt(1), contrasenia);//Esta sería la desencriptada...
            
        }catch(SQLException sqlE){
            System.out.println("Error al crear el cajero: "+ sqlE.getMessage());            
        }                              
        return null;
    }//el valor que devolverá, será numérico, puesto que es autoincrementable, 
    //entonces para utilizar el mismo método de buscador para hallar la contraseña [al loguearse]...
    //lo harás luego de tener la carga de datos...
    
    public Cliente crearCliente(String datosUsuario[], String path){
        String crear = "INSERT INTO Cliente (nombre, DPI, pathDPI, direccion, sexo, password, birth) VALUES(?,?,?,?,?,?,?)";
        String contrasenia = "password";//Aquí el método para generarlas aleatoriamente xD
        
        try(PreparedStatement instrucciones = conexion.prepareStatement(crear, Statement.RETURN_GENERATED_KEYS)){            
            instrucciones.setString(1,datosUsuario[0]);
            instrucciones.setString(2,datosUsuario[1]);
            instrucciones.setString(3, path);//este será el nombre del documento, el cual agregarás a la dirección en la que se almacenan todos los DPI, por lo cual podrás obtener el que corresponde, media vez obtengas este nombre... xD, depkano que se tendrá que agarrar luego de haberlo "subido" al servidor... entonces piensa como vas a llamar al servlet subidor...
            instrucciones.setString(4, datosUsuario[2]);
            instrucciones.setString(5, datosUsuario[3]);
            instrucciones.setString(6, herramientas.encriptarContrasenia(contrasenia));
            instrucciones.setString(7, datosUsuario[4]);            
            
            instrucciones.executeUpdate();
            
            ResultSet resultado = instrucciones.getGeneratedKeys();
            resultado.first();
            return conversor.convertirACliente(datosUsuario, resultado.getInt(1), contrasenia, path);
            
        }catch(SQLException sqlE){
            System.out.println("Error al crear el cliente: "+ sqlE.getMessage());           
        }                
        return null;
    }  
    
    public Gerente crearGerente(String datosUsuario[]){
        String crear = "INSERT INTO Gerente (nombre, DPI, direccion, sexo, password, turno) VALUES(?,?,?,?,?,?)";
        String contrasenia = "pass";
        
        try(PreparedStatement instrucciones = conexion.prepareStatement(crear, Statement.RETURN_GENERATED_KEYS)){                        
                      
            instrucciones.setString(1, datosUsuario[0]);//nombre
            instrucciones.setString(2, datosUsuario[1]);//DPI
            instrucciones.setString(3, datosUsuario[2]);//direccion
            instrucciones.setString(4, datosUsuario[3]);//sexo
            instrucciones.setString(5, herramientas.encriptarContrasenia(contrasenia));//password [será susti, por lo que devuleva el método generador de contraseñas...]
            instrucciones.setString(6, datosUsuario[4]);//turno
            
            instrucciones.executeUpdate();
            
            ResultSet resultado = instrucciones.getGeneratedKeys();
            resultado.first();
            return conversor.convertirAGerente(datosUsuario, resultado.getInt(1), contrasenia);
            
        }catch(SQLException sqlE){
            System.out.println("Error al crear el gerente: "+ sqlE.getMessage());
        }
        return null;
    }
    
    /**
     * Se ejecutará luego de recuperar el usauri al que le 
     * pertenece el #cuenta en el JSP, para así devolver el
     * # de cuenta que tendrá la cta... y así evitar errores
     * de #cta iguales...
     * @param codigoDueno
     * @return
     */
    public int reservarEspacioCuenta(int codigoDueno){
        String crearReserva = "INSERT INTO Cuentas_Propias (codigoDueno) VALUES(?)";
        
        try(PreparedStatement instrucciones = conexion.prepareStatement(crearReserva, Statement.RETURN_GENERATED_KEYS)){                                                            
            instrucciones.setInt(1, codigoDueno);
            
            instrucciones.executeUpdate();
            ResultSet resultado= instrucciones.getGeneratedKeys();            
            resultado.first();
            return resultado.getInt(1);//se devuleve el #cuenta...*///hasta que sea autoIncre...                      
        }catch(SQLException sqlE){
            System.out.println("Error al completar la creacion de la cuenta: "+ sqlE.getMessage());           
        }              
        return 0;
    }
    
    /**
     *Método usado luego de haber recuperado los datos del 
     * cliente existende y de haber creado la reserva de espacio
     * para la cuenta en cuestión...[donde dichos procesos previos
     * se realizan en el JSP] y este en el servlet... 
     * @param datosCuenta     
     * @return
     */
    public Cuenta crearCuentaCompleta(String datosCuenta[]){
        String crear = "INSERT INTO Cuentas_Propias(numeroCuenta, codigoDueno, monto, fechaCreacion)"
            + " VALUES(?,?,?,?) ON DUPLICATE KEY UPDATE monto = ?, fechaCreacion = ?";//Creo que necesito AA DD MM... ahí revisas... sino toca cb...
        
        try(PreparedStatement instrucciones = conexion.prepareStatement(crear)){            
            int codigoDueno = Integer.parseInt(datosCuenta[0]);
            int numeroCuenta = Integer.parseInt(datosCuenta[1]);
            int monto = Integer.parseInt(datosCuenta[2]);
            String fecha = herramientas.darFechaActualString();                                   
            
            instrucciones.setInt(1, numeroCuenta);
            instrucciones.setInt(2, codigoDueno);
            instrucciones.setInt(3, monto);
            instrucciones.setString(4,fecha);
            instrucciones.setInt(5, monto);
            instrucciones.setString(6,fecha);
            
            instrucciones.executeUpdate();
            return conversor.convertirACuenta(numeroCuenta, codigoDueno, monto, fecha);
            
        }catch(SQLException sqlE){
            System.out.println("Error al completar la creacion de la cuenta: "+ sqlE.getMessage());           
        }catch(NumberFormatException e){
            System.out.println("Error al convertir el #Cta: "+ e.getMessage());
        }
        return null;
    }
    /*EN el JSP pues
     * creo que hara menos extenso el proceso y el cuerpo del servlet 
     * de cta, si es que se puede poner un switch y exe 1 de los 2 procesos que puede hacer...
     * [aunque podrías usar el get...] pero la cuestión es la llenada de los datos
     * recuperados para que pueda continuar con la creación... SI se hará en el JSP xD*/
    
}
