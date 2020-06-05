package wsdad;

import alumno.Alumno;
import alumno.AlumnoImpl;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "saludoWSdad")
public class saludoWSdad {

    @WebMethod(operationName = "Holaaa wey")
    public String hello(@WebParam(name = "name") String txt) {
        return "Holaaa wey" + txt + " !";
    }
    
    @WebMethod(operationName = "getEgresados")
    public ArrayList<Alumno> getEgresados() throws Exception {
        alumno.AlumnoImpl am= new AlumnoImpl();
        return am.listaEgresados("2004");
    }
}
