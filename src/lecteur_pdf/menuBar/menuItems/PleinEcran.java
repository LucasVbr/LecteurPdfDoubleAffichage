/*
 * PleinEcran.java, 26/02/2022
 * IUT Rodez 2021-2022, INFO 2
 * pas de copyright, aucun droits
 */

package lecteur_pdf.menuBar.menuItems;

import lecteur_pdf.IhmPdf;

import java.awt.event.KeyEvent;

/**
 * TODO commentaires
 *
 * @author Léo Franch
 * @author Lucas Vabre
 * @author Noé Villeneuve
 * @author Tristan Nogaret
 */
public class PleinEcran extends MenuItem {

    /**
     * TODO
     * @param parent
     */
    public PleinEcran(IhmPdf parent) {
        super(parent, "Mode Plein Ecran");

        addActionListener(e -> {
            parent.pleinEcran();
        });

        setRaccourcis(KeyEvent.VK_P, KeyEvent.CTRL_DOWN_MASK);
    }
}