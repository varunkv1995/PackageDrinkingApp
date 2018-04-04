package comw.example.mdsaif.packagedrinkingapp.Model;

import java.util.ArrayList;

/**
 * Created by Md.Saif on 24-02-2018.
 */

public class OrderTo {
    public ArrayList<OrderItemTo> products = new ArrayList<>();
    public double subTotal;
    public String paymentMethod;
    public String emailId;
    public long orderPlacingTime;
    public String orderStatus;
}

