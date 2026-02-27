package gui.OrdersWindow;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

public class CustomerInfo extends JPanel{

    private JTextField tfCusomterName;
    private JTextField tfCusomterPhone;
    private JTextField tfCusomterLocation;
    public CustomerInfo(){

        setBackground(Color.white);
        setPreferredSize(new Dimension(600,300));
        setLayout(null);
        JLabel customerInformation = new JLabel("Customer Information");
        JLabel customerName = new JLabel("Full name");       
        JLabel PhoneNumber = new JLabel("Phone number");
        JLabel location = new JLabel("Location");

        tfCusomterName = new JTextField();
        tfCusomterPhone= new JTextField();
        tfCusomterLocation = new JTextField();


        add(customerInformation);
        add(customerName);
        add(PhoneNumber);
        add(location);
        add(tfCusomterName);
        add(tfCusomterPhone);
        add(tfCusomterLocation);



        customerInformation.setBounds(10,10,300,20);
        customerInformation.setFont(new Font("MV Boli", Font.ITALIC | Font.BOLD, 24));
        customerInformation.setForeground(new Color(0x00FF00));
        customerName.setBounds(10,40,300,30);
        customerName.setFont(new Font("MV Boli",Font.ITALIC,20));
        tfCusomterName.setBounds(10,80,250,40);
        tfCusomterName.setBackground(new Color(0xEAEAEA));

        PhoneNumber.setBounds(330,40,300,30);
        PhoneNumber.setFont(new Font("MV Boli",Font.ITALIC,20));
        tfCusomterPhone.setBounds(330,80,250,40);
        tfCusomterPhone.setBackground(new Color(0xEAEAEA));

        
        location.setBounds(10,160,100,20);
        location.setFont(new Font("MV Boli",Font.ITALIC,20));
        tfCusomterLocation.setBounds(10,200,250,40);
        tfCusomterLocation.setBackground(new Color(0xEAEAEA));
    }

    public JTextField getTfCusomterName() {
        return tfCusomterName;
    }
    public JTextField getTfCusomterPhone() {
        return tfCusomterPhone;
    }
    public JTextField getTfCusomterLocation() {
        return tfCusomterLocation;
    }
}
