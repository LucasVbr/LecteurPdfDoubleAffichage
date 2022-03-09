/*
 * MenuFichier.java, 26/02/2022
 * IUT Rodez 2021-2022, INFO 2
 * pas de copyright, aucun droits
 */

package lecteur_pdf.menuBar.menu;

import lecteur_pdf.Fenetre;
import lecteur_pdf.menuBar.menuItems.*;

import javax.swing.*;

/**
 * Element de la barre des menus contenant l'intégralités des actions lié à la gestion des fichers de l'application
 *
 * @author Léo Franch
 * @author Lucas Vabre
 * @author Noé Villeneuve
 * @author Tristan Nogaret
 */
public class MenuFichier extends JMenu {

    /**
     * Crée une nouvelle instance du menu fichier
     *
     * @param parent Référence de la fenêtre qui possède l'instance de ce menu
     */
    public MenuFichier(Fenetre parent) {
        super("Fichier");

        add(new OuvrirFichier(parent));
        add(new FermerFichier(parent));
        add(new Quitter(parent));
    }
}
