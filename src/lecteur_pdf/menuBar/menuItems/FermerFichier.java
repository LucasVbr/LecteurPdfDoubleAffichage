package lecteur_pdf.menuBar.menuItems;

import lecteur_pdf.GestionPdf;
import lecteur_pdf.IhmPdf;

import java.awt.event.KeyEvent;

public class FermerFichier extends MenuItem {

    public FermerFichier(IhmPdf parent) {
        super(parent, "Fermer");

        addActionListener(e -> {
            parent.getPdfPanel().dechargerPdf();
            parent.setTitle(GestionPdf.titreApplication);
            parent.pack();
        });

        setRaccourcis(KeyEvent.VK_X, KeyEvent.CTRL_DOWN_MASK);
    }
}
