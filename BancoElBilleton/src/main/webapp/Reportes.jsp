<%-- 
    Document   : Reportes
    Created on : 11/11/2020, 20:14:31
    Author     : phily
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/cssReportes.css">
        <title>Reports</title>
    </head>
    <body>
    <center>
        <h1>>>REPORTES<<</h1>
     </center>       
        
        <div id="cintaOpciones" style="width:"500px;"><!--de reportes xD-->
            <center>
                <%for(int boton=0; boton <7; boton++){%>
                    <input type="submit" class="button" id="submit" name="reportes" value="el que corresponde xD"><br/><br/>
                <%}%>
            </center>            
        </div>               
            <iframe src="" title="Reportes" id="frameReportes">                   
   
    </body>
</html>
