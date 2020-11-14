<%-- 
    Document   : Retiro
    Created on : 12/11/2020, 15:25:27
    Author     : phily
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../../css/cssCajero.css">
        <title>Debit</title>
    </head>
    <body>
         <form method="POST" action="Retiro"><!--si todo salió bien, entonces se refireccionará al servlet-->
            <center>
                <div id="general">
                    <h1>>>RETIRO<<</h1>                            
                
                    <table cellspacing="10px" cellpadding="5px">                  
                        <tr>                        
                            <th>
                                <input type="text" name="DPI_Buscado" placeholder="DPI del solicitante de retiro" id="buscado" required><!--no cambio a recpetora porque de todos modos debe buscarse...-->
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
                                <h4>----------->>Datos para debitar<<-----------</h4>
                            </th>      
                        </tr>
                        <tr>
                            <th colspan="2" rowspan="2">
                                <div id="imgDPI">
                                    
                                </div><!--aquí debe ir el submit para subir el archivo y por ser de imagen recuerda que la termina mostrando... como en el lvideo... de igual forma tendría que abarcar el mismo espacio que este div...-->
                            </th>
                            <th>
                                <label><h5>#Cuenta Emisora:</h5></label>
                            </th>
                            <th>
                                <input type="number" name="numeroCuenta" value="0" id="numeroCuenta" min="0" required>
                            </th>                          
                        </tr>
                        <tr>
                            <th>
                                <label><h4>Monto $.</h4></label>
                            </th>
                            <th>
                                <input type="number" name="monto" value="1" id="monto" min="1" required>
                            </th>                              
                        </tr>
                        <tr>
                            <th>
                                <label><h5>Nombre Dueño:</h5></label>
                            </th>
                            <th>
                                <input type="text" name="nombre" id="nombre" readonly>
                            </th>      
                             <th colspan="2">
                                <center>
                                     <input type="submit" id="submit" name="retirar" value="RETIRAR"><!--todos los sumbit sin importar de qué entidad sean y qué sea lo que suban tendrán el mismo aspecto...-->
                                </center>        
                            </th><!--debería aparecer a la par de nombre... pero por el rowspan creo que aparecerá a la par del DPI...-->
                        </tr>
                        <tr>
                            <th>
                                <label><h5>DPI</h5></label>
                            </th>
                            <th>
                                <input type="number" name="DPI" id="DPI" min="0" readonly>
                            </th>                            
                        </tr>
                                                                                                        
                    </table>                                
                </div>                          
            </center>
        </form>
    </body>
</html>
