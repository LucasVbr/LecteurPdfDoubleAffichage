/*
 * MenuOption.java, 20/11/2021
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

    /** Menu "Fichier" */
    private JMenu Fichier;

    /** Element "Ouvrir" */
    private JMenuItem Ouvrir;

    /** Element "Fermer" */
    private JMenuItem Fermer;

    ArrayList<JMenu> menu = new ArrayList<JMenu>();
    ArrayList<JMenuItem> item = new ArrayList<JMenuItem>();

    public Menu() {
        // Frame de test
        JFrame frame = new JFrame("Menu ouverture");
        // Création de la barre de menu
        JMenuBar menubar = new JMenuBar();
        // Création du menu "Fichier"
        Fichier = new JMenu("Fichier");
        // Créer les éléments du menu et sous menu
        Ouvrir = new JMenuItem("Ouvrir");
        Fermer = new JMenuItem("Fermer");
        // Ajouter les éléments au menu "Fichier"
        Fichier.add(Ouvrir);
        Fichier.add(Fermer);
        // Ajouter le menu au barre de menu
        menubar.add(Fichier);
        // Ajouter la barre de menu au frame
        frame.setJMenuBar(menubar);
        frame.setSize(300,300);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void getMenuBar () {
        // TODO Compléter la class
    }

    public void getMenuItems () {
        // TODO Compléter la class
    }

    public void getMenuItem (int index) {
        // TODO Compléter la class
    }

    public static void main(String args[])
    {
        new Menu();
    }
}