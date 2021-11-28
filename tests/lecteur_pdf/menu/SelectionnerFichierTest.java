package lecteur_pdf.menu;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import lecteur_pdf.menu.Menu;

import javax.swing.*;

class SelectionnerFichierTest {

    /**
     * TODO comment main
     *
     * @param args
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("Menu ouverture");
        Menu menu = new Menu();
        frame.setJMenuBar(menu.getMenuBar());
        frame.setSize(300,300);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}