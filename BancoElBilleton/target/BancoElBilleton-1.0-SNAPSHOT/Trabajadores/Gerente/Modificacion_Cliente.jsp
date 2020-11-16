<%-- 
    Document   : Modificacion_Cliente
    Created on : 11/11/2020, 20:16:34
    Author     : phily
--%>

<%@page import="Modelo.Entidades.Usuarios.Cliente"%>
<%@page import="Modelo.Manejadores.DB.Buscador"%>
<%@page import="Modelo.Kit"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../../css/cssGerente.css">
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>  
        <title>ModifyClient</title>
        <%!Buscador buscador = new Buscador();
           Cliente cliente = null;
           Kit herramienta = new Kit();
           String contraseniaDesencripatada;%>
    </head>
    <body>
         <form method="POST" action="Modificacion_Cliente.jsp"><!--si todo salió bien, entonces se refireccionará al servlet-->
            <center>
                <div id="general"><!--posiblemente lleve color xD o borde... o ambos xD-->
                    <h1>>>MODIFICAR CLIENTE<<</h1>                                                                                       
                    <br/>
                    <form method="POST" action="Modificacion_Cliente.jsp">
                        <table cellspacing="10px" cellpadding="5px">
                            <tr>                            
                                <th>                             
                                    <input type="number" name="codigoClienteBuscado" id="buscado" placeholder="Código del Cliente" required>                                
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
                    </form><!--para realizar la búsqueda del cliente y determinar si puede o no modificarlo [según su existencia]-->
                    
                    <%if(request.getParameter("codigoClienteBuscado")!=null){
                        cliente = buscador.buscarCliente(request.getParameter("codigoClienteBuscado"));
                      }
                    if(cliente!=null){//aunque podría estar dentro del if en el que se busca media vez halla algo para buscar... puesto que si no se busca, cliente == null, y si se busca pero existe fallo, entocnes seguirá siendo nulll, así que PUEDE ESTAR DENTRO, porque no hay una segunda redirección en la que mande el valor del cliente [establecerlo como atrib] y a partir de ello tenga que hacer algo con dicha info...
                        request.getSession().setAttribute("clienteAntiguo", cliente);
                        contraseniaDesencripatada = herramienta.desencriptarContrasenia(cliente.darContrasenia());
                        %>                        
                        <br>
                        <label style="position: relative; left:-325px;">>Datos Inmutables</label>                                       
                                                
                            <table cellspacing="10px" cellpadding="5px">                        
                                <tr>                            
                                    <th>
                                       <label><h5>Código:</h5></label>
                                    </th>
                                    <th>
                                        <input type="number" name="codigo" value ="<%=cliente.darCodigo()%>" id="codigoCliente" readonly>
                                    </th>
                                    <th>
                                        <label><h5>CUI:</h5></label>
                                    </th>
                                    <th>
                                        <input type="number" name="CUI" value ="<%=cliente.darDPI()%>" id="CUI" readonly>
                                    </th>                            
                                </tr>
                                    <tr>
                                      <th>
                                        <label><h5>Género:</h5></label>
                                    </th>
                                    <th>
                                        <input type="text" name="genero" id="genero" value ="<%=cliente.darSexo()%>" readonly>
                                    </th>
                                    <th>
                                        <label><h5>Nacimiento:</h5></label>
                                    </th>
                                    <th>
                                        <input type="date" name="birth" id="birth" value ="<%=cliente.darBirth()%>" style="width: 250px;" readonly><!--si quieres le mandas la fecha actual.... pero por ser "requerido" no hbará problemas de ausencia xD-->
                                    </th>
                                </tr>                         
                            </table>                                       
                            <br/>
                            <label style="position: relative; left:-325px;">>Datos Modificables</label>                         
                         
                        <form method="POST" enctype="multipart/form-data" action="../../gestorRecargaDPI" >
                            <%//request.setAttribute("pathAntiguo", cliente.darPath());%>
                            <input type="text" name="pathAntiguo" value="<%=cliente.darPath()%>" hidden>
                            <table cellspacing="10px" cellpadding="5px">                                          
                                <tr>
                                    <th>
                                        <label><h5>Nombre:</h5></label>
                                    </th>
                                    <th>
                                        <input type="text" name="datosActualizar" id="nombre" placeholde="Nombre" value ="<%=cliente.darNombre()%>" required>
                                    </th><!--OJO: los jsp que manden a tratar la info a un mismo servlet deben tener nombres distintos para campos de envío que sean del mismo tipo p.ej -> nombre... porque sino.... o no verdad, no hay problema, porque cada quien jalaría los datos en su propio bloque,dependiendo del argumento que envíen con el cual indicaran "quién" está enviando la info...-->                                                 
                                     <th>
                                        <label><h5>DPI:</h5></label>
                                    </th><!--esto ya es otra cosa, por el hecho de que no alamaceno directamente la img en la DB, sino el path... así que esto si no required xD-->
                                    <th>
                                       <input type="file" name="archDPI" accept=".pdf" id="dpi"><!--si quieres le mandas la fecha actual.... pero por ser "requerido" no hbará problemas de ausencia xD-->
                                    </th>
                                </tr>                                                          
                                <tr>
                                    <th>
                                        <label><h5>Dirección:</h5></label>
                                    </th>
                                    <th>
                                        <input type="text" name="datosActualizar" id="direccion" value ="<%=cliente.darDireccion()%>" required><!--si quieres le mandas la fecha actual.... pero por ser "requerido" no hbará problemas de ausencia xD-->
                                    </th>
                                    <th>
                                        <label><h5>Contraseña:</h5></label>
                                    </th>
                                    <th>
                                        <input type="text" name="datosActualizar" id="contrasenia" value ="<%=contraseniaDesencripatada%>" required><!--si quieres le mandas la fecha actual.... pero por ser "requerido" no hbará problemas de ausencia xD-->                                        
                                    </th><!--podrías poner un botón para que genere una nueva de forma aletaoria... pero eso se haría en el servlet, es decir tendría que ser un checkbox, pero con eso tendría que ser solo de lectura la contra...... si te da tiempo hazlo xD-->                                
                                </tr>                                           
                            </table>                                   
                            
                            <input type="submit" id="submit" name="submit" value="ACTUALIZAR CLIENTE" width="200px"><!--todos los sumbit sin importar de qué entidad sean y qué sea lo que suban tendrán el mismo aspecto...-->                    
                        </form>                     
                     <%}else if(cliente == null && request.getParameter("codigoClienteBuscado")!=null){%><!--Es decir se buscó, pero se falló en la búsqueda...-->    
                        <script src="../../js/sweetInexistente.js"></script>
                     <%}%>
                </div>
                
            </center>        
    </body>
</html>
