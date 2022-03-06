/*
 * ZoomPlus.java, 26/02/2022
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
public class ZoomPlus extends MenuItem {

    /**
     * TODO
     * @param parent
     */
    public ZoomPlus(IhmPdf parent) {
        super(parent, "Zoom 150%");

        addActionListener(e -> {
            parent.getPdfPanel().updateScaleZoom(1.5f);
            parent.validate();
        });

        setRaccourcis(KeyEvent.VK_P, KeyEvent.CTRL_DOWN_MASK);

    }
}