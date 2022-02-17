package lecteur_pdf.menuBar;

import lecteur_pdf.IhmPdf;
import lecteur_pdf.menuBar.menu.*;

import javax.swing.*;

public class MenuBar extends JMenuBar {

    public MenuBar(IhmPdf parent) {

        add(new MenuFichier(parent));
        add(new MenuAffichage(parent));
        add(new MenuMode(parent));
        add(new MenuOptions(parent));
    }
}
