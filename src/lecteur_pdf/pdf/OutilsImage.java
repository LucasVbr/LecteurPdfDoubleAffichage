package lecteur_pdf.pdf;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class OutilsImage {

    /**
     * Change la taille d'une image
     * @param img
     * @param newW
     * @param newH
     * @return
     */
    public static BufferedImage resize(BufferedImage img, int newW, int newH) {
        int w = img.getWidth();
        int h = img.getHeight();
        BufferedImage dimg = new BufferedImage(newW, newH, img.getType());
        Graphics2D g = dimg.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.drawImage(img, 0, 0, newW, newH, 0, 0, w, h, null);
        g.dispose();
        return dimg;
    }

    /**
     *
     * @param img
     * @param newW
     * @return
     */
    public static BufferedImage resizeWidth(PdfLoader a, Icon img, int newW) {
        int w = a.getMinWidth();
        int h = a.getMinHeight();

        float ratio = (float)newW / (float)w;

        return a.setScale(ratio);
    }

    /**
     *
     * @param img
     * @param newH
     * @return
     */
    public static BufferedImage resizeHeight(BufferedImage img, int newH) {
        int w = img.getWidth();
        int h = img.getHeight();

        int ratio = newH / (1+h);

        int newW = w * ratio;

        return resize(img, newW, newH);
    }

}
