package gui.OrdersWindow;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
// import javax.swing.*;
// import javax.swing.border.EmptyBorder;
// import javax.swing.table.DefaultTableModel;

public class Header  extends JPanel{
    public Header(){

        ImageIcon icon = new ImageIcon("gui/assets/logo.png");
        JLabel logo = new JLabel(icon);
        logo.setText("Vigge");
        logo.setForeground(new Color(0x00FF00));
        logo.setFont(new Font("MV Boli",Font.PLAIN,35));
        logo.setHorizontalAlignment(JLabel.LEFT);
        logo.setVerticalAlignment(JLabel.CENTER);

        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(100,80));
        setBackground(new Color(0xFFFFFF));
        add(logo,BorderLayout.WEST);
    }
}
