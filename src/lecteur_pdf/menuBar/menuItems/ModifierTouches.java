/*
 * ModifierTouches.java, 26/02/2022
 * IUT Rodez 2021-2022, INFO2
 * Pas de copyright, aucun droits
 */

package lecteur_pdf.menuBar.menuItems;

import lecteur_pdf.Fenetre;
import lecteur_pdf.raccourcisClavier.RaccourcisClavier;

/**
 * Élément de {@link lecteur_pdf.menuBar.menu.MenuOptions MenuOptions}
 * qui permet d'ouvrir une {@link javax.swing.JFrame fenêtre}
 * pour modifier les raccourcis claviers de l'application
 *
 * @author Léo Franch
 * @author Tristan Nogaret
 * @author Lucàs Vabre
 * @author Noé Villeneuve
 * @see MenuItem
 */
public class ModifierTouches extends MenuItem {

    /**
     * Créé un nouvel élément de
     * {@link lecteur_pdf.menuBar.menu.MenuOptions MenuOptions}
     *
     * @param parent Référence de la fenêtre qui possède l'instance de ce
     *               {@link lecteur_pdf.menuBar.menuItems.MenuItem MenuItem}
     */
    public ModifierTouches(Fenetre parent) {
        super(parent, "Modifier Touches");
    }

    @Override
    protected void action() {
        new RaccourcisClavier();
    }
}
