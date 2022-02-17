package lecteur_pdf.menuBar.menuItems;

import lecteur_pdf.IhmPdf;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class PleinEcran extends JMenuItem {

    IhmPdf parent;

    public PleinEcran(IhmPdf parent) {
        super("Mode Plein Ecran");
        this.parent = parent;
        KeyStroke raccourciPleinEcran = KeyStroke.getKeyStroke(KeyEvent.VK_F11,
                                                               0);
        setAccelerator(raccourciPleinEcran);
        addActionListener(e -> {parent.pleinEcran();});

    }
}
