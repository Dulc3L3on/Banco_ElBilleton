<%-- 
    Document   : Perfil_Cajero
    Created on : 11/11/2020, 20:12:09
    Author     : phily
--%>

<%@page import="Modelo.Kit"%>
<%@page import="Modelo.Entidades.Usuarios.Cajero"%>
<%@page import="Modelo.Manejadores.DB.Buscador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../../css/cssCajero.css">
        <title>CashierProfile</title>
        <%!Buscador buscador = new Buscador();
           Cajero cajero = null;
           Kit herramienta = new Kit();
           String contraseniaDesencripatada;%>
    </head>
    <body>
       <%cajero = buscador.buscarCajero((String) request.getSession().getAttribute("codigo"));
        contraseniaDesencripatada = herramienta.desencriptarContrasenia(cajero.darContrasenia());%>   
         <center>                   
             <tr>
                <th>
                    <h4>CÓDIGO: <%=cajero.darCodigo()%></h4>
                </th>
             </tr>
            <table cellspacing="25">
                <th colspan="2">
                    <center>
                        <img src="../../img/Trabajadores.png" alt="iconoCajeros">
                    </center>                                    
                </th>                
                <tr> 
                    <th>
                        <input type="text" id="datosUsuario"  name="nombre" placeholder="Nombre" value="<%=cajero.darNombre()%>"readonly>
                    </th>
                    <th>
                        <input type="text" id="datosUsuario" name="password" placeholder="Contraseña" value="<%=contraseniaDesencripatada%>" readonly>                                 
                    </th>                                                                 
                </tr>                
                <tr>  
                    <th>
                        <input type="text" id="datosUsuario"  name="turno" placeholder="Turno" value="<%=cajero.darTipoTurno()%>" readonly>
                    </th> 
                    <th>
                        <input type="number" id="datosUsuario"  name="DPI" placeholder="DPI" maxlength="13" value="<%=cajero.darDPI()%>" readonly>
                    </th>                                                                                                 
                </tr>
                <tr>                   
                    <th>
                     <input type="text" id="datosUsuario" name="genero" placeholder="Genero" value="<%=cajero.darSexo()%>" readonly> 
                    </th><!--pregunta.. cuando se coloca una var para que el input reciba un valor, cuando a este último le es cb su dato, implica que tb a la var???-->
                    <th>
                        <input type="text" id="datosUsuario"  name="direccion" placeholder="Direccion" value="<%=cajero.darDireccion()%>" readonly>
                    </th>                                                                 
                </tr>                                                                     
            </table>     <!--SI NO llegara a ser así, entoces deberás buscar nuevamente al administrador para tener los datos correctos, esto luego de haber realizado la actualización y de haber salido todo nice xD-->                                                                       </form>
    </center>
    </body>
</html>
