
import Modelo.Ciudad;
import DAO.CiudadDAO;
import DAO.HistorialDAO;
import Modelo.Turista;
import DAO.TuristaDAO;
import Modelo.Historial;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PC
 */
public class NewClass {
    
     public static void main(String[] args) throws ClassNotFoundException{
/*
         List<Ciudad> list = new ArrayList<>();
            String respuesta="";
            RequestDispatcher rd = null;
            CiudadDAO daoc = new CiudadDAO();
          TuristaDAO dao = new TuristaDAO();
        List<Turista> datos = new ArrayList(); 

         System.out.println(daoc.Buscarid(5).getHotel_reservado());
         dao.listarTuristas();
          datos = dao.listarTuristas();
                    for (Turista dato : datos) {
                          dato.getIdentificacion();
                               dato.getNombret();
                             dato.getFechan();
                              dato.getTipoid();
                              dato.getFrecuencia();
                              dato.getPresupuesto();
                            // System.out.println(dato.getCiudad());
                              dato.isTarjeta();
                        }


Turista turista = new Turista();
TuristaDAO daot = new TuristaDAO();
 Ciudad ciudad = new Ciudad();

                    turista.setNombret("textnombre");
                    turista.setFechan(LocalDate.parse("2018-12-31"));
                    turista.setIdentificacion("3");
                    turista.setTipoid(("tipoid"));
                    turista.setFrecuencia(5);
                    turista.setPresupuesto(Double.valueOf("52.0"));
                    turista.setCiudad(8);
                    turista.setTarjeta(true);
  
                    daot.insertar(turista);
*/
        HistorialDAO dao = new HistorialDAO();
        List<Historial> datos2 = new ArrayList();
         datos2 = dao.listarCantidad();
         /*
         for (Historial dato : datos2) {
             System.out.println(dato.getNombre_ciudad());
             System.out.println(dato.getCant());
             
         }*/
         Historial historia2 = new Historial();
         
         historia2.setNombre_turista("asdasssd");
         historia2.setNombre_ciudad("asdassds");
         historia2.setId_turista("asdasd");
         historia2.setFecha_ingreso(LocalDate.now());
         System.out.println(dao.insertar(historia2));
         
         
         
         }
                


    
    }


