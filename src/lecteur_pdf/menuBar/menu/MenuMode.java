/*
 * MenuMode.java, 26/02/2022
 * IUT Rodez 2021-2022, INFO 2
 * pas de copyright, aucun droits
 */

package lecteur_pdf.menuBar.menu;

import lecteur_pdf.GestionMode;
import lecteur_pdf.IhmPdf;
import lecteur_pdf.menuBar.menuItems.ModeSepare;
import lecteur_pdf.menuBar.menuItems.ModeSynchronise;
import lecteur_pdf.menuBar.menuItems.NouvelleFenetre;

import javax.swing.*;

/**
 * Element de la barre des menus contenant l'intégralités des actions lié au mode multi-affichage
 *
 * @author Léo Franch
 * @author Lucas Vabre
 * @author Noé Villeneuve
 * @author Tristan Nogaret
 */
public class MenuMode extends JMenu {

    /**
     * Crée une nouvelle instance du menu Mode
     *
     * @param parent Référence de la fenêtre qui possède l'instance de ce menu
     */
    public MenuMode(IhmPdf parent) {
        super("Mode");

        /* Crée les différentes options */
        ModeSepare modeSepare = new ModeSepare();
        ModeSynchronise modeSynchronise = new ModeSynchronise();
        NouvelleFenetre nouvelleFenetre = new NouvelleFenetre(parent);

        /* Les ajoute au gestionnaire des mode */
        GestionMode.addItem(nouvelleFenetre, modeSepare, modeSynchronise);

        /* Ajoute les menu items */
        add(nouvelleFenetre);
        addSeparator();
        add(modeSepare);
        add(modeSynchronise);
    }
}