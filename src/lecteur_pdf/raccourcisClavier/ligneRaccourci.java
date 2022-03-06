/*
 * ligneRaccourci.java, 25/02/2022
 * IUT Rodez 2022-2022, INFO2
 * pas de copyright, aucun droits
 */

package lecteur_pdf.raccourcisClavier;

import javax.swing.*;
import java.util.Locale;

/**
 * TODO class comment
 */
public class ligneRaccourci extends JPanel {
    private JLabel raccourciLabel;
    private JPanel optionsRaccourcis;
    private JButton inputButton;

    public ligneRaccourci(String labelName, char raccourcis) {
        raccourciLabel.setText(labelName);
        inputButton.setText(String.valueOf(raccourcis)/*.toUpperCase(Locale
        .ROOT)*/);
        add(optionsRaccourcis);
    }

    public JLabel getRaccourciLabel() {
        return raccourciLabel;
    }

    public JButton getInputButton() {
        return inputButton;
    }
}