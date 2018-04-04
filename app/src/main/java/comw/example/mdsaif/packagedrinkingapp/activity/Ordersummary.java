package comw.example.mdsaif.packagedrinkingapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import comw.example.mdsaif.packagedrinkingapp.R;

/**
 * Created by myLaptop on 3/14/2018.
 */

public class Ordersummary extends AppCompatActivity {
    ImageView image;
    TextView textprice;
    TextView textdt;
    List<String> details;
    ArrayAdapter<String> adapter;
    ListView lv;
    String email;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cod);
//        textprice = (TextView) findViewById(R.id.textprice);
//        textdt = (TextView) findViewById(R.id.textdt);
//        image = (ImageView) findViewById(R.id.img1);
//        Bundle i = getIntent().getExtras();
//        String input = i.getString("input","");
//        textprice.setText(" \n " + input);
//        String datetime = i.getString("date");
//        textdt.setText(" " + datetime);
//        int images = i.getInt("image");
//        image.setImageResource(images);
//        Intent intent = getIntent();
//        Bundle b = intent.getExtras();
//        email = b.getString("email");
//        lv = (ListView) findViewById(R.id.lv);
//        details = new ArrayList<>();
//
//
//
//        databaseReference = FirebaseDatabase.getInstance().getReference();
//        databaseReference.child("RegisteredUsers").orderByChild("email").equalTo(email).addListenerForSingleValueEvent(new ValueEventListener() {
//
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//
//                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
//                    ProfileSaveData profileSaveData = dataSnapshot1.getValue(ProfileSaveData.class);
//                    String address = profileSaveData.getAddress();
//                    String pincode = profileSaveData.getPincode();
//                    details.add(" " + address);
//                    details.add(" " + pincode);
//                }
//                adapter = new ArrayAdapter<String>(Ordersummary.this, android.R.layout.simple_dropdown_item_1line, details);
//
//                lv.setAdapter(adapter);
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });
  }


}

