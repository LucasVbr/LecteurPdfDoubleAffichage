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
 * TODO commentaires
 *
 * @author Léo Franch
 * @author Lucas Vabre
 * @author Noé Villeneuve
 * @author Tristan Nogaret
 */
public class MenuBar extends JMenuBar {
    
    public MenuBar(Fenetre parent) {
        add(new MenuFichier(parent));
        add(new MenuAffichage(parent));
        add(new MenuMode(parent));
        add(new MenuOptions(parent));
    }
}
