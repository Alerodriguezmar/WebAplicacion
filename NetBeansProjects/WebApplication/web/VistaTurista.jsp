
<%@page import="Modelo.Historial"%>
<%@page import="DAO.HistorialDAO"%>
<%@page import="DAO.CiudadDAO"%>
<%@page import="DAO.TuristaDAO"%>
<%@page import="Modelo.Ciudad"%>
<%@page import="Modelo.Turista"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
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

                <option value="<%= dato.getNombre_ciudad().toString()%>"> <%= dato.getNombre_ciudad().toString()%> </option>
                <% }%>
            </select><br>          
            <input type="submit" name="btninsertar" value="Insertar">
            <input type="submit" name="btnmodificar" value="Modificar">
            <input type="submit" name="btneliminar" value="Eliminar"> 
            <hr>
        </form>
        <h1><center> Registros </center> </h1>
        <table border="1px">
            <tr>
                <td>Identificacion</td> <td>Nombre</td> <td>Fecha de nacimeinto</td> <td>Tipo ID</td> <td>Frecuencia Viajes</td><td>Presupuesto Viajes</td><td>Destino</td><td>Tarjeta de credito</td>
            </tr>
            <%
                //generar recorrido sobre la consulta y motrar datos
                datos = dao.listarTuristas();
                for (Turista dato : datos) {
            %>
            <tr>
                <td> <%= dato.getIdentificacion()%>       </td>
                <td> <%= dato.getNombret()%>    </td>
                <td> <%= dato.getFechan()%> </td>
                <td> <%= dato.getTipoid()%> </td>
                <td> <%= dato.getFrecuencia()%> </td>
                <td> <%= dato.getPresupuesto()%> </td>
                <td><%= ciudaddao.Buscarid(dato.getCiudad()).getNombre_ciudad()%></td>
                <td> <%= dato.isTarjeta()%> </td>
            </tr> 
            <% } %>

        </table>  
        <hr>
        <h1><center> Historico </center> </h1> 

        <table border="1px">
            <tr>
                <td> Ciudad </td><td>Cantidad Visitantes</td>
            </tr> 
            <%
                //generar recorrido sobre la consulta y motrar datos
                HistorialDAO daoh = new HistorialDAO();
                List<Historial> datos2 = new ArrayList();
                datos2 = daoh.listarCantidad();

                for (Historial dato : datos2) {
            %>     
            <tr>
                <td> <%= dato.getNombre_ciudad()%>       </td>
                <td> <%= dato.getCant()%>    </td>
            </tr>                
            <% }%>
        </table>
        <hr>
        <h1><center> Historial de Viajes </center> </h1>
        <form name="Turista" method="post" action="SERVturista" >
            Buscar Turista: <input type="text" name="buscaturista">
            <input type="submit" name="btnbuscart" value="Buscar"><br> <br>
            Buscar Ciudad: <input type="text" name="buscaturista">
             <input type="submit" name="btnbuscarc" value="Buscar"><br> <br>
            
        </form>
        <table border="1px">
            <tr>
                <td>Ciudad</td><td>Turista</td><td>Identificion turista</td><td>Fecha de registro</td>
            </tr>
            <%
                List<Historial> datos3 = new ArrayList();
                datos3 = daoh.listarHistorial();

                for (Historial dato : datos3) {
            %>     
            <tr>
                <td> <%= dato.getNombre_ciudad() %>       </td>
                <td> <%= dato.getNombre_turista() %>                </td>
                <td> <%= dato.getId_turista() %>       </td>
                <td> <%= dato.getFecha_ingreso() %>                </td>
            </tr>                
            <% }%>
        </table><br><br>

    </body>
    <a href="http://localhost:8080/WebApplication"><input type="button" value="INICIO"></a>
</html>
