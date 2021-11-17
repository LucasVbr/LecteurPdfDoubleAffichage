/*
 * Page, 17/11/2021
 * IUT Rodez 2021, INFO2
 * pas de copyright, aucun droits
 */

package lecteur_pdf.document;

import org.apache.pdfbox.pdmodel.PDDocument;

import javax.swing.*;

/**
 * TODO A compléter
 *
 * @author Lucas
 */
public class Page {

    /**
     * TODO A compléter
     */
    private int index;

    /**
     * TODO A compléter
     */
    private JLabel image;

    /**
     * TODO A compléter
     */
    private int hauteur;

    /**
     * TODO A compléter
     */
    private int largeur;

    /**
     * TODO A compléter
     * @param document
     * @param index
     * @throws IllegalArgumentException
     */
    public Page(PDDocument document, int index) throws IllegalArgumentException {
        if (!isValid(document, index)) throw new IllegalArgumentException();
        // TODO
    }

    /**
     * TODO A compléter
     * @param document
     * @param index
     * @return
     */
    private boolean isValid(PDDocument document, int index) {
        return document != null
               && 0 <= index && index < document.getNumberOfPages();
    }

    /**
     * TODO A compléter
     * @param positionX
     * @param positionY
     */
    public void setPosition(int positionX, int positionY) {
        // TODO
    }

    /**
     * TODO A compléter
     * @return
     */
    public JLabel getImage() {
        return image;
    }
}
