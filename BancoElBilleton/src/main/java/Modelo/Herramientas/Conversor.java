/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Herramientas;

import Modelo.Entidades.Cuenta;
import Modelo.Entidades.Transaccion;
import Modelo.Entidades.Usuarios.Cajero;
import Modelo.Entidades.Usuarios.Cliente;
import Modelo.Entidades.Usuarios.Gerente;

/**
 *
 * @author phily
 */
public class Conversor {
    
    public Cajero convertirACajero(String datos[], int codigo, String contrasenia){
        return new Cajero(codigo, datos[0], datos[1], datos[2], datos[3], contrasenia, datos[4]);
    }
    
    /**
     * Empleado en la creacion
     * @param datos
     * @param codigo
     * @param contrasenia
     * @param path
     * @return
     */
    public Cliente convertirACliente(String datos[], int codigo, String contrasenia, String path){//al parecer el path lo recibiraás después... porque debes pensar como llamarás al otro servlet... en el que se encarga de la ... O podrías hacerlo con un dopost o un método más en este mismo servlet... pero eso implicaría tener otro para la carga de datos...
        return new Cliente(codigo, datos[0], datos[1], path, datos[2], datos[3], contrasenia, datos[4]);
    }
    
    public Gerente convertirAGerente(String datos[], int codigo, String contrasenia){
        return new Gerente(codigo, datos[0], datos[1], datos[2], datos[3], contrasenia, datos[4]);
    }
    
    /**
     *Para la modificación xD
     * @param clienteAntiguo
     * @param datos
     * @return
     */
    public Cliente convertirACliente(Cliente clienteAntiguo, String[] datos){
        return new Cliente(clienteAntiguo.darCodigo(), datos[0], clienteAntiguo.darDPI(), datos[1],
               datos[2], clienteAntiguo.darSexo(), datos[3], clienteAntiguo.darBirth());
    }
    
    public Cuenta convertirACuenta(int numeroCuenta, int codigoDueno, int monto, String fecha){
        return new Cuenta(numeroCuenta, codigoDueno, monto, fecha);
    }
    
    public Transaccion convertirATransaccion(int elCodigo, int elNumeroCuenta, String elTipo, 
        int elMonto, String laFecha, String laHora, int elCodigoCajero){
        
        return new Transaccion(elCodigo, elNumeroCuenta, elTipo, elMonto, laFecha, laHora, elCodigoCajero);    
    }
    
    //Solo debes componer el tipo a DPI en la DB y revisar lo de las fechas xD si funciona con Strings xD
}
