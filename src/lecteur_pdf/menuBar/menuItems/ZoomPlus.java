package lecteur_pdf_swing.menuBar.menuItems;

import lecteur_pdf_swing.IhmPdf;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class ZoomPlus extends JMenuItem {

    IhmPdf parent;

    public ZoomPlus(IhmPdf parent) {
        super("Zoom 150%");
        this.parent = parent;
        KeyStroke raccourciZoomPlus = KeyStroke.getKeyStroke(KeyEvent.VK_M,
                                                             KeyEvent.CTRL_DOWN_MASK);
        setAccelerator(raccourciZoomPlus);
        addActionListener(e -> {parent.zoomPlus();});

    }
}