/*
 * GestionMode.java, 26/02/2022
 * IUT Rodez 2021-2022, INFO 2
 * pas de copyright, aucun droits
 */

package lecteur_pdf;

import lecteur_pdf.menuBar.menuItems.ModeSepare;
import lecteur_pdf.menuBar.menuItems.ModeSynchronise;

import java.util.ArrayList;

/**
 * TODO commentaires
 *
 * @author Léo Franch
 * @author Lucas Vabre
 * @author Noé Villeneuve
 * @author Tristan Nogaret
 */
public class GestionMode {

    /**
     * Défini le mode actif :
     * true -> Mode Séparé
     * false -> Mode Synchronisé
     */
    private static boolean modeSepare;

    /**
     * TODO
     */
    private static final ArrayList<ModeSepare> modeSepareList = new ArrayList<>();

    /**
     * TODO
     */
    private static final ArrayList<ModeSynchronise> modeSynchroniseList = new ArrayList<>();

    /**
     * TODO
     * @param separe
     * @param synchronise
     */
    public static void addItem(ModeSepare separe, ModeSynchronise synchronise) {
        modeSepareList.add(separe);
        modeSynchroniseList.add(synchronise);
        updateMode();
    }

    /**
     * TODO
     * @return
     */
    public static boolean isModeSepare() {
        return modeSepare;
    }

    /**
     * TODO
     */
    public static void setModeSepare() {
        modeSepare = true;
        updateMode();
    }

    /**
     * TODO
     */
    public static void setModeSynchronise() {
        modeSepare = false;
        updateMode();
    }

    /**
     * TODO
     */
    private static void updateMode() {
        for (int i = 0; i < modeSepareList.size() ; i++) {
            modeSepareList.get(i).setSelected(modeSepare);
            modeSynchroniseList.get(i).setSelected(!modeSepare);
        }
    }
}