package lecteur_pdf.menu;

import org.junit.jupiter.api.Test;

import javax.swing.*;

import java.sql.SQLOutput;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MenuTest {

    @Test
    void getMenuItems() {

        final String[] itemAttendu = {"Ouvrir", "Fermer"};

        Menu menuTest = new Menu();
        ArrayList<JMenuItem> menuItemTest = menuTest.getMenuItems();

        for (int i = 0; i < menuItemTest.size(); i++) {
            assertEquals(itemAttendu[i], menuItemTest.get(i).getText());
        }
    }

    @Test
    void getMenuItem() {

        final String[] itemAttendu = {"Ouvrir", "Fermer"};

        Menu menuTest = new Menu();

        for (int i = 0; i < itemAttendu.length; i++) {
            assertEquals(menuTest.getMenuItem(i).getText(), itemAttendu[i]);
        }
    }

    @Test
    void testMenu() {
        // Frame de test
        JFrame frame = new JFrame("Menu ouverture");

        // Créer le Menu
        Menu menu = new Menu();

        // Ajouter la barre de menu au frame
        frame.setJMenuBar(menu.getMenuBar());
        frame.setSize(300,300);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}