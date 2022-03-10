/*
 * ZoomPlus.java, 26/02/2022
 * IUT Rodez 2021-2022, INFO2
 * Pas de copyright, aucun droits
 */

package lecteur_pdf.menuBar.menuItems;

import lecteur_pdf.Fenetre;

/**
 * Élément de Menu Zoom 150% qui permet de zoomer
 *
 * @author Léo Franch
 * @author Tristan Nogaret
 * @author Lucàs Vabre
 * @author Noé Villeneuve
 */
public class ZoomPlus extends MenuItem {

    /**
     * Créé un nouvel élément de Menu "Zoom 150%"
     *
     * @param parent Référence de la fenêtre qui possède l'instance de ce MenuItem
     */
    public ZoomPlus(Fenetre parent) {
        super(parent, "Zoom 150%");
    }

    @Override
    protected void action() {
        parent.getPdfPanel().setZoom(1.5f);
        parent.validate();
    }
}