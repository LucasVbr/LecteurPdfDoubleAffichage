package lecteur_pdf.menuBar.menu;

import lecteur_pdf.IhmPdf;
import lecteur_pdf.menuBar.menuItems.*;

import javax.swing.*;

public class MenuMode extends JMenu {
    public MenuMode(IhmPdf parent) {
        super("Mode");
        // Ajoute les menu items
        add(new NouvelleFenetre(parent));
        add(new ModeSynchronise(parent));
    }
}