package gui;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class Home extends JPanel {

    //! colors
    private final Color backgroundColor = new Color(245, 247, 252);
    private final Color titleColor = new Color(15, 23, 42);
    private final Color secondaryColor = new Color(71, 85, 105);
    private final Color accentColor = new Color(21, 87, 255);
    private final Color borderColor = new Color(220, 227, 239);

    public Home(AppSkeleton app) {

        setLayout(new BorderLayout(0, 24));
        setBackground(backgroundColor);
        add(createHeading(), BorderLayout.NORTH);
        add(createMainContent(app), BorderLayout.CENTER);
    }

    //! heading
    private JPanel createHeading() {

        JPanel heading = new JPanel();
        heading.setLayout(new BoxLayout(heading, BoxLayout.Y_AXIS));
        heading.setOpaque(false);

        JLabel title = new JLabel("Welcome to Huffman File Compressor");
        title.setFont(new Font("SansSerif", Font.BOLD, 28));
        title.setForeground(titleColor);
        title.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel subtitle = new JLabel("Compress your files efficiently and restore them whenever you need.");
        subtitle.setFont(new Font("SansSerif", Font.PLAIN, 14));
        subtitle.setForeground(secondaryColor);
        subtitle.setAlignmentX(Component.LEFT_ALIGNMENT);

        heading.add(title);
        heading.add(Box.createVerticalStrut(8));
        heading.add(subtitle);

        return heading;
    }

    //! main content
    private JPanel createMainContent(AppSkeleton app) {

        JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        content.setOpaque(false);

        JLabel sectionTitle = new JLabel("Get started");
        sectionTitle.setFont(new Font("SansSerif", Font.BOLD, 17));
        sectionTitle.setForeground(titleColor);
        sectionTitle.setAlignmentX(Component.LEFT_ALIGNMENT);

        content.add(sectionTitle);
        content.add(Box.createVerticalStrut(20));

        //! First row
        JPanel topCards = new JPanel(new GridLayout(1, 2, 12, 0));
        topCards.setOpaque(false);
        topCards.setAlignmentX(Component.LEFT_ALIGNMENT);
        topCards.setPreferredSize(new Dimension(0, 180));
        topCards.setMinimumSize(new Dimension(0, 180));
        topCards.setMaximumSize(new Dimension(Integer.MAX_VALUE, 180));

        topCards.add(createCard(
                "Compression",
                "Compress a file into a smaller encoded file.",
                "Open compression →",
                "compression",
                () -> app.showPage("Compression")
        ));

        topCards.add(createCard(
                "Decompression",
                "Restore files compressed by the application.",
                "Open decompression →",
                "decompression",
                () -> app.showPage("Decompression")
        ));

        content.add(topCards);
        content.add(Box.createVerticalStrut(12));

        //! Second row
        JButton historyCard = createHistoryCard(() -> app.showPage("History"));

        historyCard.setAlignmentX(Component.LEFT_ALIGNMENT);
        historyCard.setPreferredSize(new Dimension(0, 85));
        historyCard.setMinimumSize(new Dimension(0, 85));
        historyCard.setMaximumSize(new Dimension(Integer.MAX_VALUE, 85));

        content.add(historyCard);

        return content;
    }

    //! Create card first row 
    private JButton createCard(
            String title,
            String description,
            String actionText,
            String iconType,
            Runnable action) {

        JButton card = new JButton();
        card.setLayout(new BorderLayout());
        card.setBackground(Color.WHITE);
        card.setOpaque(true);
        card.setFocusPainted(false);
        card.setBorderPainted(true);
        card.setBorder(new LineBorder(borderColor, 1));
        card.setCursor(new Cursor(Cursor.HAND_CURSOR));
        card.setHorizontalAlignment(SwingConstants.LEFT);
        card.setVerticalAlignment(SwingConstants.TOP);
        card.setMargin(new Insets(0, 0, 0, 0));

        JPanel details = new JPanel();
        details.setLayout(new BoxLayout(details, BoxLayout.Y_AXIS));
        details.setOpaque(false);
        details.setBorder(new EmptyBorder(15, 13, 14, 13));

        JLabel icon = createIcon(iconType);
        JLabel titleLabel = createLabel(title, 16, Font.PLAIN, titleColor);
        JLabel descriptionLabel = createLabel(description, 14, Font.PLAIN, secondaryColor);
        JLabel actionLabel = createLabel(actionText, 14, Font.PLAIN, accentColor);

        details.add(icon);
        details.add(Box.createVerticalStrut(12));
        details.add(titleLabel);
        details.add(Box.createVerticalStrut(13));
        details.add(descriptionLabel);
        details.add(Box.createVerticalStrut(12));
        details.add(actionLabel);

        card.add(details, BorderLayout.CENTER);
        card.addActionListener(event -> action.run());

        return card;
    }

    //! history
    private JButton createHistoryCard(Runnable action) {

        JButton card = new JButton();
        card.setLayout(new BorderLayout(14, 0));
        card.setBackground(Color.WHITE);
        card.setOpaque(true);
        card.setFocusPainted(false);
        card.setBorderPainted(true);
        card.setBorder(new LineBorder(borderColor, 1));
        card.setCursor(new Cursor(Cursor.HAND_CURSOR));
        card.setMargin(new Insets(0, 0, 0, 0));

        JPanel details = new JPanel(new BorderLayout(14, 0));
        details.setOpaque(false);
        details.setBorder(new EmptyBorder(15, 14, 14, 14));

        JLabel icon = createIcon("history");

        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
        textPanel.setOpaque(false);

        JLabel title = createLabel("Operation History", 16, Font.PLAIN, titleColor);

        JLabel description = createLabel("Review previous compression and decompression operations.",14, Font.PLAIN, secondaryColor);

        textPanel.add(title);
        textPanel.add(Box.createVerticalStrut(8));
        textPanel.add(description);

        JLabel arrow = createLabel("→", 18, Font.PLAIN, accentColor);arrow.setHorizontalAlignment(SwingConstants.RIGHT);

        details.add(icon, BorderLayout.WEST);
        details.add(textPanel, BorderLayout.CENTER);

        JPanel arrowWrapper = new JPanel(new BorderLayout());
        arrowWrapper.setOpaque(false);
        arrowWrapper.setBorder(new EmptyBorder(0, 0, 0, 14));
        arrowWrapper.add(arrow, BorderLayout.CENTER);

        card.add(details, BorderLayout.CENTER);
        card.add(arrowWrapper, BorderLayout.EAST);

        card.addActionListener(event -> action.run());

        return card;
    }

    //! icon
    private JLabel createIcon(String type) {

        String symbol;

        switch (type) {
        case "compression" -> symbol = "🗜"; 
        case "decompression" -> symbol = "📂";
        case "history" -> symbol = "🕘"; 
        default -> symbol = "•";
        }

        return createLabel(symbol, 25, Font.PLAIN, accentColor);
    }

    // Shared label styling
    private JLabel createLabel(String text,int size,int style,Color color) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("SansSerif", style, size));
        label.setForeground(color);
        return label;
    }
}
