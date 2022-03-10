/*
 * FermerFichier.java, 26/02/2022
 * IUT Rodez 2021-2022, INFO 2
 * pas de copyright, aucun droits
 */

package lecteur_pdf.menuBar.menuItems;

import lecteur_pdf.Fenetre;
import lecteur_pdf.Popup;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Element de Menu Fermer qui permet de fermer le document PDF courant
 *
 * @author Léo Franch
 * @author Lucas Vabre
 * @author Noé Villeneuve
 * @author Tristan Nogaret
 */
public class FermerFichier extends MenuItem {

    /** Titre de la popup lors de la fermeture d'un document */
    public static final String TITRE = "Fermeture du document";

    /** Message de la Popup lors de la fermeture d'un document */
    public static final String MESSAGE = "Êtes-vous sûr de vouloir fermer le document ?";

    /**
     * Crée un nouvel Element de Menu "Fermer"
     *
     * @param parent Référence de la fenêtre qui possède l'instance de ce MenuItem
     */
    public FermerFichier(Fenetre parent) {
        super(parent, "Fermer");
    }

    @Override
    protected void action(ActionEvent evt) {
        if (parent.getPdfPanel().isCharge()) {
            int resultatPopup = Popup.OuiNonPopup(parent, TITRE, MESSAGE);
            if (resultatPopup == JOptionPane.YES_OPTION) parent.fermerPdf();
        }
    }
}
