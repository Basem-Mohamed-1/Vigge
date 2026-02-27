package gui.OrdersWindow;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProductSelection extends JPanel implements ActionListener  {

    JButton addToCartBtn ;
    JTextField searchField ;
    JTextField quantityField;
    TableOrders tableOrders ;
    JButton deleteFromCartBtn;
    JComboBox<String> vegetables;
    JComboBox<String> vegetablesPrices;

    public ProductSelection(TableOrders tableOrders){

        this.tableOrders = tableOrders ;
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(600, 250));
        setLayout(null);
        
        JLabel productTitle = new JLabel("Product Selection");
        productTitle.setFont(new Font("MV Boli", Font.ITALIC | Font.BOLD, 24));
        productTitle.setForeground(new Color(0x00FF00));
        productTitle.setBounds(10, 10, 300, 30);


        JLabel searchLabel = new JLabel("VEGETABLE NAME");
        searchLabel.setFont(new Font("Arial", Font.BOLD, 14));
        searchLabel.setBounds(10, 50, 200, 20);
    
        Object [] availableVegetables = {
            "Tomato",
            "Potato",
            "Onion",
            "Cucumber",
            "Eggplant",
            "Zucchini",
            "Carrot",
            "Pepper",
            "Okra"
        };

        JLabel prices = new JLabel("Current Prices");
        prices.setFont(new Font("Arial", Font.BOLD, 14));
        prices.setBounds(220, 50, 200, 20);


        vegetables = new JComboBox(availableVegetables);
        vegetables.setBounds(10, 75, 200, 35);
        vegetables.setBackground(new Color(0xEAEAEA));
        vegetables.setForeground(Color.GRAY);



       Object[] vegPrices = {
            "Tomato     ......... $15.0",
            "Potato     ......... $20.0",
            "Onion      ......... $12.0",
            "Cucumber   ......... $9.0",
            "Eggplant   ......... $11.0",
            "Zucchini   ......... $7.5",
            "Carrot     ......... $11.2",
            "Pepper     ......... $21.5",
            "Okra       ......... $19.2"
        };
        vegetablesPrices = new JComboBox(vegPrices);
        vegetablesPrices.setEditable(false);
        vegetablesPrices.setBounds(220, 75, 200, 35);
        vegetablesPrices.setBackground(new Color(0xEAEAEA));
        vegetablesPrices.setForeground(Color.GRAY);
        
        JLabel quantityLabel = new JLabel("QUANTITY (KG/UNIT)");
        quantityLabel.setFont(new Font("Arial", Font.BOLD, 14));
        quantityLabel.setBounds(10, 280, 200, 20);
        
        quantityField = new JTextField("1");
        quantityField.setBounds(10, 300, 120, 40);
        quantityField.setBackground(new Color(0xEAEAEA));
        quantityField.setHorizontalAlignment(JTextField.CENTER);
        
        // JLabel stockLabel = new JLabel("LOW Stock: 4.2 kg left");
        // stockLabel.setForeground(new Color(255, 69, 0)); // Orange-red color
        
        addToCartBtn = new JButton("Add to Cart");
        addToCartBtn.setBounds(370, 300, 200, 40);
        addToCartBtn.setBackground(new Color(50, 150, 50));
        addToCartBtn.setForeground(new Color(0x00FF00));
        addToCartBtn.setFocusPainted(false);
        quantityLabel.setFont(new Font("Arial", Font.BOLD, 14));
        addToCartBtn.addActionListener(this);

        deleteFromCartBtn = new JButton("Delete From Cart");
        deleteFromCartBtn.setBounds(150, 300, 200, 40);
        deleteFromCartBtn.setBackground(new Color(50, 150, 50));
        deleteFromCartBtn.setForeground(Color.RED);
        deleteFromCartBtn.setFocusPainted(false);
        deleteFromCartBtn.addActionListener(this);
        deleteFromCartBtn.setFocusPainted(false);


        

        
       
        
        // Add all components to productSelection
        add(productTitle);
        add(searchLabel);
        add(vegetables);
        add(quantityLabel);
        add(quantityField);
        add(deleteFromCartBtn);
        add(addToCartBtn);
        add(vegetablesPrices);
        add(prices);
    
        // Set preferred size to accommodate all components
        setPreferredSize(new Dimension(600, 400));
    }


    public JButton addItemToCard(){
        return addToCartBtn;
    }

    public JTextField getQuantityField(){
        return quantityField;
    }

    public JButton deleteFromTheOrder(){
        return deleteFromCartBtn;
    }

    public JComboBox<String> getNameOfTheVegetable(){
        return vegetables;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}

