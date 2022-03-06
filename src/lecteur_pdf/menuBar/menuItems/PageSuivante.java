/*
 * PageSuivante.java, 26/02/2022
 * IUT Rodez 2021-2022, INFO 2
 * pas de copyright, aucun droits
 */

package lecteur_pdf.menuBar.menuItems;

import lecteur_pdf.GestionMode;
import lecteur_pdf.GestionPdf;
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
public class PageSuivante extends MenuItem {

    /**
     * TODO
     * @param parent
     */
    public PageSuivante(IhmPdf parent) {
        super(parent, "Page suivante");

        addActionListener(e -> {
            if (GestionMode.isModeSepare()) {
                parent.getPdfPanel().nextPage();
            } else {
                GestionPdf.nextPages();
            }
        });

        setRaccourcis(KeyEvent.VK_M, KeyEvent.CTRL_DOWN_MASK);
    }
}
