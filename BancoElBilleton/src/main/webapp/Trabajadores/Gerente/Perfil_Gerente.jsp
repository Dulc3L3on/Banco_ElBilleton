<%-- 
    Document   : Perfil_Gerente
    Created on : 11/11/2020, 20:11:55
    Author     : phily
--%>

<%@page import="Modelo.Kit"%>
<%@page import="Modelo.Entidades.Usuarios.Gerente"%>
<%@page import="Modelo.Manejadores.DB.Buscador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../../css/cssGerente.css">
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>  
        <title>ManagerProfile</title>
         <%!Buscador buscador = new Buscador();
           Gerente gerente = null;
           Kit herramienta = new Kit();
           String contraseniaDesencripatada;%>
    </head>
    <body><!--por el hecho de tener que revisar si la sesión sigue activa, mandaré la dirección del gestor de los perfiles, en lugar de la página misma al momento de loguearse...-->        
        <%gerente = buscador.buscarGerente((String) request.getSession().getAttribute("codigo"));
          contraseniaDesencripatada = herramienta.desencriptarContrasenia(gerente.darContrasenia());%>   
    <center>
        <form method="POST" action="../../gestorModificacionGerente"><!--al final de cuentas el action irá al servlet xD pues ahí se trabaja la info xD...-->
            <table cellspacing="25">
                <tr>
                    <th>
                        <h4>CÓDIGO: <%=gerente.darCodigo()%></h4>
                    </th>
                </tr>                
                <th colspan="2">
                    <center>
                        <img src="../../img/administrador.png" alt="iconoGerente">
                    </center>                                    
                </th>                
                <tr>    
                    <th>
                        <input type="text" id="datosUsuario"  name="datosActualizar" placeholder="Nombre" value="<%=gerente.darNombre()%>"  required>
                    </th>
                    <th>
                        <input type="text" id="datosUsuario" name="datosActualizar" placeholder="Contraseña" value="<%=contraseniaDesencripatada%>" required>                                 
                    </th>                                               
                </tr>                
                <tr>                    
                    <th>
                        <input type="number" id="DPI"  name="DPI" placeholder="DPI" maxlength="13" value="<%=gerente.darDPI()%>" readonly>
                    </th>   
                     <th>
                        <input type="text" id="datosUsuario"  name="datosActualizar" placeholder="Direccion" value="<%=gerente.darDireccion()%>" required>
                    </th>   
                </tr>
                <tr>                                      
                    <th>
                     <input type="text" id="datosUsuario" name="genero" placeholder="Genero" value="<%=gerente.darSexo()%>" readonly> 
                    </th><!--pregunta.. cuando se coloca una var para que el input reciba un valor, cuando a este último le es cb su dato, implica que tb a la var???-->
                     <th>
                       <select name="datosActualizar" id="turno" style="width: 250px">
                            <option value="matutino" selected>Matutino</option><!--no creo que sea necesario poner un vacío en el valor... creo que con no declararlo basta...-->                                    
                            <option value="vespertino">Vespertino</option>
                       </select>
                   </th>
                </tr>                                                        
            </table>     <!--SI NO llegara a ser así, entoces deberás buscar nuevamente al administrador para tener los datos correctos, esto luego de haber realizado la actualización y de haber salido todo nice xD-->                                 
            <input type="submit" id="acciones" name="accion"  value="MODIFICAR">                        
       </form>                                           
    </center>        
    </body>
</html>
