package lecteur_pdf.menuBar.menuItems;

import lecteur_pdf.IhmPdf;

import java.awt.event.KeyEvent;

public class ZoomDefaut extends MenuItem {

    public ZoomDefaut(IhmPdf parent) {
        super(parent, "Zoom 100%");

        addActionListener(e -> {
            parent.getPdfPanel().updateScale(1.0f);
            parent.validate();
        });

        setRaccourcis(KeyEvent.VK_L, KeyEvent.CTRL_DOWN_MASK);

    }

}
