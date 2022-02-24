package lecteur_pdf.menuBar.menuItems;

import lecteur_pdf.IhmPdf;

import java.awt.event.KeyEvent;

public class PleinEcran extends MenuItem {

    public PleinEcran(IhmPdf parent) {
        super(parent, "Mode Plein Ecran");

        addActionListener(e -> {parent.pleinEcran();});

        setRaccourcis(KeyEvent.VK_F11);

    }
}
