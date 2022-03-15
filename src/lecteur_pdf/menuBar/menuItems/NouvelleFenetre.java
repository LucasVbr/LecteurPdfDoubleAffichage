/*
 * NouvelleFenetre.java, 26/02/2022
 * IUT Rodez 2021-2022, INFO2
 * Pas de copyright, aucun droits
 */

package lecteur_pdf.menuBar.menuItems;

import lecteur_pdf.Fenetre;
import lecteur_pdf.GestionFenetre;
import lecteur_pdf.GestionMode;

/**
 * Élément de {@link lecteur_pdf.menuBar.menu.MenuMode MenuMode} qui permet
 * d'ouvrir une autre {@link Fenetre fenêtre} (pouvant contenir un PDF) si le
 * nombre maximal de fenêtres n'est pas atteint
 *
 * @author Léo Franch
 * @author Tristan Nogaret
 * @author Lucàs Vabre
 * @author Noé Villeneuve
 * @see MenuItem
 */
public class NouvelleFenetre extends MenuItem {

    /**
     * Créé un nouvel élément de
     * {@link lecteur_pdf.menuBar.menu.MenuMode MenuMode}
     *
     * @param parent Référence de la {@link Fenetre fenêtre} qui possède
     *               l'instance de ce
     *               {@link lecteur_pdf.menuBar.menuItems.MenuItem MenuItem}
     */
    public NouvelleFenetre(Fenetre parent) {
        super(parent, "Nouvelle Fenêtre");
    }

    @Override
    public void action() {
        /* Essaye de créer une nouvelle fenêtre */
        GestionFenetre.nouvelleFenetre();

        /* Désactive le bouton si on a atteint la limite de fenêtres */
        if (GestionFenetre.FENETRE_LIST.size() == GestionFenetre.NB_MAX_PDF) {
            GestionMode.desactiverBtnNouvelleFenetre();
        }
    }
}