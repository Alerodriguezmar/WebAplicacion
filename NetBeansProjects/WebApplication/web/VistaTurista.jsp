
<%@page import="Modelo.Ciudad"%>
<%@page import="Modelo.CiudadDAO"%>
<%@page import="Modelo.Turista"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.TuristaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Turistas</title>
    </head>
      <%
        TuristaDAO dao = new TuristaDAO();
        List<Turista> datos = new ArrayList();
            CiudadDAO ciudaddao = new CiudadDAO();
        List<Ciudad> datosciudad = new ArrayList();
                    %>
    <body>
        <h1> Turistas </h1>
        <form name="Turista" method="post" action="SERVturista" >
            IDENTIFICACION<input type="text" name="textid"><br>
            NOMBRE:<input type="text" name="textnombre"><br>
            FECHA NACIMIENTO:<input type="datetime" name="textfecha"><br>
            TIPO ID:<select name="tipoid">
                <option value="Cedula">Cedula Ciudadania</option>
                <option value="Tarjeta">Tarjeta de Identidad</option>
                <option value="Pasaporte">Pasaporte</option>
                <option value="Registro">Registro Civil</option>
            </select><br>
            FRECUENCIA VIAJE:<input type="number" name="textfrecuencia"><br>
            PRESUPUESTO VIAJE:<input type="number" name="textpresupuesto"><br>
            USA TARJETA:<input type="checkbox" name="texttarjeta"><br>
            CIUDAD:<select name="Ciudades">
                               <%
                    //generar recorrido sobre la consulta y motrar datos
                    datosciudad = ciudaddao.listarciudades();
                    for (Ciudad dato : datosciudad) {
                          %>
                          
                <option value="<%= dato.getNombre_ciudad().toString() %>"> <%= dato.getNombre_ciudad().toString() %> </option>
                <% }%>
                  </select><br>
            
              
            <input type="submit" name="btninsertar" value="Insertar">
            <input type="submit" name="btnmodificar" value="Modificar">
            <input type="submit" name="btneliminar" value="Eliminar">      
        </form>
                  <h1><center> Registros </center> </h1>
         <table border="1px">
            <tr>
                <td>IDENTIFICACION</td> <td>NOMBRE</td> <td>FECHA NACIMIENTO</td> <td>TIPO ID</td> <td>FRECUENCIA VIAJES</td><td>PRESUPUESTO VIAJES</td><td>DESTINO</td><td>TARJETA CREDITO</td>
            </tr>
            
                            <%
                    //generar recorrido sobre la consulta y motrar datos
                    datos = dao.listarTuristas();
                    for (Turista dato : datos) {
                          %>
                          <tr>
                              <td> <%= dato.getIdentificacion() %>       </td>
                              <td> <%= dato.getNombret() %>    </td>
                              <td> <%= dato.getFechan() %> </td>
                              <td> <%= dato.getTipoid() %> </td>
                              <td> <%= dato.getFrecuencia() %> </td>
                              <td> <%= dato.getPresupuesto() %> </td>
                              <td><%= ciudaddao.Buscarid(dato.getCiudad()).getNombre_ciudad() %></td>
                            <td> <%= dato.isTarjeta() %> </td>
                          </tr> 
                        <%
                        }
                    %>
             
        </table>        
                  
    </body>
    <a href="http://localhost:8080/WebApplication"><input type="button" value="INICIO"></a>
</html>
