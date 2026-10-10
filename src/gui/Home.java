
package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Home extends JPanel {

    public Home(AppSkeleton app) {

        setLayout(new BorderLayout(0, 25));
        setBackground(new Color(245, 247, 252));

        JLabel title = new JLabel("Welcome to Huffman Compressor");
        title.setFont(new Font("SansSerif", Font.BOLD, 27));
        title.setForeground(new Color(35, 45, 65));

        JLabel subtitle = new JLabel(
                "Compress files efficiently. Restore them whenever you need.");
        subtitle.setForeground(new Color(115, 125, 145));

        JPanel heading = new JPanel(new GridLayout(2, 1, 0, 8));
        heading.setOpaque(false);
        heading.add(title);
        heading.add(subtitle);

        JPanel cards = new JPanel(new GridLayout(1, 3, 15, 0));
        cards.setOpaque(false);

        cards.add(createCard("Compression",
                () -> app.showPage("Compression")));

        cards.add(createCard("Decompression",
                () -> app.showPage("Decompression")));

        cards.add(createCard("Show History",
                () -> app.showPage("History")));

        add(heading, BorderLayout.NORTH);
        add(cards, BorderLayout.CENTER);
    }

    private JButton createCard(String title, Runnable action) {

        JButton card = new JButton(
                "<html><div style='text-align:left;'>"
                + "<b>" + title + "</b><br><br>"
                + "<span style='font-size:11px;'>"
                + "Open this section</span></div></html>");

        card.setFont(new Font("SansSerif", Font.PLAIN, 16));
        card.setForeground(new Color(35, 45, 65));
        card.setBackground(Color.WHITE);
        card.setFocusPainted(false);
        card.setHorizontalAlignment(JButton.LEFT);
        card.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(226, 231, 240)),
                BorderFactory.createEmptyBorder(20, 17, 20, 17)));

        card.addActionListener(event -> action.run());

        return card;
    }
}
