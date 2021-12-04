/*
 * PDF, 17/11/2021
 * IUT Rodez 2021, INFO2
 * pas de copyright, aucun droits
 */

package lecteur_pdf.document;

import lecteur_pdf.affichage.Fenetre;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

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

    private List pages;

    /**
     * Crée un document PDF qui est capable d’être affiché dans une fenêtre
     *
     * @param fichier Le fichier PDF que l’on veut ouvrir
     * @throws IllegalArgumentException si le fichier n’existe pas
     */
    public PDF(File fichier) {
        try {
            this.document = PDDocument.load(fichier);
            pages = this.document.getDocumentCatalog().getAllPages();

            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            this.setAlignmentX(Component.CENTER_ALIGNMENT);
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Charge toutes les pages du document PDF et les stocke dans le tableau
     */
    public void loadPages(Fenetre fenetre, int zoom) {


        for (Object p : pages) {
            if (p instanceof PDPage pdPage) {
                try {
                    this.add(new Page(pdPage, zoom));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                fenetre.validate();

                /* Méthode asynchrone (Ne marche pas bien) */
//                new Thread(() -> {
//                    try {
//                        this.add(new Page(pdPage, zoom));
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                    fenetre.validate();
//                    try {
//                        Thread.sleep(50);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }).start();
            }
        }

        System.out.println("PDF: Loaded successfully");
    }

    /**
     * @return Le nombre de pages chargées
     */
    public int getNbPages() {
        return document.getNumberOfPages();
    }
}
