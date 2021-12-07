/*
 * Page, 17/11/2021
 * IUT Rodez 2021, INFO2
 * pas de copyright, aucun droits
 */

package lecteur_pdf.document;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Page générée virtuellement pour l’affichage avec java swing
 *
 * @author Léo FRANCH
 * @author Tristan NOGARET
 * @author Lucàs VABRE
 * @author Noé VILLENEUVE
 */
public class Page extends JLabel {

    /** Indice de la page dans le document */
    private final int INDEX;

    /** Zoom de la page (1.0f == 100 %, 0.5 == 50%, ...) */
    private final float ZOOM;

    /** Image de la page générée */
    private final ImageIcon IMAGE_ICON;

    /**
     * Crée une page virtuellement pour l’afficher avec java swing
     *
     * @param document Document pdf
     * @param index    indice de la page
     * @throws IllegalArgumentException Si les arguments ne sont pas valides
     * @throws IOException              Si la page n’as pas pu être lue
     */
    public Page(PDDocument document, int index) throws
                                                IllegalArgumentException,
                                                IOException {
        if (!isValid(document, index)) {
            throw new IllegalArgumentException();
        }

        this.INDEX = index;
        this.ZOOM = 1.0f;
        this.IMAGE_ICON = generateImage(document);

        /* Render */
        this.setIcon(IMAGE_ICON);
    }

    /**
     * Crée une page virtuellement pour l’afficher avec java swing
     *
     * @param document Document pdf
     * @param index    indice de la page
     * @param zoom     Le zoom de la page
     * @throws IllegalArgumentException Si les arguments ne sont pas valides
     * @throws IOException              Si la page n’as pas pu être lue
     */
    public Page(PDDocument document, int index, float zoom) throws
                                                IllegalArgumentException,
                                                IOException {
        if (!isValid(document, index)) throw new IllegalArgumentException();

        this.INDEX = index;
        this.ZOOM = zoom;
        this.IMAGE_ICON = generateImage(document); // Génère la page

        /* Fait le rendu de la page */
        this.setIcon(IMAGE_ICON);
    }

    /**
     * Prédicat qui vérifie si une page est valide
     * Le document ne doit pas être null et l’index doit être compris entre 0
     * et le nombre de pages du pdf.
     *
     * @param document Document pdf
     * @param index    indice de la page
     * @return true si le prédicat est vérifié, false sinon
     */
    private boolean isValid(PDDocument document, int index) {
        return document != null && 0 <= index
               && index < document.getNumberOfPages();
    }

    /**
     * Génère une image de la page
     *
     * @param document Document PDF
     * @return JLabel contenant la page sous forme d’image
     * @throws IOException En cas d’erreur de lecture
     */
    private ImageIcon generateImage(PDDocument document) throws IOException {

        /* Défini la qualité de l’image par rapport au zoom */
        final int DPI = 120;
        int imageScale = (ZOOM > 1.0f) ? Image.SCALE_SMOOTH : Image.SCALE_FAST;

        /* Crée une image de la page à afficher */
        PDFRenderer pdfRenderer = new PDFRenderer(document);
        BufferedImage bufferedImage = pdfRenderer.renderImageWithDPI(INDEX, DPI);

        /* Redimensionne l'image */
        final int LARGEUR = (int)(bufferedImage.getWidth() * ZOOM);
        final int HAUTEUR = (int)(bufferedImage.getHeight() * ZOOM);

        /* Retourne l’image à la bonne taille */
        return new ImageIcon(bufferedImage.getScaledInstance(LARGEUR, HAUTEUR,
                                                             imageScale));
    }
}
