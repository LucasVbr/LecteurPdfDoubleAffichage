/*
 * Pdf, 17/11/2021
 * IUT Rodez 2021, INFO2
 * pas de copyright, aucun droits
 */

package lecteur_pdf.document;

import org.apache.pdfbox.pdmodel.PDDocument;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Définis virtuellement un fichier PDF
 *
 * @author Léo FRANCH
 * @author Tristan NOGARET
 * @author Lucàs VABRE
 * @author Noé VILLENEUVE
 */
public class Pdf {

    /**
     * Espacement entre chaque page
     */
    public static final int OFFSET_PAGES = 10; // px

    /**
     * Document PDF chargé
     */
    private final PDDocument document;

    /**
     * Le nombre de pages du document PDF
     */
    private int nbPages;

    /**
     * Les pages du PDF sous forme d’images
     */
    private final ArrayList<Page> pages;

    private int currentPositionY;

    /**
     * Crée un document PDF qui est capable d’être affiché dans une fenêtre
     *
     * @param fichier Le fichier PDF que l’on veut ouvrir
     * @throws IllegalArgumentException si le fichier n’existe pas
     */
    public Pdf(File fichier) throws IOException {
        if (!fichier.exists()) {
            throw new IllegalArgumentException();
        }

        this.pages = new ArrayList<>();
        this.document = PDDocument.load(fichier);
        this.nbPages = 0;

        this.currentPositionY = 0;

        this.loadPages();
    }

    /**
     * Charge toutes les pages du document PDF et les stocke dans la liste
     */
    private void loadPages() {
        for (nbPages = 0; nbPages < document.getNumberOfPages(); nbPages++) {
            try {
                addPage(new Page(document, nbPages));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Ajoute une page dans la liste
     *
     * @param page Page à ajouter dans la liste
     */
    private void addPage(Page page) {
        pages.add(page);
        page.setPosition(0, currentPositionY);
        currentPositionY += (page.getHauteur() + OFFSET_PAGES);
    }

    /**
     * @return un panel scrollable contenant toutes les pages du PDF
     */
    public JScrollPane getRenderView() {
        JPanel panel = new JPanel();
        JScrollPane scrollPane = new JScrollPane(panel);

        for (Page page : pages) {
            panel.add(page.getImage());
        }

        return scrollPane;
    }

    /**
     * @return Le nombre de pages chargées
     */
    public int getNbPages() {
        return nbPages;
    }
}
