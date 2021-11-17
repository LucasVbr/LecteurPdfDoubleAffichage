/*
 * Pdf, 17/11/2021
 * IUT Rodez 2021, INFO2
 * pas de copyright, aucun droits
 */

package lecteur_pdf.document;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;

/**
 * Définis virtuellement un fichier PDF
 *
 * @author Lucas
 */
public class Pdf {

    /** Espacement entre chaque page */
    public static final int OFFSET_PAGES = 10; // px

    /** Document PDF chargé */
    private PDDocument document;

    /** Le nombre de pages du document PDF */
    private int nbPages;

    /** Les pages du PDF sous forme d’images */
    private ArrayList<Page> page;

    /**
     * Crée un document PDF qui est capable d’être affiché dans une fenêtre
     * @param fichier Le fichier PDF que l’on veut ouvrir
     * @throws IllegalArgumentException si le fichier n’existe pas
     */
    public Pdf(File fichier) {
        // TODO
    }

    public int getNbPages() {
        return nbPages;
    }

    /**
     * @return un panel scrollable contenant toutes les pages du PDF
     */
    public JScrollPane getRenderView() {
        // TODO
        return null; // Bouchon
    }

}
