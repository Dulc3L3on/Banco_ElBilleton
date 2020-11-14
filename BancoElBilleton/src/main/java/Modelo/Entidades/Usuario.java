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
public class Usuario {
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
