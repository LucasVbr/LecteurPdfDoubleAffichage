package lecteur_pdf.document;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

class PDFTest {

    /**
     * Test du constructeur {@link PDF#PDF(File)}
     *
     * @param args non utilisé
     */
    public static void main(String[] args) throws IOException {
        /* Mise en place du JFrame de test */
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setSize(300,300);
        frame.setBackground(Color.gray);
        frame.setVisible(true);

        /* Creation de l’objet PDF */
        PDF doc = new PDF(new File("./test_pdf1.pdf"));

        /* Creation du JScrollPane contenant notre PDF pour pouvoir scroller */
        JScrollPane scrollPane = new JScrollPane(doc);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        /* Ajout du ScrollPane dans la frame et mise à jour de la frame */
        frame.add(scrollPane);
        frame.validate();
    }
}