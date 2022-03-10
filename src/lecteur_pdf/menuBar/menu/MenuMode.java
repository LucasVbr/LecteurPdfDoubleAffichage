/*
 * MenuMode.java, 26/02/2022
 * IUT Rodez 2021-2022, INFO2
 * Pas de copyright, aucun droits
 */

package lecteur_pdf.menuBar.menu;

import lecteur_pdf.Fenetre;
import lecteur_pdf.GestionMode;
import lecteur_pdf.menuBar.menuItems.*;

import javax.swing.*;

/**
 * Élément de la barre des menus contenant l'intégralité des actions liés au
 * mode multi-affichage
 *
 * @author Léo Franch
 * @author Tristan Nogaret
 * @author Lucàs Vabre
 * @author Noé Villeneuve
 * @see JMenu
 */
public class MenuMode extends JMenu {

    /**
     * Créé une nouvelle instance du menu Mode
     *
     * @param parent Référence de la {@link Fenetre fenêtre}
     *               qui possède l'instance de ce menu
     */
    public MenuMode(Fenetre parent) {
        super("Mode");

        /* Créé les différentes options */
        NouvelleFenetre nouvelleFenetre = new NouvelleFenetre(parent);
        ModeSepare modeSepare = new ModeSepare();
        ModeSynchronise modeSynchronise = new ModeSynchronise();

        /* Les ajoute au gestionnaire des modes */
        GestionMode.addItem(nouvelleFenetre, modeSepare, modeSynchronise);

        /* Ajoute les menuItems */
        add(nouvelleFenetre);
        addSeparator();
        add(modeSepare);
        add(modeSynchronise);
    }
}