package lecteur_pdf.menuBar.menuItems;

import lecteur_pdf.IhmPdf;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class ModeSynchronise extends JMenuItem {

    IhmPdf parent;

    public ModeSynchronise(IhmPdf parent) {
        super("Mode Synchronisé");
        this.parent = parent;

        // TODO ajouter une checkbox pour indiquer si l'option est utilisé

        // TODO ajouter l'options de mode Synchronisé
    }
}