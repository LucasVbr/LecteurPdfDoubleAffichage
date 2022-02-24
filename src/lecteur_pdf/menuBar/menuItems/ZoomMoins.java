package lecteur_pdf.menuBar.menuItems;

import lecteur_pdf.IhmPdf;

import java.awt.event.KeyEvent;

public class ZoomMoins extends MenuItem {

    public ZoomMoins(IhmPdf parent) {
        super(parent, "Zoom 50%");

        addActionListener(e -> {
            parent.getPdfPanel().updateScale(0.5f);
            parent.validate();
        });

        setRaccourcis(KeyEvent.VK_K, KeyEvent.CTRL_DOWN_MASK);

    }
}
