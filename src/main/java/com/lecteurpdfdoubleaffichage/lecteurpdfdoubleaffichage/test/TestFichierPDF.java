/*
 * TestChargerFichier, 13/11/2021
 * IUT Rodez 2021, INFO2
 * pas de copyright, aucun droits
 */

package com.lecteurpdfdoubleaffichage.lecteurpdfdoubleaffichage.test;

import com.lecteurpdfdoubleaffichage.lecteurpdfdoubleaffichage.FichierPDF;

import java.io.File;

/**
 * Classe de test de {@link FichierPDF}
 *
 * @author Lucas Vabre
 */
public class TestFichierPDF {

    public FichierPDF FIXTURE = new FichierPDF(
        new File("fichierTest/test_pdf.pdf"));

    /**
     * Tests unitaires de {@link FichierPDF#FichierPDF(File)}
     */
    public static void testFichierPdfFile() {
        System.out.print("Test unitaire de FichierPDF#FichierPDF(File)");

        File[] INVALIDES = {
            /* Chemin inconnu */
            new File(" "),
            new File("\n"),
            new File("aaa.pdf"),
            new File("iii.png")
        };

        for (int i = 0; i < INVALIDES.length; i++) {
            try {
                new FichierPDF(INVALIDES[i]);
                throw new AssertionError("Erreur au test n°" + i);
            } catch (IllegalArgumentException ignored) {}
        }

        System.out.println(" => OK");
    }

    /**
     * Tests unitaires de {@link FichierPDF#getDocumentPages()}
     */
    public static void testGetDocumentPages() {
        System.out.println("Test unitaire de FichierPDF#getDocumentPages():");
        // TODO
    }

    /**
     * Tests unitaires de {@link FichierPDF#getPdDocument()}
     */
    public static void testGetPdDocument() {
        System.out.println("Test unitaire de FichierPDF#getPdDocument():");
        // TODO
    }

    /**
     * Tests unitaires de {@link FichierPDF#getFichier()}
     */
    public static void testGetFichier() {
        System.out.println("Test unitaire de FichierPDF#getFichier():");
        // TODO
    }

    /**
     * Tests unitaires de {@link FichierPDF#pageToImage(int)}
     */
    public static void testPageToImage() {
        System.out.println("Test unitaire de FichierPDF#pageToImage(int):");
        // TODO
    }

    /**
     * Lance les tests de la classe {@link FichierPDF}
     *
     * @param args non utilisé
     */
    public static void main(String[] args) {
        testFichierPdfFile();
        //        testGetDocumentPages();
        //        testGetPdDocument();
        //        testGetFichier();
        //        testPageToImage();
    }
}
