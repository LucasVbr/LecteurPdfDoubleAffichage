/*
 * ModeSepare.java, 26/02/2022
 * IUT Rodez 2021-2022, INFO2
 * Pas de copyright, aucun droits
 */

package lecteur_pdf.menuBar.menuItems;

import lecteur_pdf.GestionMode;
import lecteur_pdf.raccourcisClavier.RaccourcisClavier;

import javax.swing.*;

/**
 * Élément de {@link lecteur_pdf.menuBar.menu.MenuMode MenuMode}
 * qui permet d'activer le défilement des pages de documents en séparé
 *
 * @author Léo Franch
 * @author Tristan Nogaret
 * @author Lucàs Vabre
 * @author Noé Villeneuve
 * @see JRadioButtonMenuItem
 */
public class ModeSepare extends JRadioButtonMenuItem {

    /**
     * Créé un nouvel élément de
     * {@link lecteur_pdf.menuBar.menu.MenuMode MenuMode}
     */
    public ModeSepare() {
        super("Mode Séparé");
        addActionListener(e -> GestionMode.setModeSepare(true));
        RaccourcisClavier.listeMenuItems.add(this);
    }
}
