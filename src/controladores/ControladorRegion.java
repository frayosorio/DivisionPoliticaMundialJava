package controladores;

import divisionpolitica.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import modelos.*;
import org.hibernate.*;
import vistas.VistaRegion;

public class ControladorRegion {

    private VistaRegion vista;
    private List<Region> regiones;
    private String[] encabezados = new String[]{"Nombre", "Área", "Población"};

    public ControladorRegion(VistaRegion vista) {
        this.vista = vista;
    }

    public void mostrar() {
        this.vista.setTitle("Regiones");
        this.vista.setLocation(50, 100);
        this.vista.setSize(600, 500);
        this.vista.setClosable(true);
        this.vista.setResizable(true);
        this.vista.setVisible(true);

        consultarPaises();

        this.vista.cmbPais.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                consultarRegiones();
                listarRegiones();
            }
        });
    }

    public void consultarPaises() {
        //Consultar la lista de paises
        SessionFactory sf = UtilHibernate.getSessionFactory();
        Session sesion = sf.openSession();

        Query q = sesion.createQuery("FROM Pais");
        Iterator<Pais> it = q.iterate();

        this.vista.cmbPais.removeAllItems();
        while (it.hasNext()) {
            Pais p = it.next();
            this.vista.cmbPais.addItem(p.getNombre());
        }
    }
    
        public void consultarRegiones() {
        //Consultar la lista de paises
        SessionFactory sf = UtilHibernate.getSessionFactory();
        Session sesion = sf.openSession();

        Query q = sesion.createQuery("SELECT r FROM Region r INNER JOIN r.pais WHERE r.pais.nombre= :NPais");
        q.setString("NPais", this.vista.cmbPais.getSelectedItem().toString());
        
        Iterator<Region> it = q.iterate();

        regiones=new ArrayList<>();
        while (it.hasNext()) {
            Region r = it.next();
            regiones.add(r);
        }
    }

    private String[][] pasarMatriz() {
        if (regiones != null) {
            String[][] datos = new String[regiones.size()][encabezados.length];
            int fila = 0;
            for (Region r : regiones) {
                datos[fila][0] = r.getNombre();
                datos[fila][1] = String.valueOf(r.getArea());
                datos[fila][2] = String.valueOf(r.getPoblacion());
                fila++;
            }
            return datos;
        }
        return null;
    }

    public void listarRegiones() {
        UtilIU.mostrarTabla(this.vista.tbl, pasarMatriz(), encabezados);
    }

}
