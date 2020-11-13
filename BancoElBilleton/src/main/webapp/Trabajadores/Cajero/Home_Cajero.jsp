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
        <link rel="stylesheet" href="../../css/cssTrabajador.css">
        <title>CashierHome</title>
    </head>
    <body>
        <div id="menuCajero">                          
            <form method="POST" accion="Home_Cajero">
                <center>        
                    <br/>
                    <input type="submit" class="button" id="opciones" name="opcion" value="DEPÓSITO" >
                    <input type="submit" class="button" id="opciones" name="opcion" value="RETIRO" >
                    <input type="submit" class="button" id="opciones" name="opcion" value="REPORTES" >
                    <a href="Home_Cajero.jsp"><img src="../../img/IconoPerfil.png" width="50" height="50" id="perfil"></a>
                </center>                   
            </form>                                            
        </div>                
        <br/>
        <hr>      
        
        <iframe id="frameGerente"></iframe>
    </body>
</html>
