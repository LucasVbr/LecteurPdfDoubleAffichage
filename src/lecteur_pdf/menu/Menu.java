/*
 * MenuOptions.java, 20/11/2021
 * IUT Rodez 2021-2021, INFO2
 * pas de copyright, aucun droits
 */

package lecteur_pdf.menu;

import javax.swing.*;
import java.util.ArrayList;

/**
 * TODO class comment
 *
 * @author Léo FRANCH
 * @author Tristan NOGARET
 * @author Lucàs VABRE
 * @author Noé VILLENEUVE
 * @version  1.0
 */
public class Menu {

    /** Array list contenant les JMenu */
    private ArrayList<JMenu> menuList = new ArrayList<JMenu>();

    /** Array list contenant les JMenuItem */
    private ArrayList<JMenuItem> itemList = new ArrayList<JMenuItem>();

    /** Création de la barre de menu */
    JMenuBar menubar = new JMenuBar();

    /**
     * Appelle la fonction createMenuFichier
     */
    public Menu() {
        createMenuFichier();
    }

    /**
     * Fonction pour créer le Menu fichier et ses items
     */
    private void createMenuFichier() {

        // Créer le Menu Fichier
        JMenu Fichier = new JMenu("Fichier");

        // Créer les items Ouvrir et Fermer
        JMenuItem Ouvrir = new JMenuItem("Ouvrir");
        JMenuItem Fermer = new JMenuItem("Fermer");

        // Ajouter les éléments au menu "Fichier"
        Fichier.add(Ouvrir);
        Fichier.add(Fermer);

        // Ajouter le menu au barre de menu
        menubar.add(Fichier);

        // Création du menu "Fichier"
        menuList.add(Fichier);

        // Créer les éléments du menu et sous menu
        itemList.add(Ouvrir);
        itemList.add(Fermer);
    }

    /**
     * @return le menubar
     */
    public JMenuBar getMenuBar() {
        return menubar;
    }

    /**
     * @return l'ArrayList des JMenuItem
     */
    public ArrayList<JMenuItem> getMenuItems() {
        return itemList;
    }

    /**
     * @return l'item de l'ArrayList des JMenuBar à l'index indiqué
     */
    public JMenuItem getMenuItem(int index) {
        return itemList.get(index);
    }
}