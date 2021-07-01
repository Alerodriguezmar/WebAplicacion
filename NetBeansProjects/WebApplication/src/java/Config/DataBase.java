
package Config;


public class DataBase {
        private String driver;
    private String url;
    private String usuario;
    private String contrasena;

    public DataBase() {
        this.driver = "com.mysql.cj.jdbc.Driver";
        this.url = "jdbc:mysql://localhost:3306/aplicacionweb";
        this.usuario = "root";
        this.contrasena = "123456";
    }

    public String getDriver() {
        return driver;
    }

    public String getUrl() {
        return url;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    
    
            
}
