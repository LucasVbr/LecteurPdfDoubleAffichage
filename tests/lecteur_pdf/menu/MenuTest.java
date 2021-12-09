/*
 * MenuTest.java, 25/11/2021
 * IUT Rodez 2021-2022, INFO 2
 * pas de copyright, aucun droits
 */

package lecteur_pdf.menu;

import lecteur_pdf.affichage.Fenetre;
import lecteur_pdf.document.Page;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests de la classe {@link Page}
 *
 * @author Léo FRANCH
 * @author Tristan NOGARET
 * @author Lucàs VABRE
 * @author Noé VILLENEUVE
 */
class MenuTest {

    /**
     * Classe de test de getMenuItems
     * Teste si le getter retourne bien les MenuItems
     */
    @Test
    void getMenuItems() {

        final String[] itemAttendu = {
            "Ouvrir", "Fermer", "Quitter", "Mode plein écran", "Zoom 150%",
            "Zoom 100%", "Zoom 50%", "Disposition Verticale",
            "Disposition Horizontale"};

        Menu menuTest = new Menu(new Fenetre());
        ArrayList<JMenuItem> menuItemTest = menuTest.getMenuItems();

        for (int i = 0; i < menuItemTest.size(); i++) {
            assertEquals(itemAttendu[i], menuItemTest.get(i).getText());
        }
    }

    /**
     * Classe de test de getMenuItem
     * Teste si le getter retourne bien le MenuItem à l'index donné
     */
    @Test
    void getMenuItem() {

        final String[] itemAttendu = {
            "Ouvrir", "Fermer", "Quitter", "Mode plein écran", "Zoom 150%",
            "Zoom 100%", "Zoom 50%", "Disposition Verticale",
            "Disposition Horizontale"};

        Menu menuTest = new Menu(new Fenetre());

        for (int i = 0; i < itemAttendu.length; i++) {
            assertEquals(menuTest.getMenuItem(i).getText(), itemAttendu[i]);
        }
    }

    /**
     * Classe de test Menu
     * Main pour voir l'affichage des menus et valide le test ou non
     */
    @Test
    void testMenu() {
        // Frame de test
        JFrame frame = new JFrame("Menu ouverture");

        // Créer le Menu
        Menu menu = new Menu(new Fenetre());

        // Ajouter la barre de menu au frame
        frame.setJMenuBar(menu);
        frame.setSize(300, 300);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}