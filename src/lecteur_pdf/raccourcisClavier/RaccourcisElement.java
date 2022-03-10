/*
 * RaccourcisElement.java 10/03/2022
 * IUT Rodez 2021-2022, INFO 2
 * Pas de copyright, aucun droits
 */

package lecteur_pdf.raccourcisClavier;

import lecteur_pdf.Popup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Element de raccourcis qui définit un raccourcis pour une propriété de l'application
 *
 * @author Léo Franch
 * @author Lucas Vabre
 * @author Noé Villeneuve
 * @author Tristan Nogaret
 */
public class RaccourcisElement extends JPanel {

    /** Le nom du MenuItem */
    private final String nom;

    /** Le boutton qui contiens en valeur la séquence de touches correspondant au raccourcis du MenuItem de l'application */
    private final JButton btnRaccourcis;

    /** Le raccourcis clavier */
    private KeyStroke raccourcis;

    /**
     * Crée un nouveau JPanel conportant une ligne et deux colonnes
     * Dans la première colonne on trouve un Label qui défini le MenuItem
     * Dans la seconde colonne on trouve le boutton pour éditer le raccourcis clavier
     *
     * @param nom Le nom du MenuItem ciblé
     * @param raccourcis Le raccourcis clavier actuel du MenuItem ciblé
     */
    public RaccourcisElement(String nom, KeyStroke raccourcis) {
        super(new GridLayout(1, 2));

        this.nom = nom;
        this.raccourcis = raccourcis;

        /* Interface */
        JLabel nomElement = new JLabel(nom);
        System.out.println(raccourcis);
        btnRaccourcis = new JButton(keystrokeToString(raccourcis));
        add(nomElement);
        add(btnRaccourcis);

        btnRaccourcis.addActionListener(this::action);
    }

    /**
     * Action lors du clic sur le boutton d'édition du raccourcis
     *
     * @param evt écouteur d'évènement
     */
    public void action(ActionEvent evt) {
        if (!RaccourcisClavier.saisieBloquee) {
            RaccourcisClavier.saisieBloquee = true;
            btnRaccourcis.setText(" --- ");

            btnRaccourcis.addKeyListener(new KeyListener() {

                /** Valeur qui permet de définir si une touche n'est pas reconnue */
                private static final int INDETERMINATE = -1;

                /** La valeur de la touche pressé precedament */
                private int previousKeyPressed = INDETERMINATE;

                @Override
                public void keyPressed(KeyEvent evt) {
                    if (previousKeyPressed == INDETERMINATE) previousKeyPressed = evt.getKeyCode();
                    else if (previousKeyPressed != evt.getKeyCode()
                            && isMaskValide(previousKeyPressed)
                            && !isMaskValide(evt.getKeyCode())) {

                        KeyStroke ks = KeyStroke.getKeyStroke(evt.getKeyCode(), getMask(previousKeyPressed));

                        /* Vérifie que ce raccourci clavier n'existe pas */
                        if (!RaccourcisClavier.raccourcis.containsValue(ks)) {
                            btnRaccourcis.setText(getMaskString(previousKeyPressed) + " + " + ks.toString().split(" ")[2]);
                            // On modifie la valeur
                            RaccourcisClavier.raccourcis.replace(nom, ks);
                            raccourcis = ks;
                            RaccourcisClavier.affecterRaccourcis();
                            RaccourcisClavier.sauvegarderRaccourcis();
                        } else {
                            final String TITRE_ERREUR = "Erreur raccourcis";
                            final String MESSAGE_ERREUR = "Le raccourcis que vous venez de réaliser est déja affecté à une autre fonctionnalité";

                            Popup.errorPopup(btnRaccourcis, TITRE_ERREUR, MESSAGE_ERREUR);
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

                /**
                 * Methode outils qui permet de convertir la valeur tapée en KeyEvent
                 * @param maskValue Valeur de masque tapé (controle, shift ou alt)
                 * @return Le KeyEvent correspondant
                 */
                private int getMask(int maskValue) {
                    return switch (maskValue) {
                        case 16 -> KeyEvent.SHIFT_DOWN_MASK;
                        case 17 -> KeyEvent.CTRL_DOWN_MASK;
                        default -> KeyEvent.ALT_DOWN_MASK;
                    };
                }

                /**
                 * Méthode outils qui permet de convertir la valeur tapée en Chaine de caractère
                 * @param maskValue Valeur de masque tapé (controle, shift ou alt)
                 * @return La chaine de caractère correspondante
                 */
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

    /**
     * Convertis un Modifieur en chaine de caractère
     * @param modifier valeur du modifieur (Element d'un KeyStroke != KeyEvent)
     * @return La chaine de caractère correspondante
     */
    private String modifierToString(int modifier) {
        return switch (modifier) {
            case 65 -> "SHIFT";
            case 130 -> "CTRL";
            default -> "ALT";
        };
    }

    /**
     * Convertis un raccourcis en chaine de caractère
     * @param keyStroke Le raccourcis en question
     * @return La chaine de caractère construite à partir du raccourcis
     */
    private String keystrokeToString(KeyStroke keyStroke) {
        return modifierToString(keyStroke.getModifiers()) + " + " + keyStroke.toString().split(" ")[2];
    }

    /**
     * Change le raccourcis (visuellement)
     * @param raccourcis Nouveau raccourcis
     */
    public void setRaccourcis(KeyStroke raccourcis) {
        this.raccourcis = raccourcis;
        this.btnRaccourcis.setText(keystrokeToString(raccourcis));
    }
}
