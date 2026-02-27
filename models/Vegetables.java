package models;

import java.util.HashMap;

public class Vegetables {

    private String vegetableName;
    public static HashMap<String, Double> prices = new HashMap<>();

    public Vegetables() {
        vegetableName = "none";
    }

    public Vegetables(String vname) {
        vegetableName = vname;
    }

    static {
        prices.put("Tomato", 15.0);
        prices.put("Potato", 20.0);
        prices.put("Onion", 12.0);
        prices.put("Cucumber", 9.0);
        prices.put("Eggplant", 11.0);
        prices.put("Zucchini", 7.5);
        prices.put("Carrot", 11.2);
        prices.put("Pepper", 21.5);
        prices.put("Okra", 19.2);
    }

    public int getVegetableId(String name) {
        switch (name) {
            case "Tomato": {return 1;}
            case "Potato": {return 2;}
            case "Onion": {return 3;}
            case "Cucumber": {return 4;}
            case "Eggplant": {return 5;}
            case "Zucchini": {return 6;}
            case "Carrot": {return 7;}
            case "Pepper": {return 8;}
            case "Okra": {return 9;}
            default:
                return 0;
        }
    }

    public void setVegetableName(String vName) {
        vegetableName = vName;
    }

    public final String getVegetableName() {
        return vegetableName;
    }

    public final double getVegetablePrice(String vName) {
        return prices.get(vName);
    }

    public double getVegetablePrice() {
        return prices.get(vegetableName);
    }

}
