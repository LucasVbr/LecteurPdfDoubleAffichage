/*
 * PdfLoader.java, 26/02/2022
 * IUT Rodez 2021-2022, INFO 2
 * pas de copyright, aucun droits
 */

package lecteur_pdf.pdf;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * TODO commentaires
 *
 * @author Léo Franch
 * @author Lucas Vabre
 * @author Noé Villeneuve
 * @author Tristan Nogaret
 */
public class PdfLoader {

    /**
     * TODO
     */
    PDDocument document;

    /**
     * TODO
     */
    PDFRenderer renderer;

    /**
     * TODO
     *
     * @param file
     * @throws IOException
     */
    public PdfLoader(File file) throws IOException {
        document = PDDocument.load(file);
        renderer = new PDFRenderer(document);
    }

    /**
     * TODO
     *
     * @return
     */
    public int getNbPages() {
        return document.getNumberOfPages();
    }

    /**
     * TODO
     *
     * @param pageIndex
     * @param scale
     * @return
     * @throws IOException
     */
    public BufferedImage renderPage(int pageIndex, float scale) throws IOException {
        if (pageIndex < 0 || pageIndex >= this.getNbPages()) {
            throw new IllegalArgumentException();
        }
        return renderer.renderImage(pageIndex, scale);
    }

    /**
     * TODO
     */
    public void close() {
        try {
            renderer = null;
            document.close();
        } catch (IOException ignored) {
        }
    }

    /**
     * TODO
     *
     * @param file
     */
    public void load(File file) {
        try {
            document = PDDocument.load(file);
        } catch (IOException ignored) {
        }
    }
}
