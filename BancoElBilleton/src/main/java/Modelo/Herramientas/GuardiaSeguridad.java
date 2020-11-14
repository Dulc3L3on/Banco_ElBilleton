/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Herramientas;

/**
 *
 * @author phily
 */
public class GuardiaSeguridad {
    
    public boolean esUsuarioAutentico(String nombreUsuario, String contrasenia){            
        return esContraseniaCorrecta(contrasenia, esNombreUsuarioCorrecto(nombreUsuario));        
    }
    
     private String esNombreUsuarioCorrecto(String nombreUsuario){
        //Se busca al usuario... y se devulven los datos completos para que peuda crearse el obj entidad corresp...
        
        return null;
    }
    
    private boolean esContraseniaCorrecta (String contraseniaIngresada, String contraseniaRegistrada){
        if(contraseniaRegistrada!=null){
        
        }
        
        return false;
    }         
  
}
