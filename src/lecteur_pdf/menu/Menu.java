/*
 * MenuOptions.java, 20/11/2021
 * IUT Rodez 2021-2021, INFO2
 * pas de copyright, aucun droits
 */

package lecteur_pdf.menu;

import lecteur_pdf.affichage.Fenetre;
import lecteur_pdf.document.PDF;

import javax.swing.*;
import java.awt.event.ActionEvent;
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

    JFrame frame;

    /**
     * Appelle la fonction createMenuFichier
     */
    public Menu(JFrame frame) {
        this.frame = frame;
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
            try {
                PDF doc;
                doc = new PDF(SelectionnerFichier.ouvrirFichier());
                /* Creation du JScrollPane contenant notre PDF pour pouvoir scroller */
                JScrollPane scrollPane = new JScrollPane(doc);
                scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

                /* Ajout du ScrollPane dans la frame et mise à jour de la frame */
                frame.add(scrollPane);
                frame.validate();
            } catch (IOException e) {
                e.printStackTrace();
            }


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