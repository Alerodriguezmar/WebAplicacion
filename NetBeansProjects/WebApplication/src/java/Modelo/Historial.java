
package Modelo;

import java.time.LocalDate;

public class Historial {
    private int id;
    private String nombre_ciudad;
    private String nombre_turista;
    private String id_turista;
    private LocalDate fecha_ingreso;  
    private int cant;

    public Historial() {
    }

    public Historial(String nombre_ciudad, String nombre_turista, String id_turista, LocalDate fecha_ingreso) {
        this.nombre_ciudad = nombre_ciudad;
        this.nombre_turista = nombre_turista;
        this.id_turista = id_turista;
        this.fecha_ingreso = fecha_ingreso;
    }

    
    
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
 
    
       public Historial(String nombre,int datos ) {
         this.nombre_ciudad = nombre;
        this.cant = datos;
    } 

    public LocalDate getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(LocalDate fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }
    
    public String getNombre_ciudad() {
        return nombre_ciudad;
    }

    public void setNombre_ciudad(String nombre_ciudad) {
        this.nombre_ciudad = nombre_ciudad;
    }

    public String getNombre_turista() {
        return nombre_turista;
    }

    public void setNombre_turista(String nombre_turista) {
        this.nombre_turista = nombre_turista;
    }

    public String getId_turista() {
        return id_turista;
    }

    public void setId_turista(String id_turista) {
        this.id_turista = id_turista;
    }
    
    
}
