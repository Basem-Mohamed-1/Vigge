import java.awt.Dimension;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import gui.OrdersWindow.ProductSelection;
import gui.OrdersWindow.CustomerInfo;
import gui.OrdersWindow.Header;
import gui.OrdersWindow.TableOrders;
import Controller.*;
import java.awt.BorderLayout;
import java.awt.Color;

public class Cashier {
    
    public static void main(String[] args) throws Exception {

        JFrame frame = new JFrame("Vigge");
        frame.setLayout(new BorderLayout(20,10));
    try{
        ImageIcon icon = new ImageIcon("logo.png");
        frame.setIconImage(icon.getImage());
    }catch(Exception e){
        System.err.println(e.getMessage());
    }

        // Create a main content panel with margins
        JPanel contentPanel = new JPanel(new BorderLayout(20, 10));
        contentPanel.setBorder(new EmptyBorder(10, 10, 10, 10)); // top, left, bottom, right margins
        
        Header header = new Header();
        JPanel leftSide = new JPanel();
    
        leftSide.setPreferredSize(new Dimension(600,80));
        leftSide.setLayout(new BorderLayout(10,10));

        CustomerInfo customerInfo = new  CustomerInfo();
        TableOrders tableOrders = new TableOrders();
        ProductSelection productSelection = new ProductSelection(tableOrders);
            
        CashierController controller = new CashierController(tableOrders, productSelection, customerInfo);

        leftSide.add(productSelection, BorderLayout.CENTER);
        leftSide.add(customerInfo, BorderLayout.NORTH);

        // Add everything to content panel instead of directly to frame
        contentPanel.add(header, BorderLayout.NORTH);
        contentPanel.add(leftSide, BorderLayout.WEST);
        contentPanel.add(tableOrders, BorderLayout.CENTER);
        frame.setBackground(Color.gray);
        frame.add(contentPanel); // Add content panel with margins to frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
        frame.setResizable(false);

    }
}