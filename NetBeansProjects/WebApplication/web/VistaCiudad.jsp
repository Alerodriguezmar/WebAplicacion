<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.Ciudad"%>
<%@page import="Modelo.CiudadDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ciudades</title>  
    </head>
     <%
        CiudadDAO ciudaddao = new CiudadDAO();
        List<Ciudad> datos = new ArrayList();
                    %>
    <body>
        <h1>Ciudades</h1>
        <form name="Ciudad" method="post" action="SERVciudad" >
            ID CIUDAD:<input type="text" name="textid"><br>
            NOMBRE CIUDAD:<input type="text" name="textnombre"><br>
            CANTIDAD HABITANTES:<input type="text" name="texthabitantes"><br><!-- comment -->
            SITIO MAS TURISTICO:<input type="text" name="textturista"><br>
            HOTEL MAS RESERVADO:<input type="text" name="texthotel"><br>
            <input type="submit" name="btninsertar" value="Insertar">
            <input type="submit" name="btnmodificar" value="Modificar">
            <input type="submit" name="btneliminar" value="Eliminar">      
        </form>
         <table border="1px">
            <tr>
                <td>ID</td> <td>NOMBRE</td> <td>HABITANTES</td> <td>SITIO MAS TURISTICO</td> <td>HOTEL MAS RESERVADO</td>
            </tr>
                <%
                    //generar recorrido sobre la consulta y motrar datos
                    datos = ciudaddao.listarciudades();
                    for (Ciudad dato : datos) {
                          %>
                          <tr>
                              <td> <%= dato.getIdCiudad()%>       </td>
                              <td> <%= dato.getNombre_ciudad()%>    </td>
                              <td> <%= dato.getCant_habitantes() %> </td>
                              <td> <%= dato.getSitio_turistico() %> </td>
                              <td> <%= dato.getHotel_reservado() %> </td>
                          </tr> 
                        <%
                        }
                    %>
        </table>        
        
    </body>
    <a href="http://localhost:8080/WebApplication"><input type="button" value="INICIO"></a>
</html>
