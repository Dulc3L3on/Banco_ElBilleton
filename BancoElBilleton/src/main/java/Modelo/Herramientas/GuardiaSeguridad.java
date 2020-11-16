/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Herramientas;

import Modelo.Entidades.Usuarios.Usuario;
import Modelo.Kit;
import Modelo.Manejadores.DB.Buscador;

/**
 *
 * @author phily
 */
public class GuardiaSeguridad {
    Buscador buscador = new Buscador();
    Usuario usuario;
    Kit herramienta = new Kit();
    
    public boolean esUsuarioAutentico(String nombreUsuario, String contraseniaIngresada, String tipoUsuario){            
        return esContraseniaCorrecta(contraseniaIngresada, esNombreUsuarioCorrecto(nombreUsuario, tipoUsuario));        
    }
    
     private String esNombreUsuarioCorrecto(String codigoUsuario, String tipoUsuario){
        //Se busca al usuario... y se devulven los datos completos para que peuda crearse el obj entidad corresp...
        
        if(tipoUsuario!=null && codigoUsuario!=null){//por si las moscas es ejecutado de forma anormal el proceso...
            switch(tipoUsuario){
                case "cliente":
                    usuario = buscador.buscarCliente(codigoUsuario);//pues username == codigo...                    
                break;
                case "cajero":
                    usuario = buscador.buscarCajero(codigoUsuario);
                break;
                case "gerente":
                    usuario = buscador.buscarGerente(codigoUsuario);
                break;
            }
            if(usuario!=null){
                return usuario.darContrasenia();
            }            
        }                
        return null;
    }
    
    private boolean esContraseniaCorrecta (String contraseniaIngresada, String contraseniaRegistrada){
        if(contraseniaRegistrada!=null){
            if(herramienta.desencriptarContrasenia(contraseniaRegistrada).equals(contraseniaIngresada)){
                return true;
            }                        
        }        
        return false;
    }         
  
}
