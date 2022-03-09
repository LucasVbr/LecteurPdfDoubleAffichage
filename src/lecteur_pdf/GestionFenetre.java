/*
 * GestionPdf.java, 26/02/2022
 * IUT Rodez 2021-2022, INFO 2
 * pas de copyright, aucun droits
 */

package lecteur_pdf;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Gestionnaire des fênetres ouvertes dans l'application
 *
 * @author Léo Franch
 * @author Lucas Vabre
 * @author Noé Villeneuve
 * @author Tristan Nogaret
 */
public class GestionFenetre {

    /**
     * Iconne de l'application (affiché en haut a droite des fenêtres)
     */
    public static final Image ICONE = new ImageIcon("./lib/icon.png").getImage();

    /**
     * Nombre maximum de PDF que l'application peut ouvrir en simultané
     */
     public static final int NB_MAX_PDF = 2;

    /**
     * Liste des fenêtres ouvertes
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
     * Methode qui affiche la page suivante de tout les PDF ouvert (mode Synchronisé)
     */
    public static void nextPages() {
        for (Fenetre ihm : FENETRE_LIST) {
            ihm.getPdfPanel().nextPage();
        }
    }

    /**
     * Methode qui affiche la page précédente de tout les PDF ouvert (mode Synchronisé)
     */
    public static void previousPages() {
        for (Fenetre ihm : FENETRE_LIST) {
            ihm.getPdfPanel().previousPage();
        }
    }

    /**
     * Lance l'application
     * @param args non utilisé
     */
    public static void main(String[] args) {
        /* Définit le style de la fenêtre sur l'explorateur windows si possible */
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception ignored) {}

        GestionMode.setModeSepare();
        newIhmPdf();
    }
}
