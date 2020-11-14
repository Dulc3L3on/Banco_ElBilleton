<%-- 
    Document   : Transferencia
    Created on : 12/11/2020, 15:26:25
    Author     : phily
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../css/cssCliente.css">
        <title>Transfer</title>
    </head>
    <body>
        <form method="POST" action="Transferencia"><!--si todo salió bien, entonces se refireccionará al servlet-->
            <center>
                <div id="general">
                    <br/>
                    <br/>
                    <h1>>>TRANSFERENCIA<<</h1>
            
                   <table cellspacing="10px" cellpadding="5px">
                       <tr>
                            <th>
                                 <h3>>>Cuenta Destino</h3>
                            </th>
                        </tr>
                        <tr>
                            <th>
                                <input type="radio" name="tipoCuentaDestino" value ="propia" id="propia">
                                <label for="propia">Propia</label>
                            </th>
                            <th>
                                <input type="radio" name="tipoCuentaDestino" value ="terceros" id="terceros" checked>
                                <label for="propia">Terceros</label>
                            </th>
                            <th>
                                <select name="cuentasDestino" width ="75px" id="opTransferencia" width ="75px" required>
                                    <option value="" disabled select >-Seleccione #cuenta receptora-</option><!--no creo que sea necesario poner un vacío en el valor... creo que con no declararlo basta...-->
                                </select>
                            </th>
                        </tr>
                    </table>
                    
                    <table cellspacing="10px" cellpadding="5px">
                        <tr>
                            <th>
                                <label><h5>*Cuenta Origen:</h5></label>
                            </th>
                            <th>
                                 <select name="cuentasDestino" id="opTransferencia" style="width: 250px" required>
                                    <option value="" disabled select >-Seleccione-</option><!--no creo que sea necesario poner un vacío en el valor... creo que con no declararlo basta...-->
                                </select>
                            </th>
                        </tr>
                        <tr>
                            <th>
                                <label><h5>*Cuenta Receptora:</h5></label>
                            </th>
                            <th>
                                <input type="number" name="numeroCuenta" id="numeroCuenta" min="0" readonly="">
                            </th>
                        </tr>
                        <tr>
                            <th>
                                <h4>*Monto $.</h4>
                            </th>
                            <th>
                                <input type="number" name="monto" value="1" id="opTransferencia" min="1" required>
                            </th>
                        </tr>
                    </table>
                    <input type="submit" id="submit" name="transferir" value="TRANSFERIR"><!--todos los sumbit sin importar de qué entidad sean y qué sea lo que suban tendrán el mismo aspecto...-->
                </div>                
            </center>
        </form>
        
        
    </body>
</html>
