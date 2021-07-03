
package CiudadWebService;

import DAO.CiudadDAO;
import Modelo.Ciudad;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;


@WebService(serviceName = "CiudadesWebService")
public class CiudadesWebService {

    CiudadDAO dao = new CiudadDAO();
    Ciudad ciudad = new Ciudad();
    
    
    
    
    @WebMethod(operationName = "ListaCiudades")
    public List<Ciudad>ListarCiudades(@WebParam(name = "name") String txt) throws ClassNotFoundException {
        List<Ciudad> ciudades = dao.listarciudades();
        return ciudades;
    }
}
