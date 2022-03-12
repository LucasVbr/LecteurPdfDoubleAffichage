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
 * Gestionnaire de mode {@link ModeSynchronise Synchronisé} ou
 * {@link ModeSepare Séparé}
 *
 * @author Léo Franch
 * @author Tristan Nogaret
 * @author Lucàs Vabre
 * @author Noé Villeneuve
 */
public class GestionMode {

    /**
     * Définit si le {@link ModeSepare mode Séparé} est activé ou non
     */
    private static boolean modeSepare;

    /**
     * Liste les {@link lecteur_pdf.menuBar.menuItems.MenuItem MenuItems}
     * de type {@link NouvelleFenetre NouvelleFenetre} de l'application
     *
     * @see ArrayList
     */
    private static final ArrayList<NouvelleFenetre> nouvelleFenetreList
        = new ArrayList<>();

    /**
     * Liste les {@link lecteur_pdf.menuBar.menuItems.MenuItem MenuItems}
     * de type {@link ModeSepare ModeSepare} de l'application
     *
     * @see ArrayList
     */
    private static final ArrayList<ModeSepare> modeSepareList
        = new ArrayList<>();

    /**
     * Liste les {@link lecteur_pdf.menuBar.menuItems.MenuItem MenuItems}
     * de type {@link ModeSynchronise ModeSynchronise} de l'application
     *
     * @see ArrayList
     */
    private static final ArrayList<ModeSynchronise> modeSynchroniseList
        = new ArrayList<>();

    /**
     * Référence les éléments
     * {@link NouvelleFenetre NouvelleFenetre},
     * {@link ModeSepare ModeSepare} et
     * {@link ModeSynchronise ModeSynchronise}
     * lors de la création d'une nouvelle {@link Fenetre fenêtre}
     *
     * @param fenetre     Référence du
     *                    {@link lecteur_pdf.menuBar.menuItems.MenuItem
     *                    MenuItem}
     *                    {@link NouvelleFenetre NouvelleFenetre} de la fenêtre
     *                    créée
     * @param separe      Référence du
     *                    {@link lecteur_pdf.menuBar.menuItems.MenuItem
     *                    MenuItem}
     *                    {@link ModeSepare ModeSepare} de la fenêtre créée
     * @param synchronise Référence du
     *                    {@link lecteur_pdf.menuBar.menuItems.MenuItem
     *                    MenuItem}
     *                    {@link ModeSynchronise ModeSynchronise} de la fenêtre
     *                    créée
     */
    public static void addItem(NouvelleFenetre fenetre,
                               ModeSepare separe,
                               ModeSynchronise synchronise) {
        nouvelleFenetreList.add(fenetre);
        modeSepareList.add(separe);
        modeSynchroniseList.add(synchronise);
        updateMode();
    }

    /**
     * @return <ul><li>true si le {@link ModeSepare mode séparé} est
     * activé</li><li>false sinon</li></ul>
     */
    public static boolean isModeSepare() {
        return modeSepare;
    }

    /**
     * Change de mode
     *
     * @param mode <ul><li>true pour le mode séparé</li>
     *             <li>false pour le mode synchronisé</li></ul>
     */
    public static void setModeSepare(boolean mode) {
        modeSepare = mode;
        updateMode();
    }

    /**
     * Met à jour dans toutes les {@link Fenetre fenêtres} ouvertes la
     * checkbox du mode sélectionné
     */
    private static void updateMode() {
        for (int i = 0; i < modeSepareList.size(); i++) {
            modeSepareList.get(i).setSelected(modeSepare);
            modeSynchroniseList.get(i).setSelected(!modeSepare);
        }
    }

    /**
     * Grise le bouton "{@link NouvelleFenetre Nouvelle Fenêtre}" de toutes les
     * {@link Fenetre fenêtres} de l'application
     */
    public static void desactiverBtnNouvelleFenetre() {
        for (NouvelleFenetre item : nouvelleFenetreList) {
            item.setEnabled(false);
            item.setBackground(Color.GRAY);
        }
    }

    /**
     * Dégrise le bouton "{@link NouvelleFenetre Nouvelle Fenêtre}" de toutes
     * les {@link Fenetre fenêtres} de l'application
     */
    public static void activerBtnNouvelleFenetre() {
        for (NouvelleFenetre item : nouvelleFenetreList) {
            item.setEnabled(true);
            item.setBackground(Color.BLACK);
        }
    }
}
