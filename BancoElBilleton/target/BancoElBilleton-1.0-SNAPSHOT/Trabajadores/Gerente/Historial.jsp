<%-- 
    Document   : Home_Cajero
    Created on : 11/11/2020, 20:10:35
    Author     : phily
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../../css/cssGerente.css">
        <title>RECORD</title>
    </head>
    <body>
        <center>
            <h1>>>HISTORIAL<<</h1>
                    
        
        <%for(int dato =0; dato <7; dato++){%><!--aquí la lectura de los datos formateados...-->        
                <h6>Los datos</h6><br/>               
        <%}%>
        
         <input type="submit" id="submit" name="sumbmit" value="VER HISTORIAL COMPLETO">
        </center>
    </body>
</html>
