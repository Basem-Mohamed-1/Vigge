package models;

public class OrderItem {
    private Vegetables vegetable;
    private static int id;
    private int Quntity;
    private double ItemPrice ;


    public OrderItem(Vegetables vegetable,int quntity){
        this.vegetable = vegetable;
        this.Quntity = quntity;
        ++id;
    }
 

    
    public int getQuntity() {
        return Quntity;
    }

    public void setQuntity(int quntity) {
        Quntity = quntity;
    }

    public double getItemPrice(){
        ItemPrice =   Quntity * this.vegetable.getVegetablePrice(vegetable.getVegetableName());
        return ItemPrice;
    }

   
    public final Vegetables getVegetable(){
        return this.vegetable;
    }
    
    public void print(){
        System.out.println(vegetable.getVegetableName());
        System.out.println(vegetable.getVegetablePrice(vegetable.getVegetableName()));
        System.out.println(id);
        System.out.println(Quntity);
    }
    

    public static int getId(){
        return id;
    }

    public static int decreamnetID(){
        return --id;
    }

}
