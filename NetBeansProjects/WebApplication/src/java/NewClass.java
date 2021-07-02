
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
    
     public static void main(String[] args) throws ClassNotFoundException{
         CiudadDAO dao = new CiudadDAO();
            Ciudad ciudad = new Ciudad();
            Ciudad ciudad2 = new Ciudad();
            
            List<Ciudad> list = new ArrayList<>();
            String respuesta="";
            RequestDispatcher rd = null;
            
                      CiudadDAO ciudaddao = new CiudadDAO();
        List<Ciudad> datosciudad = new ArrayList();
                datosciudad = ciudaddao.listarciudades();
                System.out.println(datosciudad.size());
                    for (Ciudad dato : datosciudad) {   
                           System.out.println(String.valueOf(dato.getNombre_ciudad()));
                            }                    
    
    }
}

