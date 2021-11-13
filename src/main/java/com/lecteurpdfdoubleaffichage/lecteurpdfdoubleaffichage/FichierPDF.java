/*
 * FichierPDF, 13/11/2021
 * IUT Rodez 2021, INFO2
 * pas de copyright, aucun droits
 */

package com.lecteurpdfdoubleaffichage.lecteurpdfdoubleaffichage;

import javafx.scene.image.Image;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

import java.io.*;
import java.util.ArrayList;

/**
 * Classe permettant la manipulation de fichier PDF et son affichage.
 *
 * @author Lucas
 */
public class FichierPDF {

    /**
     * Fichier à charger
     */
    private final File fichier;

    /**
     * Document pdf chargé à partir du fichier
     */
    private final PDDocument pdDocument;

    /**
     * Outils de rendu pour l’affichage des pages
     */
    private final PDFRenderer render;

    /**
     * Liste des pages du PDF sous forme d’images
     */
    private final ArrayList<Image> documentPages = new ArrayList<>();

    /**
     * @param file Le fichier que l’on veut charger
     */
    public FichierPDF(File file) {
        if (file == null || !file.isFile()) {
            throw new IllegalArgumentException();
        }

        try {
            this.pdDocument = PDDocument.load(file);
        } catch (IOException e) {
            throw new IllegalArgumentException(e.getMessage());
        }

        this.fichier = file;
        this.render = new PDFRenderer(pdDocument);

        /* Remplis le tableau documentPages */
        for (int i = 0; i < pdDocument.getNumberOfPages(); i++) {
            documentPages.add(pageToImage(i));
        }
    }

    /**
     * @return La liste des pages du PDF sous forme d’images
     */
    public ArrayList<Image> getDocumentPages() {
        return documentPages;
    }

    /**
     * @return Le document pdf chargé
     */
    public PDDocument getPdDocument() {
        return pdDocument;
    }

    /**
     * @return Le Fichier chargé
     */
    public File getFichier() {
        return fichier;
    }

    /**
     * Convertis une page PdfBox en image JavaFX
     * @param pageNumber Le numéro de la page que l’on veut convertir
     * @return L’image compatible avec JavaFX
     */
    public Image pageToImage(int pageNumber) {
        if (pageNumber <= pdDocument.getNumberOfPages()) {
            return null;
        }

        BufferedImage pageImage = null;
        try {
            pageImage = render.renderImage(pageNumber);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bufferedImageToFxImage(pageImage);
    }

    /**
     * Methode qui convertis une image dans le buffer en image compatible
     * avec JavaFX
     * @param bufferedImg Image dans le buffer à convertir
     * @return Image compatible avec JavaFX
     */
    private static Image bufferedImageToFxImage(BufferedImage bufferedImg) {

        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();

        try {
            ImageIO.write(bufferedImg, "jpg", arrayOutputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        InputStream inStream = new ByteArrayInputStream(
            arrayOutputStream.toByteArray());

        return new Image(inStream);
    }
}
