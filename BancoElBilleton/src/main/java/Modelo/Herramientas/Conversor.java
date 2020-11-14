/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Herramientas;

import Modelo.Entidades.Cajero;

/**
 *
 * @author phily
 */
public class Conversor {
    
    public Cajero convertirACajero(String datos[], int codigo, String contrasenia){
        return new Cajero(codigo, datos[0], datos[1], datos[2], datos[3], contrasenia, datos[4]);
    }
    
    //Solo debes componer el tipo a DPI en la DB y revisar lo de las fechas xD si funciona con Strings xD
}
