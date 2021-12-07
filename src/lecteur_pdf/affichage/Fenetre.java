/*
 * Fenetre, 22/11/2021
 * IUT Rodez 2021, INFO2
 * pas de copyright, aucun droits
 */

package lecteur_pdf.affichage;

import lecteur_pdf.document.PDF;
import lecteur_pdf.menu.Menu;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * classe correspondant à l’objet Fenêtre
 *
 * @author Léo FRANCH
 * @author Tristan NOGARET
 * @author Lucàs VABRE
 * @author Noé VILLENEUVE
 * @version 1.0
 */

public class Fenetre extends JFrame {

    /**
     * TODO
     */
    private final String TITRE = "Lecteur PDF";

    /**
     * TODO
     */
    private Menu menu;

    /**
     * TODO
     */
    private File fichier;

    public PDF documentPDF;

    private boolean affichageVertical;

    /**
     * TODO
     */
    public Fenetre() {

        /* Change le style de la fenêtre */
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException
                     | InstantiationException
                     | IllegalAccessException
                     | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        // Création du menu
        menu = new Menu(this);
        this.setJMenuBar(menu);

        this.affichageVertical = true;

        setup();
    }

    public void setup() {
        setTitle(TITRE);

        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        dechargerPDF();
        revalidate();
        repaint();
    }

    /**
     * TODO
     *
     * @param fichier
     */
    public void chargerPDF(File fichier) throws IOException {
        dechargerPDF();

        this.fichier = fichier;

        /* Crée le panel qui contient le document PDF */
        JPanel pdfPanel = new JPanel();
        /* Crée l’élément scrollable */
        JScrollPane scrollPane = new JScrollPane(pdfPanel);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        scrollPane.getHorizontalScrollBar().setUnitIncrement(16);
        this.add(scrollPane, BorderLayout.CENTER);

        documentPDF = new PDF(fichier, affichageVertical);
        pdfPanel.add(documentPDF);

        /* Charge les pages */
        documentPDF.loadPages();

        /* Met à jour la page */
        this.setTitle(TITRE + " | " + fichier.getName());
        this.validate();
        this.pack();
        this.setLocationRelativeTo(null);
    }

    /**
     *
     * @throws IOException
     */
    public void rechargerPDF() throws IOException {
        rechargerPDF(1.0f);
    }

    /**
     *
     * @param zoom
     * @throws IOException
     */
    public void rechargerPDF(float zoom) throws IOException {
        dechargerPDF();

        /* Crée le panel qui contient le document PDF */
        JPanel pdfPanel = new JPanel();
        /* Crée l’élément scrollable */
        JScrollPane scrollPane = new JScrollPane(pdfPanel);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        scrollPane.getHorizontalScrollBar().setUnitIncrement(16);
        this.add(scrollPane);

        documentPDF = new PDF(fichier, affichageVertical);
        documentPDF.setZoom(zoom);
        pdfPanel.add(documentPDF);

        /* Charge les pages */
        documentPDF.loadPages();

        /* Met à jour la page */
        this.setTitle(TITRE + " | " + fichier.getName());
        this.validate();
        this.pack();
        this.setLocationRelativeTo(null);
    }

    /**
     *
     */
    public void dechargerPDF() {
        if (this.getContentPane() != null) {
            this.getContentPane().removeAll();
            documentPDF = null;
        }
    }

    public boolean haveDocument() {
        return documentPDF != null;
    }

    public void setAffichageVertical(boolean affichageVertical) {
        this.affichageVertical = affichageVertical;
    }

    public boolean isAffichageVertical() {
        return affichageVertical;
    }

    /**
     * TODO comment main
     *
     * @param args non utilisé
     */
    public static void main(String[] args) {
        new Fenetre();
    }
}