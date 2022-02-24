package lecteur_pdf.menuBar.menuItems;

import lecteur_pdf.IhmPdf;
import lecteur_pdf.RaccourcisClavier;

import javax.swing.*;

public class MenuItem extends JMenuItem {
    IhmPdf parent;

    public MenuItem(IhmPdf parent, String name) {
        super(name);
        this.parent = parent;

    }

    public void setRaccourcis(int key) {
        KeyStroke raccourcis = KeyStroke.getKeyStroke((char)key);
        setAccelerator(raccourcis);

        RaccourcisClavier.gestionnaireRaccourcis.put(this, raccourcis);
    }

    public void setRaccourcis(int key, int mask) {
        KeyStroke raccourcis = KeyStroke.getKeyStroke(key, mask);
        setAccelerator(raccourcis);

        RaccourcisClavier.gestionnaireRaccourcis.put(this, raccourcis);
    }
}
