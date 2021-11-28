///*
// * MenuTest.java, 25/11/2021
// * IUT Rodez 2021-2022, INFO 2
// * pas de copyright, aucun droits
// */
//
//package lecteur_pdf.menu;
//
//import lecteur_pdf.document.Page;
//import org.junit.jupiter.api.Test;
//
//import javax.swing.*;
//
//import java.util.ArrayList;
//
//import static org.junit.jupiter.api.Assertions.*;
//
///**
// * Tests de la classe {@link Page}
// *
// * @author Léo FRANCH
// * @author Tristan NOGARET
// * @author Lucàs VABRE
// * @author Noé VILLENEUVE
// */
//class MenuTest {
//
//    @Test
//    void getMenuItems() {
//
//        final String[] itemAttendu = {"Ouvrir", "Fermer"};
//
//        Menu menuTest = new Menu(this);
//        ArrayList<JMenuItem> menuItemTest = menuTest.getMenuItems();
//
//        for (int i = 0; i < menuItemTest.size(); i++) {
//            assertEquals(itemAttendu[i], menuItemTest.get(i).getText());
//        }
//    }
//
//    @Test
//    void getMenuItem() {
//
//        final String[] itemAttendu = {"Ouvrir", "Fermer"};
//
//        Menu menuTest = new Menu(this);
//
//        for (int i = 0; i < itemAttendu.length; i++) {
//            assertEquals(menuTest.getMenuItem(i).getText(), itemAttendu[i]);
//        }
//    }
//
//    @Test
//    void testMenu() {
//        // Frame de test
//        JFrame frame = new JFrame("Menu ouverture");
//
//        // Créer le Menu
//        Menu menu = new Menu(this);
//
//        // Ajouter la barre de menu au frame
//        frame.setJMenuBar(menu.getMenuBar());
//        frame.setSize(300,300);
//        frame.setLayout(null);
//        frame.setVisible(true);
//    }
//}