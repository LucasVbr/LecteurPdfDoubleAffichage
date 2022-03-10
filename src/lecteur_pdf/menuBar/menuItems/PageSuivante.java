/*
 * PageSuivante.java, 26/02/2022
 * IUT Rodez 2021-2022, INFO 2
 * pas de copyright, aucun droits
 */

package lecteur_pdf.menuBar.menuItems;

import lecteur_pdf.Fenetre;
import lecteur_pdf.GestionFenetre;
import lecteur_pdf.GestionMode;

import java.awt.event.ActionEvent;

/**
 * Élément de Menu Page Suivante qui permet d'afficher la page suivante du
 * document courant (ou les pages suivantes si le mode Synchronisé est activé)
 *
 * @author Léo Franch
 * @author Lucas Vabre
 * @author Noé Villeneuve
 * @author Tristan Nogaret
 */
public class PageSuivante extends MenuItem {

    /**
     * Crée un nouvel Élément de Menu "Page Suivante"
     *
     * @param parent Référence de la fenêtre qui possède l'instance de ce
     *               MenuItem
     */
    public PageSuivante(Fenetre parent) {
        super(parent, "Page suivante");
    }

    @Override
    protected void action(ActionEvent evt) {
        if (GestionMode.isModeSepare()) {
            parent.getPdfPanel().nextPage();
        } else {
            GestionFenetre.nextPages();
        }
    }
}
