package lecteur_pdf_swing.menuBar;

import lecteur_pdf_swing.IhmPdf;
import lecteur_pdf_swing.menuBar.menu.*;

import javax.swing.*;

public class MenuBar extends JMenuBar {

    public MenuBar(IhmPdf parent) {

        add(new MenuFichier(parent));
        add(new MenuAffichage(parent));
        add(new MenuOptions());
    }
}
