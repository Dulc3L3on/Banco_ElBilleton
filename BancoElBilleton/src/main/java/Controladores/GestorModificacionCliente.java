/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelo.Entidades.Usuarios.Cliente;
import Modelo.Entidades.Usuarios.Gerente;
import Modelo.Manejadores.DB.Actualizador;
import Modelo.Manejadores.DB.Buscador;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author phily
 */

@WebServlet("/gestorModificacionCliente")
public class GestorModificacionCliente extends HttpServlet{
    Actualizador actualizador = new Actualizador();        
    Buscador buscador = new Buscador();       
    Gerente gerente;//esto por medio de las sesiones, porque creo que daría problemas con singleton...o no.. quizá no, por el hecho de tener un método para cuando se quiera preservar y otro para cuando no... aśi que NO PROBLEM!!! XD
    boolean fueActualizado=false;      
    String[] datos;//esto por si acaso add el check para la contra aleatoria... 
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response){                                                                           
        //aqupi verificas si está en sesión...        
                        
        datos = (String[]) request.getAttribute("datosClienteNuevo");//como se mando con un forward del dispatcher entonces no se requiere del getSession...
        System.out.println(datos[0]);
        fueActualizado =actualizador.actualizarCliente(datos, (Cliente) request.getSession().getAttribute("clienteAntiguo"));//este se mandó con un form, no con un forward del dispatcher...                                                                                                          
        redireccionarPaginaHistorial(request, response);//también hubiera podido ser el doGet xd :v        
    }        
    
    private void redireccionarPaginaHistorial(HttpServletRequest request, HttpServletResponse response){
        try {
            if(fueActualizado){
                //Aquí tendría que ir el if para revisar si el valor del checkbox !=null para llamar al método de creación aleatoria y de esa forma la posición en datos que contenía la antigua, actualice su valor para hacer bien la comparación...
                System.out.println("sesión modificador -> "+ request.getSession());
                System.out.println("codigo -> "+ request.getSession().getAttribute("codigo"));
                gerente = buscador.buscarGerente((String)request.getSession().getAttribute("codigo"));//el id que devuelve es el id de la sesión... pero aquí se requiere el de la DB... [quizá el otro sea útil para evitar que abra seasión más de una vez...]                
                if(gerente!=null){
                    gerente.hallarCambiosCliente((Cliente) request.getSession().getAttribute("clienteAntiguo"), datos);
                    request.setAttribute("cambios", gerente.darListaListados());                
                }                
            }else{                                                                                                                                  
                request.setAttribute("mostrarError", true);//puesto que cuando no se agregue correctamente un cambio, será agregado uno por uno a la página...                
            }            
            request.getRequestDispatcher("Trabajadores/Gerente/Historial.jsp").forward(request, response);//para no redireccionar a la otra pag solo par mostra eso xD, sino se puede, deplano que se tendrá que hacer así xD        
        } catch (ServletException | IOException e) {
            System.out.println("Error al redireccionar al Historial: "+ e.getMessage());
        }           
    }
    
    //listo xD, dio error porque no ini sesión xD... entonces ahora prueba iniciando xD, revisa que sucede con cliente xD, por el hecho de haber esto sin haber ini sesión...[ lo que pienso es que si se tenía un id de sesión, porque siempre se crea, pero como no llegué a la parte en la que se establece el código, por eso sucedió ese error xD]
}
