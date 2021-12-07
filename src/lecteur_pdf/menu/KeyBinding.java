/*
 * KeyBinding.java, 18/11/2021
 * IUT Rodez 2021-2021, INFO2
 * pas de copyright, aucun droits
 */

package lecteur_pdf.menu;

import javax.swing.*;
import java.awt.event.KeyEvent;
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
public class KeyBinding {

    /* Déclaration des éléments visuels */
    JFrame frame = new JFrame();
    JLabel label = new JLabel();

    /* Déclaration des listes */
    ArrayList<String> listeOptions;
    ArrayList<KeyStroke> listeRaccourcis;

    static KeyStroke raccourciOuvrir = KeyStroke.getKeyStroke(KeyEvent.VK_O,
                                                       KeyEvent.CTRL_DOWN_MASK);
    static KeyStroke raccourciFermer = KeyStroke.getKeyStroke(KeyEvent.VK_Q,
                                                       KeyEvent.CTRL_DOWN_MASK);
    static KeyStroke raccourciQuitter = KeyStroke.getKeyStroke(KeyEvent.VK_X,
                                                        KeyEvent.CTRL_DOWN_MASK);

    /**
     * TODO commenter la méthode
     */
    public void KeyBinding() {

    }

    /**
     * Méthode qui récupère la lettre pressée par l'utilisateur
     * @return un KeyEvent correspond à la lettre pressée
     */
    public KeyEvent getUserKey() {
        return null; // bouchon
    }

    /**
     * TODO commenter la méthode
     * @param key
     * @param menuItem
     */
    public void setMenuItemAccelerator(KeyStroke key, JMenuItem menuItem) {
        // TODO
    }
}
