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
public class Cajero extends Usuario{
    String turno;      
    
    public Cajero(int codigo, String nombre, String DPI, String direccion, String sexo, String password, String elTurno){
        super(codigo, nombre, DPI, direccion, sexo, password);
        
        turno = elTurno;
    }
    
    
    public String darTipoTurno(){
        return turno;//no devulevo el rango porque esto le corresponde desglosarlo o especificarlo al guardia de seguirdad xD
    }
    
    
}

