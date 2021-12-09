/*
 * PDF, 17/11/2021
 * IUT Rodez 2021, INFO2
 * pas de copyright, aucun droits
 */

package lecteur_pdf.document;

import org.apache.pdfbox.pdmodel.PDDocument;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Définis virtuellement un fichier PDF
 *
 * @author Léo FRANCH
 * @author Tristan NOGARET
 * @author Lucàs VABRE
 * @author Noé VILLENEUVE
 */
public class PDF extends JPanel {

    /** Document chargé */
    private final PDDocument document;

    /** Les pages chargés */
    private final Page[] pages;

    /** Le zoom des pages du document */
    private float zoom;

    /**
     * Crée un document PDF affichable dans une fenêtre
     *
     * @param fichier Le fichier que l’on veut ouvrir
     * @param vertical booléen si true, affiche les pages en vertical,
     *                 sinon horizontal
     * @throws IOException si le fichier n’existe pas
     */
    public PDF(File fichier, boolean vertical) throws IOException {
        document = PDDocument.load(fichier);
        pages = new Page[document.getNumberOfPages()];
        zoom = 1.0f;
        setAlignmentX(Component.CENTER_ALIGNMENT);
        if (vertical) setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    /**
     * Charge toutes les pages du document PDF et les stocke dans le tableau
     */
    public void loadPages() {

        for (int i = 0; i < pages.length; i++) {
            try {
                pages[i] = new Page(document, i, zoom);
                this.add(pages[i]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Défini le zoom des pages du document
     *
     * @param zoom la nouvelle valeur du zoom (1.0f == 100%)
     */
    public void setZoom(float zoom) {
        this.zoom = zoom;
        loadPages();
    }
}
