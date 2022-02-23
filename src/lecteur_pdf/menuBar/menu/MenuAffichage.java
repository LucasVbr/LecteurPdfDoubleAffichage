package lecteur_pdf.menuBar.menu;

import lecteur_pdf.IhmPdf;
import lecteur_pdf.menuBar.menuItems.*;

import javax.swing.*;

public class MenuAffichage extends JMenu {

    public MenuAffichage(IhmPdf parent) {
        super("Affichage");
        // Ajoute les menu items
        add(new PleinEcran(parent));
        addSeparator();
        add(new PagePrecedente(parent));
        add(new PageSuivante(parent));
        addSeparator();
        add(new ZoomPlus(parent));
        add(new ZoomDefaut(parent));
        add(new ZoomMoins(parent));
    }

}
