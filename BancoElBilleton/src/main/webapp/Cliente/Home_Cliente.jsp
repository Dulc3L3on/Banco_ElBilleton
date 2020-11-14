<%-- 
    Document   : Home_Cliente
    Created on : 11/11/2020, 20:10:45
    Author     : phily
--%>

<%@page import="Modelo.Manejadores.Web.ManejadorNavegacion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../css/cssCliente.css">
        <title>ClientHome</title>        
        <%!ManejadorNavegacion navegador = new ManejadorNavegacion();//<!--al prinicpio [es decir después de loguearse], se llegará aquí por medio del doGet del servlet Perfil o LOgin xD [mejor login xD] luego de crear a la entidad correspondiente [por medio de un parmetro que indicará el tipo al métoodo correspondiente, que por el hecho de no tener que devolver nada puede crearse a los usuarios sin tener que quitarles su mero nombre xD p.ej-> CLIENTE a USUARIO y de instanciar sus valores con el setAttribute[auque por usar singleton, creo que no seá muy útil...creo xD]... de tal forma que al ya estar logueado,s e exe con normalidad este proceso...-->
        String pagina;%> 
    </head>
    <body>
        <%pagina = navegador.darPaginasAlCliente(request.getParameter("opcion"));%>
         <div id="menu">                           
            <form method="POST" accion="Home_Cliente">
                <center>    
                    <br/>
                    <br/>
                    <br/>
                    <input type="submit" class="button" id="opciones" name="opcion" value="TRANSFERENCIA" >
                    <input type="submit" class="button" id="opciones" name="opcion" value="ASOCIACION" >
                    <input type="submit" class="button" id="opciones" name="opcion" value="REPORTES" >
                    <a href="Home_Cliente.jsp"><img src="../img/IconoPerfil.png" width="50" height="50" id="perfil"></a>
                </center>                   
            </form>                                            
        </div>                
        <br/>
        <hr>      
        
        <iframe src="<%=pagina%>" id="frameCliente"></iframe>
    </body>
</html>
