package lecteur_pdf.menuBar.menuItems;

import lecteur_pdf.GestionPdf;
import lecteur_pdf.IhmPdf;

public class PageSuivante extends MenuItem {

    public PageSuivante(IhmPdf parent) {
        super(parent,"Page suivante");

        addActionListener(e -> {
            if (GestionPdf.modeDoubleAffichage && GestionPdf.modeSynchronise) {
                GestionPdf.nextPages();
            } else {
                parent.getPdfPanel().nextPage();
            }
        });

        setRaccourcis('m');
    }
}
