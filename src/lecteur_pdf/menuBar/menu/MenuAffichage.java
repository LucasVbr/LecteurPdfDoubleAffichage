package lecteur_pdf_swing.menuBar.menu;

import lecteur_pdf_swing.IhmPdf;
import lecteur_pdf_swing.menuBar.menuItems.*;

import javax.swing.*;

public class MenuAffichage extends JMenu {

    public MenuAffichage(IhmPdf parent) {
        super("Affichage");
        // Ajouter les menu items
        add(new PleinEcran(parent));
        addSeparator();
        add(new ZoomPlus(parent));
        add(new ZoomDefaut(parent));
        add(new ZoomMoins(parent));
    }

}
