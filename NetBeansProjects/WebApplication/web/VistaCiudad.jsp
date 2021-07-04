<%@page import="DAO.CiudadDAO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.Ciudad"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
         <link rel="stylesheet" href="Estilo.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ciudades</title>  
 
    </head>
            <header>
            <h1>Ciudades</h1>
        </header>
     <%
        CiudadDAO ciudaddao = new CiudadDAO();
        List<Ciudad> datos = new ArrayList();
                    %>
    <body>
       
        
        <form name="Ciudad" method="post" action="SERVciudad" >
            <p>  ID CIUDAD:</p><input type="text" name="textid"><br>
            <p>NOMBRE CIUDAD:</p><input type="text" name="textnombre"><br>
           <p> CANTIDAD HABITANTES:</p><input type="text" name="texthabitantes"><br><!-- comment -->
          <p>  SITIO MAS TURISTICO:</p><input type="text" name="textturista"><br>
           <p> HOTEL MAS RESERVADO:</p><input type="text" name="texthotel"><br>
           <p>
            <input type="submit" name="btninsertar" value="Insertar">
            <input type="submit" name="btnmodificar" value="Modificar">
            <input type="submit" name="btneliminar" value="Eliminar">  
            </p>
        </form>
        <table class="tabla"  id="main-container" >
            <thead>
            <tr>
                <td>ID</td> <td>NOMBRE</td> <td>HABITANTES</td> <td>SITIO MAS TURISTICO</td> <td>HOTEL MAS RESERVADO</td>
            </tr>
            </thead>
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
         </table>  <br>      
        
    </body>
    <a class="boton_personalizado" id="boton2" href="/WebApplication">Inicio</a>
</html>
