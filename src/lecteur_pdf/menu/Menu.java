/*
 * MenuOptions.java, 20/11/2021
 * IUT Rodez 2021-2021, INFO2
 * pas de copyright, aucun droits
 */

package lecteur_pdf.menu;

import lecteur_pdf.affichage.Fenetre;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;

/**
 * Classe pour afficher le Menu "Fichier" avec ses options
 *
 * @author Léo FRANCH
 * @author Tristan NOGARET
 * @author Lucàs VABRE
 * @author Noé VILLENEUVE
 * @version 1.0
 */
public class Menu extends JMenuBar {

    /**
     * La Fenêtre mère de la barre des menus
     */
    private final Fenetre fenetre;

    /**
     * Liste contenant les différents menus
     */
    private final ArrayList<JMenu> menuList = new ArrayList<>();

    /**
     * Liste contenant les différents sous menus
     */
    private final ArrayList<JMenuItem> itemList = new ArrayList<>();

    /**
     * Constructeur du menu
     *
     * @param fenetre La Fenêtre mère de la barre des menus
     */
    public Menu(Fenetre fenetre) {
        this.fenetre = fenetre;

        createMenuFichier();
        // createMenuAfficher();
    }

    /**
     * Créé le menu Fichier et ses sous-menus
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

        // Définis les raccourcis
        KeyStroke raccourciOuvrir
            = KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK);
        Ouvrir.setAccelerator(raccourciOuvrir);
        KeyStroke raccourciFermer
            = KeyStroke.getKeyStroke(KeyEvent.VK_Q, KeyEvent.CTRL_DOWN_MASK);
        Fermer.setAccelerator(raccourciFermer);

        // Ajouter les éléments au menu "Fichier"
        Fichier.add(Ouvrir);
        Fichier.add(Fermer);

        // Ajoute le menu "Fichier" dans la liste des menus
        menuList.add(Fichier);

        // Ajoute Ouvrir et Fermer dans la liste des sous menu
        itemList.add(Ouvrir);
        itemList.add(Fermer);

        // Ajoute le menu à la barre de menu
        this.add(Fichier);
    }

    /**
     * Méthode qui gère les actions des sous-menus
     *
     * @param ae un action event
     */
    public void actionPerformed(ActionEvent ae) {
        String choice = ae.getActionCommand();

        switch (choice) {
            case "Ouvrir" -> {
                File fichier = SelectionnerFichier.ouvrirFichier();
                fenetre.chargerPDF(fichier);
            }
            case "Fermer" -> System.exit(
                0); // TODO à changer pour que ça quitte vraiment
        }
    }

    /**
     * @return la liste des JMenuItem
     */
    public ArrayList<JMenuItem> getMenuItems() {
        return itemList;
    }

    /**
     * Methode qui renvoie le sous menu demandé
     *
     * @param index Indice du sous menu
     * @return Le sous menu demandé
     */
    public JMenuItem getMenuItem(int index) {
        return itemList.get(index);
    }
}