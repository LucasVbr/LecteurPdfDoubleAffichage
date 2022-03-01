/*
 * NouvelleFenetre.java, 26/02/2022
 * IUT Rodez 2021-2022, INFO 2
 * pas de copyright, aucun droits
 */

package lecteur_pdf.menuBar.menuItems;

import lecteur_pdf.GestionMode;
import lecteur_pdf.GestionPdf;
import lecteur_pdf.IhmPdf;

import java.awt.*;

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
    public NouvelleFenetre(IhmPdf parent) {
        super(parent, "Nouvelle Fenêtre");

        addActionListener(e -> {
            /* Essaye de créer une nouvelle fenêtre */
            GestionPdf.newIhmPdf();

            /* Désactive le bouton si on a atteint la limite des affichages */
            if (GestionPdf.ihmPdfList.size() == GestionPdf.maxPdf) GestionMode.desactiverFenetre();
        });

    }
}