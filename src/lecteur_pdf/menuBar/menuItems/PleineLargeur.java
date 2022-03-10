/*
 * PleineLargeur.java, 09/03/2022
 * IUT Rodez 2021-2022, INFO2
 * Pas de copyright, aucun droits
 */

package lecteur_pdf.menuBar.menuItems;

import lecteur_pdf.Fenetre;

/**
 * Élément de Menu Pleine Largeur qui permet d'afficher le document courant
 * de manière bord à bord (la taille horizontale du document coincide avec
 * celle de la fenêtre)
 *
 * @author Léo Franch
 * @author Tristan Nogaret
 * @author Lucàs Vabre
 * @author Noé Villeneuve
 */
public class PleineLargeur extends MenuItem {


    /**
     * Créé un nouvel élément de Menu "Pleine Largeur"
     *
     * @param parent Référence de la fenêtre qui possède l'instance de ce
     *               MenuItem
     */
    public PleineLargeur(Fenetre parent) {
        super(parent, "Pleine Largeur");
    }

    @Override
    protected void action() {
        parent.getPdfPanel().setPleineLargeur(true);
    }
}
