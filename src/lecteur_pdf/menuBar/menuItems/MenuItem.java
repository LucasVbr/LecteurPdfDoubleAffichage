/*
 * MenuItem.java, 26/02/2022
 * IUT Rodez 2021-2022, INFO 2
 * pas de copyright, aucun droits
 */

package lecteur_pdf.menuBar.menuItems;

import lecteur_pdf.IhmPdf;
import lecteur_pdf.raccourcisClavier.RaccourcisClavier;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * TODO commentaires
 *
 * @author Léo Franch
 * @author Lucas Vabre
 * @author Noé Villeneuve
 * @author Tristan Nogaret
 */
public abstract class MenuItem extends JMenuItem {

    /**
     * TODO
     */
    IhmPdf parent;

    /**
     * TODO
     *
     * @param parent Référence de la fenêtre qui possède l'instance de ce MenuItem
     * @param name Nom de l'action
     */
    public MenuItem(IhmPdf parent, String name) {
        super(name);
        this.parent = parent;
        addActionListener(this::action);
        RaccourcisClavier.listeMenuItems.add(this);
    }

    protected abstract void action(ActionEvent evt);

//    public void setRaccourcis(int key) {
//        KeyStroke raccourcis.save = KeyStroke.getKeyStroke((char) key);
//        setAccelerator(raccourcis.save);
//
//        RaccourcisClavier.raccourcis.save.put(this.getText(), raccourcis.save);
//        RaccourcisClavier.gestionnaireRaccourcis.put(this, this.getText());
//    }

//    public void setRaccourcis(int key, int mask) {
//        KeyStroke raccourcis.save = KeyStroke.getKeyStroke(key, mask);
//        setAccelerator(raccourcis.save);
//
//        RaccourcisClavier.raccourcis.save.put(this.getText(), raccourcis.save);
//        RaccourcisClavier.gestionnaireRaccourcis.put(this, this.getText());
//    }



}
