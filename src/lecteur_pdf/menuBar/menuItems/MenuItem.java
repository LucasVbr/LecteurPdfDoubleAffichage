/*
 * MenuItem.java, 26/02/2022
 * IUT Rodez 2021-2022, INFO 2
 * pas de copyright, aucun droits
 */

package lecteur_pdf.menuBar.menuItems;

import lecteur_pdf.IhmPdf;
import lecteur_pdf.raccourcisClavier.RaccourcisClavier;

import javax.swing.*;

/**
 * TODO commentaires
 *
 * @author Léo Franch
 * @author Lucas Vabre
 * @author Noé Villeneuve
 * @author Tristan Nogaret
 */
public class MenuItem extends JMenuItem {

    /**
     * TODO
     */
    IhmPdf parent;

    /**
     * TODO
     *
     * @param parent Référence de la fenêtre qui possède l'instance de ce MenuItem
     * @param name
     */
    public MenuItem(IhmPdf parent, String name) {
        super(name);
        this.parent = parent;

    }

    /**
     * TODO
     *
     * @param key
     */
    public void setRaccourcis(int key) {
        KeyStroke raccourcis = KeyStroke.getKeyStroke((char) key);
        setAccelerator(raccourcis);

        RaccourcisClavier.raccourcis.put(this.getText(), raccourcis);
        RaccourcisClavier.gestionnaireRaccourcis.put(this, this.getText());
    }

    /**
     * TODO
     *
     * @param key
     * @param mask
     */
    public void setRaccourcis(int key, int mask) {
        KeyStroke raccourcis = KeyStroke.getKeyStroke(key, mask);
        setAccelerator(raccourcis);

        RaccourcisClavier.raccourcis.put(this.getText(), raccourcis);
        RaccourcisClavier.gestionnaireRaccourcis.put(this, this.getText());
    }
}
