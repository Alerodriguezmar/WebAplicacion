package DAO;

import Config.DataBase;
import Modelo.Ciudad;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CiudadDAO {
      DataBase db = new DataBase();
      
      
      //elimina una ciudad ya registrada
      public String Eliminar(Object object){
             Ciudad ciudad = (Ciudad) object;
          Connection con;
          PreparedStatement pst;
          String sql = "DELETE FROM ciudad WHERE idCiudad = ? ";
          String respuesta="";
          try {
              Class.forName(db.getDriver());
              con = DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getContrasena());
              pst = con.prepareStatement(sql);           
              pst.setInt(1, ciudad.getIdCiudad());
              int fila = pst.executeUpdate();
              respuesta = "se eliminaron" + fila + " elementos";
              con.close();     
          } catch (ClassNotFoundException | SQLException e) {
              
          }
         return respuesta;
      }
      
      //inserta una nueva ciudad en la DB
      public String insertar(Object object){
          Ciudad ciudad = (Ciudad) object;
          Connection con;
          PreparedStatement pst;
          String sql = "INSERT INTO ciudad VALUES(?,?,?,?,?)";
          String respuesta="";
          try {
              Class.forName(db.getDriver());
              con = DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getContrasena());
              pst = con.prepareStatement(sql);
              
              pst.setInt(1,ciudad.getIdCiudad());
              pst.setString(2, ciudad.getNombre_ciudad());
              pst.setInt(3, ciudad.getCant_habitantes());
              pst.setString(4, ciudad.getSitio_turistico());
              pst.setString(5, ciudad.getHotel_reservado());
              int fila = pst.executeUpdate();
              respuesta = "se registraron" + fila + "nuevo elemento";
              con.close();     
          } catch (ClassNotFoundException | SQLException e) {
              
          }
         return respuesta ;
      }
      
      
            //Actualiza un registro ya hecho
            public String Actulizar(Object object){
          Ciudad ciudad = (Ciudad) object;
          Connection con;
          PreparedStatement pst;
          String sql = "UPDATE ciudad SET nombre_ciudad=?,cant_habitantes=?,sitio_turistico=?,hotel_reservado=? WHERE idCiudad =? ";
          String respuesta="";
          try {
              Class.forName(db.getDriver());
              con = DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getContrasena());
              pst = con.prepareStatement(sql);
              
              
              pst.setString(1, ciudad.getNombre_ciudad());
              pst.setInt(2, ciudad.getCant_habitantes());
              pst.setString(3, ciudad.getSitio_turistico());
              pst.setString(4, ciudad.getHotel_reservado());
              pst.setInt(5, ciudad.getIdCiudad());
              int fila = pst.executeUpdate();
              respuesta = "se registraron" + fila + "nuevo elemento";
              con.close();     
          } catch (ClassNotFoundException | SQLException e) {
              
          }
         return respuesta;
      }
      
            //Consulta todas las ciudades registradas
      public List<Ciudad> listarciudades() throws ClassNotFoundException{
        List<Ciudad> lista = new ArrayList<>();
        Connection con;
        PreparedStatement pst;
        ResultSet rs; 
        String sql ="SELECT * FROM ciudad";
       
        try {
           Class.forName(db.getDriver());
           con = DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getContrasena());
           pst = con.prepareStatement(sql);
           rs = pst.executeQuery();
            while (rs.next()) {           
                int idCiudad = rs.getInt("idCiudad");
                String nombre_ciudad= rs.getString("nombre_ciudad");
                int cant_habitantes = rs.getInt("cant_habitantes");
                String sitio_turistico = rs.getString("sitio_turistico");
                String hotel_reservado = rs.getString("hotel_reservado");
                
                Ciudad ciudad = new Ciudad(idCiudad, nombre_ciudad, cant_habitantes, sitio_turistico, hotel_reservado);
                lista.add(ciudad);
            }
            con.close();   
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
         return lista;
    }
    
      //Busca ciudad ´por su nombre;
  public Ciudad Buscar(String nombre) {
        Ciudad ciudad = new Ciudad();
        Connection con;
        PreparedStatement pst;
        ResultSet rs; 
       
       
        try {
 
           con = DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getContrasena());
           String sql ="SELECT* FROM ciudad WHERE nombre_ciudad = ?";
           pst = con.prepareStatement(sql);
           pst.setString(1, nombre);
           rs = pst.executeQuery();
            while (rs.next()) {           
                int idCiudad = rs.getInt("idCiudad");
                String nombre_ciudad= rs.getString("nombre_ciudad");
                int cant_habitantes = rs.getInt("cant_habitantes");
                String sitio_turistico = rs.getString("sitio_turistico");
                String hotel_reservado = rs.getString("hotel_reservado");
                
              ciudad = new Ciudad(idCiudad, nombre_ciudad, cant_habitantes, sitio_turistico, hotel_reservado);
                System.out.println("Consulta realizada");
            }
            con.close();   
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
         return ciudad;
    }
  
    //Busca ciudad ´por su id;
    public Ciudad Buscarid(int id) {
        Ciudad ciudad = new Ciudad();
        Connection con;
        PreparedStatement pst;
        ResultSet rs; 
       
       
        try {
 
           con = DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getContrasena());
           String sql ="SELECT* FROM ciudad WHERE idCiudad = ?";
           pst = con.prepareStatement(sql);
           pst.setInt(1, id);
           rs = pst.executeQuery();
            while (rs.next()) {           
                int idCiudad = rs.getInt("idCiudad");
                String nombre_ciudad= rs.getString("nombre_ciudad");
                int cant_habitantes = rs.getInt("cant_habitantes");
                String sitio_turistico = rs.getString("sitio_turistico");
                String hotel_reservado = rs.getString("hotel_reservado");
                
              ciudad = new Ciudad(idCiudad, nombre_ciudad, cant_habitantes, sitio_turistico, hotel_reservado);
                System.out.println("Consulta realizada");
            }
            con.close();   
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
         return ciudad;
    }
      
    
      
      
}
