/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelo.Entidades.Cuenta;
import Modelo.ListaEnlazada;
import Modelo.Manejadores.DB.BuscadorParaCliente;
import Modelo.Manejadores.DB.Tramitador;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author phily
 */
@WebServlet("/gestorTransferencia")
public class GestorTransferencia extends HttpServlet{
    BuscadorParaCliente buscador = new BuscadorParaCliente();  
    Tramitador tramitador = new Tramitador();
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response){
        try {
            switch(request.getParameter("tipoCuentaDestino")){
                case "propia":
                    request.setAttribute("listadoCuentasReceptoras", buscador.buscarNumeroCuentasPropias(request.getSession().getAttribute("codigo").toString()));
                    break;
                case "terceros":
                    request.setAttribute("listadoCuentasReceptoras", buscador.buscarCuentasDeTerceros(request.getSession().getAttribute("codigo").toString()));
                    break; 
            }
            
            request.setAttribute("listadoCuentasOrigen", buscador.buscarNumeroCuentasPropias(request.getSession().getAttribute("codigo").toString()));
            request.getRequestDispatcher("Cliente/Transferencia.jsp").forward(request, response);
        } //será empleado para llenar los componentes con la info que corresponde al tipo de cuenta destino al que llegará el dinero...
        catch (ServletException  | IOException ex) {
            System.out.println("Error al obtener el listado de #Cuentas");
        }
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response){
        try {
            if(tramitador.depositar(request.getParameter("destino"), request.getParameter("monto"))
                    && tramitador.retirar(request.getParameter("origen"), request.getParameter("monto"))){
                request.setAttribute("resultadoExitoso", true);
            }else{
                request.setAttribute("resultadoExitoso", false);//y en realidad al suceder esto se debería eliminar el registro que se había generado de la transacción no completada... es decir habría que revertir el proceso[pero solo para la transacc que se efectuó correctaente, peor habría que saber cuál de las 2 op salieron bien...
            }
            
            request.getRequestDispatcher("Cliente/Transferencia.jsp").forward(request, response);
        } //este será empleado para la acción de transferir...
        catch (ServletException | IOException e) {
            System.out.println("Error al redireccionar para mostrar el resultado de la transferencia: "+ e.getMessage());
        }
    }
    
}
