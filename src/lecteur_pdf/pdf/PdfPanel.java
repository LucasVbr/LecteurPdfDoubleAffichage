/*
 * PdfPanel.java, 26/02/2022
 * IUT Rodez 2021-2022, INFO 2
 * Pas de copyright, aucun droits
 */

package lecteur_pdf.pdf;

import lecteur_pdf.GestionMode;
import lecteur_pdf.GestionFenetre;
import lecteur_pdf.Popup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

/**
 * Interface de la mainframe de l'application sans utilisation de forms
 *
 * @author Léo Franch
 * @author Lucas Vabre
 * @author Noé Villeneuve
 * @author Tristan Nogaret
 */
public class PdfPanel extends JPanel {

    /* Données */
    private int currentPage;
    private float scaleSizing;
    private float scaleZoom;
    private boolean pleineLargeur;
    private boolean processing;

    /* Chargeur de Pdf */
    private DocumentPdf pdfLoader;

    /* Interface */
    private final JTextField indexPageInput;
    private final JLabel maxPageLabel;
    private final JScrollPane scrollPane;
    private final JViewport viewport;
    private final JLabel page;

    /**
     * Crée une nouvelle interface de PDF vide
     */
    public PdfPanel() {
        super(new BorderLayout());

        scaleSizing = 0.0f;
        scaleZoom = 1.0f;
        currentPage = 0;
        processing = false;
        pleineLargeur = false;

        /* Controleurs */
        JPanel controls = new JPanel();
        JButton btnPrecedent = new JButton("Précédent");
        indexPageInput = new JTextField(7);
        indexPageInput.setText("-");
        maxPageLabel = new JLabel("/ -");
        JButton btnSuivant = new JButton("Suivant");

        controls.add(btnPrecedent);
        controls.add(indexPageInput);
        controls.add(maxPageLabel);
        controls.add(btnSuivant);

        add(controls, BorderLayout.PAGE_START);

        /* View */
        page = new JLabel();
        JPanel pagePanel = new JPanel();
        /* Contenu de View */
        scrollPane = new JScrollPane(pagePanel);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        viewport = scrollPane.getViewport();

        pagePanel.add(page);

        add(scrollPane, BorderLayout.CENTER);

        /* Actions */
        btnSuivant.addActionListener(this::btnSuivantAction);
        btnPrecedent.addActionListener(this::btnPrecedentAction);

        /* Saisie uniquement de caractère numérique */
        indexPageInput.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                String value = indexPageInput.getText();
                int l = value.length();
                indexPageInput.setEditable(e.getKeyChar() >= '0' && e.getKeyChar() <= '9');
            }
        });

        /* A la pression de la touche entrée on fait une recherche */
        indexPageInput.addActionListener(e -> {
            String saisie = indexPageInput.getText();
            try {
                int index = Integer.parseInt(saisie);
                if (isPageValide(index - 1)) setPage(index - 1);
                else throw new Exception();
            } catch (Exception f) {
                indexPageInput.setText(Integer.toString(currentPage +1));
            }

        });

        scrollPane.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                resize();
            }
        });
    }

    /**
     * @param evt Ecouteur d'évèvement
     */
    private void btnSuivantAction(ActionEvent evt) {
        if (GestionMode.isModeSepare()) nextPage();
        else GestionFenetre.nextPages();
    }

    /**
     * @param evt Ecouteur d'évèvement
     */
    private void btnPrecedentAction(ActionEvent evt) {
        if (GestionMode.isModeSepare()) previousPage();
        else GestionFenetre.previousPages();
    }

    public void resize() {
        if (pdfLoader != null && !processing) {
            scaleSizing = pleineLargeur
                    ? (((float) viewport.getWidth() - (float) scrollPane.getVerticalScrollBar().getWidth()) / (float) pdfLoader.getMinWidth()) - scaleZoom
                    : (((float) viewport.getHeight() - (float) scrollPane.getHorizontalScrollBar().getHeight()) / (float) pdfLoader.getMinHeight()) - scaleZoom;
            updateScaleSizing(scaleSizing);
        }
    }

    public void setPleineLargeur(boolean pleineLargeur) {
        this.pleineLargeur = pleineLargeur;
        resize();
    }

    /**
     * Prédicat qui vérifie si un index de page est valide pour le PDF courrant
     *
     * @param index Entier correspondant a l'indice du numéro de page à tester
     * @return true si le prédicat est vérifié, false sinon
     */
    private boolean isPageValide(int index) {
        if (pdfLoader == null) return false;
        return 0 <= index && index < pdfLoader.getNbPages();
    }

    /**
     * Methode qui permet de charger un PDF dans le fenêtre courrante
     *
     * @param pdfFile Le fichier PDF à charger
     * @return true si le PDF à pu se charger, false sinon
     */
    public boolean chargerPdf(File pdfFile) {
        try {
            setPdfLoader(new DocumentPdf(pdfFile));
            setPage(0);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    /**
     * @param pdfLoader
     */
    public void setPdfLoader(DocumentPdf pdfLoader) {
        this.pdfLoader = pdfLoader;
    }

    /**
     * Décharge le document courrant si il y en a un
     */
    public void dechargerPdf() {
        if (isCharge()) {
            /* Ferme le loader et l'efface */
            pdfLoader.close();
            pdfLoader = null;

            /* Efface l'image de la page */
            page.setIcon(null);
            currentPage = 0;

            /* Interface Vide */
            indexPageInput.setText("");
            maxPageLabel.setText("/ -");

            /* Efface les données relatives au zoom */
            scaleSizing = 0.0f;
            scaleZoom = 1.0f;

            validate();
        }
    }

    /**
     * Change la taille de la page courrante
     *
     * @param scale Valeur flottante (1.00f == 100%)
     */
    public void updateScaleZoom(float scale) {
        scaleZoom = scale;
        setPage(currentPage);
    }

    /**
     * Change la taille de la page courrante
     *
     * @param scale Valeur flottante (1.00f == 100%)
     */
    public void updateScaleSizing(float scale) {
        scaleSizing = scale;
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
     *
     * @param index Le numéro de la page où l'on veut se rendre
     */
    private void setPage(int index) {
        if (isPageValide(index)) {

            processing = true;
            try {
                page.setIcon(new ImageIcon(pdfLoader.renderPage(index, scaleZoom + scaleSizing)));
                currentPage = index;
                indexPageInput.setText(Integer.toString(currentPage + 1));
                maxPageLabel.setText(String.format("/%d", pdfLoader.getNbPages()));
            } catch (IOException ignored) {}
            processing = false;
        }
    }

    /**
     * Prédicat qui vérifie si un PDF est chargé ou non
     * @return true si un PDF est chargé, false sinon
     */
    public boolean isCharge() {
        return pdfLoader != null;
    }
}
