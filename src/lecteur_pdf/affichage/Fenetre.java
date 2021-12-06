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

    /**
     * TODO
     */
    public Fenetre() {

        /* Change le style de la fenêtre */
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException
                 | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        // Création du menu
        menu = new Menu(this);

        this.setTitle(TITRE);

        // Ajout de la barre de menu au frame

        this.setJMenuBar(menu);

        this.setSize(300, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    /**
     * TODO
     *
     * @param fichier
     */
    public void chargerPDF(File fichier) {
        dechargerPDF();

        this.fichier = fichier;

        /* Crée le panel qui contient le document PDF */
        JPanel pdfPanel = new JPanel();
        /* Crée l’élément scrollable */
        JScrollPane scrollPane = new JScrollPane(pdfPanel);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        scrollPane.getHorizontalScrollBar().setUnitIncrement(16);
        this.add(scrollPane, BorderLayout.CENTER);

        documentPDF = new PDF(fichier);
        pdfPanel.add(documentPDF);

        /* Ajoute le scrollPane et le centre dans la page */

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
    public void rechargerPDF(float zoom) {
        dechargerPDF();

        /* Crée le panel qui contient le document PDF */
        JPanel pdfPanel = new JPanel();
        /* Crée l’élément scrollable */
        JScrollPane scrollPane = new JScrollPane(pdfPanel);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        scrollPane.getHorizontalScrollBar().setUnitIncrement(16);
        this.add(scrollPane, BorderLayout.CENTER);

        documentPDF = new PDF(fichier);
        documentPDF.setZoom(zoom);
        pdfPanel.add(documentPDF);

        /* Ajoute le scrollPane et le centre dans la page */

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
        }
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