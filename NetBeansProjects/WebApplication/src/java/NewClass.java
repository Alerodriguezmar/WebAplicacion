
import Modelo.Ciudad;
import Modelo.CiudadDAO;
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
    
     public static void main(String[] args) {
         CiudadDAO dao = new CiudadDAO();
            Ciudad ciudad = new Ciudad();
            
            List<Ciudad> list = new ArrayList<>();
            String respuesta="";
            RequestDispatcher rd = null;
            
          
                
                    
                    ciudad.setIdCiudad(8);
                    ciudad.setNombre_ciudad("Felipe");
                    ciudad.setCant_habitantes(15696);
                    ciudad.setSitio_turistico("asdasd");
                    ciudad.setHotel_reservado("asdasdasd");
                    respuesta = dao.insertar(ciudad);
                    System.out.println(respuesta);
    
    }
}

