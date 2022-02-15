package lecteur_pdf.menuBar.menuItems;

import lecteur_pdf.IhmPdf;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class OuvrirFichier extends JMenuItem {

    IhmPdf parent;

    public OuvrirFichier(IhmPdf parent) {
        super("Ouvrir");
        this.parent = parent;

        addActionListener(e -> {
            try {
                parent.ouvrirFichier();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        KeyStroke raccourciOuvrir = KeyStroke.getKeyStroke(KeyEvent.VK_O,
                                                           KeyEvent.CTRL_DOWN_MASK);
        setAccelerator(raccourciOuvrir);
    }
}
