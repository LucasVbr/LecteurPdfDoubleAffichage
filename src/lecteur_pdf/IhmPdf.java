/*
 * Ihm, 03/02/2022
 * IUT Rodez 2022, INFO2
 * pas de copyright, aucun droits
 */

package lecteur_pdf;

import lecteur_pdf.menuBar.MenuBar;
import lecteur_pdf.pdf.PdfPanel;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * TODO A compléter
 *
 * @author lucas
 */
public class IhmPdf extends JFrame {

    PdfPanel pdfPanel;
    MenuBar menuBar;

    public IhmPdf(File pdfFile) throws IOException {
        super(pdfFile.getName());

        /* Déclaration des attributs */
        menuBar = new MenuBar(this);
        pdfPanel = new PdfPanel(pdfFile);

        /* Hierarchie */
        setContentPane(pdfPanel);
        setJMenuBar(menuBar);

        /* Render de la Frame */
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public void fermerFichier() {
        try {
            pdfPanel = new PdfPanel(null);
            validate();
        } catch (IOException ignored) {
        }
    }

    public PdfPanel getPdfPanel() {
        return pdfPanel;
    }

    public void ouvrirFichier() throws IOException {
        File fichier = SelectionnerFichier.ouvrirFichier();
        pdfPanel = new PdfPanel(fichier);
        validate();
    }

    private boolean fullscreen = false;
    private GraphicsDevice device;

    public void pleinEcran() {
        // Switch de disposition
        fullscreen = !fullscreen;
        if (fullscreen) { // Set fullscreen
            GraphicsEnvironment graphics =
                GraphicsEnvironment.getLocalGraphicsEnvironment();
            device = graphics.getDefaultScreenDevice();
            device.setFullScreenWindow(this);
        } else { // remove fullscreen
            device.setFullScreenWindow(null);
            setUndecorated(false);
            setVisible(true);
        }
    }

    public void quitter() {
        dispose();
    }

    public void zoomDefaut() {
        pdfPanel.updateScale(1.0f);
        validate();
    }

    public void zoomMoins() {
        pdfPanel.updateScale(0.5f);
        validate();
    }

    public void zoomPlus() {
        pdfPanel.updateScale(1.5f);
        validate();
    }
}
