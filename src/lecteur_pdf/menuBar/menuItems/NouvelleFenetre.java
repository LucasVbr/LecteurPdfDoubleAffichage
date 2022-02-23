package lecteur_pdf.menuBar.menuItems;

import lecteur_pdf.GestionPdf;
import lecteur_pdf.IhmPdf;

import javax.swing.*;

public class NouvelleFenetre extends JMenuItem {

    IhmPdf parent;

    public NouvelleFenetre(IhmPdf parent) {
        super("Nouvelle Fenêtre");
        this.parent = parent;

        addActionListener(e -> {
            /* Essaye de créer une nouvelle fenêtre */
            GestionPdf.newIhmPdf();

            /* Désactive le bouton si on a atteint la limite des affichages */
            this.setEnabled(GestionPdf.ihmPdfList.size() == GestionPdf.maxPdf);
        });

    }
}