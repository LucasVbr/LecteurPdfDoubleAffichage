/*
 * NouvelleFenetre.java, 26/02/2022
 * IUT Rodez 2021-2022, INFO 2
 * pas de copyright, aucun droits
 */

package lecteur_pdf.menuBar.menuItems;

import lecteur_pdf.Fenetre;
import lecteur_pdf.GestionFenetre;
import lecteur_pdf.GestionMode;

import java.awt.event.ActionEvent;

/**
 * Élément de Menu NouvelleFenetre qui permet d'ouvrir une autre fenêtre 
 * (pouvant contenir un PDF) si le nombre maximal de fenêtre n'est pas atteint
 *
 * @author Léo Franch
 * @author Lucas Vabre
 * @author Noé Villeneuve
 * @author Tristan Nogaret
 */
public class NouvelleFenetre extends MenuItem {

    /**
     * Créé un nouvel élément de Menu "Nouvelle Fenêtre"
     *
     * @param parent Référence de la fenêtre qui possède l'instance de ce MenuItem
     */
    public NouvelleFenetre(Fenetre parent) {
        super(parent, "Nouvelle Fenêtre");
    }

    @Override
    public void action(ActionEvent evt) {
        /* Essaye de créer une nouvelle fenêtre */
        GestionFenetre.newIhmPdf();

        /* Désactive le bouton si on a atteint la limite de fenêtres */
        if (GestionFenetre.FENETRE_LIST.size() == GestionFenetre.NB_MAX_PDF) GestionMode.desactiverBtnNouvelleFenetre();
    }
}