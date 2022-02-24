package lecteur_pdf.menuBar.menuItems;

import lecteur_pdf.IhmPdf;

import java.awt.event.KeyEvent;

public class ZoomPlus extends MenuItem {

    public ZoomPlus(IhmPdf parent) {
        super(parent, "Zoom 150%");

        addActionListener(e -> {
            parent.getPdfPanel().updateScale(1.5f);
            parent.validate();
        });

        setRaccourcis(KeyEvent.VK_M, KeyEvent.CTRL_DOWN_MASK);

    }
}