<%-- 
    Document   : Home_Cajero
    Created on : 11/11/2020, 20:10:35
    Author     : phily
--%>

<%@page import="Modelo.Nodo"%>
<%@page import="Modelo.ListaEnlazada"%>
<%@page import="Modelo.Entidades.Cambio"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/cssGerente.css"><!--por el hecho de ser solo accedido por la pág del frame dentro del frame xD... simi a R//-->
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>     
        <title>RECORD</title>
        <%!ListaEnlazada<ListaEnlazada<Cambio>> listadoCambiosGeneral;
           Nodo<ListaEnlazada<Cambio>> nodoDeListados;
           ListaEnlazada<Cambio> listado;
           Nodo<Cambio> nodoAuxiliar;%>
    </head>
    <body>
        <center>                       
            <%if(request.getAttribute("mostrarError")!= null){%> 
                <script src="js/sweetError.js"></script>
            <%}else{%><!--quiere decir que no hubo un error "fatal"-->
                 <h1>>>HISTORIAL<<</h1>
                 <h3 style="float: right;">Fecha: <%=java.time.LocalDate.now()%></h3><br/>

                <%if(request.getAttribute("cambios")!=null){//<!--y debería serlo xD-->
                    listadoCambiosGeneral = (ListaEnlazada<ListaEnlazada<Cambio>>)request.getAttribute("cambios");

                    if(!listadoCambiosGeneral.estaVacia()){                    
                        nodoDeListados = listadoCambiosGeneral.obtnerPrimerNodo();                    
                    
                        for(int numeroListado=1; numeroListado <= listadoCambiosGeneral.darTamanio(); numeroListado++){
                            listado = nodoDeListados.contenido;%>
                        
                            <table cellspacing="10px" cellpadding="5px" style="width: 700px">
                                <%if(numeroListado == 1){%>                                                                                      
                                <tr>
                                    <th colspan="4">
                                        <h3>>> Cambios Exitosos</h3>
                                    </th>
                                </tr>
                                
                                <%}%>
                                <%if(numeroListado == 2){%>                                                                                      
                                    <tr>
                                        <th>
                                            <h3>>> Cambios Fallidos</h3>
                                        </th>
                                    </tr>
                                <%}%>                            
                                    <tr>
                                        <th>
                                            <h4>Hora</h4>
                                        </th>
                                        <th>
                                            <h4>Tipo</h4>
                                        </th>
                                        <th>
                                            <h4>Dato Antiguo</h4>
                                        </th>
                                        <th>
                                            <h4>Reemplazo</h4>
                                        </th>
                                    </tr>                                                    
                        <%nodoAuxiliar = listado.obtnerPrimerNodo();
                         for(int cambio =1; cambio <= listado.darTamanio(); cambio++){%>
                             <tr>
                                <th>
                                    <h5><%=nodoAuxiliar.contenido.darHora()%></h5>
                                </th>
                                <th>
                                    <h5><%=nodoAuxiliar.contenido.darTipo()%></h5>
                                </th>
                                <th>
                                    <h5><%=nodoAuxiliar.contenido.darDatoAntiguo()%></h5>
                                </th>
                                <th>
                                    <h5><%=nodoAuxiliar.contenido.darDatoNuevo()%></h5>
                                </th>
                            </tr>                            
                          <%nodoAuxiliar = nodoAuxiliar.nodoSiguiente; 
                         }%><!--se leen los cambios bien almacenados...-->                                               
                        </table>                               
                        <%nodoDeListados = nodoDeListados.nodoSiguiente;
                    }//fin del for para el listado de listados xD
                }else{%>                                    
                 <h3>Información intacta, sin cambios que mostrar</h3>
              <%}%>
                 <input type="submit" id="submit" name="sumbmit" value="VER HISTORIAL COMPLETO">
             <%}%>                                     
            
         <%}%> 
        </center>
    </body>
</html>
