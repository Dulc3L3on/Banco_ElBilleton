/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Manejadores.DB;

import Modelo.Entidades.Transaccion;
import Modelo.Herramientas.Conversor;
import Modelo.Kit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author phily
 */
public class Tramitador {
    private Connection conexion = ManejadorDB.darConexion();               
    private Conversor conversor = new Conversor();
    private Kit herramientas = new Kit();

    public Transaccion depositar(int codigoCajero, String numeroCuenta, String monto){
        String tramitar = "INSERT INTO Transaccion (codigo, numeroCuentaAfectada, "
                + "tipoTransaccion, monto, fecha, hora, codigoCajero) VALUES (?,?,?,?,?,?,?)";
        
        try(PreparedStatement instrucciones = conexion.prepareStatement(tramitar)){
            int numeroDeCuenta = Integer.parseInt(numeroCuenta);                 
            int montoDeposito = Integer.parseInt(monto);
            String hora = herramientas.darHoraActual();
            
            instrucciones.setInt(1, 12345);//codigo de la transaccion [autoIncre...]       
            instrucciones.setInt(2, numeroDeCuenta);
            instrucciones.setString(3, "credito");// == deposito [para el otro debes usar debito...]
            instrucciones.setInt(4, montoDeposito);
            instrucciones.setString(5, herramientas.darFechaActualString());
            instrucciones.setString(6, hora);
            instrucciones.setInt(7, codigoCajero);
            
            instrucciones.executeUpdate();
            return conversor.convertirATransaccion(codigoCajero, numeroDeCuenta, "deposito", montoDeposito, herramientas.darFechaActualString(), hora, codigoCajero);
            
        } catch (SQLException | NumberFormatException e) {
            System.out.println("Error al tramitar el deposito: " + e.getMessage());
        }
        return null;        
    }
    
}


