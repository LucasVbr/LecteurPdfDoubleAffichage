/*
 * Fenetre, 22/11/2021
 * IUT Rodez 2021, INFO2
 * pas de copyright, aucun droits
 */

package lecteur_pdf.affichage;

import lecteur_pdf.document.PDF;
import lecteur_pdf.menu.Menu;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * classe correspondant à l’objet Fenêtre
 *
 * @author Léo FRANCH
 * @author Tristan NOGARET
 * @author Lucàs VABRE
 * @author Noé VILLENEUVE
 * @version 1.0
 */

public class Fenetre extends JFrame {

    /**
     * TODO
     */
    private String titre;

    /**
     * TODO
     */
    private Menu menu;

    /**
     * TODO
     */
    private PDF fichierPDF;

    /**
     * TODO
     */
    public Fenetre() {

        // Création du menu
        menu = new Menu(this);

        // Ajout de la barre de menu au frame

        this.setJMenuBar(menu);

        this.setSize(300, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    /**
     * TODO
     *
     * @param fichier
     */
    public void chargerPdf(File fichier) {

        /* Décharge le précédent PDF avant de charger le prochain */
        dechargerPdf();

        PDF fichierPDF = new PDF(fichier);

        /* Crée le panel qui contient le document PDF */
        JPanel mainPanel = new JPanel();
        mainPanel.add(fichierPDF);

        /* Crée l’élément scrollable qui contiendra le pannel */
        JScrollPane scrollPane = new JScrollPane(mainPanel);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        /* Ajoute l'élément scrollable a la fenêtre et le centre */
        this.add(scrollPane, BorderLayout.CENTER);

        /* Génère les pages */
        fichierPDF.loadPages(this, 1);

        this.pack();
        this.setLocationRelativeTo(null);
    }

    public void dechargerPdf() {
        if (this.getContentPane() != null) {
            this.getContentPane().removeAll();
        }
    }

    /**
     * TODO comment main
     *
     * @param args non utilisé
     */
    public static void main(String[] args) {
        new Fenetre();
    }
}