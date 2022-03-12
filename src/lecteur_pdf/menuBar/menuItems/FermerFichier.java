/*
 * FermerFichier.java, 26/02/2022
 * IUT Rodez 2021-2022, INFO2
 * Pas de copyright, aucun droits
 */

package lecteur_pdf.menuBar.menuItems;

import lecteur_pdf.Fenetre;
import lecteur_pdf.Popup;

import javax.swing.*;

/**
 * Élément de {@link lecteur_pdf.menuBar.menu.MenuFichier MenuFichier} qui
 * permet de fermer le document PDF courant
 *
 * @author Léo Franch
 * @author Tristan Nogaret
 * @author Lucàs Vabre
 * @author Noé Villeneuve
 * @see MenuItem
 */
public class FermerFichier extends MenuItem {

    /**
     * Titre de la {@link lecteur_pdf.Popup Popup} lors de la fermeture d'un
     * document
     */
    public static final String TITRE = "Fermeture du document";

    /**
     * Message de la {@link lecteur_pdf.Popup Popup} lors de la fermeture
     * d'un {@link lecteur_pdf.pdf.DocumentPdf document}
     */
    public static final String MESSAGE
        = "Êtes-vous sûr de vouloir fermer le document ?";

    /**
     * Créé un nouvel élément de
     * {@link lecteur_pdf.menuBar.menu.MenuFichier MenuFichier}
     *
     * @param parent Référence de la {@link Fenetre fenêtre}
     *               qui possède l'instance de ce menu
     *               {@link lecteur_pdf.menuBar.menuItems.MenuItem MenuItem}
     */
    public FermerFichier(Fenetre parent) {
        super(parent, "Fermer");
    }

    @Override
    protected void action() {
        if (parent.getPdfPanel().isCharge()) {
            int resultatPopup = Popup.OuiNonPopup(parent, TITRE, MESSAGE);
            if (resultatPopup == JOptionPane.YES_OPTION) {
                parent.fermerPdf();
            }
        }
    }
}
