package lecteur_pdf.menuBar.menuItems;

import lecteur_pdf.GestionPdf;
import lecteur_pdf.IhmPdf;

import javax.swing.*;

public class PagePrecedente extends JMenuItem {

    IhmPdf parent;

    public PagePrecedente(IhmPdf parent) {
        super("Page précédente");
        this.parent = parent;

        addActionListener(e -> {
            if (GestionPdf.modeDoubleAffichage && GestionPdf.modeSynchronise) {
                GestionPdf.previousPages();
            } else {
                parent.getPdfPanel().previousPage();
            }
        });

        KeyStroke raccourciPagePrecedente = KeyStroke.getKeyStroke('l');
        setAccelerator(raccourciPagePrecedente);
    }
}
