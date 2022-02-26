/*
 * ModeSepare.java, 26/02/2022
 * IUT Rodez 2021-2022, INFO 2
 * pas de copyright, aucun droits
 */

package lecteur_pdf.menuBar.menuItems;

import lecteur_pdf.GestionMode;
import lecteur_pdf.IhmPdf;

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
     */
    IhmPdf parent;

    /**
     * TODO
     * @param parent Référence de la fenêtre qui possède l'instance de ce MenuItem
     */
    public ModeSepare(IhmPdf parent) {
        super("Mode Séparé");
        this.parent = parent;

        addActionListener(e -> {
            GestionMode.setModeSepare();
        });

        // TODO ajouter une checkbox pour indiquer si l'option est utilisé

        // TODO ajouter l'options de mode Synchronisé
    }
}
