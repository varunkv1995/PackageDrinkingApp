package comw.example.mdsaif.packagedrinkingapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import comw.example.mdsaif.packagedrinkingapp.R;

public class EditprofileActivity extends AppCompatActivity {
    EditText firstname, lastname, contact, email, address, pincode;
    String pass, key;
    Button save;

    // DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editprofile);
        // Intent i=getIntent();
        //Bundle b=i.getExtras();
        /*String name=b.getString("name");
        String emailid=b.getString("email");
        String number=b.getString("number");
        String addresss=b.getString("address");
        String pinno=b.getString("pinno");
        String pass=b.getString("pass");*/
        firstname = (EditText) findViewById(R.id.edittext1);

        lastname = (EditText) findViewById(R.id.edittext2);
        contact = (EditText) findViewById(R.id.edittext3);

        email = (EditText) findViewById(R.id.edittext4);

        address = (EditText) findViewById(R.id.edittext5);

        pincode = (EditText) findViewById(R.id.edittext6);

        save = (Button) findViewById(R.id.savetext);

//        key=b.getString("key");
//        databaseReference=FirebaseDatabase.getInstance().getReference().child("RegisteredUsers");
//        databaseReference.child(key).addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                User value=dataSnapshot.getValue(User.class);
//                firstname.setText(value.getName());
//                contact.setText(value.getNumber());
//                address.setText(value.getAddress());
//                pincode.setText(value.getPincode());
//                email.setText(value.getEmail());
//                pass=value.getPassword();
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });
//
//
//        databaseReference= FirebaseDatabase.getInstance().getReference().child("RegisteredUsers");
//        save.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                AddData();
//
//            }
//        });
//    }
//    public void AddData() {
//        String Firstname = firstname.getText().toString().trim();
//        //  String Lasttname = lastname.getText().toString().trim();
//        String Contact = contact.getText().toString().trim();
//        String Email = email.getText().toString().trim();
//        String Address = address.getText().toString().trim();
//        String Pincode = pincode.getText().toString().trim();
//        User saveData=new User(Firstname,Contact,Email,pass,Address,Pincode);
//       /* ProfileSaveData saveData=new ProfileSaveData(Firstname,Lasttname,Contact,Email,Address,Pincode)*/;
//        databaseReference.child(key).setValue(saveData);
//    }
    }
}