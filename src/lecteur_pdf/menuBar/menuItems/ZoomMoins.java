package lecteur_pdf.menuBar.menuItems;

import lecteur_pdf.IhmPdf;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class ZoomMoins extends JMenuItem {

    IhmPdf parent;

    public ZoomMoins(IhmPdf parent) {
        super("Zoom 50%");
        this.parent = parent;

        KeyStroke raccourciZoomMoins = KeyStroke.getKeyStroke(KeyEvent.VK_K,
                                                              KeyEvent.CTRL_DOWN_MASK);
        setAccelerator(raccourciZoomMoins);
        addActionListener(e -> {parent.zoomMoins();});

    }
}
