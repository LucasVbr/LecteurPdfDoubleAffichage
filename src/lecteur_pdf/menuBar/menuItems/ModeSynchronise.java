package lecteur_pdf.menuBar.menuItems;

import lecteur_pdf.GestionPdf;
import lecteur_pdf.IhmPdf;

import javax.swing.*;

public class ModeSynchronise extends JRadioButtonMenuItem {

    IhmPdf parent;

    public ModeSynchronise(IhmPdf parent) {
        super("Mode Synchronisé");
        this.parent = parent;

        addActionListener(e -> {
            GestionPdf.setModeSynchronise(true);
        });

        // TODO ajouter une checkbox pour indiquer si l'option est utilisé

        // TODO ajouter l'options de mode Synchronisé
    }
}