<%-- 
    Document   : Login_Cliente
    Created on : 11/11/2020, 20:17:48
    Author     : phily
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/cssUsuario.css">
        <title>UserLogin</title>
        
    </head>
    <body class="cuerpo">
        <center>
            <div id ="banner">                
                <img src="img/Logos_ElBilleton/logo1_0_ElBilleton.png" id="img">
            </div>                 
            <div id="divLogin">      
                
                <form method="POST" action="gestorLogin">             
                  <table cellspacing="25">
                      <th>
                          <img src="img/profile.png" id="img">
                      </th>
                      <tr>
                          <th>
                              <input type="text" id="userData" name="username" placeholder="Username" required>
                          </th><!--si quieres recibir la info en un arreglo entonces nombra a estos comp IGUAL xd-->
                      </tr>
                      <tr>
                          <th>
                            <input type="password" id="userData" name="password" placeholder="Password" required>
                          </th>
                      </tr> 
                      <tr>
                           <th>
                               <input type="radio" name="tipoUsuario" value ="cliente" id="cliente" checked>
                                <label for="cliente">Cliente</label>                            
                            
                               <input type="radio" name="tipoUsuario" value ="cajero" id="cajero">
                               <label for="cajero">Cajero</label>

                               <input type="radio" name="tipoUsuario" value ="gerente" id="gerente">
                               <label for="gerente">Gerente</label>
                            </th>
                      </tr>
                          
                      <tr>
                          <th>
                              <input type ="submit" id="infoLog" name="login" value="LOGIN">
                          </th>
                      </tr>                                                
                  </table>                                       
                </form>
            </div>                     
        </center>               
    </body>
</html>
