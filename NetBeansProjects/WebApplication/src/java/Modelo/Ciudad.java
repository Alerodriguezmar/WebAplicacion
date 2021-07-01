
package Modelo;


public class Ciudad {
      private int idCiudad;
    private String nombre_ciudad;
    private int cant_habitantes;
    private String sitio_turistico;
    private String hotel_reservado;

    public Ciudad() {
    }
    
    
    public Ciudad(int idCiudad, String nombre_ciudad, int cant_habitantes, String sitio_turistico, String hotel_reservado) {
        this.idCiudad = idCiudad;
        this.nombre_ciudad = nombre_ciudad;
        this.cant_habitantes = cant_habitantes;
        this.sitio_turistico = sitio_turistico;
        this.hotel_reservado = hotel_reservado;
    }
    public int getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(int idCiudad) {
        this.idCiudad = idCiudad;
    }

    public String getNombre_ciudad() {
        return nombre_ciudad;
    }

    public void setNombre_ciudad(String nombre_ciudad) {
        this.nombre_ciudad = nombre_ciudad;
    }




    public int getCant_habitantes() {
        return cant_habitantes;
    }

    public void setCant_habitantes(int cant_habitantes) {
        this.cant_habitantes = cant_habitantes;
    }

    public String getSitio_turistico() {
        return sitio_turistico;
    }

    public void setSitio_turistico(String sitio_turistico) {
        this.sitio_turistico = sitio_turistico;
    }

    public String getHotel_reservado() {
        return hotel_reservado;
    }

    public void setHotel_reservado(String hotel_reservado) {
        this.hotel_reservado = hotel_reservado;
    }
    
    
    
}
