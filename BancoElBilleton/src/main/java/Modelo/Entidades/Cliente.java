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
public class Cliente extends Usuario{
    String birth;
    
    public Cliente(int codigo, String nombre, String DPI, String direccion, String sexo, String password, String theBirth){//prueba si se pueden hacer las op para fecha en mysql con strings [varchars]...
        super(codigo, nombre, DPI, direccion, sexo, password);
        
        birth = theBirth;
    }
    
    public String darBirth(){
        return birth;
    }//si es que se puedne hacer las op con str... sino aquí se devolverá en Date o LocalDate.. dep de quine lo necesite xD
    
}
