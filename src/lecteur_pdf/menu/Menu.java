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
//        createMenuOptions();
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

        // Ajoute des actionListener aux JMenuItem
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

        // Ajout des éléments au menu "Fichier"
        Fichier.add(Ouvrir);
        Fichier.add(Fermer);
        Fichier.add(Quitter);

        // Ajoute le menu "Fichier" dans la liste des menus
        MENU_LIST.add(Fichier);

        // Ajoute Ouvrir, Fermer et Quitter dans la liste des items
        ITEM_LIST.add(Ouvrir);
        ITEM_LIST.add(Fermer);
        ITEM_LIST.add(Quitter);

        // Ajoute le menu à la barre de menu
        this.add(Fichier);
    }

/**
 * Menu Options, pas fini, à faire dans les prochains sprints
  */
//    /**
//     * Créé le menu Options et ses sous-menus
//     */
//    private void createMenuOptions() {
//
//        // Créer le Menu Options
//        JMenu Options = new JMenu("Options");
//
//        // Créer l'item Préférences
//        JMenuItem Preferences = new JMenuItem("Préférences");
//
//        // Ajout du Listener au JMenuItem
//        Preferences.addActionListener(this::actionPerformed);
//
//        // Définis les raccourcis
//        KeyStroke raccourciPreferences = KeyStroke.getKeyStroke(KeyEvent.VK_P,
//                                                                KeyEvent.CTRL_DOWN_MASK);
//        Preferences.setAccelerator(raccourciPreferences);
//
//        // Ajouter les éléments au menu "Options"
//        Options.add(Preferences);
//
//        // Ajoute le menu "Affichage" dans la liste des menus
//        MENU_LIST.add(Options);
//
//        // Ajoute Preferences dans la liste des items
//        ITEM_LIST.add(Preferences);
//
//        // Ajoute le menu à la barre de menu
//        this.add(Options);
//    }

    /**
     * Créé le menu Affichage et ses sous-menus
     */
    private void createMenuAffichage() {

        // Créer le Menu Affichage
        JMenu Affichage = new JMenu("Affichage");

        // Créer les items de zoom, plein écran et affichage horizontal ou vertical
        JMenuItem PleinEcran = new JMenuItem("Mode plein écran");
        JMenuItem ZoomPlus = new JMenuItem("Zoom 150%");
        JMenuItem ZoomNeutre = new JMenuItem("Zoom 100%");
        JMenuItem ZoomMinus = new JMenuItem("Zoom 50%");
        JMenuItem affichageVertical = new JMenuItem("Disposition Verticale");
        JMenuItem affichageHorizontal = new JMenuItem("Disposition Horizontale");

        // Ajoute des actionListener aux JMenuItem
        PleinEcran.addActionListener(this::actionPerformed);
        ZoomPlus.addActionListener(this::actionPerformed);
        ZoomNeutre.addActionListener(this::actionPerformed);
        ZoomMinus.addActionListener(this::actionPerformed);
        affichageVertical.addActionListener(this::actionPerformed);
        affichageHorizontal.addActionListener(this::actionPerformed);

        // Définis les raccourcis des différents JMenuItems
        KeyStroke raccourciPleinEcran = KeyStroke.getKeyStroke(KeyEvent.VK_F11,
                                                              0);
        PleinEcran.setAccelerator(raccourciPleinEcran);
        KeyStroke raccourciZoomPlus = KeyStroke.getKeyStroke(KeyEvent.VK_PLUS,
                                                             KeyEvent.CTRL_DOWN_MASK);
        ZoomPlus.setAccelerator(raccourciZoomPlus);
        KeyStroke raccourciZoomNeutre = KeyStroke.getKeyStroke(KeyEvent.VK_0,
                                                               KeyEvent.CTRL_DOWN_MASK);
        ZoomNeutre.setAccelerator(raccourciZoomNeutre);
        KeyStroke raccourciZoomMinus = KeyStroke.getKeyStroke(KeyEvent.VK_MINUS,
                                                              KeyEvent.CTRL_DOWN_MASK);
        ZoomMinus.setAccelerator(raccourciZoomMinus);
        KeyStroke raccourciAffVert = KeyStroke.getKeyStroke(KeyEvent.VK_V,
                                                              KeyEvent.CTRL_DOWN_MASK);
        affichageVertical.setAccelerator(raccourciAffVert);
        KeyStroke raccourciAffHor = KeyStroke.getKeyStroke(KeyEvent.VK_H,
                                                            KeyEvent.CTRL_DOWN_MASK);
        affichageHorizontal.setAccelerator(raccourciAffHor);

        // Ajout des éléments au menu "Affichage"
        Affichage.add(PleinEcran);
        Affichage.addSeparator();
        Affichage.add(ZoomPlus);
        Affichage.add(ZoomNeutre);
        Affichage.add(ZoomMinus);
        Affichage.addSeparator();
        Affichage.add(affichageVertical);
        Affichage.add(affichageHorizontal);

        // Ajoute le menu "Affichage" dans la liste des menus
        MENU_LIST.add(Affichage);

        // Ajoute les JMenuItem dans la liste des items
        ITEM_LIST.add(PleinEcran);
        ITEM_LIST.add(ZoomPlus);
        ITEM_LIST.add(ZoomNeutre);
        ITEM_LIST.add(ZoomMinus);
        ITEM_LIST.add(affichageVertical);
        ITEM_LIST.add(affichageHorizontal);


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
                                    + " chargement de votre document,"
                                    + " il a peut-être été corrompu. ";


        final int FERMER = 0;
        final int QUITTER = 1;

        /* Message sur les popups d'erreurs */
        final String[][] POPUPS_MSG = {
            {"Fermer le PDF actuel", "Êtes-vous sûr de vouloir fermer le PDF "
                                     + "courant ?"},
            {"Quitter l'application", "Êtes-vous sûr de vouloir quitter ?"}
        };

        switch (choice) {
            // Cas où l'utilisateur clique sur ouvrir
            case "Ouvrir" -> {
                if (FENETRE.isFullscreen()) {
                    FENETRE.setFullscreen();
                }

                if (FENETRE.haveDocument()
                    && popupConfirmation(POPUPS_MSG[FERMER])
                       != JOptionPane.OK_OPTION) {
                    break;
                }
                File fichier = SelectionnerFichier.ouvrirFichier();

                if (fichier != null) {
                    try {
                        FENETRE.chargerPDF(fichier);
                    } catch (IOException e) {
                        JOptionPane.showMessageDialog(FENETRE,
                                                      messageErrCorrompu);
                    }
                }
            }

            // Cas où l'utilisateur clique sur fermer
            case "Fermer" -> {
                if (FENETRE.isFullscreen()) {
                    FENETRE.setFullscreen();
                }
                if (FENETRE.haveDocument()
                    && popupConfirmation(POPUPS_MSG[FERMER])
                       == JOptionPane.OK_OPTION) {
                    FENETRE.setup();
                }
            }

            // Cas où l'utilisateur clique sur quitter
            case "Quitter" -> {
                if (FENETRE.isFullscreen()) {
                    FENETRE.setFullscreen();
                }
                int option = popupConfirmation(POPUPS_MSG[QUITTER]);

                if (option == JOptionPane.OK_OPTION) {
                    System.exit(0);
                }
            }

            // Cas où l'utilisateur clique sur mode plein écran
            case "Mode plein écran" -> FENETRE.setFullscreen();

            // Cas où l'utilisateur clique sur zoom 150%
            case "Zoom 150%" -> {
                try {
                    FENETRE.chargerPDF(2.0f);
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(FENETRE, messageErrCorrompu);
                }
            }

            // Cas où l'utilisateur clique sur zoom 100%
            case "Zoom 100%" -> {
                try {
                    FENETRE.chargerPDF(1.0f);
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(FENETRE, messageErrCorrompu);
                }
            }

            // Cas où l'utilisateur clique sur zoom 50%
            case "Zoom 50%" -> {
                try {
                    FENETRE.chargerPDF(0.5f);
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(FENETRE, messageErrCorrompu);
                }
            }

            // Cas où l'utilisateur clique sur dispotion verticale
            case "Disposition Verticale" -> {
                if (FENETRE.haveDocument()) {
                    FENETRE.setAffichageVertical(true);
                    try {
                        FENETRE.chargerPDF();
                    } catch (IOException e) {
                        JOptionPane.showMessageDialog(FENETRE, messageErrCorrompu);
                    }
                }
            }

            // Cas où l'utilisateur clique sur dispotion horizontale
            case "Disposition Horizontale" -> {
                if (FENETRE.haveDocument()) {
                    FENETRE.setAffichageVertical(false);
                    try {
                        FENETRE.chargerPDF();
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
     * Methode qui renvoie le sous menu demandé avec l'index adéquat
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