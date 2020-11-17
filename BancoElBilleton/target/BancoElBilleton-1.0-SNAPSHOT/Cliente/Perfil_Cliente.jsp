<%-- 
    Document   : Perfil_Cliente
    Created on : 11/11/2020, 20:13:54
    Author     : phily
--%>

<%@page import="Modelo.Kit"%>
<%@page import="Modelo.Entidades.Usuarios.Cliente"%>
<%@page import="Modelo.Manejadores.DB.Buscador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../css/cssCliente.css">
        <title>ClientProfile</title>
        <%!Buscador buscador = new Buscador();
           Cliente cliente = null;
           Kit herramienta = new Kit();
           String contraseniaDesencripatada;%> 
    </head>
    <body>       
     <%cliente = buscador.buscarCliente((String) request.getSession().getAttribute("codigo"));
       contraseniaDesencripatada = herramienta.desencriptarContrasenia(cliente.darContrasenia());%> 
       <center>
        <form method="POST" action="Perfil_Cliente.jsp"><!--al final de cuentas el action irá al servlet xD pues ahí se trabaja la info xD...-->
            <table cellspacing="25">
                <tr>
                     <th>
                        <h4>CÓDIGO: <%=cliente.darCodigo()%></h4>
                    </th>
                </tr>
                <th colspan="2">
                    <center>
                        <img src="../img/usuarios.png" alt="iconoUsuarios">
                    </center>                                    
                </th>                
                <tr>
                   <th>
                       <input type="text" id="datosUsuario"  name="nombre" placeholder="Nombre" value="<%=cliente.darNombre()%>" readonly>
                   </th>
                    <th>
                        <input type="text" id="datosUsuario" name="password" placeholder="Contraseña" value="<%=contraseniaDesencripatada%>" readonly>                                 
                    </th>                                               
                </tr>                
                <tr>                    
                    <th>
                        <input type="number" id="datosUsuario"  name="DPI" placeholder="DPI" maxlength="13" value="<%=cliente.darDPI()%>" readonly>
                    </th>                                                                             
                    <th>
                        <input type="text" id="datosUsuario"  name="direccion" placeholder="Direccion" value="<%=cliente.darDireccion()%>" readonly>
                    </th>                       
                </tr>
                <tr>                    
                    <th>
                        <input type="text" id="datosUsuario" name="genero" placeholder="Genero" value="<%=cliente.darSexo()%>" readonly> 
                    </th><!--pregunta.. cuando se coloca una var para que el input reciba un valor, cuando a este último le es cb su dato, implica que tb a la var???-->
                    <th>
                        <input type="date" id="datosUsuario" name="birth" value="<%=cliente.darBirth()%>" readonly> 
                    </th>
                </tr>                  
            </table>     <!--SI NO llegara a ser así, entoces deberás buscar nuevamente al administrador para tener los datos correctos, esto luego de haber realizado la actualización y de haber salido todo nice xD-->                                                                      
        </form>
    </center>
    </body>
</html>
