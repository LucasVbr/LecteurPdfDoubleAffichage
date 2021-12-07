/*
 * Menu.java, 20/11/2021
 * IUT Rodez 2021-2021, INFO2
 * pas de copyright, aucun droits
 */

package lecteur_pdf.menu;

import lecteur_pdf.affichage.Fenetre;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
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
    private final Fenetre FENETRE;

    /**
     * Liste contenant les différents menus
     */
    private final ArrayList<JMenu> MENU_LIST = new ArrayList<>();

    /**
     * Liste contenant les différents sous menus
     */
    private final ArrayList<JMenuItem> ITEM_LIST = new ArrayList<>();

    /**
     * Constructeur du menu
     *
     * @param fenetre La Fenêtre mère de la barre des menus
     */
    public Menu(Fenetre fenetre) {
        this.FENETRE = fenetre;

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
        KeyStroke raccourciOuvrir = KeyStroke.getKeyStroke(KeyEvent.VK_O,
                                                           KeyEvent.CTRL_DOWN_MASK);
        Ouvrir.setAccelerator(raccourciOuvrir);
        KeyStroke raccourciFermer = KeyStroke.getKeyStroke(KeyEvent.VK_Q,
                                                           KeyEvent.CTRL_DOWN_MASK);
        Fermer.setAccelerator(raccourciFermer);
        KeyStroke raccourciQuitter = KeyStroke.getKeyStroke(KeyEvent.VK_X,
                                                            KeyEvent.CTRL_DOWN_MASK);
        Quitter.setAccelerator(raccourciQuitter);

        // Ajouter les éléments au menu "Fichier"
        Fichier.add(Ouvrir);
        Fichier.add(Fermer);
        Fichier.add(Quitter);

        // Ajoute le menu "Fichier" dans la liste des menus
        MENU_LIST.add(Fichier);

        // Ajoute Ouvrir, Fermer et Quitter dans la liste des sous menu
        ITEM_LIST.add(Ouvrir);
        ITEM_LIST.add(Fermer);
        ITEM_LIST.add(Quitter);

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
        KeyStroke raccourciPreferences = KeyStroke.getKeyStroke(KeyEvent.VK_P,
                                                                KeyEvent.CTRL_DOWN_MASK);
        Preferences.setAccelerator(raccourciPreferences);

        // Ajouter les éléments au menu "Options"
        Options.add(Preferences);

        // Ajoute le menu "Affichage" dans la liste des menus
        MENU_LIST.add(Options);

        // Ajoute Preferences dans la liste des sous menu
        ITEM_LIST.add(Preferences);

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
        JMenuItem ZoomPlus = new JMenuItem("Zoom 150%");
        JMenuItem ZoomNeutre = new JMenuItem("Zoom 100%");
        JMenuItem ZoomMinus = new JMenuItem("Zoom 50%");
        JMenuItem affichageVertical = new JMenuItem("Disposition Verticale");
        JMenuItem affichageHorizontal = new JMenuItem("Disposition Horizontale");

        // Ajoute des Listener aux JMenuItem
        ZoomPlus.addActionListener(this::actionPerformed);
        ZoomNeutre.addActionListener(this::actionPerformed);
        ZoomMinus.addActionListener(this::actionPerformed);
        affichageVertical.addActionListener(this::actionPerformed);
        affichageHorizontal.addActionListener(this::actionPerformed);

        // Définis les raccourcis
        KeyStroke raccourciZoomPlus = KeyStroke.getKeyStroke(KeyEvent.VK_PLUS,
                                                             KeyEvent.CTRL_DOWN_MASK);
        ZoomPlus.setAccelerator(raccourciZoomPlus);
        KeyStroke raccourciZoomNeutre = KeyStroke.getKeyStroke(KeyEvent.VK_0,
                                                               KeyEvent.CTRL_DOWN_MASK);
        ZoomNeutre.setAccelerator(raccourciZoomNeutre);
        KeyStroke raccourciZoomMinus = KeyStroke.getKeyStroke(KeyEvent.VK_MINUS,
                                                              KeyEvent.CTRL_DOWN_MASK);
        ZoomMinus.setAccelerator(raccourciZoomMinus);

        // Ajouter les éléments au menu "Affichage"
        Affichage.add(ZoomPlus);
        Affichage.add(ZoomNeutre);
        Affichage.add(ZoomMinus);
        Affichage.addSeparator();
        Affichage.add(affichageVertical);
        Affichage.add(affichageHorizontal);

        // Ajoute le menu "Affichage" dans la liste des menus
        MENU_LIST.add(Affichage);

        // Ajoute des zoom dans la liste des sous menu
        ITEM_LIST.add(ZoomPlus);
        ITEM_LIST.add(ZoomNeutre);
        ITEM_LIST.add(ZoomMinus);
        ITEM_LIST.add(affichageHorizontal);
        ITEM_LIST.add(affichageVertical);

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
        String messageErrCorrompu = "Une erreur s'est produite dans le"
                                    + "chargement de votre document,"
                                    + "il a peut-être été corrompu. ";


        final int FERMER = 0;
        final int QUITTER = 1;

        final String[][] POPUPS_MSG = {
            {"Fermer le PDF actuel", "Êtes-vous sûr de vouloir fermer ?"},
            {"Quitter l'application", "Êtes-vous sûr de vouloir quitter ?"}
        };

        switch (choice) {
            case "Ouvrir" -> {
                File fichier = SelectionnerFichier.ouvrirFichier();

                if (FENETRE.haveDocument()
                    && popupConfirmation(POPUPS_MSG[FERMER])
                       != JOptionPane.OK_OPTION) {
                    break;
                }

                if (fichier != null) {
                    try {
                        FENETRE.chargerPDF(fichier);
                    } catch (IOException e) {
                        JOptionPane.showMessageDialog(FENETRE,
                                                      messageErrCorrompu);
                    }
                }
            }
            case "Fermer" -> {
                if (FENETRE.haveDocument()
                    && popupConfirmation(POPUPS_MSG[FERMER])
                       == JOptionPane.OK_OPTION) {
                    FENETRE.setup();
                }
            }
            case "Quitter" -> {
                int option = popupConfirmation(POPUPS_MSG[QUITTER]);

                if (option == JOptionPane.OK_OPTION) {
                    System.exit(0);
                }
            }
            case "Zoom 150%" -> {
                try {
                    FENETRE.rechargerPDF(2.0f);
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(FENETRE, messageErrCorrompu);
                }
            }
            case "Zoom 100%" -> {
                try {
                    FENETRE.rechargerPDF(1.0f);
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(FENETRE, messageErrCorrompu);
                }
            }
            case "Zoom 50%" -> {
                try {
                    FENETRE.rechargerPDF(0.5f);
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(FENETRE, messageErrCorrompu);
                }
            }
            case "Disposition Verticale" -> {
                if (FENETRE.haveDocument()) {
                    FENETRE.setAffichageVertical(true);
                    try {
                        FENETRE.rechargerPDF();
                    } catch (IOException e) {
                        JOptionPane.showMessageDialog(FENETRE, messageErrCorrompu);
                    }
                }
            }
            case "Disposition Horizontale" -> {
                if (FENETRE.haveDocument()) {
                    FENETRE.setAffichageVertical(false);
                    try {
                        FENETRE.rechargerPDF();
                    } catch (IOException e) {
                        JOptionPane.showMessageDialog(FENETRE, messageErrCorrompu);
                    }
                }
            }
        }
    }

    /**
     * @return la liste des JMenuItem
     */
    public ArrayList<JMenuItem> getMenuItems() {
        return ITEM_LIST;
    }

    /**
     * Methode qui renvoie le sous menu demandé
     *
     * @param index Indice du sous menu
     * @return Le sous menu demandé
     */
    public JMenuItem getMenuItem(int index) {
        return ITEM_LIST.get(index);
    }

    /**
     * Affiche une popup avec un message ou l'on peut repondre par oui ou par
     * non
     *
     * @param strings Le tableau de chaine de caractère contenant le titre de
     *                la fenêtre et son message
     * @return 0 Si la valeur est Oui
     * 1 Si la valeur est Non
     * -1 en cas d'erreur
     */
    public int popupConfirmation(String[] strings) {
        if (strings.length != 2) {
            return -1;
        }

        final int TITRE = 0;
        final int MESSAGE = 1;

        final Object[] CHOIX = {"Oui", "Non"};

        return JOptionPane.showOptionDialog(null, strings[MESSAGE],
                                            strings[TITRE],
                                            JOptionPane.YES_NO_OPTION,
                                            JOptionPane.QUESTION_MESSAGE, null,
                                            CHOIX, CHOIX[0]);
    }
}