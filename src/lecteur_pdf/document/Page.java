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
public class Page {

    /**
     * Indice de la page
     */
    private final int index;

    /**
     * Label contenant l’image de la page
     */
    private final JLabel image;

    /**
     * Hauteur de la page
     */
    private int hauteur;

    /**
     * Largeur de la page
     */
    private int largeur;

    /**
     * Position X de la page dans son panel
     */
    private int positionX;

    /**
     * Position Y de la page dans son panel
     */
    private int positionY;

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

        this.index = index;
        this.image = generateImage(document);

        positionX = 0;
        positionY = 0;
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
    private JLabel generateImage(PDDocument document) throws IOException {

        PDFRenderer pdfRenderer = new PDFRenderer(document);
        BufferedImage bufferedImage = pdfRenderer.renderImageWithDPI(this.index,
                                                                     300,
                                                                     ImageType.RGB);

        this.largeur = bufferedImage.getWidth();
        this.hauteur = bufferedImage.getHeight();

        ImageIcon icon = new ImageIcon(
            bufferedImage.getScaledInstance(largeur, hauteur,
                                            Image.SCALE_SMOOTH));

        JLabel result = new JLabel("", SwingConstants.LEADING);
        result.setIcon(icon);

        return result;
    }

    /**
     * Positionne la page dans son Panel
     *
     * @param positionX Position X de la page
     * @param positionY Position Y de la page
     */
    public void setPosition(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;

        image.setLocation(positionX, positionY);
    }

    /**
     * @return Le label contenant l’image de la page
     */
    public JLabel getImage() {
        return image;
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
