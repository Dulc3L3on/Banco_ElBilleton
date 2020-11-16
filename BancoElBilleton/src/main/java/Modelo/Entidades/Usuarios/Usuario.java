/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Entidades.Usuarios;

/**
 *
 * @author phily
 */
public class Usuario {
    Usuario usuarioAlojado = null;
    int codigo;
    String nombre;
    String DPI;
    String direccion;
    String sexo;
    String password;       
    
    public Usuario(int elCodigo, String elNombre, String elDPI, 
            String laDireccion, String elSexo, String thePassword){
        
        codigo = elCodigo;
        nombre = elNombre;
        DPI = elDPI;
        direccion = laDireccion;
        sexo = elSexo;
        password = thePassword;
    }
    
    public void alojarUsuario(Usuario usuario){//Con respecto a los parámetros no creo que hallan problemas, puesto que USER es el más general, entonce puede aceptar cualquiera que descienda de él... [como los métodos con Object...]
        if(usuarioAlojado == null){//como los demás usuarios [a quienes no les pertenece la sesión] se crean cada vez, entonces no habrá problema con el hecho de que los cb afectarían tb a este...                
            usuarioAlojado = usuario;
        }//Es un hecho[porque solo puede haber una sesión por ordenador xD] pero para seguir el estándar xD
    }
    
    public Usuario darUsuarioAlojado(){//habría que castear para los hijos.         
        return usuarioAlojado;
    }//si es null es porque no hay usuario alojado xD
    
    public int darCodigo(){
        return codigo;
    }
    
    public String darNombre(){
        return nombre;
    }
    
    public String darDPI(){
        return DPI;
    }
    
    public String darDireccion(){
        return direccion;
    }
    
    public String darSexo(){
        return sexo;
    }
    
    public String darContrasenia(){
        return password;
    }
    
}
