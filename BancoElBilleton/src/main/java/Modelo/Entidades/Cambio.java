/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Entidades;

import java.io.Serializable;

/**
 *
 * @author phily
 */
public class Cambio implements Serializable{
    private int gerenteACargo;
    private String fecha;
    private String hora;
    private String tipo;
    private String datoNuevo;
    private String datoAntiguo;    
    
    public Cambio(String laFecha, String laHora, int unGerenteACargo, String elTipo, String elDatoAntiguo, String elDatoNuevo){
        gerenteACargo = unGerenteACargo;
        fecha = laFecha; 
        hora = laHora; 
        tipo = elTipo;
        datoNuevo = elDatoNuevo;        
        datoAntiguo = elDatoAntiguo;        
    }
    
    public int getGerenteACargo(){
        return gerenteACargo;
    }
    
    public String getFecha(){
        return fecha;
    }
    
    public String getHora(){
        return hora;
    }
    
    public String getTipo(){
        return tipo;
    }
    
    public String getDatoNuevo(){
        return datoNuevo;
    }
    
    public String getDatoAntiguo(){
        return datoAntiguo;
    }       
}//puesto que solo se necesota de una entidad en específico... y si guardo el dato, sería redundante, muy redundante... xD
