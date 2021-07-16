package DAO;

import Config.DataBase;
import Modelo.Ciudad;
import Modelo.Historial;
import Modelo.Turista;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class HistorialDAO {
    
DataBase db = new DataBase();
        
        //Inserta un nuevo registro en latabla historial
      public String insertar(Object object){
          
          Historial historial =  (Historial) object;
          Connection con;
          PreparedStatement pst;
          String sql = "INSERT INTO  historial ( nombre_ciudad , nombre_turista , id_turista , fecha_ingreso ) VALUES(?, ?, ?, ?)";
          String respuesta="";
          try {
              Class.forName(db.getDriver());
              con = DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getContrasena());
              pst = con.prepareStatement(sql);
              
              pst.setString(1, historial.getNombre_ciudad());
              pst.setString(2, historial.getNombre_turista());
              pst.setString(3, historial.getId_turista()); 
              pst.setDate(4, Date.valueOf(historial.getFecha_ingreso())); 
              int fila = pst.executeUpdate();
              respuesta = "se registraron" + fila + "nuevo elemento";
              con.close();     
          } catch (ClassNotFoundException | SQLException e) {
              
          }
         return respuesta ;
      }
      
        //Consulta la cantidad de de personas que han registrado o viajado a una ciudad
      public List<Historial> listarCantidad() throws ClassNotFoundException {
        List<Historial> lista = new ArrayList<>();
        Connection con;
        PreparedStatement pst;
        ResultSet rs;
        String sql = "select nombre_ciudad , count(*) as historial from historial group by nombre_ciudad";
        try {
            Class.forName(db.getDriver());
            con = DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getContrasena());
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {

                String nombret = rs.getString("nombre_ciudad");
                int cantidad = rs.getInt("historial");
                Historial historial = new Historial(nombret, cantidad);
                lista.add(historial);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
        return lista;
    }
            
        //Consulta todos los datos registrados en la tabla historial
        public List<Historial> listarHistorial() throws ClassNotFoundException {
        List<Historial> lista = new ArrayList<>();
        Connection con;
        PreparedStatement pst;
        ResultSet rs;
        String sql = "SELECT * FROM historial";
        try {
            Class.forName(db.getDriver());
            con = DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getContrasena());
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                
                String nombret = rs.getString("nombre_turista");  
                String nombrec = rs.getString("nombre_ciudad");
                String id_turista = rs.getString("id_turista");
                LocalDate fecha = rs.getDate("fecha_ingreso").toLocalDate();
                
                Historial historial = new Historial(nombrec, nombret, id_turista, fecha) ;
                lista.add(historial);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
        return lista;
    }
      
            //Busca todos los registros de una ciudad en concreto
          public List<Historial> BuscarCiudad(String nombre) throws ClassNotFoundException {
        List<Historial> lista = new ArrayList<>();
        Connection con;
        PreparedStatement pst;
        ResultSet rs;
        String sql = "SELECT * FROM historial WHERE nombre_ciudad ='" +nombre + "'";
        try {
            Class.forName(db.getDriver());
            con = DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getContrasena());
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                
                String nombret = rs.getString("nombre_turista");  
                String nombrec = rs.getString("nombre_ciudad");
                String id_turista = rs.getString("id_turista");
                LocalDate fecha = rs.getDate("fecha_ingreso").toLocalDate();
                
                Historial historial = new Historial(nombrec, nombret, id_turista, fecha) ;
                lista.add(historial);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
        return lista;
    }
            
          
          //Busca todos los registros de una persona en concreto
          public List<Historial> BuscarTurista(String id) throws ClassNotFoundException {
        List<Historial> lista = new ArrayList<>();
        Connection con;
        PreparedStatement pst;
        ResultSet rs;
        String sql = "SELECT * FROM historial WHERE id_turista ='" +id + "'";
        try {
            Class.forName(db.getDriver());
            con = DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getContrasena());
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                
                String nombret = rs.getString("nombre_turista");  
                String nombrec = rs.getString("nombre_ciudad");
                String id_turista = rs.getString("id_turista");
                LocalDate fecha = rs.getDate("fecha_ingreso").toLocalDate();
                
                Historial historial = new Historial(nombrec, nombret, id_turista, fecha) ;
                lista.add(historial);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
        return lista;
    }
 
}
