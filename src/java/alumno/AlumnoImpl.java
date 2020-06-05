package alumno;

/**
 *
 * @author vilee
 */
import com.mysql.jdbc.MysqlIO;
import java.util.*;
import java.sql.*;
import conexion.Conexion;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AlumnoImpl {

    Conexion x = new Conexion();
    String sql = "";
    ArrayList<Alumno> listaAlumnosEgresados = new ArrayList<Alumno>();
        
    public ArrayList<Alumno> listaEgresados(String s_anhio_egreso) throws Exception{
    
        try {
            Connection conn = x.connectDatabase();
            sql="select * from alumno where alumno_codigo like '"+s_anhio_egreso+"%'";
            
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Alumno datos = new Alumno();
                datos.setO_alumno_id(rs.getString("alumno_id"));
                datos.setO_alumno_codigo(rs.getString("alumno_codigo"));
                datos.setO_alumno_nombre(rs.getString("alumno_nombre"));
                datos.setO_alumno_apellido_paterno(rs.getString("alumno_apellido_paterno"));
                datos.setO_alumno_apellido_materno(rs.getString("alumno_apellido_materno"));
                datos.setO_alumno_direccion(rs.getString("alumno_direccion"));
            
                listaAlumnosEgresados.add(datos);
            }                       
        } catch (SQLException ex) { System.out.println("ERROR"+ ex.getMessage());        }
        return listaAlumnosEgresados;
    } 
public static void main (String[] args) throws Exception{
            
            AlumnoImpl am=new AlumnoImpl();
            for (Alumno ad : am.listaEgresados("2004")) {
            System.out.println("en el foor loop");
            System.out.println(ad.getO_alumno_codigo());
            System.out.println(ad.getO_alumno_nombre());
            }
        }
    }
