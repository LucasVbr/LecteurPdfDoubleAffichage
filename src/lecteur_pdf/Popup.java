/*
 * Popup.java, 09/03/2022
 * IUT Rodez 2021-2022, INFO 2
 * pas de copyright, aucun droits
 */

package lecteur_pdf;

import javax.swing.*;
import java.awt.*;

/**
 * Classe outils permettant de créer des fenêtres Popups
 *
 * @author Léo Franch
 * @author Lucas Vabre
 * @author Noé Villeneuve
 * @author Tristan Nogaret
 */
public class Popup {

    /**
     * Créé une nouvelle fenêtre comportant un message et
     * deux boutons : Oui et Non
     *
     * @param parent La fenêtre parente de référence
     * @param titre Titre de la fenêtre
     * @param message Message affiché dans la fenêtre
     * @return JOptionPane.YES_OPTION si oui est cliqué, JOptionPane.NO_OPTION si non est cliqué
     */
    public static int OuiNonPopup(Component parent, String titre, String message) {
        String[] choix = {"Oui", "Non"};
        return JOptionPane.showOptionDialog(parent, message, titre, JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE,
                                            null, choix, choix[0]);
    }

    /**
     * Créé une nouvelle fenêtre comportant un message d'erreur avec un
     * bouton OK
     *
     * @param parent La fenêtre parente de référence
     * @param titre Titre de la fenêtre
     * @param message Message d'erreur
     */
    public static void errorPopup(Component parent, String titre, String message) {
        JOptionPane d = new JOptionPane();
        String[] choix = {"OK"};
        JOptionPane.showOptionDialog(parent, message, titre, JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE, null, choix, choix[0]);
    }
}
