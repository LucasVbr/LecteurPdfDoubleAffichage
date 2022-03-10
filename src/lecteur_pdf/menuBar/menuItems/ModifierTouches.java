/*
 * ModifierTouches.java, 26/02/2022
 * IUT Rodez 2021-2022, INFO 2
 * pas de copyright, aucun droits
 */

package lecteur_pdf.menuBar.menuItems;

import lecteur_pdf.Fenetre;
import lecteur_pdf.raccourcisClavier.RaccourcisClavier;

import java.awt.event.ActionEvent;

/**
 * Élément de Menu Modifier Touches qui permet d'ouvrir une fenêtre pour modifier les raccourcis claviers de l'application
 *
 * @author Léo Franch
 * @author Lucas Vabre
 * @author Noé Villeneuve
 * @author Tristan Nogaret
 */
public class ModifierTouches extends MenuItem {

    /**
     * Crée un nouvel Élément de Menu "Modifier Touches"
     *
     * @param parent Référence de la fenêtre qui possède l'instance de ce MenuItem
     */
    public ModifierTouches(Fenetre parent) {
        super(parent, "Modifier Touches");
    }

    @Override
    protected void action(ActionEvent evt) {
        new RaccourcisClavier();
    }
}
