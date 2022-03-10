/*
 * MenuOptions.java, 26/02/2022
 * IUT Rodez 2021-2022, INFO2
 * Pas de copyright, aucun droits
 */

package lecteur_pdf.menuBar.menu;

import lecteur_pdf.Fenetre;
import lecteur_pdf.menuBar.menuItems.*;

import javax.swing.*;

/**
 * Élément de la barre des menus contenant l'intégralité des options de
 * l'application
 *
 * @author Léo Franch
 * @author Tristan Nogaret
 * @author Lucàs Vabre
 * @author Noé Villeneuve
 * @see JMenu
 */
public class MenuOptions extends JMenu {

    /**
     * Créé une nouvelle instance du menu Options
     *
     * @param parent Référence de la {@link Fenetre fenêtre}
     *               qui possède l'instance de ce menu
     */
    public MenuOptions(Fenetre parent) {
        super("Options");
        add(new ModifierTouches(parent));
    }
}
