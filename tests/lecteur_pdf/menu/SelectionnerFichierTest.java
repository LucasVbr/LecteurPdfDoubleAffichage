package lecteur_pdf.menu;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import lecteur_pdf.menu.Menu;

import javax.swing.*;

class SelectionnerFichierTest {

    @Test
    void ouvrirFichier() {
        Menu menu = new Menu();
        SelectionnerFichier.ouvrirFichier();
    }
}