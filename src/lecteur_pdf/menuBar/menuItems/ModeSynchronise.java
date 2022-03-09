/*
 * ModeSynchronise.java, 26/02/2022
 * IUT Rodez 2021-2022, INFO 2
 * pas de copyright, aucun droits
 */

package lecteur_pdf.menuBar.menuItems;

import lecteur_pdf.GestionMode;
import lecteur_pdf.raccourcisClavier.RaccourcisClavier;

import javax.swing.*;

/**
 * Element de Menu Mode Synchronisé qui permet d'activer le défilement des pages de documents en simultané
 *
 * @author Léo Franch
 * @author Lucas Vabre
 * @author Noé Villeneuve
 * @author Tristan Nogaret
 */
public class ModeSynchronise extends JRadioButtonMenuItem {

    /**
     * Crée un nouvel Element de Menu "Mode Synchronisé"
     */
    public ModeSynchronise() {
        super("Mode Synchronisé");
        addActionListener(e -> GestionMode.setModeSynchronise());
        RaccourcisClavier.listeMenuItems.add(this);
    }
}