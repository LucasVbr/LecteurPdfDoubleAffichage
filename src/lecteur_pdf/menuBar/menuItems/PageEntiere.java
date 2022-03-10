/*
 * PageEntiere.java, 09/03/2022
 * IUT Rodez 2021-2022, INFO2
 * Pas de copyright, aucun droits
 */

package lecteur_pdf.menuBar.menuItems;

import lecteur_pdf.Fenetre;

/**
 * Élément de Menu Page Entière qui permet d'afficher l'intégralité du document courant verticalement
 *
 * @author Léo Franch
 * @author Tristan Nogaret
 * @author Lucàs Vabre
 * @author Noé Villeneuve
 */
public class PageEntiere extends MenuItem {
    /**
     * Créé un nouvel élément de Menu PageEntiere
     *
     * @param parent Référence de la fenêtre qui possède l'instance de ce MenuItem
     */
    public PageEntiere(Fenetre parent) {
        super(parent, "Page Entière");
    }

    @Override
    protected void action() {
        parent.getPdfPanel().setPleineLargeur(false);
    }
}
