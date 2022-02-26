/*
 * Quitter.java, 26/02/2022
 * IUT Rodez 2021-2022, INFO 2
 * pas de copyright, aucun droits
 */

package lecteur_pdf.menuBar.menuItems;

import lecteur_pdf.IhmPdf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * TODO commentaires
 *
 * @author Léo Franch
 * @author Lucas Vabre
 * @author Noé Villeneuve
 * @author Tristan Nogaret
 */
public class Quitter extends MenuItem {

    /**
     * TODO
     * @param parent
     */
    public Quitter(IhmPdf parent) {
        super(parent, "Quitter");

        addActionListener(e -> {
            JDialog jd = new JDialog();
            jd.setLayout(new FlowLayout());
            jd.setBounds(500,300,400,100);
            JLabel jlabel = new JLabel("etes vous sûr de vouloir quitter ? ");
            JButton oui = new JButton("oui");
            oui.addActionListener(m -> {
                parent.quitter();
                jd.setVisible(false);
            });
            JButton non = new JButton("non");
            non.addActionListener(n -> jd.setVisible(false));
            jd.add(jlabel);
            jd.add(oui);
            jd.add(non);
            jd.setVisible(true);

        });

        setRaccourcis(KeyEvent.VK_Q, KeyEvent.CTRL_DOWN_MASK);
    }

}
