/*
 * RaccourcisClavier.java, 26/02/2022
 * IUT Rodez 2021-2022, INFO 2
 * pas de copyright, aucun droits
 */

package lecteur_pdf.raccourcisClavier;

import lecteur_pdf.GestionFenetre;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
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

    public static final String FICHIER_SAUVEGARDE = "raccourcis.save";

    public static boolean saisieBloquee;

    /**
     * Liste des menus items, se remplis à la création de chaque MenuItem de
     * l'application
     */
    public static ArrayList<JMenuItem> listeMenuItems = new ArrayList<>();

    public static ArrayList<RaccourcisElement> listeRaccourcisElement = new ArrayList<>();

    /**
     * HashMap qui prend en clé le Nom et en valeur une combinaison de touche : le raccourcis.save clavier
     */
    public static Map<String, KeyStroke> raccourcis = new HashMap<>() {};

    public static String[] LISTE_NOM = {
        "Ouvrir",
        "Fermer",
        "Quitter",
        "Mode Plein Écran",
        "Page précédente",
        "Page suivante",
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
        KeyStroke.getKeyStroke(KeyEvent.VK_F11, KeyEvent.CTRL_DOWN_MASK), // Mode Plein Écran
        KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, KeyEvent.CTRL_DOWN_MASK), // Page Précédente
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
        setIconImage(GestionFenetre.ICONE);

        /* Charge le fichier et affecte les raccourcis aux MenuItems */
        chargerRaccourcis();
        affecterRaccourcis();

        /* Creation de la fenêtre */
        JPanel panel = new JPanel(new GridLayout(raccourcis.size() +1, 1, 10, 5));

        for (String nom : LISTE_NOM) {
            RaccourcisElement raccourcisElement = new RaccourcisElement(nom, raccourcis.get(nom));
            listeRaccourcisElement.add(raccourcisElement);
            panel.add(raccourcisElement);
        }

        JButton btnReset = new JButton("Raccourcis par défaut");
        btnReset.addActionListener(this::actionBtnReset);
        panel.add(btnReset);

        add(panel);

        pack();
        setMinimumSize(new Dimension(400, 200));
        setVisible(true);
    }

    private void actionBtnReset(ActionEvent evt) {
        initialisationFichierRaccourcis();
        chargerRaccourcis();

        // Affichage des boutons
        for (int i = 0; i < listeRaccourcisElement.size() ; i++) {
            String cle = LISTE_NOM[i];
            KeyStroke valeur = raccourcis.get(cle);

            /* Met a jour l'affichage du bouton */
            listeRaccourcisElement.get(i).setRaccourcis(valeur);
        }
        affecterRaccourcis();
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
     * Affecte a chaque MenuItems le raccourci qui lui est destiné
     */
    public static void affecterRaccourcis() {
        for (JMenuItem menuItem : listeMenuItems) {
            menuItem.setAccelerator(raccourcis.get(menuItem.getText()));
        }
    }
}
