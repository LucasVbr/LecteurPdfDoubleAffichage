package lecteur_pdf.raccourcisClavier;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class RaccourcisElement extends JPanel {

    private final String nom;
    private final JButton btnRaccourcis;
    private KeyStroke raccourcis;

    public RaccourcisElement(String nom, KeyStroke raccourcis) {
        super(new GridLayout(1, 2));

        this.nom = nom;
        this.raccourcis = raccourcis;

        /* Interface */
        JLabel nomElement = new JLabel(nom);
        btnRaccourcis = new JButton(modifierToString(raccourcis.getModifiers()) + " + " + (char)raccourcis.getKeyCode());
        add(nomElement);
        add(btnRaccourcis);

        btnRaccourcis.addActionListener(this::action);
    }

    public void action(ActionEvent evt) {
        if (!RaccourcisClavier.saisieBloquee) {
            RaccourcisClavier.saisieBloquee = true;
            btnRaccourcis.setText(" --- ");

            btnRaccourcis.addKeyListener(new KeyListener() {

                private static final int INDETERMINATE = -1;
                private int previousKeyPressed = INDETERMINATE;

                @Override
                public void keyPressed(KeyEvent evt) {
                    if (previousKeyPressed == INDETERMINATE) previousKeyPressed = evt.getKeyCode();
                    else if (previousKeyPressed != evt.getKeyCode()
                            && isMaskValide(previousKeyPressed)
                            && !isMaskValide(evt.getKeyCode())) {

                        KeyStroke ks = KeyStroke.getKeyStroke(evt.getKeyCode(), getMask(previousKeyPressed));
                        System.out.println(ks);
                        /* Vérifie que ce raccourcis clavier n'existe pas */
                        if (!RaccourcisClavier.raccourcis.containsValue(ks)) {
                            btnRaccourcis.setText(getMaskString(previousKeyPressed) + " + " + (char)evt.getKeyCode());
                            // On modifie la valeur
                            RaccourcisClavier.raccourcis.replace(nom, ks);
                            raccourcis = ks;
                            RaccourcisClavier.affecterRaccourcis();
                            RaccourcisClavier.sauvegarderRaccourcis();
                        } else {
                            // TODO Erreur cette combinaison de touche est deja utilisé
                            btnRaccourcis.setText(modifierToString(raccourcis.getModifiers()) + " + " + (char)raccourcis.getKeyCode());
                        }

                        btnRaccourcis.removeKeyListener(this);
                        RaccourcisClavier.saisieBloquee = false;
                    }
                }

                @Override
                public void keyTyped(KeyEvent evt) {}

                @Override
                public void keyReleased(KeyEvent evt) {
                    if (previousKeyPressed == evt.getKeyCode()) previousKeyPressed = INDETERMINATE;
                }

                private boolean isMaskValide(int maskValue) {
                    return 16 <= maskValue && maskValue <= 18;
                }

                private int getMask(int maskValue) {
                    return switch (maskValue) {
                        case 16 -> KeyEvent.SHIFT_DOWN_MASK;
                        case 17 -> KeyEvent.CTRL_DOWN_MASK;
                        default -> KeyEvent.ALT_DOWN_MASK;
                    };
                }

                private String getMaskString(int maskValue) {
                    return switch (maskValue) {
                        case 16 -> "SHIFT";
                        case 17 -> "CTRL";
                        default -> "ALT";
                    };
                }
            });
        }
    }

    private String modifierToString(int modifier) {
        return switch (modifier) {
            case 65 -> "SHIFT";
            case 130 -> "CTRL";
            default -> "ALT";
        };
    }

}
