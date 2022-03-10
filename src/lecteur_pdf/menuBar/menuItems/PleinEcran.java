/*
 * PleinEcran.java, 26/02/2022
 * IUT Rodez 2021-2022, INFO 2
 * pas de copyright, aucun droits
 */

package lecteur_pdf.menuBar.menuItems;

import lecteur_pdf.Fenetre;

import java.awt.event.ActionEvent;

/**
 * Element de Menu PleinEcran qui permet d'afficher la page la fenêtre courante en plein écran
 *
 * @author Léo Franch
 * @author Lucas Vabre
 * @author Noé Villeneuve
 * @author Tristan Nogaret
 */
public class PleinEcran extends MenuItem {

    /**
     * Crée un nouvel Element de Menu PleinEcran
     *
     * @param parent Référence de la fenêtre qui possède l'instance de ce MenuItem
     */
    public PleinEcran(Fenetre parent) {
        super(parent, "Mode Plein Écran");
    }

    @Override
    protected void action(ActionEvent evt) {
        parent.pleinEcran();
    }
}