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
public class Cuenta {
    private int numeroCuenta;
    private int codigoDueno;
    private int monto;
    private String fechaCreacion;
    
    public Cuenta(int elnumeroCuenta, int elCodigoDueno, int elMonto, String laFechaCreacion){
        numeroCuenta = elnumeroCuenta;
        codigoDueno = elCodigoDueno; 
        monto = elMonto; 
        fechaCreacion = laFechaCreacion;
    }
    
    public int darNumeroCuenta(){
        return numeroCuenta;
    }
    
    public int darCodigoDueno(){
        return codigoDueno;
    }
    
    public int darMonto(){
        return monto;
    }
    
    public String darFechaCreacion(){
        return fechaCreacion;
    }           
}
