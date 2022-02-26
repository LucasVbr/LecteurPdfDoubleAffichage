package lecteur_pdf.menuBar.menuItems;

import lecteur_pdf.GestionMode;
import lecteur_pdf.GestionPdf;
import lecteur_pdf.IhmPdf;

public class PagePrecedente extends MenuItem {

    public PagePrecedente(IhmPdf parent) {
        super(parent,"Page précédente");

        addActionListener(e -> {
            if (GestionMode.isModeSepare()) {
                parent.getPdfPanel().previousPage();
            } else {
                GestionPdf.previousPages();
            }
        });

        setRaccourcis('l');
    }
}
