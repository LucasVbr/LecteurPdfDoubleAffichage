package lecteur_pdf_swing.pdf;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PdfLoader {
    PDDocument document;
    PDFRenderer renderer;

    public PdfLoader(File file) throws IOException {
        document = PDDocument.load(file);
        renderer = new PDFRenderer(document);
    }

    public int getNbPages() {
        return document.getNumberOfPages();
    }

    public BufferedImage renderPage(int pageIndex, float scale) throws IOException {
        if (pageIndex < 0 || pageIndex >= this.getNbPages()) {
            throw new IllegalArgumentException();
        }
        return renderer.renderImage(pageIndex, scale);
    }

    public void close() {
        try {
            document.close();
        } catch(IOException ignored) {}
    }

    public void load(File file) {
        try {
            document = PDDocument.load(file);
        } catch (IOException ignored) {}
    }

}
