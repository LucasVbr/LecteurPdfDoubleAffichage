package lecteur_pdf;

import lecteur_pdf.menuBar.menuItems.ModeSepare;
import lecteur_pdf.menuBar.menuItems.ModeSynchronise;

public class GestionMode {

    private ModeSepare modeSepare;
    private ModeSynchronise modeSynchronise;

    public GestionMode(ModeSepare separe, ModeSynchronise synchronise) {
        modeSepare = separe;
        modeSynchronise = synchronise;

        /* Mode par défaut */
        setModeSepare();
    }

    public void setModeSepare() {
        modeSepare.setSelected(true);
        modeSynchronise.setSelected(false);
    }

    public void setModeSynchronise() {
        modeSepare.setSelected(false);
        modeSynchronise.setSelected(true);
    }


}
