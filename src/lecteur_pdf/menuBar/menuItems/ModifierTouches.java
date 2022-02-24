package lecteur_pdf.menuBar.menuItems;

import lecteur_pdf.IhmPdf;

public class ModifierTouches extends MenuItem {

    public ModifierTouches(IhmPdf parent) {
        super(parent, "Modifier Touches");

        addActionListener(e -> {
            // TODO Ouverture de la fenêtre de dialogue de modification des touches
        });

    }
}
