package lecteur_pdf_swing;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GestionPdf {
    private static final int maxPdf = 2;
    private static final List<IhmPdf> ihmPdfList = new ArrayList<IhmPdf>();

    public static void newIhmPdf() {
        if (ihmPdfList.size() >= maxPdf) {
            throw new IllegalStateException();
        }

        try {
            IhmPdf ihm = new IhmPdf(SelectionnerFichier.ouvrirFichier());
            ihmPdfList.add(ihm);
        } catch (IOException ignored) {}

    }

    public static void main(String[] args) {
        newIhmPdf();
    }
}
