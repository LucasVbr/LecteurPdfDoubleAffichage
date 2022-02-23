package lecteur_pdf;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GestionPdf {
    public static boolean modeDoubleAffichage = false;
    public static boolean modeSynchronise = false;
    public static final int maxPdf = 2;
    public static final List<IhmPdf> ihmPdfList = new ArrayList<>();

    public static void newIhmPdf() {
        if (ihmPdfList.size() >= maxPdf) {
            throw new IllegalStateException();
        }

        try {
            IhmPdf ihm = new IhmPdf(SelectionnerFichier.ouvrirFichier());
            ihmPdfList.add(ihm);
        } catch (IOException ignored) {}

        modeDoubleAffichage = ihmPdfList.size() >= 2;
    }

    public static void main(String[] args) {
        newIhmPdf();
    }

    public static void nextPages() {
        for (IhmPdf ihm : ihmPdfList) {
            ihm.pdfPanel.nextPage();
        }
    }

    public static void previousPages() {
        for (IhmPdf ihm : ihmPdfList) {
            ihm.pdfPanel.previousPage();
        }
    }
}
