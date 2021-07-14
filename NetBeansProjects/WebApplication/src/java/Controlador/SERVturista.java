/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Ciudad;
import DAO.CiudadDAO;
import DAO.HistorialDAO;
import Modelo.Turista;
import DAO.TuristaDAO;
import Modelo.Historial;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PC
 */
public class SERVturista extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
             CiudadDAO dao = new CiudadDAO();
             Historial historia = new Historial();
             HistorialDAO daoh = new HistorialDAO();
            Ciudad ciudad = new Ciudad();
            Turista turista = new Turista();
            TuristaDAO daot = new TuristaDAO();
            boolean tarjeta = false;
            String repuesta="";
            RequestDispatcher rd= null;
            String Buscar;
            List<Historial> datosbusqueda = new ArrayList<>();
            
            
            try {
                if(request.getParameter("btninsertar") != null){
                    if(daot.CantidadVisitas(request.getParameter("fechaviaje"),dao.Buscar(request.getParameter("Ciudades")).getIdCiudad())<6){
                            turista.setNombret(request.getParameter("textnombre"));
                            turista.setFechan(LocalDate.parse(request.getParameter("textfecha")));
                            turista.setIdentificacion(request.getParameter("textid"));
                            turista.setTipoid(request.getParameter("tipoid"));
                            turista.setFrecuencia(Integer.valueOf(request.getParameter("textfrecuencia")));
                            turista.setPresupuesto(Double.valueOf(request.getParameter("textpresupuesto")));
                            if(request.getParameter("texttarjeta")!= null)
                                tarjeta = true;
                            turista.setTarjeta(tarjeta); 
                            turista.setCiudad(dao.Buscar(request.getParameter("Ciudades")).getIdCiudad());
                            if(request.getParameter("fechaviaje").equals("")){
                                 turista.setFechaviaje(LocalDate.parse("1111-11-11"));
                            }else{
                                 turista.setFechaviaje(LocalDate.parse(request.getParameter("fechaviaje")));
                            } 
                            repuesta = daot.insertar(turista);

         ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //==============================================================================================================================

                             historia.setId_turista(request.getParameter("textid"));
                             historia.setNombre_turista(request.getParameter("textnombre"));
                             historia.setNombre_ciudad(request.getParameter("Ciudades"));
                             historia.setFecha_ingreso(LocalDate.now());
                             repuesta =  daoh.insertar(historia);         
                            request.setAttribute("respuesta", repuesta);
                    }else{
                        repuesta = "lleno";
                        request.setAttribute("ocupacion", repuesta);
                        
                    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//==============================================================================================================================                    
                }else if(request.getParameter("btnmodificar") != null){
                    turista.setNombret(request.getParameter("textnombre"));
                    turista.setFechan(LocalDate.parse(request.getParameter("textfecha")));
                    turista.setIdentificacion(request.getParameter("textid"));
                    turista.setTipoid(request.getParameter("tipoid"));
                    turista.setFrecuencia(Integer.valueOf(request.getParameter("textfrecuencia")));
                    turista.setPresupuesto(Double.valueOf(request.getParameter("textpresupuesto")));
                    if(request.getParameter("texttarjeta")!= null)
                        tarjeta = true;
                    turista.setTarjeta(tarjeta); 
                    turista.setCiudad(dao.Buscar(request.getParameter("Ciudades")).getIdCiudad());
                    repuesta = daot.Actualizar(turista);
                    request.setAttribute("respuesta", repuesta);
                    
                    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//==============================================================================================================================                    
                }else if(request.getParameter("btneliminar") != null){
                   turista.setIdentificacion(request.getParameter("textid"));
                    repuesta = daot.Eliminar(turista);
                    request.setAttribute("respuesta", repuesta);
  ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//=============================================================================================================================                  
                }else if(request.getParameter("btnbuscartu") != null){
                   Buscar = request.getParameter("buscaturista");
                   datosbusqueda = daoh.BuscarTurista(Buscar);
                   request.setAttribute("busqueda",datosbusqueda);    
  ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//=============================================================================================================================                  
                }else if(request.getParameter("btnbuscarci") != null){
                   Buscar = request.getParameter("buscarciudad");
                   datosbusqueda = daoh.BuscarCiudad(Buscar);
                   request.setAttribute("busqueda",datosbusqueda);    
  ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//=============================================================================================================================                  
                 }else if(request.getParameter("btnborrar") != null){
                   datosbusqueda = daoh.listarHistorial();
                   request.setAttribute("borrar",datosbusqueda);    
  ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//=============================================================================================================================                  
                }
                
                
                
                
                
                
                
                
                rd = request.getRequestDispatcher("VistaTurista.jsp");
                             } catch (Exception e) {}
            rd.forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
