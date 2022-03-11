/*
 * ZoomDefaut.java, 26/02/2022
 * IUT Rodez 2021-2022, INFO2
 * Pas de copyright, aucun droits
 */

package lecteur_pdf.menuBar.menuItems;

import lecteur_pdf.Fenetre;

/**
 * Élément de {@link lecteur_pdf.menuBar.menu.MenuAffichage MenuAffichage}
 * qui permet de mettre le zoom par défaut
 *
 * @author Léo Franch
 * @author Tristan Nogaret
 * @author Lucàs Vabre
 * @author Noé Villeneuve
 * @see MenuItem
 */
public class ZoomDefaut extends MenuItem {

    /**
     * Créé un nouvel élément de
     * {@link lecteur_pdf.menuBar.menu.MenuAffichage MenuAffichage}
     *
     * @param parent Référence de la {@link Fenetre fenêtre} qui possède
     *               l'instance de ce
     *               {@link lecteur_pdf.menuBar.menuItems.MenuItem MenuItem}
     */
    public ZoomDefaut(Fenetre parent) {
        super(parent, "Zoom 100%");
    }

    @Override
    protected void action() {
        parent.getPdfPanel().setZoom(1.0f);
        parent.validate();
    }
}
