<%-- 
    Document   : Asociacion
    Created on : 12/11/2020, 15:26:41
    Author     : phily
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../css/cssCliente.css">
        <title>SentAssociation</title>
    </head>
    <body>
        <form method="POST" action="Enviar_Asociacion"><!--si todo salió bien, entonces se refireccionará al servlet-->
            <center>
                <div id="general"><!--posiblemente lleve color xD o borde... o ambos xD-->
                    <h1>>>ASOCIACIÓN<<</h1>                                                                   

                    <table cellspacing="10px" cellpadding="5px">                  
                        <tr>
                                 <label><h5>#Intentos:</h5></label>
                        </tr>
                        <tr>
                            <th>
                                <label><h5>#Cuenta: </h5></label>                            
                            </th>
                            <th>
                                <input type="number" name="cuentaBuscada" id="buscada" required>
                            </th>
                            <th>
                                <input type="submit" name="submit" id="submit" value="BUSCAR">
                            </th>                       
                        </tr>
                    </table>
            
                    <table cellspacing="10px" cellpadding="5px">
                        <tr>
                            <th>
                                <label><h5>Nombre:</h5></label>
                            </th>
                            <th>
                                <input type="text" name="nombreDueno" id="nombre" readonly>
                                 <!--label?? o un input que sea solo de lectura... eso haría que se mande junto con los ele enviados por el form... y es justo lo que necesito...-->
                                 <!--sip, donde muestre info debo hacer esto... pero prueba si se puede establecer el valor con vars... sino entonces con lbl y aparte el input que no se mira, para mandar la info...-->
                            </th>
                        </tr>
                        <tr>
                            <th>
                                <label><h5>DPI:</h5></label>
                            </th>
                            <th>
                                <input type="number" name="DPI" id="DPI" readonly><!--como solo es para lectura da igual... pero eso implicaría un conversión... mejor tipo number xD-->
                            </th>
                        </tr>
                        <tr>
                            <th>
                                <label><h5>#Cuenta:</h5></label>
                            </th>
                            <th>
                                <input type="number" name="numeroCuenta" id="numeroCuenta" min="0" readonly="">
                            </th>
                        </tr>   
                        
                    </table>                
                
                    <input type="submit" id="submit" name="solicitar" value="ENVIAR SOLICITUD" width="200px"><!--todos los sumbit sin importar de qué entidad sean y qué sea lo que suban tendrán el mismo aspecto...-->                    
                </div>
                
            </center>
        </form>
    </body>
</html>
