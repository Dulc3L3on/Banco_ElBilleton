<%-- 
    Document   : Login_Trabajadores
    Created on : 11/11/2020, 20:18:02
    Author     : phily
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JobLogin</title>
        <link rel="stylesheet" href="css/cssLoginTrabajador.css">
    </head>
    <body>
    <div id="frameIzquierdo">
        <center>
            <img src="img/Logos_ElBilleton/logo2-1ElBilleton.png" id="logo2">
        </center>                       
    </div>
    <div id="frameDerecho">
        <form method="POST" actio="gestorLogin">                        
                <input type ="radio" name="tipoTrabajador" id="cajero" value="cajero">
                <label for="cajero">Cajero</label>
                <input type ="radio" name="tipoTrabajador" id="gerente" value="gerente">
                <label for="gerente">Gerente</label>
            
            <center>
                <table cellspacing="25" id="tableUserData">
                    <tr>
                        <th>
                            <input type="text" placeholder="Username" name="username" id="userData" required>
                        </th>                        
                    </tr>
                    <tr>
                        <th>
                            <input type="password" placeholder="Password" name="password" id="userData" required>
                        </th>
                    </tr>           
                    <tr>
                        <th>
                            <input type="submit" name="login" value="LOGIN" id="infoLog">
                        </th>                        
                    </tr>
                </table>                
            </center>
            
        </form>               
    </div>
    </body>
</html>
