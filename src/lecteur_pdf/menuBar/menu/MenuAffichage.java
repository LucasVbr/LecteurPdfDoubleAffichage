/*
 * MenuAffichage.java, 26/02/2022
 * IUT Rodez 2021-2022, INFO2
 * Pas de copyright, aucun droits
 */

package lecteur_pdf.menuBar.menu;

import lecteur_pdf.Fenetre;
import lecteur_pdf.menuBar.menuItems.*;

import javax.swing.*;

/**
 * Élément de la barre des menus contenant l'intégralité des actions liés à
 * l'affichage de l'application
 *
 * @author Léo Franch
 * @author Tristan Nogaret
 * @author Lucàs Vabre
 * @author Noé Villeneuve
 * @see JMenu
 */
public class MenuAffichage extends JMenu {

    /**
     * Créé une nouvelle instance du menu d'affichage
     *
     * @param parent Référence de la {@link Fenetre fenêtre}
     *               qui possède l'instance de ce menu
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

        /* Section des Zooms */
        add(new ZoomMoins(parent));
        add(new ZoomDefaut(parent));
        add(new ZoomPlus(parent));
        addSeparator();

        /* Mode d'affichage */
        add(new PageEntiere(parent));
        add(new PleineLargeur(parent));
    }
}
