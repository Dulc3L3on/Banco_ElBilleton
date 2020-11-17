<%-- 
    Document   : Transferencia
    Created on : 12/11/2020, 15:26:25
    Author     : phily
--%>

<%@page import="Modelo.Nodo"%>
<%@page import="Modelo.ListaEnlazada"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../css/cssCliente.css">
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>  
        <title>Transfer</title>
        <%!ListaEnlazada<Integer> listadoNumerosCuentaDestino;
           Nodo<Integer> nodoAuxiliarDestino;
           ListaEnlazada<Integer> listadoNumerosCuentaOrigen;
           Nodo<Integer> nodoAuxiliarOrigen;%>
    </head>
    <body>
        <%if(request.getAttribute("resultadoExitoso")==null){%>
          <!--si todo salió bien, entonces se refireccionará al servlet-->
                <center>
                    <div id="general">
                        <br/>
                        <br/>
                        <h1>>>TRANSFERENCIA<<</h1>
            
                        <form method="GET" action="../gestorTransferencia">
                            <table cellspacing="10px" cellpadding="5px">
                                <tr>
                                    <th>
                                         <h3>>>Cuenta Destino</h3>
                                    </th>
                                </tr>
                                <tr>
                                    <th>
                                        <input type="radio" name="tipoCuentaDestino" value ="propia" id="propia">
                                        <label for="propia">Propia</label>
                                    </th>
                                    <th>
                                        <input type="radio" name="tipoCuentaDestino" value ="terceros" id="terceros" checked>
                                        <label for="terceros">Terceros</label>
                                    </th>
                                    <th>
                                        <input type="submit" name="aceptar" value="ACEPTAR" id="submit">
                                    </th>
                                </tr>
                            </table>
                        </form>
                   
                    
                        <%if(request.getAttribute("listadoCuentasOrigen")!=null){//lo cual quiere decir que ya se regrsó del servlet... [no reviso si el otro listrao!= null puesto que se encían en un mismo método y este es el 2do por lo tanto si este != null es porque no hubo ningún fallo en el servlet que detuviera su proceso normal...
                            listadoNumerosCuentaDestino = (ListaEnlazada<Integer>)request.getAttribute("listadoCuentasReceptoras");
                            listadoNumerosCuentaOrigen = (ListaEnlazada<Integer>)request.getAttribute("listadoCuentasOrigen");%>                                                                                               
                            
                            <form methos="POST" action="../gestorTransferencia"> 
                                 <table cellspacing="10px" cellpadding="5px">
                                     <tr>
                                        <th>
                                            <label><h5>*Cuenta Origen:</h5></label>
                                        </th>
                                        <th>
                                            <select name="origen" id="opTransferencia" style="width: 250px" required>
                                                  <%nodoAuxiliarOrigen = listadoNumerosCuentaOrigen.obtnerPrimerNodo();
                                                     for(int cuentaActual=0; cuentaActual < listadoNumerosCuentaOrigen.darTamanio(); cuentaActual++){%>
                                                        <option value="<%=nodoAuxiliarOrigen.contenido%>" ><%=nodoAuxiliarOrigen.contenido%></option><!--no creo que sea necesario poner un vacío en el valor... creo que con no declararlo basta...-->
                                                        
                                                    <%nodoAuxiliarOrigen = nodoAuxiliarOrigen.nodoSiguiente;
                                                    }%><!--por el momento nos saltaremos el proceso en el que si las cuentas de destino son las propias, que se inhabilite la opción = a la que está selecciondad en el cbBx de destino, puesto que tendrías que usar JS...-->
                                            </select>
                                        </th>
                                    </tr>
                                    <tr>
                                        <th>
                                            <label><h5>*Cuenta Destino:</h5></label>
                                        </th>
                                        <th>
                                            <select name="destino" id="opTransferencia" style="width: 250px" required><!--no les pongo el required a estos cbox, puesto que siempre estará seleccionado 1 así que...-->
                                                  <%nodoAuxiliarDestino = listadoNumerosCuentaDestino.obtnerPrimerNodo();
                                                     for(int cuentaActual=0; cuentaActual < listadoNumerosCuentaDestino.darTamanio(); cuentaActual++){%>
                                                        <option value="<%=nodoAuxiliarDestino.contenido%>" ><%=nodoAuxiliarDestino.contenido%></option><!--no creo que sea necesario poner un vacío en el valor... creo que con no declararlo basta...-->
                                                        
                                                    <%nodoAuxiliarDestino = nodoAuxiliarDestino.nodoSiguiente;
                                                    }%>
                                            </select>
                                        </th>
                                    </tr>                                
                                    <tr> 
                                        <th>
                                            <h4>*Monto $.</h4><!--deberíamos delimitar el monto máximo, peor eso también conlleva JS, pues a partir del dato seleccionado de la cta de origen habría que ingresar el valor que corresponde a su saldo, esto a partir del arreglo o lista de los datos de tío wilis xD-->
                                        </th>
                                        <th>
                                            <input type="number" name="monto" value="1" id="opTransferencia" min="1" required>
                                        </th>
                                    </tr>
                                </table>
                                <input type="submit" id="submit" name="transferir" value="TRANSFERIR"><!--todos los sumbit sin importar de qué entidad sean y qué sea lo que suban tendrán el mismo aspecto...-->
                            </form>
                   <%}%>
                </div>                
           </center>  
         <%}else{
                if(request.getAttribute("resultadoExitoso").equals(true)){%>
                    <script src="../../js/sweetInexistente.js"></script>
               <%}else{%>
                            <script src="../../js/sweetError.js"></script>
               <%}
           }%>
    </body>
</html>
