package lecteur_pdf;

import lecteur_pdf.menuBar.menuItems.ModeSepare;
import lecteur_pdf.menuBar.menuItems.ModeSynchronise;

import java.util.ArrayList;

public class GestionMode {

    /**
     * Défini le mode actif :
     * true -> Mode Séparé
     * false -> Mode Synchronisé
     */
    private static boolean modeSepare;

    private static final ArrayList<ModeSepare> modeSepareList = new ArrayList<>();
    private static final ArrayList<ModeSynchronise> modeSynchroniseList = new ArrayList<>();

    public static void addItem(ModeSepare separe, ModeSynchronise synchronise) {
        modeSepareList.add(separe);
        modeSynchroniseList.add(synchronise);
        updateMode();
    }

    public static boolean isModeSepare() {
        return modeSepare;
    }

    public static void setModeSepare() {
        modeSepare = true;
        updateMode();
    }

    public static void setModeSynchronise() {
        modeSepare = false;
        updateMode();
    }

    private static void updateMode() {
        for (int i = 0; i < modeSepareList.size() ; i++) {
            modeSepareList.get(i).setSelected(modeSepare);
            modeSynchroniseList.get(i).setSelected(!modeSepare);
        }
    }


}
