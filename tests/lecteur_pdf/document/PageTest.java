package lecteur_pdf.document;

import org.apache.pdfbox.pdmodel.PDDocument;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

class PageTest {

    /**
     * Test du constructeur {@link Page#Page(PDDocument, int)}
     *
     * @param args non utilisé
     */
    public static void main(String[] args) throws IOException {
        /* Mise en place du JFrame de test */
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setSize(300, 300);
        frame.setBackground(Color.gray);
        frame.setVisible(true);

        /* Creation de l’objet Page */
        PDDocument document = PDDocument.load(new File("F:/paysage_35pages.pdf"));
        Page page = new Page(document, 0);

        /* Ajout de l’objet dans la frame et mise à jour de la frame */
        frame.add(page);
        frame.validate();
    }
}