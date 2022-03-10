/*
 * ZoomDefaut.java, 26/02/2022
 * IUT Rodez 2021-2022, INFO2
 * Pas de copyright, aucun droits
 */

package lecteur_pdf.menuBar.menuItems;

import lecteur_pdf.Fenetre;

/**
 * Élément de Menu Zoom 100% qui permet de mettre le Zoom par défaut
 *
 * @author Léo Franch
 * @author Tristan Nogaret
 * @author Lucàs Vabre
 * @author Noé Villeneuve
 */
public class ZoomDefaut extends MenuItem {

    /**
     * Créé un nouvel élément de Menu "Zoom 100%"
     *
     * @param parent Référence de la fenêtre qui possède l'instance de ce MenuItem
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
