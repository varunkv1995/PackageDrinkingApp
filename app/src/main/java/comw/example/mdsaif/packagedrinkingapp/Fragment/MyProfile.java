package comw.example.mdsaif.packagedrinkingapp.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
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
import comw.example.mdsaif.packagedrinkingapp.activity.EditprofileActivity;
//import comw.example.mdsaif.packagedrinkingapp.activity.MyProfileActivity;
import comw.example.mdsaif.packagedrinkingapp.activity.User;

public class MyProfile extends Fragment {
    Button btn;
    DatabaseReference databaseReference;
    List<User> details;
    ListView lv;
    String email,key;

    public MyProfile() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.activity_editprofile, container, false);
//        if (getArguments() != null) {
//             email = getArguments().getString("email");

     //   }
       //  Intent i=getIntent();

       Intent i=getActivity().getIntent();
        Bundle b = i.getExtras();
        email = b.getString("email");
        btn = (Button) v.findViewById(R.id.displaytext);
        lv = (ListView) v.findViewById(R.id.lv);
        details = new ArrayList<User>();
        databaseReference = FirebaseDatabase.getInstance().getReference().child("RegisteredUsers");
        databaseReference.orderByChild("email").equalTo(email).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot childSnapshot : dataSnapshot.getChildren()) {
                    key = childSnapshot.getKey();
                    User value = childSnapshot.getValue(User.class);
                    details.add(value);
                }
                BaseAdapter ba = new Adapter();
                lv.setAdapter(ba);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), EditprofileActivity.class);

                /*Bundle b=new Bundle();
                b.putSerializable("list",(Serializable) details);
                i.putExtra("bundle",b);*/
                i.putExtra("key", key);
                startActivity(i);
            }
        });
        return v;

    }
    private class  Adapter extends BaseAdapter{

        @Override
        public int getCount() {
            return details.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater li=getActivity().getLayoutInflater();
            View v=li.inflate(R.layout.list_view_style1,null);
            TextView address=(TextView)v.findViewById(R.id.address);
            TextView emaill=(TextView)v.findViewById(R.id.email);
            TextView name=(TextView)v.findViewById(R.id.name);
            TextView number=(TextView)v.findViewById(R.id.number);
            TextView pin=(TextView)v.findViewById(R.id.pin);
            User values=details.get(position);
            NAME=(String )values.getName();
            NUMBER=values.getNumber();
            PINNO=values.getPincode();
            ADDRESS=values.getAddress();
            EMAIL=values.getEmail();
            PASS=values.getPassword();
            address.setText(ADDRESS);
            emaill.setText(EMAIL);
            name.setText(NAME);
            number.setText(NUMBER);
            pin.setText(PINNO);
            return v;
        }
    }
    String NAME,NUMBER,PINNO,EMAIL,ADDRESS,PASS;


}

