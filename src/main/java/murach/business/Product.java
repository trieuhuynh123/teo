package murach.business;

import java.text.NumberFormat;
import java.util.HashMap;

public class Product {

    private String code;
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    private Double price;

    HashMap<String, Double> prices = new HashMap<String, Double>() {
        {
            put("8601", 14.95);
            put("pf01", 12.95);
            put("pf02", 14.95);
            put("jr01", 14.95);
        }
    };
    HashMap<String, String> descriptions = new HashMap<String, String>() {
        {
            put("8601", "86 (the band) - True Life Songs and Pictures");
            put("pf01", "Paddlefoot - The first CD");
            put("pf02", "Paddlefoot - The second CD");
            put("jr01", "Joe Rut - Genuine Wood Grained Finish");
        }
    };

    public Product(String code) {
        this.code = code;
        this.price = prices.get(code);
        this.description = descriptions.get(code);
    }

    public String getCode() {
        return code;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCode(String id) {
        this.code = id;
    }

    public String getPriceCurrencyFormat() {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(price);
    }
}
