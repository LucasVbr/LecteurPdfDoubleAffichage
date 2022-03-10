/*
 * MenuBar.java, 26/02/2022
 * IUT Rodez 2021-2022, INFO 2
 * pas de copyright, aucun droits
 */

package lecteur_pdf.menuBar;

import lecteur_pdf.Fenetre;
import lecteur_pdf.menuBar.menu.MenuAffichage;
import lecteur_pdf.menuBar.menu.MenuFichier;
import lecteur_pdf.menuBar.menu.MenuMode;
import lecteur_pdf.menuBar.menu.MenuOptions;

import javax.swing.*;

/**
 * Barre de menu contenant l'ensemble des menus de l'application
 *
 * @author Léo Franch
 * @author Lucas Vabre
 * @author Noé Villeneuve
 * @author Tristan Nogaret
 */
public class MenuBar extends JMenuBar {

    /**
     * Créé une nouvelle barre de menu avec l'ensemble des menus de
     * l'application
     *
     * @param parent Référence de la fenêtre qui possède l'instance de ce MenuItem
     */
    public MenuBar(Fenetre parent) {
        add(new MenuFichier(parent));
        add(new MenuAffichage(parent));
        add(new MenuMode(parent));
        add(new MenuOptions(parent));
    }
}
