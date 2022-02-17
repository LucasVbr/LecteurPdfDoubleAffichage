package lecteur_pdf.menuBar.menuItems;

import lecteur_pdf.IhmPdf;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class FermerFichier extends JMenuItem {

    IhmPdf parent;

    public FermerFichier(IhmPdf parent) {
        super("Fermer");
        this.parent = parent;

        addActionListener(e -> {parent.fermerFichier();});

        KeyStroke raccourciFermer = KeyStroke.getKeyStroke(KeyEvent.VK_X,
                                                           KeyEvent.CTRL_DOWN_MASK);
        setAccelerator(raccourciFermer);

    }
}
