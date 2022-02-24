package lecteur_pdf.menuBar.menuItems;

import lecteur_pdf.GestionPdf;
import lecteur_pdf.IhmPdf;

import javax.swing.*;

public class ModeSepare extends JRadioButtonMenuItem {

    IhmPdf parent;

    public ModeSepare(IhmPdf parent) {
        super("Mode Séparé");
        this.parent = parent;

        addActionListener(e -> {
            GestionPdf.setModeSynchronise(false);
        });

        // TODO ajouter une checkbox pour indiquer si l'option est utilisé

        // TODO ajouter l'options de mode Synchronisé
    }
}
