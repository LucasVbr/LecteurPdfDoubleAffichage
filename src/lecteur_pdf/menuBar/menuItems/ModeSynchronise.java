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
 * TODO commentaires
 *
 * @author Léo Franch
 * @author Lucas Vabre
 * @author Noé Villeneuve
 * @author Tristan Nogaret
 */
public class ModeSynchronise extends JRadioButtonMenuItem {

    /**
     * TODO
     */
    public ModeSynchronise() {
        super("Mode Synchronisé");
        addActionListener(e -> GestionMode.setModeSynchronise());
        RaccourcisClavier.listeMenuItems.add(this);
    }
}