package lecteur_pdf.menuBar.menuItems;

import lecteur_pdf.IhmPdf;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class ZoomDefaut extends JMenuItem {

    IhmPdf parent;

    public ZoomDefaut(IhmPdf parent) {
        super("Zoom 100%");
        this.parent = parent;

        KeyStroke raccourciZoomDefaut = KeyStroke.getKeyStroke(KeyEvent.VK_L,
                                                               KeyEvent.CTRL_DOWN_MASK);
        setAccelerator(raccourciZoomDefaut);
        addActionListener(e -> {parent.zoomDefaut();});

    }

}
