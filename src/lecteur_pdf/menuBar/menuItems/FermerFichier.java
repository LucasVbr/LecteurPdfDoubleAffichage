/*
 * FermerFichier.java, 26/02/2022
 * IUT Rodez 2021-2022, INFO 2
 * pas de copyright, aucun droits
 */

package lecteur_pdf.menuBar.menuItems;

import lecteur_pdf.GestionPdf;
import lecteur_pdf.IhmPdf;

import java.awt.event.KeyEvent;

/**
 * TODO commentaires
 *
 * @author Léo Franch
 * @author Lucas Vabre
 * @author Noé Villeneuve
 * @author Tristan Nogaret
 */
public class FermerFichier extends MenuItem {

    /**
     * TODO
     *
     * @param parent Référence de la fenêtre qui possède l'instance de ce MenuItem
     */
    public FermerFichier(IhmPdf parent) {
        super(parent, "Fermer");

        /* Action du bouton */
        addActionListener(e -> {
            parent.getPdfPanel().dechargerPdf();
            parent.setTitle(GestionPdf.TITRE_APPLICATION);
            parent.pack();
        });

        /* TODO Définition du raccourcis clavier a modifier */
        setRaccourcis(KeyEvent.VK_X, KeyEvent.CTRL_DOWN_MASK);
    }
}
