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
    private Fenetre[] fenetresOuvertes;
    File fichier = null ;


    public void ouvrirFenetre(){
        int placeVide;
        for (placeVide=0; placeVide<2; placeVide++){
            if (fenetresOuvertes[placeVide]==null){
                break;
            }
        }
        if(placeVide==2) {
            //todo erreur trop de fenetres
        }else {
            Fenetre fenetre = new Fenetre();
            fenetresOuvertes[placeVide] = fenetre;
        }
    }
    public void fermerFenetre(JFrame fenetre){
        for (int i = 0; i<2 ; i++){
            if (fenetre==fenetresOuvertes[i]){
                fenetre.dispose();
                fenetresOuvertes[i]= null ;
            }
        }
    }
    public static void main(String[] args)  {
        JFrame fenetrePrincipale = new Fenetre();
        //fenetrePrincipale.ouvrirPDF();
    }


}
