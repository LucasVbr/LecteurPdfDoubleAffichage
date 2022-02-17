package lecteur_pdf.menuBar.menu;

import lecteur_pdf.IhmPdf;
import lecteur_pdf.menuBar.menuItems.*;

import javax.swing.*;

public class MenuOptions extends JMenu {
    public MenuOptions(IhmPdf parent) {
        super("Options");
        // Ajoute les menu items
        add(new ModifierTouches(parent));
    }
}
