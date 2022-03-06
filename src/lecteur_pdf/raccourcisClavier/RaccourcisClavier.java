/*
 * RaccourcisClavier.java, 26/02/2022
 * IUT Rodez 2021-2022, INFO 2
 * pas de copyright, aucun droits
 */

package lecteur_pdf.raccourcisClavier;

import lecteur_pdf.menuBar.menuItems.MenuItem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
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

    public static Map<String, JMenuItem> listeItem = new HashMap<>();

    public final String[][] RACCOURCIS = {
            {"Ouvrir", "o",},
            {"Fermer", "f",},
            {"Quitter", "x",},
            {"Mode Plein Ecran", "p",},
            {"Page Prédédente", "m",},
            {"Page Suivante", "l",},
            {"Zoom 50%", "&",},
            {"Zoom 100%", "é",},
            {"Zoom 150%", "\"",},
            {"Page Entière", "a",},
            {"Pleine Largeur", "z",},
            {"Nouvelle Fenêtre", "n",},
//          {  "Mode Séparé",},
//          {  "Mode Synchronisé",},
            {"Modifier Touches", "!",}
    };

    public RaccourcisClavier() {
        super("Modification des raccourcis claviers");
        JPanel panel = new JPanel(new GridLayout(RACCOURCIS.length, 1, 10, 5));

        System.out.println(listeItem);

        for (int i = 0; i < listeItem.size(); i++) {
            RaccourcisElement raccourcisElement = new RaccourcisElement(RACCOURCIS[i][0], listeItem.get(RACCOURCIS[i][0]));

            // Si l'actions n'as pas de raccourcis, mettre celui par défaut
//            try {
//                listeItem.get(RACCOURCIS[i][0]).getAccelerator();
//            } catch (NullPointerException e) {
//                listeItem.get(RACCOURCIS[i][0]).setAccelerator(KeyStroke.getKeyStroke(RACCOURCIS[i][1].charAt(0), KeyEvent.CTRL_DOWN_MASK));
//            }

            panel.add(raccourcisElement);
        }

        add(new JScrollPane(panel));

//        JPanel panel = new JPanel();
//        for (String nomOptions : raccourcis.keySet()) {
//            panel.add(new ligneRaccourci(nomOptions,
//                                         (char) raccourcis.get(nomOptions)
//                                                          .getKeyCode()));
//        }
//        add(panel);
        pack();
        setMinimumSize(new Dimension(400, 200));
//        setSize(200, 400);
//        setResizable(false);
        setVisible(true);
    }

    private void chargerRaccourcisDefaut() {

    }

    private void chargerRaccourcis() {

    }
}
