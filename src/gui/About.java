
package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class About extends JPanel {

    public About() {
        setLayout(new BorderLayout());
        setBackground(new Color(245, 247, 252));

        JLabel title = new JLabel("About Huffman File Compressor");
        title.setFont(new Font("SansSerif", Font.BOLD, 27));
        title.setForeground(new Color(35, 45, 65));

        add(title, BorderLayout.NORTH);
    }
}
