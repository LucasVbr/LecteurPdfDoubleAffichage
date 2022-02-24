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
        // Ajoute les menu items
        add(new NouvelleFenetre(parent));

        ButtonGroup groupe = new ButtonGroup();
        ModeSepare modeSepare = new ModeSepare(parent);
        ModeSynchronise modeSynchronise = new ModeSynchronise(parent);

        add(modeSepare);
        add(modeSynchronise);

        groupe.add(modeSepare);
        groupe.add(modeSynchronise);


        modeSepare.setSelected(!GestionPdf.modeSynchronise);
        modeSynchronise.setSelected(GestionPdf.modeSynchronise);

        parent.setMode(modeSepare, modeSynchronise);
    }
}