/*
 * gestionFenetre, 22/11/2021
 * IUT Rodez 2021, INFO2
 * pas de copyright, aucun droits
 */

package lecteur_pdf.affichage;

import lecteur_pdf.document.PDF;
import lecteur_pdf.menu.Menu;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * classe de gestion des fenêtres
 *
 * @author Léo FRANCH
 * @author Tristan NOGARET
 * @author Lucàs VABRE
 * @author Noé VILLENEUVE
 * @version  1.0
 */
public class gestionFenetre {


    final int NB_MAX_FENETRE = 2 ;
    private ArrayList<Fenetre> fenetresOuvertes;


    public void ouvrirPDF() throws IOException {
        PDF doc = new PDF(new File("F:/test_pdf1.pdf"));

        JScrollPane scrollPane = new JScrollPane(doc);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        //this.getContentPane().add(scrollPane);
        try {
            JPanel pdf = new PDF(Menu.fichier);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void fermerPDF(){

    }
    public static void main (String[] args)  {
        JFrame fenetrePrincipale = new Fenetre();
        //fenetrePrincipale.ouvrirPDF();
    }


}
