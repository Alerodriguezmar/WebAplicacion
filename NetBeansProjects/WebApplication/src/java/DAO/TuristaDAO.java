/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Config.DataBase;
import Modelo.Ciudad;
import DAO.CiudadDAO;
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

/**
 *
 * @author PC
 */
public class TuristaDAO {

    DataBase db = new DataBase();

    public String insertar(Object object) {
        Turista turista = (Turista) object;
        Connection con;
        PreparedStatement pst;

        String sql = "INSERT INTO turista VALUES(?,?,?,?,?,?,?,?)";
        String respuesta = "";
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
            pst.setInt(8, turista.getCiudad());
            int fila = pst.executeUpdate();
            System.out.println("consulta");
            respuesta = "se registraron" + fila + "nuevo elemento";
            con.close();
        } catch (ClassNotFoundException | SQLException e) {

        }
        return respuesta + "consulta";
    }

    public List<Turista> listarTuristas() throws ClassNotFoundException {
        List<Turista> lista = new ArrayList<>();
        Connection con;
        Ciudad ciudad = null;
        CiudadDAO daoc = new CiudadDAO();
        PreparedStatement pst;
        ResultSet rs;
        String sql = "SELECT * FROM turista";

        try {
            Class.forName(db.getDriver());
            con = DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getContrasena());
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {

                String nombret = rs.getString("nombret");
                LocalDate fecha = rs.getDate("fechan").toLocalDate();
                String identificacion = rs.getString("identificacion");
                String tipoid = rs.getString("tipoid");
                int frecuencia = rs.getInt("frecuencia");
                Double presupuesto = rs.getDouble("presupuesto");
                boolean tarjeta = rs.getBoolean("tarjeta");
                int destino = rs.getInt("destino");

                Turista turista = new Turista(nombret, fecha, identificacion, tipoid, frecuencia, presupuesto, tarjeta, destino);
                lista.add(turista);

            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
        return lista;
    }

    public String Eliminar(Turista object) {
        Turista turista = (Turista) object;
        Connection con;
        PreparedStatement pst;
        String sql = "DELETE FROM turista WHERE identificacion = ? ";
        String respuesta = "";
        try {
            Class.forName(db.getDriver());
            con = DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getContrasena());
            pst = con.prepareStatement(sql);
            pst.setString(1, turista.getIdentificacion());
            int fila = pst.executeUpdate();
            respuesta = "se eliminaron" + fila + " elementos";
            con.close();
        } catch (ClassNotFoundException | SQLException e) {

        }
        return respuesta;
    }

    public String Actualizar(Object object) {
        Turista turista = (Turista) object;
        Connection con;
        PreparedStatement pst;

        String sql = "UPDATE turista SET nombret=? , fechan =? ,tipoid=? ,frecuencia=? ,  presupuesto=? ,tarjeta=?, destino =? WHERE identificacion=? ";
        String respuesta = "";
        try {
            Class.forName(db.getDriver());
            con = DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getContrasena());
            pst = con.prepareStatement(sql);

            pst.setString(1, turista.getNombret());
            pst.setDate(2, Date.valueOf(turista.getFechan()));
            pst.setString(3, turista.getTipoid());
            pst.setInt(4, turista.getFrecuencia());
            pst.setDouble(5, turista.getPresupuesto());
            pst.setBoolean(6, turista.isTarjeta());
            pst.setInt(7, turista.getCiudad());
            pst.setString(8, turista.getIdentificacion());
            int fila = pst.executeUpdate();
            System.out.println("consulta");
            respuesta = "se registraron" + fila + "nuevo elemento";
            con.close();
        } catch (ClassNotFoundException | SQLException e) {

        }
        return respuesta;
    }

}
