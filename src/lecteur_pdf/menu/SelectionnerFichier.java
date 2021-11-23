/*
 * SelectionnerFichier.java, 18/11/2021
 * IUT Rodez 2021-2021, INFO2
 * pas de copyright, aucun droits
 */
package lecteur_pdf.menu;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
/**
 * TODO class comment
 *
 * @author Léo FRANCH
 * @author Tristan NOGARET
 * @author Lucàs VABRE
 * @author Noé VILLENEUVE
 * @version  1.0
 */
public class SelectionnerFichier {

    /**
     * Méthode qui créée une fenêtre pour que l'utilisateur choisisse un
     * fichier PDF
     * @param actionEvent un action event
     * @return file le fichier choisi par l'utilisateur
     */
    public static File ouvrirFichier(ActionEvent actionEvent) {

        JFrame JFileChooserStage = new JFrame();

        JFileChooser fileChooser = new JFileChooser
                     (FileSystemView.getFileSystemView().getHomeDirectory());
        fileChooser.setDialogTitle("Sélectionnez un PDF");
//        fileChooser.setMultiSelectionEnabled(true);
        fileChooser.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter
            filter = new FileNameExtensionFilter("PDF files", "pdf");
        fileChooser.addChoosableFileFilter(filter);

//        try {
//            PDDocument document = new PDDocument();
//            PDFRenderer render = new PDFRenderer(document);
//            PDDocument.load(file);
//            return new File(fileChooser.getSelectedFile().getPath());
//        } catch (Exception e) { // TODO préciser erreur
//            e.printStackTrace();
//        }

//        if (returnValue == JFileChooser.APPROVE_OPTION) {
//            System.out.println(jfc.getSelectedFile().getPath());
//        }

        return new File(fileChooser.getSelectedFile().getPath());
    }
}
