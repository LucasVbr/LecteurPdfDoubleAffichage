/*
 * PageSuivante.java, 26/02/2022
 * IUT Rodez 2021-2022, INFO 2
 * pas de copyright, aucun droits
 */

package lecteur_pdf.menuBar.menuItems;

import lecteur_pdf.GestionMode;
import lecteur_pdf.GestionFenetre;
import lecteur_pdf.Fenetre;

import java.awt.event.ActionEvent;

/**
 * TODO commentaires
 *
 * @author Léo Franch
 * @author Lucas Vabre
 * @author Noé Villeneuve
 * @author Tristan Nogaret
 */
public class PageSuivante extends MenuItem {

    /**
     * TODO
     * @param parent
     */
    public PageSuivante(Fenetre parent) {
        super(parent, "Page suivante");
    }

    @Override
    protected void action(ActionEvent evt) {
        if (GestionMode.isModeSepare()) parent.getPdfPanel().nextPage();
        else GestionFenetre.nextPages();
    }
}
