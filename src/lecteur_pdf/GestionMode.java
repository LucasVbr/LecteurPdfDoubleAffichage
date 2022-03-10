/*
 * GestionMode.java, 26/02/2022
 * IUT Rodez 2021-2022, INFO2
 * Pas de copyright, aucun droits
 */

package lecteur_pdf;

import lecteur_pdf.menuBar.menuItems.ModeSepare;
import lecteur_pdf.menuBar.menuItems.ModeSynchronise;
import lecteur_pdf.menuBar.menuItems.NouvelleFenetre;

import java.awt.*;
import java.util.ArrayList;

/**
 * Gestionnaire de mode Synchronisé ou Séparé
 *
 * @author Léo Franch
 * @author Tristan Nogaret
 * @author Lucàs Vabre
 * @author Noé Villeneuve
 */
public class GestionMode {

    /** Défini si le mode séparé est activé ou non */
    private static boolean modeSepare;

    /** Liste les MenuItems de type NouvelleFenetre de l'application */
    private static final ArrayList<NouvelleFenetre> nouvelleFenetreList = new ArrayList<>();

    /** Liste les MenuItem de type ModeSepare de l'application */
    private static final ArrayList<ModeSepare> modeSepareList = new ArrayList<>();

    /** Liste les MenuItem de type ModeSynchronise de l'application */
    private static final ArrayList<ModeSynchronise> modeSynchroniseList = new ArrayList<>();

    /**
     * Référence les éléments NouvelleFenetre, ModeSepare, ModeSynchronise 
     * lors de la création d'une nouvelle fenêtre
     * @param fenetre Référence du MenuItem NouvelleFenetre de la fenêtre crée
     * @param separe Référence du MenuItem ModeSepare de la fenêtre crée
     * @param synchronise Référence du MenuItem ModeSynchronise de la fenêtre crée
     */
    public static void addItem(NouvelleFenetre fenetre, ModeSepare separe, ModeSynchronise synchronise) {
        nouvelleFenetreList.add(fenetre);
        modeSepareList.add(separe);
        modeSynchroniseList.add(synchronise);
        updateMode();
    }

    /** @return true si le mode séparé est activé, false sinon */
    public static boolean isModeSepare() {
        return modeSepare;
    }

    /**
     * Change de mode
     * @param mode true pour le mode séparé, false pour le mode synchronisé
     */
    public static void setModeSepare(boolean mode) {
        modeSepare = mode;
        updateMode();
    }

    /**
     * Met à jour dans toutes les fenêtres ouvertes la checkbox du mode
     * sélectionné
     */
    private static void updateMode() {
        for (int i = 0; i < modeSepareList.size() ; i++) {
            modeSepareList.get(i).setSelected(modeSepare);
            modeSynchroniseList.get(i).setSelected(!modeSepare);
        }
    }

    /**
     * Grise le bouton "Nouvelle Fenêtre" de toutes les fenêtres de
     * l'application
     */
    public static void desactiverBtnNouvelleFenetre() {
        for (NouvelleFenetre item : nouvelleFenetreList) {
            item.setEnabled(false);
            item.setBackground(Color.GRAY);
        }
    }

    /**
     * Dégrise le bouton "Nouvelle Fenêtre" de toutes les fenêtres de
     * l'application
     */
    public static void activerBtnNouvelleFenetre() {
        for (NouvelleFenetre item : nouvelleFenetreList) {
            item.setEnabled(true);
            item.setBackground(Color.BLACK);
        }
    }
}
