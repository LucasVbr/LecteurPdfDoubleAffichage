/*
 * PageSuivante.java, 26/02/2022
 * IUT Rodez 2021-2022, INFO2
 * Pas de copyright, aucun droits
 */

package lecteur_pdf.menuBar.menuItems;

import lecteur_pdf.Fenetre;
import lecteur_pdf.GestionFenetre;
import lecteur_pdf.GestionMode;

/**
 * Élément de Menu Page Suivante qui permet d'afficher la page suivante du
 * document courant (ou les pages suivantes si le mode Synchronisé est activé)
 *
 * @author Léo Franch
 * @author Tristan Nogaret
 * @author Lucàs Vabre
 * @author Noé Villeneuve
 */
public class PageSuivante extends MenuItem {

    /**
     * Créé un nouvel Élément de Menu "Page Suivante"
     *
     * @param parent Référence de la fenêtre qui possède l'instance de ce
     *               MenuItem
     */
    public PageSuivante(Fenetre parent) {
        super(parent, "Page suivante");
    }

    @Override
    protected void action() {
        if (GestionMode.isModeSepare()) {
            parent.getPdfPanel().pageSuivante();
        } else {
            GestionFenetre.nextPages();
        }
    }
}
