/*
 * MenuAffichage.java, 26/02/2022
 * IUT Rodez 2021-2022, INFO 2
 * pas de copyright, aucun droits
 */

package lecteur_pdf.menuBar.menu;

import lecteur_pdf.Fenetre;
import lecteur_pdf.menuBar.menuItems.*;

import javax.swing.*;

/**
 * Element de la barre des menus contenant l'intégralités des actions lié à l'affichage de l'application
 *
 * @author Léo Franch
 * @author Lucas Vabre
 * @author Noé Villeneuve
 * @author Tristan Nogaret
 */
public class MenuAffichage extends JMenu {

    /**
     * Crée une nouvelle instance du menu d'affichage
     *
     * @param parent Référence de la fenêtre qui possède l'instance de ce menu
     */
    public MenuAffichage(Fenetre parent) {
        super("Affichage");

        /* Mode plein écran */
        add(new PleinEcran(parent));
        addSeparator();

        /* Navigation dans les différentes pages */
        add(new PagePrecedente(parent));
        add(new PageSuivante(parent));
        addSeparator();

        /* Section des Zoom */
        add(new ZoomMoins(parent));
        add(new ZoomDefaut(parent));
        add(new ZoomPlus(parent));
        addSeparator();

        /* Mode d'affichage */
        add(new PageEntiere(parent));
        add(new PleineLargeur(parent));
    }

}
