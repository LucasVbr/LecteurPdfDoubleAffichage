/*
 * PdfPanel2.java, 26/02/2022
 * IUT Rodez 2021-2022, INFO 2
 * Pas de copyright, aucun droits
 */

package lecteur_pdf.pdf;

import lecteur_pdf.SelectionnerFichier;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * Interface de la mainframe de l'application sans utilisation de forms
 *
 * @author Léo Franch
 * @author Lucas Vabre
 * @author Noé Villeneuve
 * @author Tristan Nogaret
 */
public class PdfPanel2 extends JFrame {

    public PdfPanel2() {
        super("JScrollPaneExemple");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /* Controls */
        JPanel controlPanel = new JPanel();
        JButton btnPre = new JButton("Precedent");
        JTextField indexPageField = new JTextField();
        JLabel maxPagesLabel = new JLabel("/ -");
        JButton btnSuiv = new JButton("Suivant");

        controlPanel.add(btnPre);
        controlPanel.add(indexPageField);
        controlPanel.add(maxPagesLabel);
        controlPanel.add(btnSuiv);

        /* Vue */
        JPanel view = null;
        try {
            PdfLoader pdfLoader = new PdfLoader(SelectionnerFichier.ouvrirFichier());

            ImageIcon image = new ImageIcon(pdfLoader.renderPage(0, 1.0f));
            JLabel pimage = new JLabel();
            pimage.setIcon(image);

            view = new JPanel();
            view.add(pimage);

        } catch (IOException e) {
            e.printStackTrace();
        }

        JPanel main = new JPanel(new BorderLayout());
        main.add(controlPanel, BorderLayout.PAGE_START);
        JScrollPane jsp = new JScrollPane(view);
        main.add(jsp, BorderLayout.CENTER);

        add(main);

        setLocationRelativeTo(null);
        setVisible(true);
        setSize(300, 300);
    }

    public static void main(String[] args) {
        new PdfPanel2();
    }

}
