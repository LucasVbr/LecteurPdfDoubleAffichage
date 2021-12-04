/*
 * Page, 17/11/2021
 * IUT Rodez 2021, INFO2
 * pas de copyright, aucun droits
 */

package lecteur_pdf.document;

import org.apache.pdfbox.pdmodel.PDPage;

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

    /** Hauteur de la page */
    private int hauteur;

    /** Largeur de la page */
    private int largeur;

    /**
     * Crée une page virtuellement pour l’afficher avec java swing
     *
     * @param pageImage
     * @param scale
     * @throws IllegalArgumentException Si les arguments ne sont pas valides
     * @throws IOException              Si la page n’as pas pu être lue
     */
    public Page(PDPage pageImage, int scale) throws
                                                IllegalArgumentException,
                                                IOException {
        if (pageImage == null) throw new IllegalArgumentException();

        this.setIcon(generateImage(pageImage.convertToImage(), scale));
    }

    /**
     * Génère une image de la page
     *
     * @param img
     * @param scale
     * @throws IOException En cas d’erreur de lecture
     */
    private ImageIcon generateImage(BufferedImage img, int scale) throws IOException {

        this.largeur = img.getWidth() / scale;
        this.hauteur = img.getHeight() / scale;

        return new ImageIcon(img.getScaledInstance(largeur, hauteur,
                                                   Image.SCALE_SMOOTH));
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
