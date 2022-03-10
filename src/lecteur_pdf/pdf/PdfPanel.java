/*
 * PdfPanel.java, 26/02/2022
 * IUT Rodez 2021-2022, INFO 2
 * Pas de copyright, aucun droits
 */

package lecteur_pdf.pdf;

import lecteur_pdf.GestionFenetre;
import lecteur_pdf.GestionMode;

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

    /** Le numéro de la page courrante */
    private int numeroPage;

    /** Valeur multiplicative de la taille de la page */
    private float taille;

    /** Valeur multiplicative du zoom  */
    private float zoom;

    /** Défini si la page est en pleine largeur ou non */
    private boolean pleineLargeur;

    /** Bloqueur qui défini si le processeur est entrain de générer une nouvelle page */
    private boolean processing;

    /** Le document PDF chargé */
    private DocumentPdf pdfLoader;

    /* Interface */

    /** La zone de saisie du numéro de page */
    private final JTextField indexPageInput;

    /** Le texte définissant le nombre max de pages */
    private final JLabel maxPageLabel;

    /** Element scrollable qui contiens la page */
    private final JScrollPane scrollPane;

    /** Zone de l'élément scollable quio est visible */
    private final JViewport viewport;

    /** Label qui contiens l'image de la page affichée */
    private final JLabel page;

    /**
     * Crée une nouvelle interface de PDF vide
     */
    public PdfPanel() {
        super(new BorderLayout());

        taille = 0.0f;
        zoom = 1.0f;
        numeroPage = 0;
        processing = false;
        pleineLargeur = false;

        /* Contrôleurs */
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
                indexPageInput.setEditable(e.getKeyChar() >= '0' && e.getKeyChar() <= '9');
            }
        });

        /* À la pression de la touche entrée on fait une recherche */
        indexPageInput.addActionListener(e -> {
            String saisie = indexPageInput.getText();
            try {
                int index = Integer.parseInt(saisie);
                if (isPageValide(index - 1)) changerPage(index - 1);
                else throw new Exception();
            } catch (Exception f) {
                indexPageInput.setText(Integer.toString(numeroPage +1));
            }

        });

        scrollPane.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                changerTaille();
            }
        });
    }

    /**
     * Action lors du clic sur le boutton suivant
     * Affiche la page suivante du ou des documents (suivant si le mode synchronisé est activé)
     *
     * @param evt Écouteur d'évènement
     */
    private void btnSuivantAction(ActionEvent evt) {
        if (GestionMode.isModeSepare()) pageSuivante();
        else GestionFenetre.nextPages();
    }

    /**
     * Action lors du clic sur le boutton precedent
     * Affiche la page précédente du ou des documents (suivant si le mode synchronisé est activé)
     *
     * @param evt Écouteur d'évènement
     */
    private void btnPrecedentAction(ActionEvent evt) {
        if (GestionMode.isModeSepare()) pagePrecedente();
        else GestionFenetre.previousPages();
    }

    /**
     * Change la taille de la page courrante suivant si fonction Pleine Largeur est activé ou non
     */
    public void changerTaille() {
        if (pdfLoader == null || processing) return;

        if (pleineLargeur) {
            float viewportWidth = viewport.getWidth();
            float scrollpaneWidth = scrollPane.getVerticalScrollBar().getWidth();
            float pdfMinWidth = pdfLoader.getMinWidth();

            taille = (viewportWidth - scrollpaneWidth) / pdfMinWidth - zoom;
        } else {
            float viewportHeight = viewport.getHeight();
            float scrollpaneHeight = scrollPane.getVerticalScrollBar().getHeight();
            float pdfMinHeight = pdfLoader.getMinHeight();

            taille = (viewportHeight - scrollpaneHeight) / pdfMinHeight - zoom;
        }
        setTaille(taille);
    }

    /** @param pleineLargeur booléen qui défini l'état du mode pleine largeur */
    public void setPleineLargeur(boolean pleineLargeur) {
        this.pleineLargeur = pleineLargeur;
        changerTaille();
    }

    /**
     * Prédicat qui vérifie si un index de page est valide pour le PDF courant
     *
     * @param index Entier correspondant a l'indice du numéro de page à tester
     * @return true si le prédicat est vérifié, false sinon
     */
    private boolean isPageValide(int index) {
        return pdfLoader != null
                && 0 <= index
                && index < pdfLoader.getNbPages();
    }

    /**
     * Méthode qui permet de charger un PDF dans la fenêtre courante
     *
     * @param pdfFile Le fichier PDF à charger
     * @return true si le PDF a pu se charger, false sinon
     */
    public boolean chargerPdf(File pdfFile) {
        try {
            setPdfLoader(new DocumentPdf(pdfFile));
            changerPage(0);
            return true;
        } catch (IOException ignored) {}
        return false;
    }

    /** @param pdfLoader un nouveau document PDF à affecter à la fenêtre */
    public void setPdfLoader(DocumentPdf pdfLoader) {
        this.pdfLoader = pdfLoader;
    }

    /**
     * Décharge le document courant s'il y en a un
     */
    public void dechargerPdf() {
        if (!isCharge()) return;

        /* Ferme le loader et l'efface */
        pdfLoader.close();
        pdfLoader = null;

        /* Efface l'image de la page */
        page.setIcon(null);
        numeroPage = 0;

        /* Interface Vide */
        indexPageInput.setText("");
        maxPageLabel.setText("/ -");

        /* Efface les données relatives au zoom */
        taille = 0.0f;
        zoom = 1.0f;

        validate();
    }

    /**
     * Change la valeur du zoom de la page courante
     *
     * @param scale Valeur flottante (1.00f == 100%)
     */
    public void setZoom(float scale) {
        zoom = scale;
        changerPage(numeroPage);
    }

    /**
     * Change la taille de la page courante
     *
     * @param scale Valeur flottante (1.00f == 100%)
     */
    private void setTaille(float scale) {
        taille = scale;
        changerPage(numeroPage);
    }

    /** Affiche la page suivante */
    public void pageSuivante() {
        changerPage(numeroPage + 1);
    }

    /** Affiche la page suivante */
    public void pagePrecedente() {
        changerPage(numeroPage - 1);
    }

    /**
     * Essaye de changer de page si possible, sinon ne fait rien
     *
     * @param index Le numéro de la page où l'on veut se rendre
     */
    private void changerPage(int index) {
        if (!isPageValide(index)) return;

        processing = true;
        try {
            page.setIcon(new ImageIcon(pdfLoader.renderPage(index, zoom + taille)));
            numeroPage = index;
            indexPageInput.setText(Integer.toString(numeroPage + 1));
            maxPageLabel.setText(String.format("/%d", pdfLoader.getNbPages()));
        } catch (IOException ignored) {}
        processing = false;
    }

    /**
     * Prédicat qui vérifie si un PDF est chargé ou non
     * @return true si un PDF est chargé, false sinon
     */
    public boolean isCharge() {
        return pdfLoader != null;
    }
}
