package lecteur_pdf.menuBar.menuItems;

import lecteur_pdf.IhmPdf;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class Quitter extends JMenuItem {

    IhmPdf parent;

    public Quitter(IhmPdf parent) {
        super("Quitter");
        this.parent = parent;

        addActionListener(e -> {parent.quitter();});

        KeyStroke raccourciQuitter = KeyStroke.getKeyStroke(KeyEvent.VK_Q,
                                                            KeyEvent.CTRL_DOWN_MASK);
        setAccelerator(raccourciQuitter);
    }

}
