/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Entidades;

/**
 *
 * @author phily
 */
public class Asociacion {
    
    private int numeroCuentaSolicitante;
    private int numeroCuentaSolicitado;
    private int numeroIntentos;
    private String estado;
    
    public Asociacion(int cuentaSolicitante, int cuentaSolicitado, int numeroIntentos, String elEstado){
        numeroCuentaSolicitante = cuentaSolicitante;
        numeroCuentaSolicitado = cuentaSolicitado;
        numeroIntentos = numeroIntentos;
        estado = elEstado;
    }
    
    public int darCuentaSolicitantes(){
        return numeroCuentaSolicitante; 
    }
    
    public int darCuentaSolicitado(){
        return numeroCuentaSolicitado;
    }
    
    public int darIntentos(){
        return numeroIntentos;    
    }
    
    public String darEstado(){
        return estado;
    }
}
//el plan es recuperar el codigo del cliente, recuerperar elcliente para mostrar los datos en el "form"
//buscar si el cliente solicitante ha aceptado una solicitud del número de cuenta en cuestión, para evitar el proceso...
//si no existe [es decir que el método de búsqueda devolvió -1] entonces buscar si ha solicitado antes a ese número, si si entonces revisar estado, si es rechazado entoces revisar #intentos para saber si denegar o no
//si no existe [devolvió -1], crear el registro y "enviar" [es decir, solicitar] el enío...