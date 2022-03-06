/*
 * RaccourcisClavier.java, 26/02/2022
 * IUT Rodez 2021-2022, INFO 2
 * pas de copyright, aucun droits
 */

package lecteur_pdf.raccourcisClavier;

import org.w3c.dom.Text;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Gestionnaire des raccourcis claviers de l'application
 *
 * @author Léo Franch
 * @author Lucas Vabre
 * @author Noé Villeneuve
 * @author Tristan Nogaret
 */
public class RaccourcisClavier extends JFrame {

    public static Map<String, KeyStroke> raccourcis = new HashMap<>();

    public static Map<JMenuItem, String> gestionnaireRaccourcis
        = new HashMap<>();

    public RaccourcisClavier() {
        super("Modification des raccourcis claviers");
        JPanel panel = new JPanel();
        for (String nomOptions : raccourcis.keySet()) {
            panel.add(new ligneRaccourci(nomOptions,
                                         (char) raccourcis.get(nomOptions)
                                                          .getKeyCode(),
                                         false));
        }
        add(panel);
        pack();
        setSize(250, 500);
        setResizable(false);
        setVisible(true);
    }
}
