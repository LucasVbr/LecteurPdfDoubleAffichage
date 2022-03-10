/*
 * Quitter.java, 26/02/2022
 * IUT Rodez 2021-2022, INFO2
 * Pas de copyright, aucun droits
 */

package lecteur_pdf.menuBar.menuItems;

import lecteur_pdf.Fenetre;
import lecteur_pdf.Popup;

import javax.swing.*;

/**
 * Élément de Menu Quitter qui permet de fermer la fenêtre courante, ferme
 * l'application s'il s'agit de la dernière fenêtre fermée
 *
 * @author Léo Franch
 * @author Tristan Nogaret
 * @author Lucàs Vabre
 * @author Noé Villeneuve
 */
public class Quitter extends MenuItem {

    /**
     * Créé un nouvel élément de Menu "Quitter"
     *
     * @param parent Référence de la fenêtre qui possède l'instance de ce MenuItem
     */
    public Quitter(Fenetre parent) {
        super(parent, "Quitter");
    }

    @Override
    protected void action() {
        final String TITRE = "Quitter";
        final String MESSAGE = "Êtes-vous sûr de vouloir quitter l'application ?";
        if (Popup.OuiNonPopup(parent, TITRE, MESSAGE) == JOptionPane.YES_OPTION) parent.quitter();
    }
}
