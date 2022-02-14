package lecteur_pdf_swing.pdf;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class PdfPanel extends JPanel {
    private int currentPage;
    private float currentScale;

    final PdfLoader pdfLoader;

    private JButton suivantButton;
    private JButton precedentButton;
    private JLabel pageIndicator;
    private JPanel mainPanel;
    private JLabel page;
    private JScrollPane scrollPane;
    private JTextField indexPage;

    public PdfPanel(File pdfFile) throws IOException {
        super();

        this.currentScale = 1.0f;

        scrollPane.setMaximumSize(Toolkit.getDefaultToolkit().getScreenSize());
        /* Définitions des arguments */
        pdfLoader = new PdfLoader(pdfFile);

        if (pdfFile != null) {
            defaultPage();

            /* Hierarchie */
            add(mainPanel);

            /* Actions */
            suivantButton.addActionListener(e -> updatePage(currentPage + 1));
            precedentButton.addActionListener(e -> updatePage(currentPage - 1));
            indexPage.addActionListener(e -> updatePageInput());
        }
    }

    public void updateScale(float scale) {
        this.currentScale = scale;
        updatePage(currentPage);
    }

    private void defaultPage() {
        updatePage(0);
    }

    public void updatePage(int index) {
        try {
            if (pdfLoader == null) throw new IllegalStateException();
            page.setIcon(new ImageIcon(pdfLoader.renderPage(index,
                                                            currentScale)));
            currentPage = index;
            pageIndicator.setText(String.format("%d/%d", currentPage + 1,
                    pdfLoader.getNbPages()));
        } catch (IOException | IllegalArgumentException | IllegalStateException ignored) {}
    }

    public void updatePageInput() {
        String input = indexPage.getText();
        try {
            int index = Integer.parseInt(input);
            if (index > 0 && index <= pdfLoader.getNbPages()) {
                updatePage(index - 1);
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            indexPage.setText("");
        }
    }
}
