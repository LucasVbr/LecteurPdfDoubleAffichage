/*
 * PageSuivante.java, 26/02/2022
 * IUT Rodez 2021-2022, INFO2
 * Pas de copyright, aucun droits
 */

package lecteur_pdf.menuBar.menuItems;

import lecteur_pdf.Fenetre;
import lecteur_pdf.GestionFenetre;
import lecteur_pdf.GestionMode;

/**
 * Élément de {@link lecteur_pdf.menuBar.menu.MenuAffichage MenuAffichage}
 * qui permet d'afficher la page suivante du document courant (ou les pages
 * suivantes si le
 * {@link lecteur_pdf.menuBar.menuItems.ModeSynchronise mode Synchronisé} est
 * activé)
 *
 * @author Léo Franch
 * @author Tristan Nogaret
 * @author Lucàs Vabre
 * @author Noé Villeneuve
 * @see MenuItem
 */
public class PageSuivante extends MenuItem {

    /**
     * Créé un nouvel élément de
     * {@link lecteur_pdf.menuBar.menu.MenuAffichage MenuAffichage}
     *
     * @param parent Référence de la {@link Fenetre fenêtre} qui possède
     *               l'instance de ce
     *               {@link lecteur_pdf.menuBar.menuItems.MenuItem MenuItem}
     */
    public PageSuivante(Fenetre parent) {
        super(parent, "Page suivante");
    }

    @Override
    protected void action() {
        if (GestionMode.isModeSepare()) {
            parent.getPdfPanel().pageSuivante();
        } else {
            GestionFenetre.pagesSuivantes();
        }
    }
}
