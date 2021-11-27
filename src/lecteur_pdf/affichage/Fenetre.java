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
 * classe correspondant à l'objet Fenetre
 *
 * @author Léo FRANCH
 * @author Tristan NOGARET
 * @author Lucàs VABRE
 * @author Noé VILLENEUVE
 * @version  1.0
 */

public class Fenetre  {
    private JFrame frame;
    private String titre ;
    private Menu menu = new Menu();
    private Pdf pdf ;



    public Fenetre(){
        //création du frame
        frame = new JFrame( "lecteur pdf" );

        // Création du menu
        Menu menu = new Menu();

        // Ajout de la barre de menu au frame
        frame.setJMenuBar(menu.getMenuBar());
        frame.setSize( 300 ,300);
        frame.setLayout(null);
        frame.setVisible(true);


    }


}
