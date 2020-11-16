<%-- 
    Document   : Perfil_Cajero
    Created on : 11/11/2020, 20:12:09
    Author     : phily
--%>

<%@page import="Modelo.Entidades.Usuarios.Cliente"%>
<%@page import="Modelo.Entidades.Usuarios.Cajero"%>
<%@page import="Modelo.Entidades.Usuarios.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/cssGerente.css">
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script> 
        <title>ResultCreation</title>
    </head>
    <body>     
        <center>
            <%if(request.getAttribute("mostrarError")== null){%>
                <table> 
                    <tr>
                        <th colspan="4">
                            <center>
                                <img src="img/iconUser.png">
                            </center>                            
                        </th>
                    </tr>
                    <tr>
                        <th colspan="4">
                            <h2>>>>>DATOS DEL USUARIO<<<<</h2>
                        </th>
                    </tr>
                    <tr>
                        <th>
                            <h4><strong>Código:</strong></h4>
                        </th>
                        <th>
                            <h5>${usuario.darCodigo()}</h5>
                        </th>
                        <th>
                            <h4><strong>Nombre:</strong></h4>
                        </th>
                        <th>
                            <h5>${usuario.darNombre()}</h5>
                        </th>
                    </tr>
                    <tr>
                        <th>
                            <h4><strong>Password:</strong></h4>
                        </th>
                        <th>
                            <h5>${usuario.darContrasenia()}</h5>
                        </th>
                        <th>
                            <h4><strong>DPI:</strong></h4>
                        </th>
                        <th>
                            <h5>${usuario.darDPI()}</h5>
                        </th>                    
                    </tr>
                    <tr>
                        <th>
                            <h4><strong>Dirección:</strong></h4>
                        </th>
                        <th>
                            <h5>${usuario.darDireccion()}</h5>
                        </th>
                        <th>
                            <h4><strong>Sexo:</strong></h4>
                        </th>
                        <th>
                            <h5>${usuario.darSexo()}</h5>
                        </th>
                    </tr>
                    <tr>
                        <%if(request.getAttribute("birth")!=null){%>
                            <th>
                                <h4><strong>Cumpleaños:</strong></h4>
                            </th>
                            <th>
                                <h5>${usuario.darBirth()}</h5><!--o bien podrías usar birth, para colocar el valor de na vez xD...-->
                            </th>
                        <%}%>
                        <%if(request.getAttribute("turno")!=null){%>
                            <th>
                                <h4><strong>Turno:</strong></h4>
                            </th>
                            <th>
                                <h5>${turno.toString()}</h5><!--o bien podrías usar birth, para colocar el valor de na vez xD...-->
                            </th>
                        <%}%>                        
                    </tr>                                           
                </table><!--esto debería ser reemplazado por el html del JR...-->                                    
            <%}else{%>             
                <script src="js/sweetError.js"></script>            
            <%}%>    
        </center>    
         <!--NOTA: podrías crear una clase que tuviera todos los atrib de los usuarios, de tal forma que pudiera llenarse como cliente, admin o caj, según se necesitara, para evitar el casteo...-->
         
        <!--aquí iría el botoncito para descargar el resumen...-->
        
    </body>
</html>
