<%-- 
    Document   : Reportes_Cliente
    Created on : 13/11/2020, 12:31:11
    Author     : phily
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../css/cssReportes.css">
        <title>Reports</title>
    </head>
    <body>
        <center>
        <h1>>>REPORTES<<</h1>
     </center>       
        
        <div id="cintaOpcionesReporteCliente" style="width:"500px;"><!--de reportes xD-->
            <center>                
                <input type="submit" class="button" id="submit" name="reportes" value="15 Últimas Transacciones"><br/><br/>
                <input type="submit" class="button" id="submit" name="reportes" value="Todas las Transacciones"><br/><br/>
                <input type="submit" class="button" id="submit" name="reportes" value="Clientes con grandes sumas"><br/><br/>
                <input type="submit" class="button" id="submit" name="reportes" value="Cuenta con + dinero"><br/><br/>                
            </center>            
        </div>               
            <iframe src="" title="Reportes" id="frameReportes">      
    </body>
</html>
