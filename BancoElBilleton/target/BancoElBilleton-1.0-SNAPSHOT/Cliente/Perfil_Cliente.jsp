<%-- 
    Document   : Perfil_Cliente
    Created on : 11/11/2020, 20:13:54
    Author     : phily
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../css/cssCliente.css">
        <title>ClientProfile</title>
    </head>
    <body>
       <center>
        <form method="POST" action="Perfil_Gerente.jsp"><!--al final de cuentas el action irá al servlet xD pues ahí se trabaja la info xD...-->
            <table cellspacing="25">
                <th colspan="2">
                    <center>
                        <img src="../img/usuarios.png" alt="iconoUsuarios">
                    </center>                                    
                </th>                
                <tr>
                    <th>
                        <h4>CÓDIGO: </h4>
                    </th>
                    <th>
                        <input type="text" id="datosUsuario" name="password" placeholder="Contraseña"  readonly>                                 
                    </th>                                               
                </tr>                
                <tr>
                    <th>
                        <input type="text" id="datosUsuario"  name="nombre" placeholder="Nombre"readonly>
                    </th>
                    <th>
                        <input type="number" id="datosUsuario"  name="DPI" placeholder="DPI" maxlength="13" readonly>
                    </th>                                                                             
                </tr>
                <tr>
                    <th>
                        <input type="text" id="datosUsuario"  name="direccion" placeholder="Direccion"readonly>
                    </th>                       
                    <th>
                        <input type="text" id="datosUsuario" name="genero" placeholder="Genero" readonly> 
                    </th><!--pregunta.. cuando se coloca una var para que el input reciba un valor, cuando a este último le es cb su dato, implica que tb a la var???-->
                </tr>  
                <tr>
                    <th>
                        <input type="date" id="datosUsuario" name="birth" readonly> 
                    </th>
                </tr>
            </table>     <!--SI NO llegara a ser así, entoces deberás buscar nuevamente al administrador para tener los datos correctos, esto luego de haber realizado la actualización y de haber salido todo nice xD-->                               
                    <input type="submit" id="acciones" name="accion"  value="CERRAR SESION">
            
        </form>
    </center>
    </body>
</html>
