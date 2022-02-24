package lecteur_pdf.menuBar.menuItems;

import lecteur_pdf.GestionPdf;
import lecteur_pdf.IhmPdf;

public class NouvelleFenetre extends MenuItem {

    public NouvelleFenetre(IhmPdf parent) {
        super(parent, "Nouvelle Fenêtre");

        addActionListener(e -> {
            /* Essaye de créer une nouvelle fenêtre */
            GestionPdf.newIhmPdf();

            /* Désactive le bouton si on a atteint la limite des affichages */
            this.setEnabled(GestionPdf.ihmPdfList.size() == GestionPdf.maxPdf);
        });

    }
}