
import Modelo.Ciudad;
import Modelo.CiudadDAO;
import Modelo.Turista;
import Modelo.TuristaDAO;
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
                    
                    
        
    
    }
}

