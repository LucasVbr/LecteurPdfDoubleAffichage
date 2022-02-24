package lecteur_pdf.menuBar.menu;

import lecteur_pdf.GestionPdf;
import lecteur_pdf.IhmPdf;
import lecteur_pdf.menuBar.menuItems.ModeSepare;
import lecteur_pdf.menuBar.menuItems.ModeSynchronise;
import lecteur_pdf.menuBar.menuItems.NouvelleFenetre;

import javax.swing.*;

public class MenuMode extends JMenu {
    public MenuMode(IhmPdf parent) {
        super("Mode");

        ModeSepare modeSepare = new ModeSepare(parent);
        ModeSynchronise modeSynchronise = new ModeSynchronise(parent);

        /* Crée un groupe de Radio */
        ButtonGroup groupe = new ButtonGroup();
        groupe.add(modeSepare);
        groupe.add(modeSynchronise);

        /* Initialise les boutons selectionnés */
        modeSepare.setSelected(!GestionPdf.modeSynchronise);
        modeSynchronise.setSelected(GestionPdf.modeSynchronise);

        parent.setMode(modeSepare, modeSynchronise);

        /* Ajoute les menu items */
        add(new NouvelleFenetre(parent));
        addSeparator();
        add(modeSepare);
        add(modeSynchronise);

    }
}