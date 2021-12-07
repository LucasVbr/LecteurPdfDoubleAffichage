/*
 * MenuOptions.java, 20/11/2021
 * IUT Rodez 2021-2021, INFO2
 * pas de copyright, aucun droits
 */

package lecteur_pdf.menu;

import lecteur_pdf.affichage.Fenetre;
import org.apache.pdfbox.pdmodel.PDDocument;

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
        createMenuOptions();
        createMenuAffichage();
    }

    /**
     * Créé le menu Fichier et ses sous-menus
     */
    private void createMenuFichier() {

        // Créer le Menu Fichier
        JMenu Fichier = new JMenu("Fichier");

        // Créer les items Ouvrir, Fermer et Quitter
        JMenuItem Ouvrir = new JMenuItem("Ouvrir");
        JMenuItem Fermer = new JMenuItem("Fermer");
        JMenuItem Quitter = new JMenuItem("Quitter");

        // Ajoute des Listener aux JMenuItem
        Ouvrir.addActionListener(this::actionPerformed);
        Fermer.addActionListener(this::actionPerformed);
        Quitter.addActionListener(this::actionPerformed);

        // Définis les raccourcis
        KeyStroke raccourciOuvrir
            = KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK);
        Ouvrir.setAccelerator(raccourciOuvrir);
        KeyStroke raccourciFermer
            = KeyStroke.getKeyStroke(KeyEvent.VK_Q, KeyEvent.CTRL_DOWN_MASK);
        Fermer.setAccelerator(raccourciFermer);
        KeyStroke raccourciQuitter
                = KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.CTRL_DOWN_MASK);
        Quitter.setAccelerator(raccourciQuitter);

        // Ajouter les éléments au menu "Fichier"
        Fichier.add(Ouvrir);
        Fichier.add(Fermer);
        Fichier.add(Quitter);

        // Ajoute le menu "Fichier" dans la liste des menus
        menuList.add(Fichier);

        // Ajoute Ouvrir, Fermer et Quitter dans la liste des sous menu
        itemList.add(Ouvrir);
        itemList.add(Fermer);
        itemList.add(Quitter);

        // Ajoute le menu à la barre de menu
        this.add(Fichier);
    }

    /**
     * Créé le menu Options et ses sous-menus
     */
    private void createMenuOptions() {

        // Créer le Menu
        JMenu Options = new JMenu("Options");

        // Créer l'item Préférences
        JMenuItem Preferences = new JMenuItem("Préférences");

        // Ajoute des Listener aux JMenuItem
        Preferences.addActionListener(this::actionPerformed);

        // Définis les raccourcis
        KeyStroke raccourciPreferences
                = KeyStroke.getKeyStroke(KeyEvent.VK_P, KeyEvent.CTRL_DOWN_MASK);
        Preferences.setAccelerator(raccourciPreferences);

        // Ajouter les éléments au menu "Options"
        Options.add(Preferences);

        // Ajoute le menu "Affichage" dans la liste des menus
        menuList.add(Options);

        // Ajoute Preferences dans la liste des sous menu
        itemList.add(Preferences);

        // Ajoute le menu à la barre de menu
        this.add(Options);
    }

    /**
     * Créé le menu Affichage et ses sous-menus
     */
    private void createMenuAffichage() {

        // Créer le Menu Affichage
        JMenu Affichage = new JMenu("Affichage");

        // Créer les items de zoom
        JMenuItem ZoomPlus = new JMenuItem("Zoom +");
        JMenuItem ZoomNeutre = new JMenuItem("Zoom 0");
        JMenuItem ZoomMinus = new JMenuItem("Zoom -");

        // Ajoute des Listener aux JMenuItem
        ZoomPlus.addActionListener(this::actionPerformed);
        ZoomNeutre.addActionListener(this::actionPerformed);
        ZoomMinus.addActionListener(this::actionPerformed);

        // Définis les raccourcis
        KeyStroke raccourciZoomPlus
                = KeyStroke.getKeyStroke(KeyEvent. VK_PLUS, KeyEvent.CTRL_DOWN_MASK);
        ZoomPlus.setAccelerator(raccourciZoomPlus);
        KeyStroke raccourciZoomNeutre
                = KeyStroke.getKeyStroke(KeyEvent. VK_0, KeyEvent.CTRL_DOWN_MASK);
        ZoomNeutre.setAccelerator(raccourciZoomNeutre);
        KeyStroke raccourciZoomMinus
                = KeyStroke.getKeyStroke(KeyEvent. VK_MINUS, KeyEvent.CTRL_DOWN_MASK);
        ZoomMinus.setAccelerator(raccourciZoomMinus);

        // Ajouter les éléments au menu "Affichage"
        Affichage.add(ZoomPlus);
        Affichage.add(ZoomNeutre);
        Affichage.add(ZoomMinus);

        // Ajoute le menu "Affichage" dans la liste des menus
        menuList.add(Affichage);

        // Ajoute des zoom dans la liste des sous menu
        itemList.add(ZoomPlus);
        itemList.add(ZoomNeutre);
        itemList.add(ZoomMinus);

        // Ajoute le menu à la barre de menu
        this.add(Affichage);
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
                if (fichier != null) {
                    fenetre.chargerPDF(fichier);
                }
            }
            case "Fermer" -> {
                fenetre.dechargerPDF();
                fenetre.validate();
                fenetre.setSize(300, 300);
            }
            case "Quitter" ->  System.exit(
                    0);
            case "Zoom +" -> fenetre.rechargerPDF(2.0f);
            case "Zoom 0" -> fenetre.rechargerPDF(1.0f);
            case "Zoom -" -> fenetre.rechargerPDF(0.5f);
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