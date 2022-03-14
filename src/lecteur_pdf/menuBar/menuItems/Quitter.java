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
 * Élément de {@link lecteur_pdf.menuBar.menu.MenuFichier MenuFichier} qui
 * permet de fermer la {@link Fenetre fenêtre} courante et ferme
 * l'application s'il s'agit de la dernière {@link Fenetre fenêtre} fermée
 *
 * @author Léo Franch
 * @author Tristan Nogaret
 * @author Lucàs Vabre
 * @author Noé Villeneuve
 * @see MenuItem
 */
public class Quitter extends MenuItem {

    /**
     * Créé un nouvel élément de
     * {@link lecteur_pdf.menuBar.menu.MenuFichier MenuFichier}
     *
     * @param parent Référence de la {@link Fenetre fenêtre} qui possède
     *               l'instance de ce
     *               {@link lecteur_pdf.menuBar.menuItems.MenuItem MenuItem}
     */
    public Quitter(Fenetre parent) {
        super(parent, "Quitter");
    }

    @Override
    protected void action() {
        final String TITRE = "Quitter";
        final String MESSAGE
            = "Êtes-vous sûr de vouloir fermer la fenêtre ?";
        if (Popup.OuiNonPopup(parent, TITRE, MESSAGE)
            == JOptionPane.YES_OPTION) {
            parent.quitter();
        }
    }
}
