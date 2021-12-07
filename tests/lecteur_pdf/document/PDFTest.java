package lecteur_pdf.document;

import javax.swing.*;
import java.awt.*;
import java.io.File;

class PDFTest {

    /**
     * TODO comment main
     *
     * @param args
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        frame.setSize(300,300);
        frame.setBackground(Color.gray);
        frame.setVisible(true);

        //PDF doc = new PDF(new File("C:/Users/public/test.pdf"));

        //JScrollPane scrollPane = new JScrollPane(doc);
        //scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        //scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        //frame.add(scrollPane);
        frame.validate();
    }

}