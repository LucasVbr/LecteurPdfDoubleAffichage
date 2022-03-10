/*
 * ZoomDefaut.java, 26/02/2022
 * IUT Rodez 2021-2022, INFO 2
 * pas de copyright, aucun droits
 */

package lecteur_pdf.menuBar.menuItems;

import lecteur_pdf.Fenetre;

import java.awt.event.ActionEvent;

/**
 * Élément de Menu Zoom 100% qui permet de mettre le Zoom par défaut
 *
 * @author Léo Franch
 * @author Lucas Vabre
 * @author Noé Villeneuve
 * @author Tristan Nogaret
 */
public class ZoomDefaut extends MenuItem {

    /**
     * Crée un nouvel Élément de Menu "Zoom 100%"
     *
     * @param parent Référence de la fenêtre qui possède l'instance de ce MenuItem
     */
    public ZoomDefaut(Fenetre parent) {
        super(parent, "Zoom 100%");
    }

    @Override
    protected void action(ActionEvent evt) {
        parent.getPdfPanel().setZoom(1.0f);
        parent.validate();
    }
}
