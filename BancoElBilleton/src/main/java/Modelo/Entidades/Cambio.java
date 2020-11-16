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
public class Cambio {
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
    
    public int darGerenteACargo(){
        return gerenteACargo;
    }
    
    public String darFecha(){
        return fecha;
    }
    
    public String darHora(){
        return hora;
    }
    
    public String darTipo(){
        return tipo;
    }
    
    public String darDatoNuevo(){
        return datoNuevo;
    }
    
    public String darDatoAntiguo(){
        return datoAntiguo;
    }       
}//puesto que solo se necesota de una entidad en específico... y si guardo el dato, sería redundante, muy redundante... xD
