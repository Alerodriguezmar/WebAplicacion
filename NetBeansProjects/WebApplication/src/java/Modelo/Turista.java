package Modelo;

import java.time.LocalDate;

public class Turista {
    
    private String nombret;
    private LocalDate fechan;
    private String identificacion;
    private String tipoid;
    private int frecuencia;
    private Double presupuesto;
    private boolean tarjeta;
    private int ciudad;
    private LocalDate fechaviaje;
    public Turista() {
    }

    public Turista(String nombret, LocalDate fechan, String identificacion, String tipoid, int frecuencia, Double presupuesto, boolean tarjeta, int ciudad, LocalDate fechaviaje) {
        this.nombret = nombret;
        this.fechan = fechan;
        this.identificacion = identificacion;
        this.tipoid = tipoid;
        this.frecuencia = frecuencia;
        this.presupuesto = presupuesto;
        this.tarjeta = tarjeta;
        this.ciudad = ciudad;
        this.fechaviaje = fechaviaje;
    }



    public LocalDate getFechaviaje() {
        return fechaviaje;
    }

    public void setFechaviaje(LocalDate fechaviaje) {
        this.fechaviaje = fechaviaje;
    }
    
    

    public String getNombret() {
        return nombret;
    }

    public void setNombret(String nombret) {
        this.nombret = nombret;
    }

    public LocalDate getFechan() {
        return fechan;
    }

    public void setFechan(LocalDate fechan) {
        this.fechan = fechan;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getTipoid() {
        return tipoid;
    }

    public void setTipoid(String tipoid) {
        this.tipoid = tipoid;
    }

    public int getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(int frecuencia) {
        this.frecuencia = frecuencia;
    }

    public Double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(Double presupuesto) {
        this.presupuesto = presupuesto;
    }

    public boolean isTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(boolean tarjeta) {
        this.tarjeta = tarjeta;
    }

    public int getCiudad() {
        return ciudad;
    }

    public void setCiudad(int ciudad) {
        this.ciudad = ciudad;
    }

  
    
    
    
    
    
}
