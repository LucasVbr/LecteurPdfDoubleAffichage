/*
 * IhmPdf, 03/02/2022
 * IUT Rodez 2022, INFO2
 * pas de copyright, aucun droits
 */

package lecteur_pdf;

import lecteur_pdf.menuBar.MenuBar;
import lecteur_pdf.pdf.PdfPanel;
import lecteur_pdf.raccourcisClavier.RaccourcisClavier;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Classe définissant une fenêtre qui peut contenir un document PDF
 *
 * @author Léo Franch
 * @author Lucas Vabre
 * @author Noé Villeneuve
 * @author Tristan Nogaret
 */
public class Fenetre extends JFrame {

    /**
     * Titre de l'application
     */
    public static final String TITRE = "LPDA";

    /**
     * Le Panel contenant le document PDF
     */
    private final PdfPanel pdfPanel;

    /* Relatif au FullScreen */
    /**
     * Booléen qui définit si la fenêtre est en mode plein écran ou non
     */
    private boolean fullscreen = false;

    /**
     * Composant Graphique permettant la mise en place du plein ecran
     */
    private GraphicsDevice device;

    /**
     * Crée une nouvelle fenêtre vide
     */
    public Fenetre() {
        super(TITRE);

        /* Icone de la fenêtre */
        setIconImage(GestionFenetre.ICONE);

        /* Déclaration des attributs */
        pdfPanel = new PdfPanel();

        /* Hierarchie */
        setContentPane(pdfPanel);
        setJMenuBar(new MenuBar(this));   // Ajoute la barre des menus

        /* Action à la fermeture de la fenêtre */
        this.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent et) {
                quitter();
            }
        });
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        /* Affecte les raccourcis claviers de la fenêtre */
        RaccourcisClavier.chargerRaccourcis();
        RaccourcisClavier.affecterRaccourcis();
        RaccourcisClavier.sauvegarderRaccourcis();

        /* Render de la Frame */
        pack();
        setVisible(true);
    }

    /**
     * @return Le Panel contenant le document PDF
     */
    public PdfPanel getPdfPanel() {
        return pdfPanel;
    }

    /**
     * Si fullscreen est égal à false -> Désactive le mode Plein Ecran
     * Sinon Active le mode Plein Ecran
     */
    public void pleinEcran() {

        if (!fullscreen) { // Active le Plein Ecran
            GraphicsEnvironment graphics = GraphicsEnvironment.getLocalGraphicsEnvironment();
            device = graphics.getDefaultScreenDevice();
            device.setFullScreenWindow(this);
        } else { // Désactive le Plein Ecran
            device.setFullScreenWindow(null);
            setUndecorated(false);
            setVisible(true);
        }

        fullscreen = !fullscreen;
    }

    /**
     * Décharge le PDF courrant, ferme la fenêtre
     * Si il s'agit de la dernière fenêtre ouverte, arrête l'application
     */
    public void quitter() {

        /* Décharge le PDF */
        pdfPanel.dechargerPdf();

        /* Supprime la fenêtre de la liste du Gestionnaire de Fenêtre  */
        GestionFenetre.FENETRE_LIST.remove(this);
        dispose();

        /* Si la liste des fenêtres n'est pas pleine alors on reactive le boutton pour créer une nouvelle fenêtre  */
        if (GestionFenetre.FENETRE_LIST.size() < GestionFenetre.NB_MAX_PDF) GestionMode.activerBtnNouvelleFenetre();

        /* Si il n'y a plus de fenêtre ouvertes on quitte l'application */
        if (GestionFenetre.FENETRE_LIST.size() == 0) System.exit(0);
    }

    /**
     * Décharge le PDF courrant et redéfini le titre de l'application
     */
    public void fermerPdf() {
        getPdfPanel().dechargerPdf();
        setTitle(TITRE);
        pack();
    }
}
