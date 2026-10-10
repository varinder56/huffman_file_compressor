
package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class History extends JPanel {

    public History() {
        setLayout(new BorderLayout());
        setBackground(new Color(245, 247, 252));

        JLabel title = new JLabel("Operation History");
        title.setFont(new Font("SansSerif", Font.BOLD, 27));
        title.setForeground(new Color(35, 45, 65));

        add(title, BorderLayout.NORTH);
    }
}
