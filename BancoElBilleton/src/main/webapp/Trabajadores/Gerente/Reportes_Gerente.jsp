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
        <link rel="stylesheet" href="../../css/cssReportes.css">
        <title>Reports</title>
    </head>
    <body>
    <center>
        <h1>>>REPORTES<<</h1>
     </center>       
        
        <div id="cintaOpcionesReporteGerente" style="width:"500px;"><!--de reportes xD-->
            <center>                
                <input type="submit" class="button" id="submit" name="reportes" value="Historial de cambios"><br/><br/>
                <input type="submit" class="button" id="submit" name="reportes" value="Clientes grandes transacciones"><br/><br/>
                <input type="submit" class="button" id="submit" name="reportes" value="Clientes con grandes sumas"><br/><br/>
                <input type="submit" class="button" id="submit" name="reportes" value="10 con mas dinero"><br/><br/>
                <input type="submit" class="button" id="submit" name="reportes" value="Clientes desaparecidos"><br/><br/>
                <input type="submit" class="button" id="submit" name="reportes" value="Historial Transacciones"><br/><br/>                
                <input type="submit" class="button" id="submit" name="reportes" value="Cajero más eficiente"><br/><br/>                
            </center>            
        </div>               
            <iframe src="" title="Reportes" id="frameReportes">                   
   
    </body>
</html>
<!--creo que si habrá que tener un css solo para los reportes xd, puesto que si para mostrar el cuadro normal para visualizar los pdf, tiene que descargarse de primero los reportes al servisdor [mi compu xD] para luego abrirlos con el navegador... entonces mejro solo pongo cada botoncito que descargará a la computadora del cliente [en este caso tb mi compu xD, o la del inge xD según suceda xD] el doc [como nos enseño en auxi]...-->