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
public class DocumentPdf {

    /** TODO */
    private final PDDocument document;

    /** TODO */
    private PDFRenderer renderer;

    /** TODO */
    private int minWidth;

    /** TODO */
    private int minHeight;

    /**
     * TODO
     *
     * @param file
     * @throws IOException
     */
    public DocumentPdf(File file) throws IOException {
        document = PDDocument.load(file);
        renderer = new PDFRenderer(document);
        minWidth = -1;
        minHeight = -1;
    }

    /**
     * TODO
     */
    public int getMinWidth() {
        return minWidth;
    }

    /**
     * TODO
     */
    public int getMinHeight() {
        return minHeight;
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
     */
    public BufferedImage renderPage(int pageIndex) throws IOException {
        return renderPage(pageIndex, 1.0f);
    }

    /**
     * TODO
     */
    public BufferedImage setScale(float scale) {
        try {
            return renderPage(0, scale);
        } catch (IOException ignored) {}
        return null;
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

        BufferedImage img = renderer.renderImage(pageIndex, scale);

        if (scale == 1.0f && minWidth == -1 && minHeight == -1) {
            minWidth = img.getWidth();
            minHeight = img.getHeight();
        }

        return img;
    }

    /**
     * Ferme le document courrant et redéfini les paramêtres par défaut
     */
    public void close() {
        try {
            renderer = null;
            document.close();
            minWidth = -1;
            minHeight = -1;
        } catch (IOException ignored) {}
    }
}
