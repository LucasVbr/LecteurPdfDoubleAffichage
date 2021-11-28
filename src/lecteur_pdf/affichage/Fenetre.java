/*
 * Fenetre, 22/11/2021
 * IUT Rodez 2021, INFO2
 * pas de copyright, aucun droits
 */

package lecteur_pdf.affichage;

import lecteur_pdf.document.PDF;
import lecteur_pdf.menu.Menu;

import javax.swing.*;
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
        fichierPDF = new PDF(fichier);

        /* Crée l’élément scrollable */
        JScrollPane scrollPane = new JScrollPane(fichierPDF);
        scrollPane.setHorizontalScrollBarPolicy(
            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(
            JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        /* Supprime le précédent PDF */
        this.getContentPane().removeAll();

        /* Affiche le nouveau PDF */
        scrollPane.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        this.getContentPane().add(scrollPane);
        this.validate();
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