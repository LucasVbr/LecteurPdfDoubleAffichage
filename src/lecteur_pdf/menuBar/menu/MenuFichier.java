package lecteur_pdf_swing.menuBar.menu;

import lecteur_pdf_swing.IhmPdf;
import lecteur_pdf_swing.menuBar.menuItems.*;

import javax.swing.*;

public class MenuFichier extends JMenu {
    public MenuFichier(IhmPdf parent) {
        super("Fichier");
        // Ajouter les menu items
        add(new OuvrirFichier(parent));
        add(new FermerFichier(parent));
        add(new Quitter(parent));
    }
}
