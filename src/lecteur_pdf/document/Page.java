/*
 * Page, 17/11/2021
 * IUT Rodez 2021, INFO2
 * pas de copyright, aucun droits
 */

package lecteur_pdf.document;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.ImageType;
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

    /**
     * Hauteur de la page
     */
    private int hauteur;

    /**
     * Largeur de la page
     */
    private int largeur;

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

        this.setIcon(generateImage(document, index));
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
    private ImageIcon generateImage(PDDocument document, int index) throws IOException {

        PDFRenderer pdfRenderer = new PDFRenderer(document);
        BufferedImage bufferedImage = pdfRenderer.renderImageWithDPI(index,
                                                                     300,
                                                                     ImageType.RGB);

        this.largeur = bufferedImage.getWidth() / 2;
        this.hauteur = bufferedImage.getHeight() / 2;

        final ImageIcon imageIcon = new ImageIcon(
            bufferedImage.getScaledInstance(largeur, hauteur,
                                            Image.SCALE_SMOOTH));
        return imageIcon;
    }

    /**
     * @return La hauteur de la page
     */
    public int getHauteur() {
        return hauteur;
    }

    /**
     * @return La largeur de la page
     */
    public int getLargeur() {
        return largeur;
    }
}
