/*
 * ZoomMoins.java, 26/02/2022
 * IUT Rodez 2021-2022, INFO 2
 * pas de copyright, aucun droits
 */

package lecteur_pdf.menuBar.menuItems;

import lecteur_pdf.Fenetre;

import java.awt.event.ActionEvent;

/**
 * Element de Menu Zoom 50% qui permet de dézoomer
 *
 * @author Léo Franch
 * @author Lucas Vabre
 * @author Noé Villeneuve
 * @author Tristan Nogaret
 */
public class ZoomMoins extends MenuItem {

    /**
     * Crée un nouvel Element de Menu "Zoom 50%"
     *
     * @param parent Référence de la fenêtre qui possède l'instance de ce MenuItem
     */
    public ZoomMoins(Fenetre parent) {
        super(parent, "Zoom 50%");
    }

    @Override
    protected void action(ActionEvent evt) {
        parent.getPdfPanel().updateScaleZoom(0.5f);
        parent.validate();
    }
}
