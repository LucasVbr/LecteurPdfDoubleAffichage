/*
 * MenuOptions.java, 20/11/2021
 * IUT Rodez 2021-2021, INFO2
 * pas de copyright, aucun droits
 */

package lecteur_pdf.menu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.ArrayList;

/**
 * Classe pour afficher le Menu "Fichier" avec ses options
 *
 * @author Léo FRANCH
 * @author Tristan NOGARET
 * @author Lucàs VABRE
 * @author Noé VILLENEUVE
 * @version  1.0
 */
public class Menu {
    public static File fichier ;
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

        // Ajoute des Listener aux JMenuItem
        Ouvrir.addActionListener(this::actionPerformed);
        Fermer.addActionListener(this::actionPerformed);

        // Ajouter les éléments au menu "Fichier"
        Fichier.add(Ouvrir);
        Fichier.add(Fermer);

        // Ajouter le menu à la barre de menu
        menubar.add(Fichier);

        // Création du menu "Fichier"
        menuList.add(Fichier);

        // Créer les éléments du menu et sous menu
        itemList.add(Ouvrir);
        itemList.add(Fermer);
    }

    /**
     * Méthode qui gère les actions des JMenuItem
     * @param ae un action event
     */
    public void actionPerformed(ActionEvent ae) {
        String choice = ae.getActionCommand();
        if (choice.equals("Ouvrir")) {
           fichier = SelectionnerFichier.ouvrirFichier();
        }else if (choice.equals("Fermer")) {
            System.exit(0); // TODO à changer pour que ça quitte vraiment
        }

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