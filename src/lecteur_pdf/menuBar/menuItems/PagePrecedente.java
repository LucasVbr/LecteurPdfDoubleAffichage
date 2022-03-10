/*
 * PagePrecedente.java, 26/02/2022
 * IUT Rodez 2021-2022, INFO 2
 * pas de copyright, aucun droits
 */

package lecteur_pdf.menuBar.menuItems;

import lecteur_pdf.Fenetre;
import lecteur_pdf.GestionFenetre;
import lecteur_pdf.GestionMode;

import java.awt.event.ActionEvent;

/**
 * Élément de Menu PagePrecedente qui permet d'afficher la page précédente du
 * document courant (ou les pages précédentes si le mode Synchronisé est activé)
 *
 * @author Léo Franch
 * @author Lucas Vabre
 * @author Noé Villeneuve
 * @author Tristan Nogaret
 */
@SuppressWarnings("SpellCheckingInspection")
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
    protected void action(ActionEvent evt) {
        if (GestionMode.isModeSepare()) {
            parent.getPdfPanel().pagePrecedente();
        } else {
            GestionFenetre.previousPages();
        }
    }
}
