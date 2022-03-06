/*
 * RaccourcisClavier.java, 26/02/2022
 * IUT Rodez 2021-2022, INFO 2
 * pas de copyright, aucun droits
 */

package lecteur_pdf.raccourcisClavier;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Gestionnaire des raccourcis.save claviers de l'application
 *
 * @author Léo Franch
 * @author Lucas Vabre
 * @author Noé Villeneuve
 * @author Tristan Nogaret
 */
public class RaccourcisClavier extends JFrame {

    public static boolean saisieBloquee;

    public static final String FICHIER_SAUVEGARDE = "raccourcis.save";

    /**
     * Liste des menus items, se remplis a la création de chaque MenuItem de l'application
     */
    public static ArrayList<JMenuItem> listeMenuItems = new ArrayList<>();

    /**
     * HashMap qui prend en clé le Nom et en valeur une combinaison de touche : le raccourcis.save clavier
     */
    public static Map<String, KeyStroke> raccourcis = new HashMap<>() {};

    public static String[] LISTE_NOM = {
        "Ouvrir",
        "Fermer",
        "Quitter",
        "Mode Plein Ecran",
        "Page Prédédente",
        "Page Suivante",
        "Zoom 50%",
        "Zoom 100%",
        "Zoom 150%",
        "Page Entière",
        "Pleine Largeur",
        "Nouvelle Fenêtre",
        "Mode Séparé",
        "Mode Synchronisé",
        "Modifier Touches"
    };

    public static KeyStroke[] LISTE_RACCOURCIS = {
        KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK), // Ouvrir
        KeyStroke.getKeyStroke(KeyEvent.VK_F, KeyEvent.CTRL_DOWN_MASK), // Fermer
        KeyStroke.getKeyStroke(KeyEvent.VK_Q, KeyEvent.CTRL_DOWN_MASK), // Quitter
        KeyStroke.getKeyStroke(KeyEvent.VK_F11, KeyEvent.CTRL_DOWN_MASK), // Mode Plein Ecran
        KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, KeyEvent.CTRL_DOWN_MASK), // Page Prédédente
        KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, KeyEvent.CTRL_DOWN_MASK), // Page Suivante
        KeyStroke.getKeyStroke(KeyEvent.VK_MINUS, KeyEvent.CTRL_DOWN_MASK), // Zoom 50%
        KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD0, KeyEvent.CTRL_DOWN_MASK), // Zoom 100%
        KeyStroke.getKeyStroke(KeyEvent.VK_PLUS, KeyEvent.CTRL_DOWN_MASK), // Zoom 150%
        KeyStroke.getKeyStroke(KeyEvent.VK_W, KeyEvent.CTRL_DOWN_MASK), // Page Entière
        KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.CTRL_DOWN_MASK), // Pleine Largeur
        KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK), // Nouvelle Fenêtre
        KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.CTRL_DOWN_MASK),  // Mode Séparé
        KeyStroke.getKeyStroke(KeyEvent.VK_Z, KeyEvent.CTRL_DOWN_MASK),  // Mode Synchronisé
        KeyStroke.getKeyStroke(KeyEvent.VK_P, KeyEvent.CTRL_DOWN_MASK), // Modifier Touches
    };

    public RaccourcisClavier() {
        super("Modification des raccourcis claviers");
        saisieBloquee = false;

        /* Charge le fichier et affecte les raccourcis aux MenuItems */
        chargerRaccourcis();
        affecterRaccourcis();

        /* Creattion de la fenêtre */
        JPanel panel = new JPanel(new GridLayout(raccourcis.size(), 1, 10, 5));

        for (String nom : LISTE_NOM) {
            RaccourcisElement raccourcisElement = new RaccourcisElement(nom, raccourcis.get(nom));
            panel.add(raccourcisElement);
        }
        add(panel);

        sauvegarderRaccourcis();

        pack();
        setMinimumSize(new Dimension(400, 200));
        setVisible(true);
    }

    /**
     * Lis le fichier de sauvegarde et restaure la HashMap des raccourcis
     */
    public static void chargerRaccourcis() {
        try {
            FileInputStream fis = new FileInputStream(FICHIER_SAUVEGARDE);
            ObjectInputStream ois = new ObjectInputStream(fis);

            raccourcis = (HashMap) ois.readObject();

            ois.close();
            fis.close();
            System.out.println("Chargement des données avec succès");
        } catch (IOException ioe) {
            initialisationFichierRaccourcis();
            ioe.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
        }
    }

    /**
     * Ecrit dans le fichier de sauvegarde la HashMap des raccourcis
     */
    public static void sauvegarderRaccourcis() {
        try {
            FileOutputStream fos = new FileOutputStream(FICHIER_SAUVEGARDE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(raccourcis);

            oos.close();
            fos.close();
            System.out.println("Sauvegardé avec succes");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Remplis la HashMap avec les raccourcis claviers par défaut
     * et la sauvegarde
     */
    private static void initialisationFichierRaccourcis() {
        for (int i = 0; i < LISTE_NOM.length && i < LISTE_RACCOURCIS.length; i++) {
            raccourcis.put(LISTE_NOM[i], LISTE_RACCOURCIS[i]);
        }
        sauvegarderRaccourcis();
    }

    /**
     * Affecte a chaque MenuItems le raccourcis qui lui est destiné
     */
    public static void affecterRaccourcis() {
        for (JMenuItem menuItem : listeMenuItems) {
            menuItem.setAccelerator(raccourcis.get(menuItem.getText()));
        }
    }
}
