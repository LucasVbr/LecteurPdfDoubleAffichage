/*
 * NouvelleFenetre.java, 26/02/2022
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
public class NouvelleFenetre extends MenuItem {

    /**
     * TODO
     * @param parent
     */
    public NouvelleFenetre(Fenetre parent) {
        super(parent, "Nouvelle Fenêtre");
    }

    @Override
    public void action(ActionEvent evt) {
        /* Essaye de créer une nouvelle fenêtre */
        GestionFenetre.newIhmPdf();

        /* Désactive le bouton si on a atteint la limite des affichages */
        if (GestionFenetre.FENETRE_LIST.size() == GestionFenetre.NB_MAX_PDF) GestionMode.desactiverFenetre();
    }
}