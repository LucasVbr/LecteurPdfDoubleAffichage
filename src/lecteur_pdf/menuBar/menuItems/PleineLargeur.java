package lecteur_pdf.menuBar.menuItems;

import lecteur_pdf.IhmPdf;

public class PleineLargeur extends MenuItem{


    /**
     * TODO
     *  @param parent Référence de la fenêtre qui possède l'instance de ce MenuItem
     */
    public PleineLargeur(IhmPdf parent) {
        super(parent, "Pleine Largeur");

        addActionListener(e -> {
            parent.getPdfPanel().setPleineLargeur(true);
        });
    }
}
