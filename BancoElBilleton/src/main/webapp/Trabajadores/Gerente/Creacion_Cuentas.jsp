<%-- 
    Document   : Creacion_Cuentas
    Created on : 11/11/2020, 20:15:03
    Author     : phily
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../../css/cssGerente.css">
        <title>CreateAccount</title>
    </head>
    <body>
        <form method="POST" action="Creacion_Cuentas.jsp"><!--si todo salió bien, entonces se refireccionará al servlet-->
            <center>
                <div id="general"><!--posiblemente lleve color xD o borde... o ambos xD-->
                    <h1>>>CREAR CUENTA<<</h1>                                                                   

                    <table cellspacing="10px" cellpadding="5px">                                        
                        
                        <tr>                            
                            <th>                             
                                <input type="number" name="codigoClienteBuscado" id="buscado" required>                                
                            </th>
                            <th>
                                <input type="submit" name="submit" id="submit" value="BUSCAR">
                            </th><!--desapareció la op de nuevo cliente, por el hecho de que se debía ingresar los datos, puesto que era un form interno, entoces debía acudir a su padre... el cual no podría llenarse y por ello no crearse el cliente...-->                                                      
                        </tr>                        
                    </table>                    
                     <hr>
            
                 <table cellpadding="10px">
                    <tr>
                       <th colspan="2">
                           <h4>------------->>Datos del cliente<<-------------</h4>
                       </th>
                       <th colspan="2">
                            <h4>----------->>Datos para nueva cuenta<<-----------</h4>
                       </th>                       
                    </tr>
                   
                    <tr>
                        <th>
                            <label for="codigoDueno"><h5>Código Cliente:</h5></label>
                        </th>
                        <th>
                            <input type="number" name="codigoDueno" id="codigoDueno" readonly>
                        </th>      
                         <th>
                            <label><h5>No. Cuenta Nueva:</h5></label>
                        </th>
                        <th>
                            <input type="number" name="numeroCuenta" id="numeroCuenta" min="0" readonly>
                        </th>  
                    <tr>
                        <th>    
                             <label fpr="nombre"><h5>Nombre:</h5></label>
                        </th>
                        <th>
                            <input type="text" name="nombreDueno" id="nombre" readonly>                        
                        </th>   
                         <th>
                            <label><h5>Tipo de Cuenta:</h5></label>
                        </th>
                        <th>
                            <select name="tipoDeCuenta"  id="tipoCuenta" style="width: 240px;" required>
                                <option value="noTomesEnCuenta...">Monetaria</option><!--no creo que sea necesario poner un vacío en el valor... creo que con no declararlo basta...-->
                            </select><!--ahí te recuerdas que este valor no lo debes tomar en cuenta al trabajar con la info que recibes, para hacer el depósito xD-->
                        </th><!--bueno, al final de cuenta como tomarás los valores de forma individual, entonces simplemento no añades esta parte xD, y si vas a hacer que se forme un arreglo, entocnes solo no le pongas el mismo nombre xD, pero es mejor hacer por separada por el select, pues es un arreglo como tal xD-->
                    </tr>                                
                    <tr>
                        <th></th>
                        <th></th>
                        <th>                           
                           <label><h4>Monto Inicial $.</h4></label>
                        </th>
                        <th>
                           <input type="number" name="monto" id="monto" min="0" required>                           
                        </th>                            
                    </tr>                           
                </table>    
                    
                    <input type="submit" id="submit" name="crearCuenta" value="CREAR CUENTA" width="200px"><!--todos los sumbit sin importar de qué entidad sean y qué sea lo que suban tendrán el mismo aspecto...-->                    
                </div>
                
            </center>
        </form>
    </body>
</html>
