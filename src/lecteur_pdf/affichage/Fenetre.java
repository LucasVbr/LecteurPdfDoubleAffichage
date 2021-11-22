/*
 * Fenetre, 22/11/2021
 * IUT Rodez 2021, INFO2
 * pas de copyright, aucun droits
 */

package lecteur_pdf.affichage;

import lecteur_pdf.document.Pdf;
import lecteur_pdf.menu.Menu;

import javax.swing.*;

/**
 * Définis virtuellement un fichier PDF
 *
 * @author Léo FRANCH
 * @author Tristan NOGARET
 * @author Lucàs VABRE
 * @author Noé VILLENEUVE
 * @version  1.0
 */

public class Fenetre extends javax.swing.JFrame {
    private JFrame frame ;
    private String titre ;
    private Menu menu ;
    private Pdf pdf ;


    public Fenetre() {
        frame = new JFrame( "sans titre" );

    }

    public Fenetre(String titre) {
        frame = new JFrame( titre );
    }

}
