/*
 * PageEntiere.java, 09/03/2022
 * IUT Rodez 2021-2022, INFO 2
 * pas de copyright, aucun droits
 */

package lecteur_pdf.menuBar.menuItems;

import lecteur_pdf.Fenetre;

import java.awt.event.ActionEvent;

/**
 * Element de Menu Page Entière qui permet d'afficher l'intégralité du document courrant verticalement
 *
 * @author Léo Franch
 * @author Lucas Vabre
 * @author Noé Villeneuve
 * @author Tristan Nogaret
 */
public class PageEntiere extends MenuItem {
    /**
     * Crée un nouvel Element de Menu "Page Entiere"
     *
     *  @param parent Référence de la fenêtre qui possède l'instance de ce MenuItem
     */
    public PageEntiere(Fenetre parent) {
        super(parent, "Page Entière");
    }

    @Override
    protected void action(ActionEvent evt) {
        parent.getPdfPanel().setPleineLargeur(false);
    }
}
