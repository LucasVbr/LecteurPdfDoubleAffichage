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
 * TODO commentaires
 *
 * @author Léo Franch
 * @author Lucas Vabre
 * @author Noé Villeneuve
 * @author Tristan Nogaret
 */
public class FermerFichier extends MenuItem {

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
            String TITRE = "Fermeture du document";
            String MESSAGE = "Etes vous sûr de vouloir fermer le document ?";

            if (Popup.OuiNonPopup(parent, TITRE, MESSAGE) == JOptionPane.YES_OPTION) parent.fermerPdf();
        }
    }
}
