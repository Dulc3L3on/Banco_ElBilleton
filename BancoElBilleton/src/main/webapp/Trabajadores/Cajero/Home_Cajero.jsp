<%-- 
    Document   : Home_Cajero
    Created on : 11/11/2020, 20:10:35
    Author     : phily
--%>

<%@page import="Modelo.Manejadores.Web.ManejadorNavegacion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../../css/cssTrabajador.css">
        <title>CashierHome</title>
        <%!ManejadorNavegacion navegador = new ManejadorNavegacion();//<!--al prinicpio [es decir después de loguearse], se llegará aquí por medio del doGet del servlet Perfil o LOgin xD [mejor login xD] luego de crear a la entidad correspondiente [por medio de un parmetro que indicará el tipo al métoodo correspondiente, que por el hecho de no tener que devolver nada puede crearse a los usuarios sin tener que quitarles su mero nombre xD p.ej-> CLIENTE a USUARIO y de instanciar sus valores con el setAttribute[auque por usar singleton, creo que no seá muy útil...creo xD]... de tal forma que al ya estar logueado,s e exe con normalidad este proceso...-->
        String pagina;%> 
    </head>
    <body>
        <%pagina = navegador.darPaginasAlCajero(request.getParameter("opcion"));%>
        <div id="menuCajero">                          
            <form method="POST" accion="Home_Cajero">
                <center>        
                    <br/>
                    <input type="submit" class="button" id="opciones" name="opcion" value="DEPOSITO" >
                    <input type="submit" class="button" id="opciones" name="opcion" value="RETIRO" >
                    <input type="submit" class="button" id="opciones" name="opcion" value="REPORTES" >
                    <a href="Home_Cajero.jsp"><img src="../../img/IconoPerfil.png" width="50" height="50" id="perfil"></a>
                    <a href="../../gestorLogout"><img src="../../img/off.png" width="50" height="50" id="off"></a>
                </center>                   
            </form>                                            
        </div>                
        <br/>
        <hr>      
        
        <iframe src="<%=pagina%>" id="frameCajero"></iframe>
    </body>
</html>
