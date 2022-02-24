package lecteur_pdf.menuBar.menuItems;

import lecteur_pdf.IhmPdf;
import lecteur_pdf.SelectionnerFichier;

import java.awt.event.KeyEvent;
import java.io.File;

public class OuvrirFichier extends MenuItem {

    public OuvrirFichier(IhmPdf parent) {
        super(parent, "Ouvrir");

        addActionListener(e -> {
            File fichier = SelectionnerFichier.ouvrirFichier();
            if (fichier != null) {
                if (parent.getPdfPanel().chargerPdf(fichier)) {
                    parent.setTitle(fichier.getName());
                    parent.pack();
                } else {
                    // TODO Erreur fichier n'as pas pu etre chargé
                }
            }
        });

        setRaccourcis(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK);
    }
}
