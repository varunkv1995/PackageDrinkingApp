package comw.example.mdsaif.packagedrinkingapp.activity;

/**
 * Created by Md.Saif on 24-02-2018.
 */


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


import comw.example.mdsaif.packagedrinkingapp.Model.OrderItemTo;
import comw.example.mdsaif.packagedrinkingapp.Model.OrderTo;
import comw.example.mdsaif.packagedrinkingapp.Model.Product;
import comw.example.mdsaif.packagedrinkingapp.Presenter.OrderPresenter;
import comw.example.mdsaif.packagedrinkingapp.R;
import comw.example.mdsaif.packagedrinkingapp.utils.CartUtils;
import comw.example.mdsaif.packagedrinkingapp.utils.RootApp;

import static android.R.id.input;
import static android.R.id.message;
import static comw.example.mdsaif.packagedrinkingapp.R.id.date;
import static comw.example.mdsaif.packagedrinkingapp.R.id.email;


public class CheckoutActivity extends AppCompatActivity {

    LinearLayout orderItemLayout;
    Button orderAddressChangeBtn;
    TextView subtotalTextView;
    ImageView image;
    TextView textprice;
    TextView textdt;
    Button change;
    TextView placeOrderBtn;
    private Product product;
    ProgressDialog progressDialog;
    DatabaseReference databaseReference;
    List<String> details;
    Toolbar toolbar;
    ArrayAdapter<String> adapter;
    ListView lv;
    FirebaseUser user;
    FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener mAuthListener;
    String email, key;
    Button codBtn,onlinePayBtn;
    String uid;
    // private static  final String TAG="CheckoutActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        codBtn = (Button) findViewById(R.id.cod_btn);
        onlinePayBtn = (Button) findViewById(R.id.online_payment_btn);
        textprice = (TextView) findViewById(R.id.textprice);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        textdt = (TextView) findViewById(R.id.textdt);
        change = (Button) findViewById(R.id.order_address_change_btn);
     //   placeOrderBtn = (Button) findViewById(R.id.place_order_btn);
        image = (ImageView) findViewById(R.id.img1);
        Bundle i = getIntent().getExtras();
        String input = i.getString("input");
        textprice.setText(" \n " + input);
        String datetime = i.getString("date");
        textdt.setText(" " + datetime);
        int images = i.getInt("image");
        image.setImageResource(images);
        Intent intent = getIntent();
        Bundle b = intent.getExtras();
        email = b.getString("email");
        lv = (ListView) findViewById(R.id.lv);
        details = new ArrayList<>();

        databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReference.child("RegisteredUsers").orderByChild("email").equalTo(email).addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    ProfileSaveData profileSaveData = dataSnapshot1.getValue(ProfileSaveData.class);
                    String name = profileSaveData.getName();
                    String number = profileSaveData.getNumber();
                    String pin = profileSaveData.getPincode();
                    details.add("NAME:" + name);
                    details.add("NUMBER:" + number);
                    details.add("PIN CODE:" + pin);
                }
                adapter = new ArrayAdapter<String>(CheckoutActivity.this, android.R.layout.simple_dropdown_item_1line, details);
                lv.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        codBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
             //  String input=textprice.getText().toString();
            Intent intent = new Intent(CheckoutActivity.this, Ordersummary.class);
                   // i.putExtra("input",input);
            startActivity(intent);
             }
            });
        onlinePayBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

            Intent intent = new Intent(CheckoutActivity.this, OrderActivity.class);
              // intent.putExtra("input",input);
            startActivity(intent);
             }
              });


    }

    //
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }
//
}




      /* Bundle bundle = getIntent().getExtras();
        if (bundle != null)
        {
            int resid = bundle.getInt("resId");
            image.setImageResource(resid);
        }*/
//        setViews();
//     //   getIntentData();
//        setPaymentOptionLayout();
//        setPlaceOrderButton();
//    }
//
//
////    private void getIntentData() {
////        Bundle extra = getIntent().getExtras();
////        if (extra.containsKey("single")) {
////            product = extra.getParcelable("product");
////        }
////    }
//
//    private void setPlaceOrderButton() {
//        placeOrderBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                progressDialog.setMessage(getResources().getString(R.string.placing_order_toast));
//                progressDialog.show();
//                startActivity(new Intent(CheckoutActivity.this, OrderActivity.class));
//                 placeOrder();
//            }
//        });
//    }
//
////
//    private void placeOrder() {
//
//        OrderTo orderTo = new OrderTo();
//      //  orderTo.products = getOrderItems();
//        //orderTo.subTotal = CartUtils.CartHelper.instance.getSubtotal();
//        orderTo.emailId = RootApp.getAuth().getCurrentUser().getEmail();
//        orderTo.orderPlacingTime = System.currentTimeMillis();
//

    //        if (codBtn.isChecked()) {
//            orderTo.paymentMethod = "CASH ON DELIVERY";
//        } else {
//            orderTo.paymentMethod = "ONLINE PAYMENT";
//        }
//
//        new OrderPresenter(CheckoutActivity.this, placeOrderInterface).placeOrder(orderTo);
//    }
//
////    private ArrayList<OrderItemTo> getOrderItems() {
////        ArrayList<OrderItemTo> orderItemTos = new ArrayList<>();
////        orderItemTos.add(new OrderItemTo(product, 1));
////        return orderItemTos;
////    }


  //  String input=textprice.getText().toString();

//    private void setPaymentOptionLayout() {
//
//          codBtn.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//             //  String input=textprice.getText().toString();
//            Intent intent = new Intent(CheckoutActivity.this, Ordersummary.class);
//                   // i.putExtra("input",input);
//            startActivity(intent);
//             }
//            });
//
//        onlinePayBtn.setOnClickListener(new View.OnClickListener() {
//           @Override
//           public void onClick(View view) {
//
//            Intent intent = new Intent(CheckoutActivity.this, OrderActivity.class);
//              // intent.putExtra("input",input);
//            startActivity(intent);
//             }
//              });
//        }
//



//    private void setViews() {
//        /*progressDialog = new ProgressDialog(CheckoutActivity.this);*/
//       //*/ progressDialog.setMessage(getResources().getString(R.string.placing_order));
//        //orderItemLayout = (LinearLayout) findViewById(R.id.order_summary_layout);
//       // orderAddressChangeBtn = (Button) findViewById(R.id.order_address_change_btn);
//        codBtn = (CheckBox) findViewById(R.id.cod_btn);
//        onlinePayBtn = (CheckBox) findViewById(R.id.online_payment_btn);
//        placeOrderBtn = (TextView) findViewById(R.id.place_order_btn);
//    }
//
//
//    OrderPresenter.PlaceOrderInterface placeOrderInterface = new OrderPresenter.PlaceOrderInterface() {
//        @Override
//        public void OnOrderPlacedSuccess(OrderTo order) {
//            CartUtils.CartHelper.instance.clearCart(product.productName);
//            Intent i = new Intent(CheckoutActivity.this, OrderActivity.class);
//           // i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//           // i.putExtra("openMyOrders", true);
//            startActivity(i);
//            finish();
//        }
//
//        @Override
//        public void OnOrderPlacedFailed(String errorMsg) {
//            progressDialog.dismiss();
//        }
//    };
//















