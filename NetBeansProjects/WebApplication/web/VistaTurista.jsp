<%@page import="java.time.LocalDate"%>
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
    <head id="header">
         <link rel="stylesheet" href="Estilo.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Turistas</title>
    
    </head>
    <%-- Enviar/Cargar datos al formulario  --%>
              <script lang="javascript">
                    function cargar(id,nombre,fecha_na,tipo_id,frecuencia,presupuesto,tarjeta,ciudad,fecha_vi) {
                         document.Turista.textid.value=id;;
                         document.Turista.textnombre.value=nombre;  
                         document.Turista.textfecha.value=fecha_na;
                         document.Turista.tipoid.value=tipo_id;
                         document.Turista.textfrecuencia.value=frecuencia;
                         document.Turista.textpresupuesto.value=presupuesto;
                         document.Turista.texttarjeta.value=tarjeta;
                         document.Turista.Ciudades.value=ciudad;
                         document.Turista.fechaviaje.value=fecha_vi;
                        
                    }            
        </script>
        
          <%--  Inicializacion --%>
    <%
        TuristaDAO dao = new TuristaDAO();
        List<Turista> datos = new ArrayList();
        CiudadDAO ciudaddao = new CiudadDAO();
        List<Ciudad> datosciudad = new ArrayList();
    %>
    
    <!-- Alerta emergente(Cantidad de tyuristas es mayor que 5 en una fecha)  -->
    <%if(request.getAttribute("ocupacion") == "lleno"){%> 
    <script>
        window.alert("Ciudad con Ocupacion Maxima");
    </script>  
     <%  }%>     
    
    
    <body>
         <header>
            <h1>Turistas</h1>
        </header>
      
        <form name="Turista" method="post" action="SERVturista" id="form" >
             <p>IDENTIFICACION:</p><input type="text" name="textid">
             <p>NOMBRE:</p><input type="text" name="textnombre"> 
             <p>FECHA NACIMIENTO:</p><input type="date"  name="textfecha"> 
             <p>TIPO ID:</p><select name="tipoid">
                <option value="Cedula Ciudadania">Cedula Ciudadania</option>
                <option value="Tarjeta de Identidad">Tarjeta de Identidad</option>
                <option value="Pasaporte">Pasaporte</option>
                <option value="Registro Civil">Registro Civil</option>
            </select>
             <p>FRECUENCIA VIAJE:<input type="number" name="textfrecuencia"></p>
             <p>PRESUPUESTO VIAJE:<input type="number" name="textpresupuesto"></p>
             <p>USA TARJETA:<input type="checkbox" name="texttarjeta"></p>         
             <p>CIUDAD:<select name="Ciudades">
                <%
                    //generar recorrido sobre la consulta y motrar datos
                    datosciudad = ciudaddao.listarciudades();
                    for (Ciudad dato : datosciudad) {
                %>

                <option value="<%= dato.getNombre_ciudad().toString()%>"> <%= dato.getNombre_ciudad().toString()%> </option>
                <% }%>
            </select></p>
             <p> ---------------------Opcional---------------------</p>
             <p>FECHA DE VIAJE:</p><input type="date" name="fechaviaje" value=""><br/>
             
             <p> <input type="submit" name="btninsertar" value="Insertar">
            <input type="submit" name="btnmodificar" value="Modificar">
            <input type="submit" name="btneliminar" value="Eliminar"> 
            </p>
        </form>
            
            
        <h1><center> Registros </center> </h1>
        <table class="tabla" id="main-container">
            <thead>
            <tr>
                <td>Identificacion</td> <td>Nombre</td> <td>Fecha de nacimeinto</td> <td>Tipo ID</td> <td>Frecuencia Viajes</td><td>Presupuesto Viajes</td><td>Destino</td><td>Tarjeta de credito</td><td>Fecha Viaje</td><td>Accion</td>
            </tr>
            </thead>
            <%
                //generar recorrido sobre la consulta y motrar datos
                LocalDate fechanull = LocalDate.parse("1111-11-11");
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
                <% if(dato.getFechaviaje().equals(fechanull)){%>
                     <td> No especificado </td>
                <% }else{ %>
                     <td> <%= dato.getFechaviaje() %> </td>
                <% } %>
                 <!-- Llama la funcion cargar y envia los datos de cada row en la tabla -->
                <td><a  class="boton_personalizado" href="javascript:cargar('<%= dato.getIdentificacion()%>',' <%= dato.getNombret()%>','<%= dato.getFechan()%>','<%= dato.getTipoid()%>
                       ','<%= dato.getFrecuencia()%>','<%= dato.getPresupuesto()%>','<%= dato.isTarjeta()%>','<%= ciudaddao.Buscarid(dato.getCiudad()).getNombre_ciudad()%>','<%= dato.getFechaviaje() %>')">cargar </a>  </td>
            </tr> 
            <% } %>

        </table>  
      
        <h1><center> Historico </center> </h1> 

        <table class="tabla" id="main-container">
            <thead>
            <tr>
                <td> Ciudad </td><td>Cantidad Visitantes</td>
            </tr> 
            </thead>
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
       
        <h1><center> Historial de Viajes </center> </h1>
        <form name="Historial" method="post" action="SERVturista" >
             <p>Buscar Turista:</p> <input type="text" name="buscaturista">
            <input type="submit" name="btnbuscartu" value="Buscar"><br> <br>
             <p>Buscar Ciudad:</p> <input type="text" name="buscarciudad">
             <input type="submit" name="btnbuscarci" value="Buscar"><br> <br>
             <input type="submit" name="btnborrar" value="Borrar Busqueda"><br> <br>
        </form>
        <table class="tabla" id="main-container" style="height: 50px;">
            <thead>
                <td>Ciudad</td><td>Turista</td><td>Identificion turista</td><td>Fecha de registro</td>
            </tr>
            </thead>
            <tbody style="overflow-y: scroll; height: 50px;" >
            <tr>
                
                
            <%
                //Busca en la tabla o borra las busquedas hechas en dicha tabla
                List<Historial> datos3 = new ArrayList();
                if(request.getAttribute("busqueda") != null){
                     datos3 = (List<Historial>) request.getAttribute("busqueda");
                } else if(request.getAttribute("borrar") != null){
                    datos3 = daoh.listarHistorial();
                }else{
                     datos3 = daoh.listarHistorial();
                }
                    
                      
                for (Historial dato : datos3) {
            %>     
            <tr>
                <td> <%= dato.getNombre_ciudad() %>       </td>
                <td> <%= dato.getNombre_turista() %>                </td>
                <td> <%= dato.getId_turista() %>       </td>
                <td> <%= dato.getFecha_ingreso() %>                </td>
            </tr>                
            <% }%>
            </tbody>
        </table><br><br>
        <a class="boton_personalizado" id="boton2" href="/WebApplication">Inicio</a>
    </body>
    
</html>
