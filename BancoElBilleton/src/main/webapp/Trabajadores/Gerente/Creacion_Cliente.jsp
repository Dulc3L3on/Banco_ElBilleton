<%-- 
    Document   : Creacion_Cliente
    Created on : 11/11/2020, 20:15:22
    Author     : phily
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../../css/cssGerente.css">
        <title>CreateClient</title>
    </head>
    <body>
         <form method="POST" action="Creacion_Cliente" enctype="multipart/form-data"><!--si todo salió bien, entonces se refireccionará al servlet-->
            <center>
                <div id="general"><!--posiblemente lleve color xD o borde... o ambos xD-->
                    <h1>>>CREAR CLIENTE<<</h1>    
                    <br/>
                    <label style="position: relative; left:-250px;">>Datos del Nuevo Cliente</label>
                    <table>                                          
                        <tr>
                            <th colspan='4'>
                                <hr>
                            </th>
                        </tr>
                        <tr>
                            <th>
                                <label><h5>Nombre:</h5></label>
                            </th>
                            <th>
                                <input type="text" name="nombre" id="nombre" placeholde="Nombre" required>
                            </th><!--OJO: los jsp que manden a tratar la info a un mismo servlet deben tener nombres distintos para campos de envío que sean del mismo tipo p.ej -> nombre... porque sino.... o no verdad, no hay problema, porque cada quien jalaría los datos en su propio bloque,dependiendo del argumento que envíen con el cual indicaran "quién" está enviando la info...-->                                                 
                             <th>
                                <label><h5>CUI:</h5></label>
                            </th>
                            <th>
                                <input type="number" name="CUI" id="CUI" placeholde="CUI" required>
                            </th>
                        </tr>        
                         <tr>
                           <th>
                                <label><h5>Correo:</h5></label>
                            </th>
                            <th>
                                <input type="email" name="correo" id="correo" required><!--si quieres le mandas la fecha actual.... pero por ser "requerido" no hbará problemas de ausencia xD-->
                            </th>
                            <th>
                                <label><h5>Dirección:</h5></label>
                            </th>
                            <th>
                                <input type="text" name="direccion" id="direccion" required><!--si quieres le mandas la fecha actual.... pero por ser "requerido" no hbará problemas de ausencia xD-->
                            </th>
                        </tr>   
                         <tr>                            
                            <th>
                                <label><h5>Nacimiento:</h5></label>
                            </th>
                            <th>
                                <input type="date" name="bith" id="birth" required><!--si quieres le mandas la fecha actual.... pero por ser "requerido" no hbará problemas de ausencia xD-->
                            </th>
                             <th>
                                <label><h5>Género:</h5></label>
                            </th>
                            <th>
                                 <select name="genero" id="genero" width ="225px" required>
                                    <option value="femenino">Femenino</option><!--no creo que sea necesario poner un vacío en el valor... creo que con no declararlo basta...-->
                                    <option value="masculino">Masculino</option>
                                </select>
                            </th>
                        </tr>   
                         <tr>
                            <th>
                                <label><h5>DPI:</h5></label>
                            </th>
                            <th>
                                <input type="file" name="DPI" id="dpi" accept="pdf" required><!--si quieres le mandas la fecha actual.... pero por ser "requerido" no hbará problemas de ausencia xD-->
                            </th>
                        </tr>                      
                    </table>                                   
                    
                    <input type="submit" id="submit" name="crearCliente" value="CREAR CLIENTE" width="200px"><!--todos los sumbit sin importar de qué entidad sean y qué sea lo que suban tendrán el mismo aspecto...-->                    
                </div>
                
            </center>
        </form>
    </body>
</html>
