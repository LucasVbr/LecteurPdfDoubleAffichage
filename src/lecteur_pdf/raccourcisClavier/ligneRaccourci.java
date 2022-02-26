/*
 * ligneRaccourci.java, 25/02/2022
 * IUT Rodez 2022-2022, INFO2
 * pas de copyright, aucun droits
 */

package lecteur_pdf.raccourcisClavier;

import javax.swing.*;

/**
 * TODO class comment
 */
public class ligneRaccourci extends JPanel {
    private JLabel raccourciLabel;
    private JTextField inputTextField;
    private JCheckBox ctrlCheckBox;
    private JPanel optionsRaccourcis;

    public ligneRaccourci(String labelName, char raccourcis, boolean ctrl) {
        raccourciLabel.setText(labelName);
        inputTextField.setText(String.valueOf(raccourcis));
        ctrlCheckBox.setSelected(ctrl);
        add(optionsRaccourcis);
    }

    public JLabel getRaccourciLabel() {
        return raccourciLabel;
    }

    public JTextField getInputTextField() {
        return inputTextField;
    }

    public JCheckBox getCtrlCheckBox() {
        return ctrlCheckBox;
    }
}
