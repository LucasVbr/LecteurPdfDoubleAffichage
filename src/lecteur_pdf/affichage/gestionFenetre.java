/*
 * gestionFenetre, 22/11/2021
 * IUT Rodez 2021, INFO2
 * pas de copyright, aucun droits
 */

package lecteur_pdf.affichage;

import lecteur_pdf.document.Pdf;
import lecteur_pdf.menu.Menu;

import java.io.IOException;
import java.util.ArrayList;

import static lecteur_pdf.menu.SelectionnerFichier.ouvrirFichier;

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


    public static void ouvrirFenetre(){
    new Fenetre();
    }
    public static void fermerFenetre(){

    }
    public static void main ()  {
        ouvrirFenetre();
    }
}
