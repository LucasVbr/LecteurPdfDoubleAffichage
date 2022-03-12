/*
 * GestionPdf.java, 26/02/2022
 * IUT Rodez 2021-2022, INFO2
 * Pas de copyright, aucun droits
 */

package lecteur_pdf;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Gestionnaire des {@link Fenetre fenêtres} ouvertes dans l'application
 *
 * @author Léo Franch
 * @author Tristan Nogaret
 * @author Lucàs Vabre
 * @author Noé Villeneuve
 */
public class GestionFenetre {

    /**
     * Icône de l'application (affiché en haut à droite des
     * {@link Fenetre fenêtres})
     *
     * @see Image
     */
    public static final Image ICONE = new ImageIcon(
        "./lib/icon.png").getImage();

    /**
     * Nombre maximum de PDF que l'application peut ouvrir en simultané
     */
    public static final int NB_MAX_PDF = 2;

    /**
     * Liste des {@link Fenetre fenêtres} ouvertes
     *
     * @see List
     */
    public static final List<Fenetre> FENETRE_LIST = new ArrayList<>();

    /**
     * Crée une nouvelle fenêtre si NB_MAX_PDF n'est pas atteint
     */
    public static void newIhmPdf() {
        if (FENETRE_LIST.size() < NB_MAX_PDF) {
            Fenetre ihm = new Fenetre();
            FENETRE_LIST.add(ihm);
        }
    }

    /**
     * Méthode qui affiche la page suivante de tous les PDF ouverts
     * ({@link lecteur_pdf.menuBar.menuItems.ModeSynchronise mode Synchronisé})
     */
    public static void nextPages() {
        for (Fenetre ihm : FENETRE_LIST) {
            ihm.getPdfPanel().pageSuivante();
        }
    }

    /**
     * Méthode qui affiche la page précédente de tous les PDF ouverts
     * ({@link lecteur_pdf.menuBar.menuItems.ModeSynchronise mode Synchronisé})
     */
    public static void previousPages() {
        for (Fenetre ihm : FENETRE_LIST) {
            ihm.getPdfPanel().pagePrecedente();
        }
    }

    /**
     * Lance l'application
     *
     * @param args non utilisé
     */
    public static void main(String[] args) {
        /* Définit le style de la fenêtre sur l'explorateur Windows si
        possible */
        try {
            UIManager.setLookAndFeel(
                "com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception ignored) {
        }

        GestionMode.setModeSepare(true);
        newIhmPdf();
    }
}
