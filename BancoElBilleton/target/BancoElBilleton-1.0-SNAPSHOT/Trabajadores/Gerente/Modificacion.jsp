<%-- 
    Document   : Modificacion
    Created on : 11/11/2020, 20:16:17
    Author     : phily
--%>

<%@page import="Modelo.Manejadores.Web.ManejadorNavegacion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../../css/cssAcciones.css">
        <title>MODIFY</title>
         <%!ManejadorNavegacion navegador = new ManejadorNavegacion();//<!--al prinicpio [es decir después de loguearse], se llegará aquí por medio del doGet del servlet Perfil o LOgin xD [mejor login xD] luego de crear a la entidad correspondiente [por medio de un parmetro que indicará el tipo al métoodo correspondiente, que por el hecho de no tener que devolver nada puede crearse a los usuarios sin tener que quitarles su mero nombre xD p.ej-> CLIENTE a USUARIO y de instanciar sus valores con el setAttribute[auque por usar singleton, creo que no seá muy útil...creo xD]... de tal forma que al ya estar logueado,s e exe con normalidad este proceso...-->
        String pagina;%> 
    </head>
    <body>
          <%pagina = navegador.darPaginasModificacion(request.getParameter("opcion"));%>
        <div id="cintaOpcionesAccion">
            <form method="POST" action="Modificacion.jsp">
                <input type="submit" class="button" id="submit" name="opcion" value="Cliente"><br/><br/>
                <input type="submit" class="button" id="submit" name="opcion" value="Cajero"><br/><br/><!--si llegar a haber problema con el hecho de tener los mismo nombre para los input, entonces solo camiale el nombre a cada grupo xd, aunque lo dudo por el hecho de ser realizados los procesos por el correspondiente servlet general de cada "agrupación"-->
            </form>
            
        </div>
        
        <!--igual que con la página principal, debería tener un métood para dar la ágina que corresponde...-->
        <iframe src="<%=pagina%>" title="Modificacion" id="frameAccion"></iframe>
    </body>
</html>
