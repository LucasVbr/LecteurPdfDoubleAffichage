/*
 * GestionPdf.java, 26/02/2022
 * IUT Rodez 2021-2022, INFO 2
 * pas de copyright, aucun droits
 */

package lecteur_pdf;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO commentaires
 *
 * @author Léo Franch
 * @author Lucas Vabre
 * @author Noé Villeneuve
 * @author Tristan Nogaret
 */
public class GestionPdf {
    /**
     * TODO
     */
    public static final String TITRE_APPLICATION = "LPDA";

    /**
     * TODO
     */
    public static final int maxPdf = 2;

    /**
     * TODO
     */
    public static final List<IhmPdf> ihmPdfList = new ArrayList<>();

    /**
     * Crée une nouvelle fenêtre
     */
    public static void newIhmPdf() {
        if (ihmPdfList.size() >= maxPdf) {
            JOptionPane.showMessageDialog(new JFrame(),"vous ne pouvez plus ouvrir de nouvelle fenêtre car vous avez atteint le nombre maximum. ");
            return;
        }

        try {
            IhmPdf ihm = new IhmPdf();
            ihmPdfList.add(ihm);
        } catch (IOException ignored) {}
    }

    /**
     * Methode affiche la page suivante en mode Synchronisé
     */
    public static void nextPages() {
        for (IhmPdf ihm : ihmPdfList) {
            ihm.getPdfPanel().nextPage();
        }
    }

    /**
     * Methode affiche la page précédente en mode Synchronisé
     */
    public static void previousPages() {
        for (IhmPdf ihm : ihmPdfList) {
            ihm.getPdfPanel().previousPage();
        }
    }

    /**
     * Lance l'application
     * @param args non utilisé
     */
    public static void main(String[] args) {
        /* Définit le style de la fenêtre sur l'explorateur windows lorsque
         * cela est possible
         */
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception ignored) {}

        GestionMode.setModeSepare();
        newIhmPdf();
    }
}
