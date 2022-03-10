/*
 * PdfLoader.java, 26/02/2022
 * IUT Rodez 2021-2022, INFO 2
 * pas de copyright, aucun droits
 */

package lecteur_pdf.pdf;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Classe qui représente un document PDF ouvert, elle permet de créer des images des pages
 *
 * @author Léo Franch
 * @author Lucas Vabre
 * @author Noé Villeneuve
 * @author Tristan Nogaret
 */
public class DocumentPdf {

    /** Le document PDF chargé avec PdfBox */
    private final PDDocument document;

    /** L'outils de rendus de PdfBox */
    private PDFRenderer renderer;

    /** La largueur par défaut de la page courrante */
    private int minWidth;

    /** La longueur par défaut de la page courrante */
    private int minHeight;

    /**
     * Charge un nouveau document PDF
     *
     * @param file Le fichier PDF à charger
     * @throws IOException Si le document passé en argument est illisible
     */
    public DocumentPdf(File file) throws IOException {
        document = PDDocument.load(file);
        renderer = new PDFRenderer(document);
        minWidth = -1;
        minHeight = -1;
    }

    /** @return La largueur par défaut de la page courrante */
    public int getMinWidth() {
        return minWidth;
    }

    /** @return La longueur par défaut de la page courrante */
    public int getMinHeight() {
        return minHeight;
    }

    /** @return Le nombre de pages du document */
    public int getNbPages() {
        return document.getNumberOfPages();
    }

    /**
     * Crée une image de la page voulue
     *
     * @param pageIndex Numero de la page désirée (compris entre 0 et le nombre maximal de pages)
     * @param scale Taille de la page (La qualité de l'image est amélioré suivant cette valeur)
     * @return Une image de la page demandée
     * @throws IOException Si l'image de rendu n'as pas pu être créée
     * @throws IllegalArgumentException Si le numero de page est invalide (n'est pas compris entre 0 et le nombre maximal de pages)
     */
    public BufferedImage renderPage(int pageIndex, float scale) throws IOException {
        if (pageIndex < 0 || pageIndex >= this.getNbPages()) {
            throw new IllegalArgumentException();
        }

        BufferedImage img = renderer.renderImage(pageIndex, scale);

        if (scale == 1.0f && minWidth == -1 && minHeight == -1) {
            minWidth = img.getWidth();
            minHeight = img.getHeight();
        }

        return img;
    }

    /**
     * Ferme le document courant et redéfini les paramètres par défaut
     */
    public void close() {
        try {
            renderer = null;
            document.close();
            minWidth = -1;
            minHeight = -1;
        } catch (IOException ignored) {}
    }
}
