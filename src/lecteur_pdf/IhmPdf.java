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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

/**
 * TODO A compléter
 *
 * @author lucas
 */
public class IhmPdf extends JFrame {

    /* Elements visuels */
    private final PdfPanel pdfPanel;
    private MenuBar menuBar;

    /* Relatif au FullScreen */
    private boolean fullscreen = false;
    private GraphicsDevice device;

    public IhmPdf() throws IOException {
        super(GestionPdf.titreApplication);

        /* Déclaration des attributs */
        menuBar = new MenuBar(this);
        pdfPanel = new PdfPanel();

        /* Hierarchie */
        setContentPane(pdfPanel);
        setJMenuBar(menuBar);

        /* Action à la fermeture de la fenêtre */
        this.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent et) {
                quitter();
            }
        });
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        /* Render de la Frame */
        pack();
        setVisible(true);
    }

    public PdfPanel getPdfPanel() {
        return pdfPanel;
    }

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
        pdfPanel.dechargerPdf();
        GestionPdf.ihmPdfList.remove(this);
        dispose();
        if (GestionPdf.ihmPdfList.size() == 0) {
            System.exit(0);
        }
    }
}
