package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vistas.*;

public class ControladorPrincipal {

    private VistaPrincipal vista;
    private ControladorPais cPais;
    private ControladorRegion cRegion;

    public ControladorPrincipal(VistaPrincipal vista) {
        this.vista = vista;

        this.vista.setTitle("División Política del Mundo");
        this.vista.setExtendedState(VistaPrincipal.MAXIMIZED_BOTH);
        this.vista.setVisible(true);

        this.vista.btnPaises.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarPaises();
            }
        });
        
        this.vista.btnRegiones.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarRegiones();
            }
        });

    }

    public void mostrarPaises() {
        if (cPais == null) {
            VistaPais vPais = new VistaPais();
            cPais = new ControladorPais(vPais);
            this.vista.add(vPais);
        }
        cPais.mostrar();
    }
    
    public void mostrarRegiones() {
        if (cRegion == null) {
            VistaRegion vRegion = new VistaRegion();
            cRegion = new ControladorRegion(vRegion);
            this.vista.add(vRegion);
        }
        cRegion.mostrar();
    }

}
