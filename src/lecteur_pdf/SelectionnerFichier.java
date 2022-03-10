/*
 * SelectionnerFichier.java, 18/11/2021
 * IUT Rodez 2021-2021, INFO2
 * pas de copyright, aucun droits
 */

package lecteur_pdf;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.io.File;

/**
 * Classe qui permet d'ouvrir une fenêtre pour sélectionner le fichier pdf à ouvrir
 *
 * @author Léo FRANCH
 * @author Tristan NOGARET
 * @author Lucàs VABRE
 * @author Noé VILLENEUVE
 */
public class SelectionnerFichier {

    /** Le titre de la fenêtre */
    private static final String TITRE = "Sélectionnez un PDF";

    /** Description du filtre */
    private static final String DESCRIPTION = "PDF files (*.pdf)";

    /** Extension de fichier filtré */
    private static final String EXTENSION = "pdf";

    /** Valeur du bouton OK */
    private static final String BOUTON_OK = "Ouvrir";

    /** Valeur du bouton Annuler */
    private static final String BOUTON_ANNULER = "Annuler";

    /** Indice au survol du bouton Ok */
    private static final String INDICE_BOUTON_OK = "Ouvre le fichier sélectionné";

    /** Indice au survol du bouton Annuler */
    private static final String INDICE_BOUTON_ANNULER = "Annule la sélection";

    /**
     * Méthode qui créée une fenêtre pour que l'utilisateur choisisse un
     * fichier PDF
     *
     * @return le fichier choisi par l'utilisateur, null si aucun fichier
     * n'est choisi
     */
    public static File ouvrirFichier(JFrame parent) {

        /* Créé une fenêtre de sélection de fichier */
        JFileChooser fileChooser = new JFileChooser(
            FileSystemView.getFileSystemView().getDefaultDirectory());
        fileChooser.setDialogTitle(TITRE);

        /* Options du JFileChooser */
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setMultiSelectionEnabled(false);
        fileChooser.setAcceptAllFileFilterUsed(false);

        /* Défini le texte et les tooltips des boutons */
        fileChooser.setApproveButtonText(BOUTON_OK);
        fileChooser.setApproveButtonToolTipText(INDICE_BOUTON_OK);
        UIManager.put("FileChooser.cancelButtonText", BOUTON_ANNULER);
        UIManager.put("FileChooser.cancelButtonToolTipText",
                      INDICE_BOUTON_ANNULER);
        SwingUtilities.updateComponentTreeUI(fileChooser);

        /* Filtre uniquement les fichiers PDF */
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
            DESCRIPTION, EXTENSION);
        fileChooser.addChoosableFileFilter(filter);


        /* Renvoie un File lorsque l'utilisateur appuie sur le bouton Ouvrir */
        int returnValue = fileChooser.showOpenDialog(parent);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            return new File(fileChooser.getSelectedFile().getAbsolutePath());
        }

        /* Renvoie null si le fichier n'est pas trouvé */
        return null;
    }
}
