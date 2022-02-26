/*
 * PdfPanel.java, 26/02/2022
 * IUT Rodez 2021-2022, INFO 2
 * pas de copyright, aucun droits
 */

package lecteur_pdf.pdf;

import lecteur_pdf.GestionMode;
import lecteur_pdf.GestionPdf;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * TODO commentaires
 *
 * @author Léo Franch
 * @author Lucas Vabre
 * @author Noé Villeneuve
 * @author Tristan Nogaret
 */
public class PdfPanel extends JPanel {
    /**
     * TODO
     */
    private int currentPage;

    /**
     * TODO
     */
    private float currentScale;

    /**
     * TODO
     */
    private PdfLoader pdfLoader;

    private JButton suivantButton;
    private JButton precedentButton;
    private JLabel pageIndicator;
    private JPanel mainPanel;
    private JLabel page;
    private JScrollPane scrollPane;
    private JTextField indexPage;

    /**
     * TODO
     */
    public PdfPanel() {
        super();

        this.currentScale = 1.0f;

        scrollPane.setMaximumSize(Toolkit.getDefaultToolkit().getScreenSize());

        // TODO supprimer le form et creer les éléments 1 par 1

        /* Hierarchie */
        add(mainPanel);

        /* Actions */
        suivantButton.addActionListener(e -> {
            if (GestionMode.isModeSepare()) {
                nextPage();
            } else {
                GestionPdf.nextPages();
            }
        });

        precedentButton.addActionListener(e -> {
            if (GestionMode.isModeSepare()) {
                previousPage();
            } else {
                GestionPdf.previousPages();
            }
        });

        indexPage.addActionListener(e -> {

            String saisie = indexPage.getText();

            int index = Integer.parseInt(saisie);

            /* Si cet entier est valide on change de page sinon on efface le contenu de la saisie */
            if (isPageValide(index)) {
                setPage(index - 1);
            } else {
                indexPage.setText(null);
            }
        });

    }

    /**
     * Prédicat qui vérifie si un index de page est valide pour le PDF courrant
     * @param index Entier correspondant a l'indice du numéro de page à tester
     * @return true si le prédicat est vérifié, false sinon
     */
    private boolean isPageValide(int index) {
        if (pdfLoader == null) return false;
        return 0 <= index && index < pdfLoader.getNbPages();
    }

    /**
     * Methode qui permet de charger un PDF dans le fenêtre courrante
     * @param pdfFile Le fichier PDF à charger
     * @return true si le PDF à pu se charger, false sinon
     */
    public boolean chargerPdf(File pdfFile) {
        try {
            setPdfLoader(new PdfLoader(pdfFile));
            setPage(0);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(new JFrame(),"Une erreur s'est produite dans le chargement de votre document, il est peut-être corrompu. ");
        }
        return true;
    }

    /**
     * TODO
     * @param pdfLoader
     */
    public void setPdfLoader(PdfLoader pdfLoader) {
        this.pdfLoader = pdfLoader;
    }

    /**
     * TODO
     */
    public void dechargerPdf() {
        if (pdfLoader == null) {
            return;
        }

        /* Ferme le loader et l'efface */
        pdfLoader.close();
        pdfLoader = null;

        /* Efface l'image de la page */
        page.setIcon(null);
        currentPage = 0;

        /* Interface Vide */
        indexPage.setText("");
        pageIndicator.setText("/ -");

        validate();
    }

    /**
     * Change la taille de la page courrante
     * @param scale Valeur flottante (1.00f == 100%)
     */
    public void updateScale(float scale) {
        currentScale = scale;
        setPage(currentPage);
    }

    /**
     * Affiche la page suivante
     */
    public void nextPage() {
        setPage(currentPage + 1);
    }

    /**
     * Affiche la page suivante
     */
    public void previousPage() {
        setPage(currentPage - 1);
    }

    /**
     * Essaye de changer de page si possible, sinon ne fait rien
     * @param index Le numéro de la page où l'on veut se rendre
     */
    private void setPage(int index) {
        if (!isPageValide(index)) return;

        try {
            page.setIcon(new ImageIcon(pdfLoader.renderPage(index, currentScale)));
            currentPage = index;
            indexPage.setText(Integer.toString(currentPage +1));
            pageIndicator.setText(String.format("/%d", pdfLoader.getNbPages()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
