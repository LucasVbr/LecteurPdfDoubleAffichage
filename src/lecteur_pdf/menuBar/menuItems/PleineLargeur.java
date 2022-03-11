/*
 * PleineLargeur.java, 09/03/2022
 * IUT Rodez 2021-2022, INFO2
 * Pas de copyright, aucun droits
 */

package lecteur_pdf.menuBar.menuItems;

import lecteur_pdf.Fenetre;

/**
 * Élément de {@link lecteur_pdf.menuBar.menu.MenuAffichage MenuAffichage}
 * qui permet d'afficher le document courant de manière bord à bord (la
 * taille horizontale du document coincide avec celle de la
 * {@link Fenetre fenêtre})
 *
 * @author Léo Franch
 * @author Tristan Nogaret
 * @author Lucàs Vabre
 * @author Noé Villeneuve
 * @see MenuItem
 */
public class PleineLargeur extends MenuItem {


    /**
     * Créé un nouvel élément de
     * {@link lecteur_pdf.menuBar.menu.MenuAffichage MenuAffichage}
     *
     * @param parent Référence de la {@link Fenetre fenêtre} qui possède
     *               l'instance de ce
     *               {@link lecteur_pdf.menuBar.menuItems.MenuItem MenuItem}
     */
    public PleineLargeur(Fenetre parent) {
        super(parent, "Pleine Largeur");
    }

    @Override
    protected void action() {
        parent.getPdfPanel().setPleineLargeur(true);
    }
}
