package lecteur_pdf.menuBar.menuItems;

import lecteur_pdf.Fenetre;

import java.awt.event.ActionEvent;

public class PageEntiere extends MenuItem {
    /**
     * TODO
     *  @param parent Référence de la fenêtre qui possède l'instance de ce MenuItem
     */
    public PageEntiere(Fenetre parent) {
        super(parent, "Page Entière");
    }

    @Override
    protected void action(ActionEvent evt) {
        parent.getPdfPanel().setPleineLargeur(false);
    }
}
