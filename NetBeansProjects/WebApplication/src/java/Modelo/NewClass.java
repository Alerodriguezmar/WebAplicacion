/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import DAO.TuristaDAO;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author PC
 */
public class NewClass {
    
    public static void main(String[] args) throws ClassNotFoundException {
          TuristaDAO dao = new TuristaDAO();
        
        List<Turista> datos = dao.listarTuristas();
        
        if(dao.CantidadVisitas("2021-07-14",1 )<5){
            System.out.println("error");
        }
   
    }
   }
    
