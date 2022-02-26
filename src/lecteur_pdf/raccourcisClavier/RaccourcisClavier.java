package lecteur_pdf.raccourcisClavier;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class RaccourcisClavier extends JFrame {

    public static Map<String, KeyStroke> raccourcis
        = new HashMap<>();

    public static Map<JMenuItem, String> gestionnaireRaccourcis =
        new HashMap<>();

    public RaccourcisClavier() {
        super("Modification des raccourcis claviers");
        JPanel panel = new JPanel();
        for (String nomOptions : raccourcis.keySet()) {
            panel.add(new ligneRaccourci(nomOptions,
                                         (char) raccourcis.get(nomOptions).getKeyCode(),
                                   false));
        }
        add(panel);
        pack();
        setSize(500, 500);
        setResizable(false);
        setVisible(true);
    }
}
