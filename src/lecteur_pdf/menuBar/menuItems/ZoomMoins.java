/*
 * ZoomMoins.java, 26/02/2022
 * IUT Rodez 2021-2022, INFO2
 * Pas de copyright, aucun droits
 */

package lecteur_pdf.menuBar.menuItems;

import lecteur_pdf.Fenetre;

/**
 * Élément de Menu Zoom 50% qui permet de dézoomer
 *
 * @author Léo Franch
 * @author Tristan Nogaret
 * @author Lucàs Vabre
 * @author Noé Villeneuve
 */
public class ZoomMoins extends MenuItem {

    /**
     * Créé un nouvel élément de Menu "Zoom 50%"
     *
     * @param parent Référence de la fenêtre qui possède l'instance de ce MenuItem
     */
    public ZoomMoins(Fenetre parent) {
        super(parent, "Zoom 50%");
    }

    @Override
    protected void action() {
        parent.getPdfPanel().setZoom(0.5f);
        parent.validate();
    }
}
