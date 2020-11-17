/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Entidades.Usuarios;

import Modelo.Entidades.Cambio;
import Modelo.Kit;
import Modelo.ListaEnlazada;
import Modelo.Manejadores.DB.Registrador;

/**
 *
 * @author phily
 */
public class Gerente extends Usuario{
    Kit herramienta = new Kit();
    Registrador registrador = new Registrador();
    String turno;
    
    public Gerente(int elCodigo, String elNombre, String elDPI, String laDireccion, String elSexo, String thePassword, String elTurno) {
        super(elCodigo, elNombre, elDPI, laDireccion, elSexo, thePassword);
        turno = elTurno;
    }
    
    public void hallarCambiosCliente(Cliente clienteAntiguo, String datosNuevos[]){
        String desencriptada = herramienta.desencriptarContrasenia(clienteAntiguo.password);
        
        if(!clienteAntiguo.nombre.equals(datosNuevos[0])){
            registrador.registrarCambioCliente(codigo, "nombre", clienteAntiguo.nombre, datosNuevos[0], clienteAntiguo.codigo);
        }
        if(!clienteAntiguo.pathDPI.equals(datosNuevos[1])){
            registrador.registrarCambioCliente(codigo, "archivo DPI", clienteAntiguo.pathDPI, datosNuevos[1], clienteAntiguo.codigo);
        }
        if(!clienteAntiguo.direccion.equals(datosNuevos[2])){
            registrador.registrarCambioCliente(codigo, "direccion", clienteAntiguo.direccion, datosNuevos[2], clienteAntiguo.codigo);
        }
        if(!desencriptada.equals(datosNuevos[3])){
            registrador.registrarCambioCliente(codigo, "contraseña", desencriptada, datosNuevos[3], clienteAntiguo.codigo);
        }              
    }
    
    public void hallarCambiosCajero(Cajero cajeroAntiguo, String datosNuevos[]){
        String desencriptada = herramienta.desencriptarContrasenia(cajeroAntiguo.password);
        
      if(!cajeroAntiguo.nombre.equals(datosNuevos[0])){
            registrador.registrarCambioCajero(codigo, "nombre", cajeroAntiguo.nombre, datosNuevos[0], cajeroAntiguo.codigo);
        }       
        if(!cajeroAntiguo.direccion.equals(datosNuevos[1])){
            registrador.registrarCambioCajero(codigo, "direccion", cajeroAntiguo.direccion, datosNuevos[1], cajeroAntiguo.codigo);
        }
        if(!desencriptada.equals(datosNuevos[2])){
            registrador.registrarCambioCajero(codigo, "contraseña", desencriptada, datosNuevos[2], cajeroAntiguo.codigo);
        } 
        if(!cajeroAntiguo.turno.equals(datosNuevos[3])){
            registrador.registrarCambioCajero(codigo, "turno", cajeroAntiguo.turno, datosNuevos[3], cajeroAntiguo.codigo);
        }
    }
    
    public void hallarCambiosPropios(String datosNuevos[]){
        String desencriptada = herramienta.desencriptarContrasenia(password);
        
      if(!nombre.equals(datosNuevos[0])){
            registrador.registrarCambioGerente(codigo, "nombre", nombre, datosNuevos[0]);
        }       
        if(!direccion.equals(datosNuevos[2])){
            registrador.registrarCambioGerente(codigo, "direccion", direccion, datosNuevos[2]);
        }
        if(!desencriptada.equals(datosNuevos[1])){
            registrador.registrarCambioGerente(codigo, "contraseña", desencriptada, datosNuevos[1]);
        } 
        if(!turno.equals(datosNuevos[3])){
            registrador.registrarCambioGerente(codigo, "turno", turno, datosNuevos[3]);
        }
    }
    
    
    public String darTipoTurno(){
        return turno;
    }
    
    public ListaEnlazada<ListaEnlazada<Cambio>> darListaListados(){
        ListaEnlazada<ListaEnlazada<Cambio>> listaListados = registrador.darListaDeListados();
        //registrador.darListaDeListados().limpiar();//vamos a probar si esto era lo que daba problemas... si si, entonces debes ver donde es el lugar correcot para hacer esta llamda... deplano que tendrá que ser en el método en el que se registran los cambios, para que pueda hacerse luego de dar los listados... auqneu básicamente es o mismo... pienslo y verás.... [harias lo mismo, pero en diferentes "lugares"]
        return listaListados;
    }
    
    public ListaEnlazada<Cambio> darListaCambiosAgregados(){
        ListaEnlazada<Cambio> agregados =  registrador.darListaAgregados();
        registrador.darListaAgregados().limpiar();
        return agregados;
    }
    
    public ListaEnlazada<Cambio> darListaCambiosErrados(){
        ListaEnlazada<Cambio> errados = registrador.darListaErrados();
        registrador.darListaErrados().limpiar();
        return errados;
    }
}
