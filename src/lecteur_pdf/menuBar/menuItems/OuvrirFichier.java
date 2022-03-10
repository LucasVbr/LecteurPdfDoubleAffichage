/*
 * OuvrirFichier.java, 26/02/2022
 * IUT Rodez 2021-2022, INFO2
 * Pas de copyright, aucun droits
 */

package lecteur_pdf.menuBar.menuItems;

import lecteur_pdf.Fenetre;
import lecteur_pdf.Popup;
import lecteur_pdf.SelectionnerFichier;

import javax.swing.*;
import java.io.File;

/**
 * Élément de Menu Ouvrir Fichier qui permet d'ouvrir un document
 *
 * @author Léo Franch
 * @author Tristan Nogaret
 * @author Lucàs Vabre
 * @author Noé Villeneuve
 */
public class OuvrirFichier extends MenuItem {

    /** Titre de la popup d'erreur lors d'une erreur d'ouverture de fichier */
    public static final String TITRE_ERREUR = "Erreur";

    /** Message de la popup d'erreur lors d'une erreur d'ouverture de fichier */
    public static final String MESSAGE_ERREUR = "Erreur : Le document n'as pas pu être chargé";

    /**
     * Créé un nouvel élément de Menu "Ouvrir Fichier"
     *
     * @param parent Référence de la fenêtre qui possède l'instance de ce MenuItem
     */
    public OuvrirFichier(Fenetre parent) {
        super(parent, "Ouvrir");
    }

    @Override
    protected void action() {

        int valide = parent.getPdfPanel().isCharge()
                ? Popup.OuiNonPopup(parent, FermerFichier.TITRE, FermerFichier.MESSAGE)
                : JOptionPane.YES_OPTION;

        if (valide == JOptionPane.YES_OPTION) {
            /* On charge le fichier si c'est possible */
            File fichier = SelectionnerFichier.ouvrirFichier(parent);

            if (fichier != null) {
                /* S'il y a deja un fichier d'ouvert, on le ferme */
                parent.getPdfPanel().dechargerPdf();
                parent.setTitle(Fenetre.TITRE);
                parent.pack();

                if (parent.getPdfPanel().chargerPdf(fichier)) {
                    parent.setTitle(Fenetre.TITRE + " - " + fichier.getName());
                    parent.pack();
                } else Popup.errorPopup(parent, TITRE_ERREUR, MESSAGE_ERREUR);
            }
        }
    }
}
