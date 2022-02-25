package lecteur_pdf;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GestionPdf {
    public static String titreApplication = "LPDA";

    public static boolean modeDoubleAffichage = false;
    public static boolean modeSynchronise = false;
    public static final int maxPdf = 2;
    public static final List<IhmPdf> ihmPdfList = new ArrayList<>();

    public static void setModeSynchronise(boolean modeSynchronise) {
        for(IhmPdf fenetre : ihmPdfList) {
            if (modeSynchronise) {
                fenetre.getGestionMode().setModeSynchronise();
            } else {
                fenetre.getGestionMode().setModeSepare();
            }
        }
    }

    /**
     * Crée une nouvelle fenêtre
     */
    public static void newIhmPdf() {
        if (ihmPdfList.size() >= maxPdf) {
            // TODO Message erreur "nombre max de fenêtre atteint"
            return;
        }

        try {
            IhmPdf ihm = new IhmPdf();
            ihmPdfList.add(ihm);
        } catch (IOException ignored) {}

        modeDoubleAffichage = ihmPdfList.size() >= 2;
    }

    /**
     * Methode affiche la page suivante en mode Synchronisé
     */
    public static void nextPages() {
        for (IhmPdf ihm : ihmPdfList) {
            ihm.getPdfPanel().nextPage();
        }
    }

    /**
     * Methode affiche la page précédente en mode Synchronisé
     */
    public static void previousPages() {
        for (IhmPdf ihm : ihmPdfList) {
            ihm.getPdfPanel().previousPage();
        }
    }

    public void chargerRaccourcisClaviers() {
        // TODO changer les raccourcis clavier a partir d'un fichier
    }

    public void sauvegarderRaccourcisClaviers() {
        // TODO sauvegarder les raccourcis clavier dans un fichier
    }

    /**
     * Lance l'application
     * @param args non utilisé
     */
    public static void main(String[] args) {
        newIhmPdf();
    }
}
