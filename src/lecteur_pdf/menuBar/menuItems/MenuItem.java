/*
 * MenuItem.java, 26/02/2022
 * IUT Rodez 2021-2022, INFO2
 * Pas de copyright, aucun droits
 */

package lecteur_pdf.menuBar.menuItems;

import lecteur_pdf.Fenetre;
import lecteur_pdf.raccourcisClavier.RaccourcisClavier;

import javax.swing.*;

/**
 * Classe abstraite qui défini les éléments de
 * {@link lecteur_pdf.menuBar.menu menu}
 * qui nécessitent d'accéder à leur {@link Fenetre fenêtre} parente
 *
 * @author Léo Franch
 * @author Tristan Nogaret
 * @author Lucàs Vabre
 * @author Noé Villeneuve
 * @see JMenuItem
 */
public abstract class MenuItem extends JMenuItem {

    /**
     * Référence de la {@link Fenetre fenêtre}
     * qui possède l'instance de ce MenuItem
     */
    final Fenetre parent;

    /**
     * Créé un nouvel élément de {@link lecteur_pdf.menuBar.menu menu}
     * avec un nom, une action et se référence dans la liste des raccourcis
     * claviers
     *
     * @param parent Référence de la fenêtre qui possède l'instance de ce
     *               MenuItem
     * @param name   Nom de l'action
     */
    public MenuItem(Fenetre parent, String name) {
        super(name);
        this.parent = parent;
        addActionListener(evt -> action());
        RaccourcisClavier.listeMenuItems.add(this);
    }

    /**
     * Action de l'élément lors du clic
     */
    protected abstract void action();
}
