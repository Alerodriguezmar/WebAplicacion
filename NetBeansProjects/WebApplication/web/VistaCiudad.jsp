<%@page import="DAO.CiudadDAO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.Ciudad"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="Estilo.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ciudades</title>  
        <%-- Enviar/Cargar datos al formulario  --%>
        <script lang="javascript">
                    function cargar(id,nombre,habitantes,sitio,hotel) {
                         document.Ciudad.textid.value=id;
                         document.Ciudad.textnombre.value=nombre;
                         document.Ciudad.texthabitantes.value=habitantes;
                         document.Ciudad.textturista.value=sitio;
                         document.Ciudad.texthotel.value=hotel;
                    }            
        </script>
        
        
 
    </head>
            <header>
            <h1>Ciudades</h1>
        </header>
            <%--  Inicializacion --%>
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
                <td>ID</td> <td>NOMBRE</td> <td>HABITANTES</td> <td>SITIO MAS TURISTICO</td> <td>HOTEL MAS RESERVADO</td> <td>Accion</td>
            </tr>
            </thead>   
            <tbody>
                
                <%--Obtener datos y llenar tabla --%>   
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
                              <-<!-- Llama la funcion cargar y envia los datos de cada row en la tabla -->
                              <td> <a class="boton_personalizado" href="javascript:cargar('<%= dato.getIdCiudad()%>','<%= dato.getNombre_ciudad()%>','<%= dato.getCant_habitantes() %>','<%= dato.getSitio_turistico() %>','<%= dato.getHotel_reservado() %>')" >Cargar</a></td>
                          </tr> 
                        <%
                        }
                    %>
                     </tbody>
         </table>  <br>      
        
    </body>
    <-<!-- envia nuevamente al Index/pagina principal -->
    <a class="boton_personalizado" id="boton2" href="/WebApplication">Inicio</a>
</html>
