/*
 * PleinEcran.java, 26/02/2022
 * IUT Rodez 2021-2022, INFO2
 * Pas de copyright, aucun droits
 */

package lecteur_pdf.menuBar.menuItems;

import lecteur_pdf.Fenetre;

/**
 * Élément de Menu PleinEcran qui permet d'afficher la page la fenêtre courante en plein écran
 *
 * @author Léo Franch
 * @author Tristan Nogaret
 * @author Lucàs Vabre
 * @author Noé Villeneuve
 */
public class PleinEcran extends MenuItem {

    /**
     * Créé un nouvel élément de Menu PleinEcran
     *
     * @param parent Référence de la fenêtre qui possède l'instance de ce MenuItem
     */
    public PleinEcran(Fenetre parent) {
        super(parent, "Mode Plein Écran");
    }

    @Override
    protected void action() {
        parent.pleinEcran();
    }
}