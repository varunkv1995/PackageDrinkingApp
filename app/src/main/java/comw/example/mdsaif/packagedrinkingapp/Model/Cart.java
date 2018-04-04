package comw.example.mdsaif.packagedrinkingapp.Model;

import java.util.HashMap;

/**
 * Created by Md.Saif on 26-02-2018.
 */

public class Cart {
    private String productName;
    private String productDescription;
    private String productImage;
    private double cost;
    private int quantity;

    public Cart() {
    }
 // public HashMap<Product,Integer>carts=new HashMap<>();
    /**
     * @param productName
     * @param productDescription

     * @param productImage
     */
    public Cart(String productName, String productDescription, String productImage) {
        quantity = 1;
        cost = 0;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productImage = productImage;
    }

    public Cart(String productName, String productDescription, String productImage, double cost) {
        this.productName = productName;
        quantity = 1;
        this.productDescription = productDescription;
        this.productImage = productImage;
        this.cost = cost;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getProductDescription() {

        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
