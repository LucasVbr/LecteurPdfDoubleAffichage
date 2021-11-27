/*
 * PDF, 17/11/2021
 * IUT Rodez 2021, INFO2
 * pas de copyright, aucun droits
 */

package lecteur_pdf.document;

import org.apache.pdfbox.pdmodel.PDDocument;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

/**
 * Définis virtuellement un fichier PDF
 *
 * @author Léo FRANCH
 * @author Tristan NOGARET
 * @author Lucàs VABRE
 * @author Noé VILLENEUVE
 */
public class PDF extends JPanel {

    /**
     * Espacement entre chaque page
     */
    public static final int OFFSET_PAGES = 10; // px

    /**
     * Document PDF chargé
     */
    private final PDDocument document;

    /**
     * Les pages du PDF sous forme de JLabel contenant des images
     */
    private final Page[] pages;

    /**
     * Crée un document PDF qui est capable d’être affiché dans une fenêtre
     *
     * @param fichier Le fichier PDF que l’on veut ouvrir
     * @throws IllegalArgumentException si le fichier n’existe pas
     */
    public PDF(File fichier) throws IOException {
        if (!fichier.exists()) {
            throw new IllegalArgumentException();
        }

        // this.container = new JPanel();

        this.document = PDDocument.load(fichier);
        this.pages = new Page[document.getNumberOfPages()];

        this.loadPages();
    }

    /**
     * Charge toutes les pages du document PDF et les stocke dans le tableau
     */
    private void loadPages() {
        int currentPositionY = 0;

        for (int i = 0; i < pages.length; i++) {
            try {
                /* Crée un JLabel de la page */
                pages[i] = new Page(document, i);

                /* Défini sa position dans le panel et l’ajoute au panel */
                pages[i].setLocation(0, currentPositionY);
                System.out.println(pages[i].getLocation());
                currentPositionY += (pages[i].getHauteur() + OFFSET_PAGES);
                this.add(pages[i]);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @return Le nombre de pages chargées
     */
    public int getNbPages() {
        return document.getNumberOfPages();
    }
}
