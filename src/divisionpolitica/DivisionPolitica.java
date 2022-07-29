package divisionpolitica;

import controladores.*;
import java.util.*;
import vistas.VistaPrincipal;

public class DivisionPolitica {

    public static void main(String[] args) {

        //Cargar las propiedades
        Properties p = UtilIU.abrirConfiguracion();
        ControladorPais.rutaMapas = p.getProperty("RutaMapas");

        new ControladorPrincipal(new VistaPrincipal());

        /*
         SessionFactory sf = UtilHibernate.getSessionFactory();
         Session sesion = sf.openSession();

         //Crear consulta de ciudades de un depto
        
        
       
        
         //Query q = sesion.createQuery("SELECT c FROM Ciudad c INNER JOIN c.region WHERE c.region.nombre= :NRegion");
         //q.setString("NRegion", "Atlántico");

         Query q = sesion.createQuery("SELECT c FROM Ciudad c "+
         "INNER JOIN c.region r "+
         "INNER JOIN r.pais "+
         "WHERE r.pais.nombre= :NPais");
         q.setString("NPais", "Brasil");
        
        
         Iterator<Ciudad> it = q.iterate();

         while (it.hasNext()) {
         Ciudad c = it.next();
         System.out.println(c.getNombre()+ " - "+c.getRegion().getNombre());
         }
         */
    }

}
