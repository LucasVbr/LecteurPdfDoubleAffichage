package lecteur_pdf.menuBar.menuItems;

import lecteur_pdf.GestionPdf;
import lecteur_pdf.IhmPdf;

import javax.swing.*;

public class PageSuivante extends JMenuItem {

    IhmPdf parent;

    public PageSuivante(IhmPdf parent) {
        super("Page suivante");
        this.parent = parent;

        addActionListener(e -> {
            if (GestionPdf.modeDoubleAffichage && GestionPdf.modeSynchronise) {
                GestionPdf.nextPages();
            } else {
                parent.getPdfPanel().nextPage();
            }
        });

        KeyStroke raccourciPageSuivante = KeyStroke.getKeyStroke('m');
        setAccelerator(raccourciPageSuivante);
    }
}
