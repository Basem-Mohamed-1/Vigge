package models;
import java.util.ArrayList;

public class Order {

    private ArrayList<OrderItem> ordersItems;
    private int id ;
    private double orderTotalPrice ;
    private int items ;

    


    public Order(){
        ordersItems = new ArrayList<>();
        id++;
        orderTotalPrice = 0;
        items =0;
    }
    public int getId() {
        return id;
    }

    public int getItems() {
        return items;
    }
    public void setItems(int items) {
        this.items = items;
    }
    public void setId(int id) {
        this.id = id;
    }
    

    public void addItemToOrder(OrderItem or){
        ++items;
        ordersItems.add(or);
    }



    public void setOrdersItems(ArrayList<OrderItem> ordersItems) {
        this.ordersItems = ordersItems;
    }

    

    public void setOrderTotalPrice(double orderTotalPrice) {
        this.orderTotalPrice = orderTotalPrice;
    }

    

    public final double getTotalOrderPrice(){
        double totalPrice  =0;

        for(OrderItem  item : ordersItems){
            totalPrice +=item.getItemPrice();
        }
        this.orderTotalPrice = totalPrice;
        return this.orderTotalPrice;
        
    }

    public void printOrderITemsValues(){
        for(OrderItem item : ordersItems){
            System.out.println("Quantity is :" + item.getQuntity() +" Price is " + item.getItemPrice() + " Name of vegetable is "+item.getVegetable().getVegetableName());
        }

        System.out.println(orderTotalPrice);
    }

    public void deleteOrderItem(int index){
        if(index >=0 && index < ordersItems.size()){
            ordersItems.remove(index);
            --items;
        }
    }
    public ArrayList<OrderItem> getOrdersItems() {
        return ordersItems;
    }

    
    
    
}
