package comw.example.mdsaif.packagedrinkingapp.utils;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.*;
import java.util.ArrayList;

import comw.example.mdsaif.packagedrinkingapp.Model.Cart;
import comw.example.mdsaif.packagedrinkingapp.Model.Product;

/**
 * Created by Md.Saif on 26-02-2018.
 */

public class CartUtils implements ValueEventListener {
    public List<Cart> getCarts() {
        return carts;
    }

    private List<Cart> carts;
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        if(dataSnapshot != null) {
            for (DataSnapshot data:
                 dataSnapshot.getChildren()) {
                Cart cart = data.getValue(Cart.class);
                carts.add(cart);
            }
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {

    }

    public double getSubtotal() {
        double subtotal=0;
       /* for (Map.Entry<Product,Integer> entry:carts.entrySet()) {
Product product=entry.getKey();
            int quantity=entry.getValue();
            subtotal+=product.getCost()*quantity;
        }*/
        return subtotal;
    }

    public static class CartHelper{
        public static final CartUtils instance = new CartUtils();
    }


    public CartUtils(){
        carts = new ArrayList<Cart>();
       DatabaseReference user =  RootApp.getDatabase().getReference("Users");
       user.child(RootApp.getUid()).child("cart").addValueEventListener(this);

    }

    public void addToCart(Cart cart){
        DatabaseReference user = RootApp.getDatabase().getReference("Users");
        user.child(RootApp.getUid()).child("cart").child(cart.getProductName()).setValue(cart);
    }

    public void clearCart(String productName){
        DatabaseReference user = RootApp.getDatabase().getReference("Users");
        for (Cart cart :
                carts) {
            if (productName.equals(cart.getProductName()));
            {
                user.child(RootApp.getUid()).child("cart").child(productName).removeValue();
            }
        }
    }

}
