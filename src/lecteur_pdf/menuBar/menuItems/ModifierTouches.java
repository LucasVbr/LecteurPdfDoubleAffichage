/*
 * ModifierTouches.java, 26/02/2022
 * IUT Rodez 2021-2022, INFO 2
 * pas de copyright, aucun droits
 */

package lecteur_pdf.menuBar.menuItems;

import lecteur_pdf.IhmPdf;
import lecteur_pdf.raccourcisClavier.RaccourcisClavier;

import java.awt.event.ActionEvent;

/**
 * TODO commentaires
 *
 * @author Léo Franch
 * @author Lucas Vabre
 * @author Noé Villeneuve
 * @author Tristan Nogaret
 */
public class ModifierTouches extends MenuItem {

    /**
     * TODO
     * @param parent Référence de la fenêtre qui possède l'instance de ce MenuItem
     */
    public ModifierTouches(IhmPdf parent) {
        super(parent, "Modifier Touches");
    }

    @Override
    protected void action(ActionEvent evt) {
        new RaccourcisClavier();
    }
}
