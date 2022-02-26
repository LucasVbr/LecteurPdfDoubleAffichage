package lecteur_pdf.menuBar.menuItems;

import lecteur_pdf.IhmPdf;

public class PageEntiere extends MenuItem {
    /**
     * TODO
     *  @param parent Référence de la fenêtre qui possède l'instance de ce MenuItem
     */
    public PageEntiere(IhmPdf parent) {
        super(parent, "Page Entière");

        addActionListener(e -> {
            parent.getPdfPanel().setPleineLargeur(false);
        });
    }
}