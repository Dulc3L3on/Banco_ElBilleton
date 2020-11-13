<%-- 
    Document   : Home_Cliente
    Created on : 11/11/2020, 20:10:45
    Author     : phily
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../css/cssCliente.css">
        <title>ClientHome</title>        
    </head>
    <body>
         <div id="menu">                           
            <form method="POST" accion="Home_Cliente">
                <center>    
                    <br/>
                    <br/>
                    <br/>
                    <input type="submit" class="button" id="opciones" name="opcion" value="TRANSACCIÓN" >
                    <input type="submit" class="button" id="opciones" name="opcion" value="ASOCIACIÓN" >
                    <input type="submit" class="button" id="opciones" name="opcion" value="REPORTES" >
                    <a href="Home_Cliente.jsp"><img src="../img/IconoPerfil.png" width="50" height="50" id="perfil"></a>
                </center>                   
            </form>                                            
        </div>                
        <br/>
        <hr>      
        
        <iframe id="frameCliente"></iframe>
    </body>
</html>
