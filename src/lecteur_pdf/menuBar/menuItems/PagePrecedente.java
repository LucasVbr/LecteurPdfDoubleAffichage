/*
 * PagePrecedente.java, 26/02/2022
 * IUT Rodez 2021-2022, INFO2
 * Pas de copyright, aucun droits
 */

package lecteur_pdf.menuBar.menuItems;

import lecteur_pdf.Fenetre;
import lecteur_pdf.GestionFenetre;
import lecteur_pdf.GestionMode;

/**
 * Élément de Menu PagePrecedente qui permet d'afficher la page précédente du
 * document courant (ou les pages précédentes si le mode Synchronisé est activé)
 *
 * @author Léo Franch
 * @author Tristan Nogaret
 * @author Lucàs Vabre
 * @author Noé Villeneuve
 */

public class PagePrecedente extends MenuItem {

    /**
     * Créé un nouvel élément de Menu PagePrecedente
     *
     * @param parent Référence de la fenêtre qui possède l'instance de ce
     *               MenuItem
     */
    public PagePrecedente(Fenetre parent) {
        super(parent, "Page précédente");
    }

    @Override
    protected void action() {
        if (GestionMode.isModeSepare()) {
            parent.getPdfPanel().pagePrecedente();
        } else {
            GestionFenetre.previousPages();
        }
    }
}
