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

    /** Titre de la fenêtre */
    private final String TITRE = "Lecteur PDF";

    /** Le menu de la fenêtre */
    private Menu menu;

    /** Le fichier courant */
    private File fichier;

    /** Le document PDF courant */
    public PDF documentPDF;

    /** Définit la disposition d'affichage des pages du document PDF */
    private boolean affichageVertical;

    /** Définit l'état de la fenêtre, true si la fenêtre est en plein écran */
    private boolean fullscreen;

    /**
     * Crée une nouvelle fenêtre contenant un Menu
     */
    public Fenetre() {

        /* Change le style de la fenêtre */
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        /* Création du menu */
        menu = new Menu(this);
        this.setJMenuBar(menu);

        /* permet de définir le mode plein écran comme désactivé lors du
        lancement de la fenêtre */
        fullscreen = false;

        /* Définis l'affichage Vertical comme affichage par défaut */
        this.affichageVertical = true;

        /* Initialise l'état par défaut de la fenêtre */
        setup();
    }

    /**
     * Fonction utilitaire qui permet de définir l'état par défaut de la fenêtre
     */
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
     * Charge le document PDF courant si possible
     *
     * @throws IOException Si l'on arrive pas a charger le PDF
     */
    public void chargerPDF() throws IOException {
        if (haveDocument()) chargerPDF(fichier, 1.0f);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    /**
     * Charge le document PDF courant avec un zoom spécifique si possible
     *
     * @param zoom La taille du zoom sur les pages
     * @throws IOException Si l'on arrive pas a charger le PDF
     */
    public void chargerPDF(float zoom) throws IOException {
        if (haveDocument()) chargerPDF(fichier, zoom);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    /**
     * Charge un document PDF
     *
     * @param fichier Le fichier PDF à afficher dans la fenêtre
     * @throws IOException Si l'on arrive pas a charger le PDF
     */
    public void chargerPDF(File fichier) throws IOException {
        chargerPDF(fichier, 1.0f);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    /**
     * Charge un document PDF
     *
     * @param fichier Le fichier PDF à afficher dans la fenêtre
     * @param zoom La taille du zoom sur les pages
     * @throws IOException Si l'on arrive pas a charger le PDF
     */
    public void chargerPDF(File fichier, float zoom) throws IOException {
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
        documentPDF.setZoom(zoom);
        pdfPanel.add(documentPDF);

        /* Met à jour la page */
        this.setTitle(TITRE + " | " + fichier.getName());
        this.validate();
        this.pack();
        this.setLocationRelativeTo(null);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

    }

    /**
     * Supprime le PDF de la fenêtre
     */
    public void dechargerPDF() {
        if (this.getContentPane() != null) {
            this.getContentPane().removeAll();
            documentPDF = null;
        }
    }

    /**
     * Prédicat qui vérifie si un PDF est affiché dans la fenêtre
     *
     * @return true si le prédicat est vérifié, false sinon
     */
    public boolean haveDocument() {
        return documentPDF != null;
    }

    /**
     * Définis le mode d'affichage du PDF
     *
     * @param affichageVertical true pour un affichage Vertical, false pour
     *                          un affichage horizontal
     */
    public void setAffichageVertical(boolean affichageVertical) {
        this.affichageVertical = affichageVertical;
    }

    /**
     * Prédicat qui vérifie si la fenêtre est en mode plein écran
     * @return true si le prédicat est vérifié, false sinon
     */
    public boolean isFullscreen() {
        return fullscreen;
    }

    /**
     * Affiche la fenêtre en plein écran lorsqu'elle ne l'est pas et repasse
     * en mode fenêtré si le mode plein écran est activé
     */
    public void setFullscreen() {
        GraphicsEnvironment graphics =
            GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice device = graphics.getDefaultScreenDevice();

        dispose();
        fullscreen = !fullscreen;
        if (fullscreen) {
            setUndecorated(true);
            device.setFullScreenWindow(this);
        } else {
            device.setFullScreenWindow(null);
            setUndecorated(false);
        }
        setVisible(true);
        repaint();
    }
}