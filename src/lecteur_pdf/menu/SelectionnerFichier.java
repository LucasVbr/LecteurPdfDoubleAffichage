/*
 * SelectionnerFichier.java, 18/11/2021
 * IUT Rodez 2021-2021, INFO2
 * pas de copyright, aucun droits
 */
package lecteur_pdf.menu;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.io.File;

/**
 * Classe qui permet d'ouvrir une fenêtre pour sélectionner le fichier pdf à
 * ouvrir
 *
 * @author Léo FRANCH
 * @author Tristan NOGARET
 * @author Lucàs VABRE
 * @author Noé VILLENEUVE
 * @version 1.0
 */
public class SelectionnerFichier {

    /**
     * Méthode qui créée une fenêtre pour que l'utilisateur choisisse un
     * fichier PDF
     *
     * @return file le fichier choisi par l'utilisateur
     */
    public static File ouvrirFichier() {

        final String TITRE = "Sélectionnez un PDF";
        final String DESCRIPTION = "PDF files (*.pdf)";
        final String EXTENSION = "pdf";

        /* Crée une fenêtre de sélection de fichier */
        JFileChooser fileChooser = new JFileChooser(
            FileSystemView.getFileSystemView().getDefaultDirectory());
        fileChooser.setDialogTitle(TITRE);
        fileChooser.setMultiSelectionEnabled(false);
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setAcceptAllFileFilterUsed(false);

        /* Filtre uniquement les fichiers PDF */
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
            DESCRIPTION, EXTENSION);
        fileChooser.addChoosableFileFilter(filter);


        int returnValue = fileChooser.showOpenDialog(null);

        return returnValue == 0
               ? new File(fileChooser.getSelectedFile().getAbsolutePath())
               : null;
    }
}
