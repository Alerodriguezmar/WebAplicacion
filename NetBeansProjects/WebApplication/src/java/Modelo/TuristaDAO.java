/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Config.DataBase;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author PC
 */
public class TuristaDAO {
    
        DataBase db = new DataBase();
        
           public String insertar(Object object){
          Turista turista =  (Turista) object;
          Connection con;
          PreparedStatement pst;
                
          String sql = "INSERT INTO turista VALUES(?,?,?,?,?,?,?,?)";
          String respuesta="";
          try {
              Class.forName(db.getDriver());
              con = DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getContrasena());
              pst = con.prepareStatement(sql);
              
              pst.setString(1, turista.getNombret());
              pst.setDate(2, Date.valueOf(turista.getFechan()));
              pst.setString(3, turista.getIdentificacion());
              pst.setString(4, turista.getTipoid());
              pst.setInt(5, turista.getFrecuencia());
              pst.setDouble(6, turista.getPresupuesto());
              pst.setBoolean(7, turista.isTarjeta());
              pst.setObject(8, turista.getCiudad());
              int fila = pst.executeUpdate();
              respuesta = "se registraron" + fila + "nuevo elemento";
              con.close();     
          } catch (ClassNotFoundException | SQLException e) {
              
          }
         return respuesta;
      }
    
}
