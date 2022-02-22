package lecteur_pdf.menuBar.menuItems;

import lecteur_pdf.IhmPdf;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class ModifierTouches extends JMenuItem {

    IhmPdf parent;

    public ModifierTouches(IhmPdf parent) {
        super("Modifier Touches");
        this.parent = parent;

        // TODO ajouter l'options de modif de touches
    }
}
