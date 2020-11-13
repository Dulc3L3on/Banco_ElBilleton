<%-- 
    Document   : Asociacion
    Created on : 12/11/2020, 23:06:29
    Author     : phily
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../css/cssCliente.css">
        <title>Association</title>
    </head>
    <body>
        <div id="titulo" left="auto">
            <h5>>>ASOCIACIÓN<<</h5>
        </div>
        <div id="cintaOpciones">
            <table>
                <tr>
                    <th>
                        <input type="submit" id="submit" name="submit" value="ENVIAR">            
                    </th>
                </tr>
                <tr>
                    <th>
                        <input type="submit" id="submit" name="submit" value="RECIBIDAS">
                    </th>
                </tr>
                <tr>
                    <th>
                        <input type="submit" id="submit" name="submit" value="REDACTADAS">
                    </th>
                </tr><!--recuerda que con un mismo nombre formas un grupo de componentes, de tal forma que se pueda obtener el valor solo de aquel con el que interactuó el cliente, de la forma que se esperaba-->
            </table>                       
        </div>
        <!--<div id="divAsociacion">-->
            <iframe id="frameAsociacion"></iframe>
        <!--</div>-->
    </body>
</html>
