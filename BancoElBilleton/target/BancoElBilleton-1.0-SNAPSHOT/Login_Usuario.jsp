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
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>  
        <title>UserLogin</title>        
    </head>
    <body class="cuerpo">
        <center>
            <div id ="banner">                
                <img src="img/Logos_ElBilleton/logo1_0_ElBilleton.png" id="img">                
            </div>                 
            <div id="divLogin">      
                
                <form method="POST" action="gestorLogin"><!--sería  bueno hacer que cuando cierren la página pero no cerraron sesión que cuando vuelva a colocar Login_Usuario lo redireccionara de una vez a us HOme xD puesto que si existía un codigo [id] rgistrado en la sesión...-->             
                  <table cellspacing="25">
                      <th>
                          <img src="img/profile.png" id="img">
                      </th>
                      <tr>
                          <th>
                              <input type="text" id="userData" name="username" placeholder="Username [codigo usuario]" required>
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
                 <%if(request.getSession().getAttribute("mostrarErrorLog")!=null){%><!--pero debes revisar que no provoque problemas por el hecho de no borrarlo, o de colocar la línea para borrarlo pero no se elimina...-->
                          <script src="js/sweetErrorLogin.js"></script>
                 <%}%>
            </div>                     
        </center>               
    </body>
</html>
