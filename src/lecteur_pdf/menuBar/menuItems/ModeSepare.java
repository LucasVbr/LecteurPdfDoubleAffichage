/*
 * ModeSepare.java, 26/02/2022
 * IUT Rodez 2021-2022, INFO 2
 * pas de copyright, aucun droits
 */

package lecteur_pdf.menuBar.menuItems;

import lecteur_pdf.GestionMode;
import lecteur_pdf.IhmPdf;
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
public class ModeSepare extends JRadioButtonMenuItem {

    /**
     * TODO
     * @param parent Référence de la fenêtre qui possède l'instance de ce MenuItem
     */
    public ModeSepare() {
        super("Mode Séparé");

        addActionListener(e -> {
            GestionMode.setModeSepare();
        });

        RaccourcisClavier.listeMenuItems.add(this);
    }
}
