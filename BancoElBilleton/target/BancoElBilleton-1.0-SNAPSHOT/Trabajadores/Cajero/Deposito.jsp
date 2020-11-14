<%-- 
    Document   : Deposito
    Created on : 12/11/2020, 15:25:06
    Author     : phily
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../../css/cssCajero.css">
        <title>Deposit</title>
    </head>
    <body>
          <form method="POST" action="Deposito"><!--si todo salió bien, entonces se refireccionará al servlet-->
            <center>
                <div id="general">
                    <h1>>>DEPÓSITO<<</h1>                            
                
                    <table cellspacing="10px" cellpadding="5px">                  
                        <tr>                        
                            <th>
                                <input type="text" name="cuentaBuscada" placeholder="#Cuenta Receptora" id="buscada" required><!--no cambio a recpetora porque de todos modos debe buscarse...-->
                            </th>
                            <th>
                                <input type="submit" name="submit" id="submit" value="BUSCAR">
                            </th>                       
                            <th colspan="2"><hr></th>
                        </tr>
                    </table>                                                                     
                
                    <table cellspacing="10px" cellpadding="5px">             
                        <tr>
                            <th colspan="2">
                           <h4>------------->>Datos del dueño<<-------------</h4>
                       </th>
                       <th colspan="2">
                            <h4>----------->>Datos para depositar<<-----------</h4>
                       </th>       
                        </tr>
                        <tr>
                            <th>
                                <label><h5>Nombre Dueño:</h5></label>
                            </th>
                            <th>
                                <input type="text" name="nombre" id="nombre" readonly>
                            </th>
                            <th>
                                <label><h4>Monto $.</h4></label>
                            </th>
                            <th>
                                <input type="number" name="monto" value="1" id="opDeposito" min="1" required>
                            </th>
                        </tr>
                        <tr>
                           <th>
                                <label><h5>No. Cuenta:</h5></label>
                            </th>
                            <th>
                                <input type="number" name="numeroCuenta" id="numeroCuenta" min="0" readonly>
                            </th>
                            <th colspan="2">
                                <center>
                                    <input type="submit" id="submit" name="depositar" value="DEPOSITAR"><!--todos los sumbit sin importar de qué entidad sean y qué sea lo que suban tendrán el mismo aspecto...-->                                                                                                                                                                            
                                </center>            
                            </th>
                         </tr>                                                       
                    </table>                                
                </div>                          
            </center>
        </form>
    </body>
</html>
