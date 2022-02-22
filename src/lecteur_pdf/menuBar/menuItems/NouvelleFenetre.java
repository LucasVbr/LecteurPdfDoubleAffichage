package lecteur_pdf.menuBar.menuItems;

import lecteur_pdf.IhmPdf;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class NouvelleFenetre extends JMenuItem {

    IhmPdf parent;

    public NouvelleFenetre(IhmPdf parent) {
        super("Nouvelle Fenêtre");
        this.parent = parent;

        // TODO griser l'options lorsque inutilisable

        // TODO ajouter l'options nouvelle fenêtre
    }
}