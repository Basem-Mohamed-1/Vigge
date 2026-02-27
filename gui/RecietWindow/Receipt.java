package gui.RecietWindow;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Receipt {
    // --- Frame and Main Panels ---
    private JFrame frame;
    private JPanel contentPanel;
    private JPanel header;
    private JPanel body;
    private JPanel footer;

    // --- Detail Labels (Fields you can catch) ---
    private JLabel nameValueLabel;
    private JLabel phoneValueLabel;
    private JLabel dateValueLabel;
    private JLabel locationValueLabel;
    private JLabel totalValue;
    // --- Table Components ---
    private DefaultTableModel model;
    private JTable ordersTable;
    JButton btnSave ;

    public Receipt() {
        // Initialize the components
        initializeUI();
        
        // Assemble and Show
        assembleReceipt();
        
        frame.setVisible(true);
    }

    private void initializeUI() {
        frame = new JFrame("Receipt System");
        
        // 1. Content Panel
        contentPanel = new JPanel();
        contentPanel.setPreferredSize(new Dimension(800, 800));
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBorder(new javax.swing.border.LineBorder(Color.LIGHT_GRAY, 5, true));
        contentPanel.setBackground(Color.WHITE);

        // 2. Header & Logo
        header = new JPanel();
        header.setBackground(Color.WHITE);
        header.setLayout(new BoxLayout(header, BoxLayout.Y_AXIS));
        header.setBorder(new EmptyBorder(20, 0, 10, 0));

        ImageIcon icon = new ImageIcon("gui/assets/logo.png");
        JLabel logo = new JLabel("Vigge", icon, JLabel.CENTER);
        logo.setForeground(new Color(0x00FF00));
        logo.setFont(new Font("MV Boli", Font.PLAIN, 35));
        logo.setAlignmentX(Component.CENTER_ALIGNMENT);
        header.add(logo);
        header.add(Box.createVerticalStrut(20));

        // 3. Information Grid & Labels
        JPanel information = new JPanel(new GridLayout(2, 2, 0, 15));
        information.setBackground(Color.WHITE);
        information.setBorder(new EmptyBorder(0, 40, 0, 40));
        information.setMaximumSize(new Dimension(750, 150));

        nameValueLabel = new JLabel("Alex Johnson");
        phoneValueLabel = new JLabel("+1 (555) 012-3456");
        dateValueLabel = new JLabel("Oct 24, 2023");
        locationValueLabel = new JLabel("Downtown Branch");

        information.add(wrapInDetailBlock("NAME", nameValueLabel, false));
        information.add(wrapInDetailBlock("PHONE", phoneValueLabel, true));
        information.add(wrapInDetailBlock("DATE", dateValueLabel, false));
        information.add(wrapInDetailBlock("LOCATION", locationValueLabel, true));
        header.add(information);

        // 4. Body (Table)
        body = new JPanel(new BorderLayout());
        body.setBackground(Color.WHITE);
        body.setBorder(new EmptyBorder(0, 40, 0, 40));

        String column[] = {"ID", "TYPE", "QUANTITY", "PRICE"};
        model = new DefaultTableModel(column, 0) {
            @Override public boolean isCellEditable(int r, int c) { return false; }
        };
        
        ordersTable = new JTable(model);
        ordersTable.getTableHeader().setFont(new Font("MV Boli", Font.BOLD, 18));
        ordersTable.setFont(new Font("MV Boli", Font.ITALIC, 14));
        ordersTable.setRowHeight(40);
        ordersTable.setSelectionBackground(new Color(0x00FF00));

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        centerRenderer.setBorder(BorderFactory.createLineBorder(new Color(0x00FF00)));
        for (int i = 0; i < ordersTable.getColumnCount(); i++) {
            ordersTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        JScrollPane jscrollpane = new JScrollPane(ordersTable);
        jscrollpane.getViewport().setBackground(Color.WHITE);
        jscrollpane.setBorder(BorderFactory.createEmptyBorder());
        body.add(jscrollpane, BorderLayout.CENTER);

        // 5. Footer (Buttons)
        footer = new JPanel(new FlowLayout(FlowLayout.RIGHT, 20, 20));
        footer.setBackground(Color.WHITE);
        footer.setPreferredSize(new Dimension(800, 100));


        JPanel totalPanel = new JPanel(new GridLayout(2,1,0,0));
        totalPanel.setBackground(Color.white);
        JLabel totalText = new JLabel("TOTAL PAYABLE");
        totalText.setFont(new Font("SansSerif", Font.BOLD, 11)); // subtle label
        totalText.setForeground(new Color(150, 160, 175));
        totalText.setAlignmentX(Component.LEFT_ALIGNMENT);

        totalValue = new JLabel("$0");
        totalValue.setFont(new Font("SansSerif", Font.BOLD, 30)); // big number
        totalValue.setForeground(new Color(20, 25, 45));
        totalValue.setAlignmentX(Component.LEFT_ALIGNMENT);

        totalPanel.add(totalText);
        totalPanel.add(totalValue);

        JButton btnDismiss = createStyledButton("Dismiss", new Color(0xFF4444));
        btnSave = createStyledButton("Save Receipt", new Color(0x00FF00));
        btnDismiss.addActionListener(e -> frame.dispose());
        footer.add(totalPanel);
        footer.add(Box.createHorizontalStrut(270));
        footer.add(btnDismiss);
        footer.add(btnSave);
    }

    private void assembleReceipt() {
        contentPanel.add(header);
        contentPanel.add(Box.createVerticalStrut(40));
        contentPanel.add(body);
        contentPanel.add(footer);

        frame.add(contentPanel);
        frame.setSize(800, 800);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
    }


    // --- ACCESSOR METHODS (GETTERS) ---
    public JLabel getNameLabel() { return nameValueLabel; }
    public JLabel getPhoneLabel() { return phoneValueLabel; }
    public JLabel getDateLabel() { return dateValueLabel; }
    public JLabel getLocationLabel() { return locationValueLabel; }
    public JTable getOrdersTable() { return ordersTable; }
    public DefaultTableModel getTableModel() { return model; }
    public JPanel getHeaderPanel() { return header; }
    public JPanel getFooterPanel() { return footer; }
    public JFrame getFrame() { return frame; }
    public JLabel getTotalValue() {return totalValue;}
    public JButton getSaveReceiptBtn(){return btnSave;}


    // --- STYLING HELPERS ---
    private JPanel wrapInDetailBlock(String title, JLabel valueLabel, boolean alignRight) {
        JPanel block = new JPanel();
        block.setLayout(new BoxLayout(block, BoxLayout.Y_AXIS));
        block.setBackground(Color.WHITE);

        JLabel lblTitle = new JLabel(title);
        lblTitle.setFont(new Font("SansSerif", Font.BOLD, 12));
        lblTitle.setForeground(new Color(160, 170, 185));

        valueLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        valueLabel.setForeground(new Color(26, 31, 54));

        float alignment = alignRight ? Component.RIGHT_ALIGNMENT : Component.LEFT_ALIGNMENT;
        lblTitle.setAlignmentX(alignment);
        valueLabel.setAlignmentX(alignment);
        block.setAlignmentX(alignment);

        block.add(lblTitle);
        block.add(Box.createVerticalStrut(1));
        block.add(valueLabel);
        return block;
    }

    private JButton createStyledButton(String text, Color bgColor) {
        JButton btn = new JButton(text);
        btn.setFont(new Font("MV Boli", Font.BOLD, 16));
        btn.setPreferredSize(new Dimension(150, 45));
        btn.setBackground(bgColor);
        btn.setFocusPainted(false);
        return btn;
    }

     public JPanel getContentPanel() {
        return contentPanel;
    }

     public JLabel getNameValueLabel() {
        return nameValueLabel;
    }

    public JLabel getPhoneValueLabel() {
        return phoneValueLabel;
    }

    public JLabel getDateValueLabel() {
        return dateValueLabel;
    }

    public JLabel getLocationValueLabel() {
        return locationValueLabel;
    }

    public DefaultTableModel getModel() {
        return model;
    }
}