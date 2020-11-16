<%-- 
    Document   : Creacion_Cuentas
    Created on : 11/11/2020, 20:15:03
    Author     : phily
--%>

<%@page import="Modelo.Entidades.Usuarios.Cliente"%>
<%@page import="Modelo.Manejadores.DB.Creador"%>
<%@page import="Modelo.Manejadores.DB.Buscador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../../css/cssGerente.css">
        <link rel="stylesheet" href="css/cssGerente.css"><!--por el msje de alerta xD sino quitalo y vuelve a mostrar solo msjin xD [ES DECIR coloca otra vez el if global, con su else...]-->
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>        
        <title>CreateAccount</title>
        
        <%!Buscador buscador = new Buscador();
          Creador creador = new Creador();
          Cliente cliente = null;
          int numeroCuenta =0;%>
    </head>
    <body>                          
            <center>
                <div id="general"><!--posiblemente lleve color xD o borde... o ambos xD-->
                    <h1>>>CREAR CUENTA<<</h1>                                                                   
                    
                    <form method="POST" action="Creacion_Cuentas.jsp">
                        <table cellspacing="10px" cellpadding="5px">                                        
                        
                            <tr>                            
                                <th>                             
                                    <input type="number" name="codigoClienteBuscado" id="buscado" placeholder="Código del Cliente" required>                                
                                </th>
                                <th>
                                    <input type="submit" name="buscar" id="submit" value="BUSCAR">
                                </th><!--desapareció la op de nuevo cliente, por el hecho de que se debía ingresar los datos, puesto que era un form interno, entoces debía acudir a su padre... el cual no podría llenarse y por ello no crearse el cliente...-->                                                      
                            </tr>                        
                        </table>                    
                         <hr>
                    </form>   
                    <%if(request.getParameter("codigoClienteBuscado")!=null){//<!--es decir que el usuario rquiere de una búsqueda...-->
                        cliente = buscador.buscarCliente(request.getParameter("codigoClienteBuscado"));                        
                    }%>
                    <%if(cliente!=null){//pues al inicio será null y si la búsqueda falla también lo será así que...
                         numeroCuenta = creador.reservarEspacioCuenta(cliente.darCodigo());
                         
                        if(numeroCuenta!=0){%>                                                      
                            <form method="POST" action="../../gestorCreacionCuenta">
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
                                            <input type="number" name="datosCuenta" id="codigoDueno"  readonly value="<%=cliente.darCodigo()%>">
                                        </th>      
                                         <th>
                                            <label><h5>No. Cuenta Nueva:</h5></label>
                                        </th>
                                        <th>
                                            <input type="number" name="datosCuenta" id="numeroCuenta" min="0" readonly value="<%=numeroCuenta%>" >
                                        </th>  
                                    <tr>
                                        <th>    
                                             <label fpr="nombre"><h5>Nombre:</h5></label>
                                        </th>
                                        <th>
                                            <input type="text" name="nombreDueno" id="nombre" readonly value="<%=cliente.darNombre()%>" >                        
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
                                           <input type="number" name="datosCuenta" id="monto" min="0" required>                           
                                        </th>                            
                                    </tr>                           
                                </table>    
                                <!--solo 2 de estos datos son de mi interés para completar la creacion [monto y #cta], por eso se llaman igual xD, los otros se tratan con otro proceso...-->
                                <input type="submit" id="submit" name="crearCuenta" value="CREAR CUENTA" width="200px"><!--todos los sumbit sin importar de qué entidad sean y qué sea lo que suban tendrán el mismo aspecto...-->                    
                          </form>     
                       <%}%>
                  <%}%>                 
                </div>                
            </center>
         <%if(request.getAttribute("mostrarMsje")!=null){
            if(request.getAttribute("mostrarMsje").equals("correcto")){%>
                <script src="js/sweet.js"></script>
             <%}else{%>
                <script src="js/sweetError.js"></script>
             <%}%>
        <%}%>                                       
    </body>
</html>
