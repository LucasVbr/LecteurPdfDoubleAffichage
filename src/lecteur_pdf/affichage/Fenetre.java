/*
 * Fenetre, 22/11/2021
 * IUT Rodez 2021, INFO2
 * pas de copyright, aucun droits
 */

package lecteur_pdf.affichage;

import lecteur_pdf.document.PDF;
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

public class Fenetre extends JFrame {
    //private JFrame frame;
    private String titre ;
    private Menu menu = new Menu();
    private PDF pdf ;



    public Fenetre(){

        // Création du menu
        Menu menu = new Menu();

        // Ajout de la barre de menu au frame

        this.setJMenuBar(menu.getMenuBar());
        this.setSize( 300 ,300);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);



    }


}
