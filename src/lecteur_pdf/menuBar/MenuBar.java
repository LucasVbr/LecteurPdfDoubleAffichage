/*
 * MenuBar.java, 26/02/2022
 * IUT Rodez 2021-2022, INFO2
 * Pas de copyright, aucun droits
 */

package lecteur_pdf.menuBar;

import lecteur_pdf.Fenetre;
import lecteur_pdf.menuBar.menu.MenuAffichage;
import lecteur_pdf.menuBar.menu.MenuFichier;
import lecteur_pdf.menuBar.menu.MenuMode;
import lecteur_pdf.menuBar.menu.MenuOptions;

import javax.swing.*;

/**
 * Barre de menu contenant l'ensemble des {@link lecteur_pdf.menuBar.menu
 * menu} de l'application
 *
 * @author Léo Franch
 * @author Tristan Nogaret
 * @author Lucàs Vabre
 * @author Noé Villeneuve
 * @see JMenuBar
 */
public class MenuBar extends JMenuBar {

    /**
     * Créé une nouvelle barre de menu avec l'ensemble des
     * {@link lecteur_pdf.menuBar.menu menu} de
     * l'application
     *
     * @param parent Référence de la {@link Fenetre fenêtre} qui possède
     *               l'instance de ce
     *               {@link lecteur_pdf.menuBar.menuItems.MenuItem MenuItem}
     */
    public MenuBar(Fenetre parent) {
        add(new MenuFichier(parent));
        add(new MenuAffichage(parent));
        add(new MenuMode(parent));
        add(new MenuOptions(parent));
    }
}
