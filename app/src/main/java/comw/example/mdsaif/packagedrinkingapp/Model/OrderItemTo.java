package comw.example.mdsaif.packagedrinkingapp.Model;

/**
 * Created by Md.Saif on 24-02-2018.
 */

public class OrderItemTo {
    public Product product;
    public int quantity;

    public OrderItemTo(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
}