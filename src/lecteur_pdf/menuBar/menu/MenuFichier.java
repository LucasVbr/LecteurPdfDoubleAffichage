package lecteur_pdf.menuBar.menu;

import lecteur_pdf.IhmPdf;
import lecteur_pdf.menuBar.menuItems.*;

import javax.swing.*;

public class MenuFichier extends JMenu {
    public MenuFichier(IhmPdf parent) {
        super("Fichier");
        // Ajoute les menu items
        add(new OuvrirFichier(parent));
        add(new FermerFichier(parent));
        add(new Quitter(parent));
    }
}
