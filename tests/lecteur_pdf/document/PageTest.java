package lecteur_pdf.document;

import org.apache.pdfbox.pdmodel.PDDocument;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

class PageTest {

    public static void testPage() {
        try {
            PDDocument document = PDDocument.load(
                new File("Documents_PDF/paysage_35pages.pdf"));
            JFrame frame = new JFrame();
            frame.setVisible(true);
            frame.add(new Page(document, 0, 1.0f));
            frame.pack();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void testPageZoom() {
        try {
            PDDocument document = PDDocument.load(
                new File("Documents_PDF/paysage_35pages.pdf"));
            JFrame frame = new JFrame();
            frame.setVisible(true);
            frame.add(new Page(document, 0, 2.0f));
            frame.pack();

            JFrame frame2 = new JFrame();
            frame2.setVisible(true);
            frame2.add(new Page(document, 0, 0.5f));
            frame2.pack();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Lance les methodes de tests
     *
     * @param args non utilisé
     */
    public static void main(String[] args) {
        testPage();
        testPageZoom();
    }
}