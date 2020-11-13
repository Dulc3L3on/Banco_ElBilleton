<%-- 
    Document   : Home_Gerente
    Created on : 11/11/2020, 20:10:15
    Author     : phily
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../../css/cssTrabajador.css">
        <title>ManagerHome</title>
    </head>
    <body>
        <div id="menuGerente">               
            <!--<img src="../../img/Logos_ElBilleton/logo2-1ElBilleton.png" height="70" width="135">-->                       
            <form method="POST" accion="Home_Gerente">
                <center>        
                    <br/>
                    <input type="submit" class="button" id="opciones" name="opcion" value="CRECIÓN" >
                    <input type="submit" class="button" id="opciones" name="opcion" value="MODIFICACIÓN" >
                    <input type="submit" class="button" id="opciones" name="opcion" value="REPORTES" >
                    <a href="Home_Gerente.jsp"><img src="../../img/IconoPerfil.png" width="50" height="50" id="perfil"></a>
                </center>                   
            </form>                                            
        </div>                
        <br/>
        <hr>      
        
        <iframe id="frameGerente"></iframe>
            
    </body>
</html>
