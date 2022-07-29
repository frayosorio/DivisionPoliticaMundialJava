package controladores;

import divisionpolitica.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import modelos.Pais;
import org.hibernate.*;
import vistas.VistaPais;

public class ControladorPais {

    public static String rutaMapas;

    private VistaPais vista;
    private List<Pais> paises;
    private String[] encabezados = new String[]{"Nombre", "Continente", "Moneda", "Tipo de Región"};

    public ControladorPais(VistaPais vista) {
        this.vista = vista;
    }

    public void mostrar() {
        this.vista.setTitle("Países");
        this.vista.setLocation(50, 100);
        this.vista.setSize(600, 500);
        this.vista.setClosable(true);
        this.vista.setResizable(true);
        this.vista.setVisible(true);

        consultar();
        listar();

        this.vista.mnuMapa.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarMapa();
            }
        });
        
        this.vista.tbl.setComponentPopupMenu(this.vista.mnuPais);
    }

    private void mostrarMapa() {
        //verificar que se tenga seleccionado un departamento
        if (this.vista.tbl.getSelectedRow() >= 0) {
            Pais p = paises.get(this.vista.tbl.getSelectedRow());
            String nombreArchivo = "file:///" + rutaMapas + "/" + p.getNombre() + ".jpg";            
            try {
                byte[] bMapa = UtilIU.obtenerImagen(nombreArchivo);
                UtilIU.mostrarImagenVentana(bMapa, "Mapa de " + p.getNombre());

            } catch (Exception ex) {
                UtilIU.error("No se pudo obtener la imagen");
            }
        }
    }

    public void consultar() {
        //Consultar la lista de paises
        SessionFactory sf = UtilHibernate.getSessionFactory();
        Session sesion = sf.openSession();

        Query q = sesion.createQuery("FROM Pais");
        Iterator<Pais> it = q.iterate();

        paises = new ArrayList<>();
        while (it.hasNext()) {
            Pais p = it.next();
            paises.add(p);
        }
    }

    private String[][] pasarMatriz() {
        if (paises != null) {
            String[][] datos = new String[paises.size()][encabezados.length];
            int fila = 0;
            for (Pais p : paises) {
                datos[fila][0] = p.getNombre();
                datos[fila][1] = p.getContinente().getNombre();
                datos[fila][2] = p.getMoneda();
                datos[fila][3] = p.getTiporegion().getTipoRegion();
                fila++;
            }
            return datos;
        }
        return null;
    }

    public void listar() {
        UtilIU.mostrarTabla(this.vista.tbl, pasarMatriz(), encabezados);
    }

}
