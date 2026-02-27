package Controller;
import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import gui.RecietWindow.*;
import gui.OrdersWindow.CustomerInfo;
import gui.OrdersWindow.Footer;
import gui.OrdersWindow.ProductSelection;
import gui.OrdersWindow.TableOrders;
import models.*;
public class CashierController implements ActionListener{

    private TableOrders tableOrders;
    private Order order;
    private ProductSelection productSelection;
    private Footer footer ;
    private CustomerInfo customerInfo;
    private Receipt reciet;
    
    public CashierController(TableOrders tableOrders, ProductSelection productSelection , CustomerInfo customerInfo){
        this.tableOrders = tableOrders;
        this.productSelection = productSelection;
        this.customerInfo = customerInfo ;
        this.footer = tableOrders.getFooter();
        this.order = new Order();
        intitCashierController();
    }

    private void intitCashierController(){

        productSelection.addItemToCard().addActionListener(e -> addItemToTable());
        productSelection.deleteFromTheOrder().addActionListener(e -> deleteItemToTable());
        productSelection.getNameOfTheVegetable().addActionListener(productSelection);
        productSelection.getQuantityField().addActionListener(productSelection);
        

        footer.getPlaceOrdeButton().addActionListener(e -> newRecietWindow());

    }




    // THE FUNCTION THAT ADDES ORDERS ITEMS TO THE TABLE 
    public void addItemToTable(){

            System.out.println("hello");
            try{
            int quntitiy =Integer.parseInt(productSelection.getQuantityField().getText());
            String vegType = String.valueOf((productSelection.getNameOfTheVegetable().getSelectedItem()));
            OrderItem or = new OrderItem(new Vegetables(vegType),quntitiy);
            order.addItemToOrder(or);
            changeOrderDetails();
            order.printOrderITemsValues();
            tableOrders.getModelOfTable().addRow(new Object[]{
            or.getVegetable().getVegetableId(or.getVegetable().getVegetableName()),
            or.getVegetable().getVegetableName(),
            or.getQuntity(),           // fixed typo
            or.getItemPrice()
         });
            
            }catch(NumberFormatException nf){
                System.out.println("error appears");
        }
    }


    // THE FUNCTION THAT DELETES ORDER ITES FROM THE TABLE 
    public void deleteItemToTable(){
        // orderItems.getOrdersTable().removeLast();
        int selectedRow = tableOrders.getOrdersTable().getSelectedRow();
        
        // Check if a row is actually selected
        if (selectedRow != -1) {
            // Convert view index to model index (important for sorted tables)
            int modelRow = tableOrders.getOrdersTable().convertRowIndexToModel(selectedRow);
            
            // Remove the row from the model
            tableOrders.getModelOfTable().removeRow(modelRow);

            //change the old price 
            order.deleteOrderItem(selectedRow);
            changeOrderDetails();
            // Optional: Show a confirmation message
            JOptionPane.showMessageDialog(null, "Selected row deleted successfully");


            // remove from the array list 
            

        } else {
            JOptionPane.showMessageDialog(null, "Please select a row to delete.");
        }
    }


    // change the numbers and details of the order
    public void changeOrderDetails(){
        footer.getTotalPriceLabel().setText(String.valueOf(order.getTotalOrderPrice()));
        footer.getTotalItemLabel().setText(String.valueOf(order.getItems()));
    }


    public void newRecietWindow(){

        
        try{ 
            String inputName = customerInfo.getTfCusomterName().getText();
            String inputLocation = customerInfo.getTfCusomterLocation().getText();
            String inputPhone = customerInfo.getTfCusomterPhone().getText();

        if (inputName.isBlank() || inputLocation.isBlank() || inputPhone.isBlank() ) {
            JOptionPane.showMessageDialog(null, "Please fill the empty information");
        }
        else if(tableOrders.getModelOfTable().getRowCount()==0){
            JOptionPane.showMessageDialog(null, "Your Cart is Empty");
        }
        else {
            reciet = new Receipt();
            reciet.getSaveReceiptBtn().addActionListener(e -> saveNewReceipt());
            reciet.getNameLabel().setText(inputName.trim());
            reciet.getLocationLabel().setText(inputLocation.trim());
            reciet.getPhoneLabel().setText(inputPhone.trim());
            reciet.getDateLabel().setText(getFormattedDate());

            DefaultTableModel recietModel =reciet.getModel();

            for(OrderItem orderItem : order.getOrdersItems()){
                recietModel.addRow(new Object[]{orderItem.getVegetable().getVegetableId(orderItem.getVegetable().getVegetableName()),orderItem.getVegetable().getVegetableName(),orderItem.getQuntity(),orderItem.getItemPrice()});
            }
            reciet.getTotalValue().setText(String.valueOf(order.getTotalOrderPrice()));
        }
        }
        catch(NullPointerException e){
            JOptionPane.showMessageDialog(null, "Please fill the empty information");
        }
    }


    public void saveNewReceipt(){
        takeSnapShot(reciet.getContentPanel());
    }




   void takeSnapShot(JPanel panel){

       BufferedImage bufImage = new BufferedImage(panel.getSize().width, panel.getSize().height,BufferedImage.TYPE_INT_RGB);
       panel.paint(bufImage.createGraphics());

        // 1. Create a format (Year-Month-Day_Hour-Minute-Second)
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");

        // 2. Get the current time and format it
        String timestamp = dtf.format(LocalDateTime.now());
        File imageFile = new File("/Users/basemmohamed/الكلية/software engineering/vigge/Last Orders/"+timestamp+"-receipt.png");

        try{
            imageFile.createNewFile();
            ImageIO.write(bufImage, "png", imageFile);
            JOptionPane.showMessageDialog(null, "Receipt has been save - Check the last orders");

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    
    public String getFormattedDate() {
        // 1. Get current date
        LocalDate today = LocalDate.now();
        
        // 2. Define the pattern to match your receipt design
        // "MMM" = Short month (Oct), "dd" = Day, "yyyy" = Year
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy");
        
        // 3. Return the formatted string
        return today.format(formatter);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}
