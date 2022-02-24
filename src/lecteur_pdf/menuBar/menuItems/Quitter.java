package lecteur_pdf.menuBar.menuItems;

import lecteur_pdf.IhmPdf;

import java.awt.event.KeyEvent;

public class Quitter extends MenuItem {

    public Quitter(IhmPdf parent) {
        super(parent, "Quitter");

        addActionListener(e -> {
            parent.quitter();
        });

        setRaccourcis(KeyEvent.VK_Q, KeyEvent.CTRL_DOWN_MASK);
    }

}
