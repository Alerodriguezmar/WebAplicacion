
package Modelo;

import DAO.CiudadDAO;



public class InicializacionCiudades {
    
    public static void main(String[] args) throws ClassNotFoundException {
        //Inicializacion Ciudades
        
        Ciudad ciudad = new Ciudad ();
        CiudadDAO daoCiudad = new CiudadDAO();
     
        ////////////////////////////////////
        ciudad.setIdCiudad(101);
        ciudad.setNombre_ciudad("Bucaramanga");
        ciudad.setCant_habitantes(1141671);
        ciudad.setSitio_turistico("Parque del Agua");
        ciudad.setHotel_reservado("Central");
        daoCiudad.insertar(ciudad);
        //////////////////////////////////////
        ciudad.setIdCiudad(102);
        ciudad.setNombre_ciudad("Cartagena");
        ciudad.setCant_habitantes(914552);
        ciudad.setSitio_turistico("Castillo San Felipé");
        ciudad.setHotel_reservado("Cartagena Plaza");
         daoCiudad.insertar(ciudad);
        /////////////////////////////////
        ciudad.setIdCiudad(102);
        ciudad.setNombre_ciudad("Medellin");
        ciudad.setCant_habitantes(2569000);
        ciudad.setSitio_turistico("la Plaza Botero");
        ciudad.setHotel_reservado("Principal");
         daoCiudad.insertar(ciudad);
         
        
        
        
        
        
    
        
   }
}
    
