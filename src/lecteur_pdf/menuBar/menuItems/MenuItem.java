/*
 * MenuItem.java, 26/02/2022
 * IUT Rodez 2021-2022, INFO 2
 * pas de copyright, aucun droits
 */

package lecteur_pdf.menuBar.menuItems;

import lecteur_pdf.Fenetre;
import lecteur_pdf.raccourcisClavier.RaccourcisClavier;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Classe abstraite qui défini les Éléments de menu qui nécessite d'accéder à
 * leur Fenêtre parente
 *
 * @author Léo Franch
 * @author Lucas Vabre
 * @author Noé Villeneuve
 * @author Tristan Nogaret
 */
public abstract class MenuItem extends JMenuItem {

    /** Référence de la fenêtre qui possède l'instance de ce MenuItem */
    final Fenetre parent;

    /**
     * Crée un nouvel Élément de Menu avec un nom, une action et se référence dans la liste des raccourcis claviers
     *
     * @param parent Référence de la fenêtre qui possède l'instance de ce MenuItem
     * @param name Nom de l'action
     */
    public MenuItem(Fenetre parent, String name) {
        super(name);
        this.parent = parent;
        addActionListener(this::action);
        RaccourcisClavier.listeMenuItems.add(this);
    }

    /**
     * Action de l'élément lors du clic
     * @param evt Action de l'utilisateur (clic)
     */
    protected abstract void action(ActionEvent evt);
}
