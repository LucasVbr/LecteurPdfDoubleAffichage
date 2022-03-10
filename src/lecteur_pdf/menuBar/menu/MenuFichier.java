/*
 * MenuFichier.java, 26/02/2022
 * IUT Rodez 2021-2022, INFO2
 * Pas de copyright, aucun droits
 */

package lecteur_pdf.menuBar.menu;

import lecteur_pdf.Fenetre;
import lecteur_pdf.menuBar.menuItems.*;

import javax.swing.*;

/**
 * Élément de la barre des menus contenant l'intégralité des actions liés à
 * la gestion des fichiers de l'application
 *
 * @author Léo Franch
 * @author Tristan Nogaret
 * @author Lucàs Vabre
 * @author Noé Villeneuve
 * @see JMenu
 */
public class MenuFichier extends JMenu {

    /**
     * Créé une nouvelle instance du menu fichier
     *
     * @param parent Référence de la {@link Fenetre fenêtre}
     *               qui possède l'instance de ce menu
     */
    public MenuFichier(Fenetre parent) {
        super("Fichier");

        add(new OuvrirFichier(parent));
        add(new FermerFichier(parent));
        add(new Quitter(parent));
    }
}
