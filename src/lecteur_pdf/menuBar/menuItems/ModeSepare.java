/*
 * ModeSepare.java, 26/02/2022
 * IUT Rodez 2021-2022, INFO 2
 * pas de copyright, aucun droits
 */

package lecteur_pdf.menuBar.menuItems;

import lecteur_pdf.GestionMode;
import lecteur_pdf.raccourcisClavier.RaccourcisClavier;

import javax.swing.*;

/**
 * Élément de Menu Mode Séparé qui permet d'activer le défilement des pages de documents en séparé
 *
 * @author Léo Franch
 * @author Lucas Vabre
 * @author Noé Villeneuve
 * @author Tristan Nogaret
 */
public class ModeSepare extends JRadioButtonMenuItem {

    /**
     * Crée un nouvel Élément de Menu "Mode Séparé"
     */
    public ModeSepare() {
        super("Mode Séparé");
        addActionListener(e -> GestionMode.setModeSepare(true));
        RaccourcisClavier.listeMenuItems.add(this);
    }
}
