/*
 * OuvrirFichier.java, 26/02/2022
 * IUT Rodez 2021-2022, INFO 2
 * pas de copyright, aucun droits
 */

package lecteur_pdf.menuBar.menuItems;

import lecteur_pdf.IhmPdf;
import lecteur_pdf.SelectionnerFichier;

import java.awt.event.KeyEvent;
import java.io.File;

/**
 * TODO commentaires
 *
 * @author Léo Franch
 * @author Lucas Vabre
 * @author Noé Villeneuve
 * @author Tristan Nogaret
 */
public class OuvrirFichier extends MenuItem {

    /**
     * TODO
     *
     * @param parent
     */
    public OuvrirFichier(IhmPdf parent) {
        super(parent, "Ouvrir");

        addActionListener(e -> {
            File fichier = SelectionnerFichier.ouvrirFichier();
            if (fichier != null && parent.getPdfPanel().chargerPdf(fichier)) {
                parent.setTitle(fichier.getName());
                parent.pack();
            } else {
                // TODO Erreur fichier n'as pas pu etre chargé
            }
        });

        setRaccourcis(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK);
    }
}
