/*
 * OuvrirFichier.java, 26/02/2022
 * IUT Rodez 2021-2022, INFO 2
 * pas de copyright, aucun droits
 */

package lecteur_pdf.menuBar.menuItems;

import lecteur_pdf.Fenetre;
import lecteur_pdf.Popup;
import lecteur_pdf.SelectionnerFichier;

import java.awt.event.ActionEvent;
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
     */
    public OuvrirFichier(Fenetre parent) {
        super(parent, "Ouvrir");

//        setRaccourcis(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK);
    }

    @Override
    protected void action(ActionEvent evt) {
        /* On charge le fichier si c'est possible */
        File fichier = SelectionnerFichier.ouvrirFichier(parent);

        if (fichier == null) {
            return;
        }

        /* Si il y a deja un fichier d'ouvert, on le ferme */
        parent.getPdfPanel().dechargerPdf();
        parent.setTitle(Fenetre.TITRE);
        parent.pack();

        if (parent.getPdfPanel().chargerPdf(fichier)) {
            parent.setTitle(Fenetre.TITRE + " - " + fichier.getName());
            parent.pack();
        } else {
            final String TITRE = "Erreur";
            final String MESSAGE = "Erreur : Le document n'as pas pu être chargé";
            Popup.errorPopup(parent, TITRE, MESSAGE);
        }
    }
}
