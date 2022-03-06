/*
 * ligneRaccourci.java, 25/02/2022
 * IUT Rodez 2022-2022, INFO2
 * pas de copyright, aucun droits
 */

package lecteur_pdf.raccourcisClavier;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.Scanner;

///**
// * TODO class comment
// */
//public class ligneRaccourci extends JPanel implements ActionListener {
//    private JLabel raccourciLabel;
//    private JPanel optionsRaccourcis;
//    private JButton inputButton;
//
//    Scanner entree = new Scanner(System.in);
//
//    public ligneRaccourci(String labelName, char raccourcis) {
//        raccourciLabel.setText(labelName);
//        inputButton.setText(String.valueOf(raccourcis));
//        add(optionsRaccourcis);
//        inputButton.addActionListener(this);
//    }
//
//    public JLabel getRaccourciLabel() {
//        return raccourciLabel;
//    }
//
//    public JButton getInputButton() {
//        return inputButton;
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        inputButton.setText(
//            String.valueOf(entree.next().charAt(0)).toUpperCase(Locale.ROOT));
//    }
//}