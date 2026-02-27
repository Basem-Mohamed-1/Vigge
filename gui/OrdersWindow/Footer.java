package gui.OrdersWindow;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.*;

public class Footer extends JPanel {

    JLabel lblTotalValue;
    JLabel lblItemsValue;
    JButton btnPlaceOrder;
    public Footer() {

        setPreferredSize(new Dimension(500, 150));
        setBackground(Color.WHITE);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        //  TOTAL PAYABLE Section
        JPanel totalPanel = new JPanel();
        totalPanel.setLayout(new BoxLayout(totalPanel, BoxLayout.Y_AXIS));
        totalPanel.setOpaque(false);

        JLabel lblTotalText = new JLabel("TOTAL PAYABLE");
        lblTotalText.setFont(new Font("SansSerif", Font.BOLD, 11)); // subtle label
        lblTotalText.setForeground(new Color(150, 160, 175));
        lblTotalText.setAlignmentX(Component.LEFT_ALIGNMENT);

        lblTotalValue = new JLabel("$0");
        lblTotalValue.setFont(new Font("SansSerif", Font.BOLD, 38)); // big number
        lblTotalValue.setForeground(new Color(20, 25, 45));
        lblTotalValue.setAlignmentX(Component.LEFT_ALIGNMENT);

        totalPanel.add(lblTotalText);
        totalPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        totalPanel.add(lblTotalValue);

        //  Vertical Separator
        JSeparator separator = new JSeparator(SwingConstants.VERTICAL);
        separator.setPreferredSize(new Dimension(1, 60));
        separator.setForeground(new Color(230, 230, 230));

        //  ITEMS IN CART Section
        JPanel itemsPanel = new JPanel();
        itemsPanel.setLayout(new BoxLayout(itemsPanel, BoxLayout.Y_AXIS));
        itemsPanel.setOpaque(false);

        JLabel lblItemsText = new JLabel("ITEMS IN CART");
        lblItemsText.setFont(new Font("SansSerif", Font.BOLD, 11)); // subtle like TOTAL
        lblItemsText.setForeground(new Color(150, 160, 175));
        lblItemsText.setAlignmentX(Component.LEFT_ALIGNMENT);

        lblItemsValue = new JLabel("0"); // big number like TOTAL
        lblItemsValue.setFont(new Font("SansSerif", Font.BOLD, 38));
        lblItemsValue.setForeground(new Color(20, 25, 45));
        lblItemsValue.setAlignmentX(Component.LEFT_ALIGNMENT);

        itemsPanel.add(lblItemsText);
        itemsPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        itemsPanel.add(lblItemsValue);

        // PLACE ORDER Button
         btnPlaceOrder = new JButton("🛒 PLACE ORDER");
        btnPlaceOrder.setBackground(new Color(102, 241, 92));
        btnPlaceOrder.setForeground(new Color(10, 20, 30));
        btnPlaceOrder.setFont(new Font("SansSerif", Font.BOLD, 16));
        btnPlaceOrder.setFocusPainted(false);
        btnPlaceOrder.setBorder(BorderFactory.createEmptyBorder(15, 25, 15, 25));
        btnPlaceOrder.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnPlaceOrder.setOpaque(true);

        // --- Add Components using GridBagConstraints ---

        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.anchor = GridBagConstraints.WEST;

        // Total Section
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0;
        gbc.insets = new Insets(20, 20, 20, 20);
        add(totalPanel, gbc);

        // Separator
        gbc.gridx = 1;
        gbc.insets = new Insets(45, 5, 45, 15);
        add(separator, gbc);

        // Items Section
        gbc.gridx = 2;
        gbc.weightx = 1.0; // give leftover horizontal space
        gbc.insets = new Insets(20, 5, 20, 20);
        add(itemsPanel, gbc);

        // Button
        gbc.gridx = 3;
        gbc.weightx = 2;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.fill = GridBagConstraints.NONE;
        add(btnPlaceOrder, gbc);
    }

    // Getter for total price
    public JLabel getTotalPriceLabel() {
        return lblTotalValue;
    }

    // Getter for total items
    public JLabel getTotalItemLabel() {
        return lblItemsValue;
    }

    public JButton getPlaceOrdeButton(){
        return btnPlaceOrder;
    }
}