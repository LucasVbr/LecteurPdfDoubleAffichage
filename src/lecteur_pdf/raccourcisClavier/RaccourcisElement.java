package lecteur_pdf.raccourcisClavier;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class RaccourcisElement extends JPanel {

    JLabel nomElement;
    JButton btnRaccourcis;
    KeyEvent raccourcis;
    JMenuItem menuItem;

    public RaccourcisElement(String nom, JMenuItem menuItem) {
        super(new GridLayout(1, 2));

        nomElement = new JLabel(nom);
        this.menuItem = menuItem;
        btnRaccourcis = new JButton();

        add(nomElement);
        add(btnRaccourcis);

        btnRaccourcis.addActionListener(this::action);

//        this.setVisible(false);
    }

    public void action(ActionEvent evt) {
        // TODO ecoute la frappe de clavier et change le raccourcis
//        KeyListener kl = new KeyListener() {
//            @Override
//            public void keyTyped(KeyEvent e) {}
//
//            @Override
//            public void keyPressed(KeyEvent e) {
//                setCaractereRaccourcis(e.getKeyChar());
//            }
//
//            @Override
//            public void keyReleased(KeyEvent e) {}
//        };
//        addKeyListener(kl);
//        removeKeyListener(kl);
//        btnRaccourcis.setText(String.valueOf(caractereRaccourcis));
//    }
//
//    public void setMenuItem(JMenuItem menuItem) {
//        this.menuItem = menuItem;
//        this.setVisible(true);
//    }
//
//    public void setCaractereRaccourcis(char caractereRaccourcis) {
//        this.caractereRaccourcis = caractereRaccourcis;
//        menuItem.setAccelerator(KeyStroke.getKeyStroke(caractereRaccourcis, KeyEvent.CTRL_DOWN_MASK));
    }
}
