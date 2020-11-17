<%-- 
    Document   : Retiro
    Created on : 12/11/2020, 15:25:27
    Author     : phily
--%>

<%@page import="Modelo.Kit"%>
<%@page import="Modelo.Entidades.Cuenta"%>
<%@page import="Modelo.Entidades.Usuarios.Cliente"%>
<%@page import="Modelo.Manejadores.DB.Buscador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../../css/cssCajero.css">
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>  
        <title>Debit</title>
         <%!Buscador buscador = new Buscador();
        Cuenta[] cuentas;
        Cliente cliente = null;
        Kit herramienta = new Kit();%>               
    </head>
    <body>         
        <center>
           <div id="general">
                <h1>>>RETIRO<<</h1>                            
                <form method="POST" action="Retiro.jsp"><!--si todo salió bien, entonces se refireccionará al servlet-->
                    <table cellspacing="10px" cellpadding="5px">                  
                        <tr>                        
                            <th>
                                <input type="text" name="DPI_Buscado" placeholder="DPI del solicitante de retiro" id="buscado" maxlength="13" required><!--no cambio a recpetora porque de todos modos debe buscarse...-->
                            </th>
                            <th>
                                <input type="submit" name="submit" id="submit" value="BUSCAR">
                            </th>                       
                            <th colspan="2"><hr></th>
                        </tr>
                    </table>                                                                
                </form>
                
              <%if(request.getParameter("DPI_Buscado")!=null){                    
                    cliente = buscador.buscarClienteSolicitanteRetiro(request.getParameter("DPI_Buscado"));                                                      
                    
                    if(cliente!=null){
                        cuentas = buscador.buscarCuentas(cliente.darCodigo());
                    }//recuerda que debe ir aquí para evitar que haga el proceso cuando se regrese y por ello se traiga devuelta a "cliente"              
              }
               if(cuentas!=null){%><!--busca como saber si el arreglo es null, puesto que no hace al usar los signos normales d ecomparación [!=]...-->                                                                              
                     <form method="POST" action="../../gestorRetiro">
                        <table cellspacing="10px" cellpadding="5px">          
                            <tr>
                                <th colspan="4" rowspan="2">     
                                    <center>
                                        <iframe src="<%=herramienta.darPathDPI(cliente.darPath())%>" width="780px" height="210px"></iframe>                                                                              
                                    </center>                                
                                </th>
                            </tr>
                            <tr></tr>
                            <tr>                                    
                               <th colspan="2">
                                   <h4>------------->>Datos del dueño<<-------------</h4>
                               </th>
                               <th colspan="2">
                                    <h4>----------->>Datos para debitar<<-----------</h4>
                                </th>      
                            </tr>
                            <tr>      
                                 <th>
                                    <label><h5>Nombre Dueño:</h5></label>
                                </th>
                                <th>
                                    <input type="text" name="nombre" id="nombre" value="<%=cliente.darNombre()%>" readonly>
                                </th>     
                                 <th>
                                    <label><h5>Cuenta Saliente:</h5></label>
                                </th>
                                <th>
                                    <select name="numeroCuenta"  id="numeroCuenta" style="width: 240px;" onclick="maximoMonto()" required>
                                        <%for(int cuentaActual=0; cuentaActual<cuentas.length; cuentaActual++){%>
                                                <option value="<%=cuentas[cuentaActual].darNumeroCuenta()%>"><%=cuentas[cuentaActual].darNumeroCuenta()%></option>
                                        <%}%>
                                    </select>                                    
                                </th>                                        
                            </tr>
                            <tr>
                                <th>
                                    <label><h5>DPI</h5></label>
                                </th>
                                <th>
                                    <input type="number" name="DPI" id="DPI" min="0" value="<%=cliente.darDPI()%>" readonly>
                                </th>                            
                                 <th>
                                    <label><h4>Monto $.</h4></label>
                                </th>
                                <th>
                                    <input type="number" name="monto" value="1" id="monto" min="1" required><!--aquí tengo que usar JS para establecer el máximo según la cuenta que esté seleccionada...-->
                                </th>                             
                            </tr>
                            <tr>                               
                                <th colspan="4">
                                    <center>
                                         <input type="submit" id="submit" name="retirar" value="RETIRAR"><!--todos los sumbit sin importar de qué entidad sean y qué sea lo que suban tendrán el mismo aspecto...-->
                                    </center>        
                                </th><!--debería aparecer a la par de nombre... pero por el rowspan creo que aparecerá a la par del DPI...-->
                            </tr>                                                        
                        </table>  
                    </form>                    
                <%}else if(cliente == null && request.getParameter("DPI_Buscado")!=null){%>                                    
                    <script src="../../js/sweetInexistente.js"></script><!--el chivo es ver como se colocó el css[para que pudiera visualizarse...] xD Jahajajja, pues a esa profundidad se encuentra la pág... xd-->
                <%}else if(cuentas==null && cliente != null && request.getParameter("DPI_Buscado")!=null){%>    
                    <script src="../../js/sweetSinCuentas.js"></script><!--insisto que esto no debería suceder, pues si es cliente tien más de alguna cuenta...-->
                <%}%>
            </div>                          
        </center> 
        <script>
         function maximoMonto(){//for more velocity xD
               document.getElementById("monto").max = document.getElementById("numeroCuenta").value;//de esta forma el valor máximo cambiará de forma adecuada xD                                                                                    
          }                                        
        </script>               
    </body>
</html>
