<%-- 
    Document   : Modificacion_Cajero
    Created on : 11/11/2020, 20:16:46
    Author     : phily
--%>

<%@page import="Modelo.Entidades.Usuarios.Cajero"%>
<%@page import="Modelo.Manejadores.DB.Buscador"%>
<%@page import="Modelo.Kit"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../../css/cssGerente.css">
        <title>ModifyCashier</title>
        <%!Buscador buscador = new Buscador();
           Cajero cajero = null;
           Kit herramienta = new Kit();
           String contraseniaDesencripatada;%>
    </head>
    <body>
         <form method="POST" action="Modificacion_Cajero.jsp"><!--si todo salió bien, entonces se refireccionará al servlet-->
            <center>
                <div id="general"><!--posiblemente lleve color xD o borde... o ambos xD-->
                    <h1>>>MODIFICAR CAJERO<<</h1>                                                                   
                    <br/>
                    <form method="POST" action="Modificacion_Cajero.jsp">
                        <table cellspacing="10px" cellpadding="5px">
                            <tr>                            
                                <th>                             
                                    <input type="number" name="codigoCajeroBuscado" id="buscado" placeholder="Código del Cajero" required>                                
                                </th>
                                <th>
                                    <input type="submit" name="buscar" id="submit" value="BUSCAR">
                                </th><!--desapareció la op de nuevo cliente, por el hecho de que se debía ingresar los datos, puesto que era un form interno, entoces debía acudir a su padre... el cual no podría llenarse y por ello no crearse el cliente...-->                                                                                      
                            </tr>        
                            <tr>
                                <th colspan="2">
                                    <hr>
                                </th>
                            </tr>
                        </table>
                    </form>
                     <%if(request.getParameter("codigoCajeroBuscado")!=null){
                        cajero = buscador.buscarCajero(request.getParameter("codigoCajeroBuscado"));
                      }
                    if(cajero!=null){//aunque podría estar dentro del if en el que se busca media vez halla algo para buscar... puesto que si no se busca, cliente == null, y si se busca pero existe fallo, entocnes seguirá siendo nulll, así que PUEDE ESTAR DENTRO, porque no hay una segunda redirección en la que mande el valor del cliente [establecerlo como atrib] y a partir de ello tenga que hacer algo con dicha info...
                        request.getSession().setAttribute("cajeroAntiguo", cajero);                        
                        contraseniaDesencripatada = herramienta.desencriptarContrasenia(cajero.darContrasenia());
                    %>   
                    <br>
                    <label style="position: relative; left:-325px;">>Datos Inmutables</label>   
                    
                    <table>                        
                        <tr>                            
                            <th>
                               <label><h5>Código:</h5></label>
                            </th>
                            <th>
                                <input type="number" name="codigo" value ="<%=cajero.darCodigo()%>" id="codigoCajero" readonly>
                            </th>
                            <th>
                                <label><h5>CUI:</h5></label>
                            </th>
                            <th>
                                <input type="number" name="CUI" value ="<%=cajero.darDPI()%>" id="CUI" readonly>
                            </th>                            
                        </tr>
                        <tr>
                            <th>
                                <label><h5>Género:</h5></label>
                            </th>
                            <th>
                                <input type="text" name="genero" value ="<%=cajero.darSexo()%>" id="genero" readonly>
                            </th>                            
                        </tr>
                    </table>                                                                                                                                                                     
                    
                    <br/>
                    <label style="position: relative; left:-325px;">>Datos Modificables</label> 
                    <form method="POST" action="../../gestorModificacionCajero" >
                        <table cellspacing="10px" cellpadding="5px">                                          
                            <tr>
                                <th>
                                    <label><h5>Nombre:</h5></label>
                                </th>
                                <th>
                                    <input type="text" name="datosActualizar" id="nombre" value ="<%=cajero.darNombre()%>" placeholde="Nombre" required>
                                </th><!--OJO: los jsp que manden a tratar la info a un mismo servlet deben tener nombres distintos para campos de envío que sean del mismo tipo p.ej -> nombre... porque sino.... o no verdad, no hay problema, porque cada quien jalaría los datos en su propio bloque,dependiendo del argumento que envíen con el cual indicaran "quién" está enviando la info...-->                                                 
                                <th>
                                    <label><h5>Dirección:</h5></label>
                                </th>
                                <th>
                                    <input type="text" name="datosActualizar" value ="<%=cajero.darDireccion()%>" id="direccion" required><!--si quieres le mandas la fecha actual.... pero por ser "requerido" no hbará problemas de ausencia xD-->
                                </th>                                
                            </tr>                                                         
                            <tr>                                                        
                                <th>
                                    <label><h5>Password:</h5></label>
                                </th>
                                <th>
                                    <input type="text" name="datosActualizar" value ="<%=contraseniaDesencripatada%>" id="password" required><!--si quieres le mandas la fecha actual.... pero por ser "requerido" no hbará problemas de ausencia xD-->
                                </th>                           
                                <th>
                                    <label><h5>Turno:</h5></label><!--solo con este si no se como mandarle el valor que tenía gurardado y como 2da opción el que no xD-->
                                </th>
                                <th>
                                    <select name="datosActualizar" id="turno" style="width: 250px" readonly>
                                        <option value="matutino" selected>Matutino</option><!--no creo que sea necesario poner un vacío en el valor... creo que con no declararlo basta...-->                                    
                                        <option value="vespertino" selected>Vespertino</option>
                                    </select>
                                </th>
                            </tr>                               
                        </table>                                                       
                        <input type="submit" id="submit" name="modificarCajero" value="ACTUALIZAR CAJERO" width="200px"><!--todos los sumbit sin importar de qué entidad sean y qué sea lo que suban tendrán el mismo aspecto...-->                    
                    </form>   
                 <%}else if(cajero == null && request.getParameter("codigoCajeroBuscado")!=null){%><!--Es decir se buscó, pero se falló en la búsqueda...-->    
                        <script src="../../js/sweetInexistente.js"></script>
                 <%}%>
                </div>                
            </center>
        </form>
    </body>
</html>
