/*
 * Popup.java, 09/03/2022
 * IUT Rodez 2021-2022, INFO 2
 * pas de copyright, aucun droits
 */

package lecteur_pdf;

import javax.swing.*;
import java.awt.*;

/**
 * TODO
 *
 * @author Léo Franch
 * @author Lucas Vabre
 * @author Noé Villeneuve
 * @author Tristan Nogaret
 */
public class Popup {

    public static int OuiNonPopup(Component parent, String titre, String message) {
        JOptionPane d = new JOptionPane();
        String[] choix = {"Oui", "Non"};
        return d.showOptionDialog(parent, message, titre, JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE,
                null, choix, choix[0]);
    }

    public static void errorPopup(Component parent, String titre, String message) {
        JOptionPane d = new JOptionPane();
        String[] choix = {"OK"};
        JOptionPane.showOptionDialog(parent, message, titre, JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE, null, choix, choix[0]);
    }



}
