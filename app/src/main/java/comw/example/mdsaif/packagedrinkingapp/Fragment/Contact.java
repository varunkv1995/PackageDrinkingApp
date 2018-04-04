package comw.example.mdsaif.packagedrinkingapp.Fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import comw.example.mdsaif.packagedrinkingapp.R;
import comw.example.mdsaif.packagedrinkingapp.activity.emailus;


public class Contact extends Fragment {
    private TextView textView,textview1;

    public Contact() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.contactus, container, false);
        setViews(v);
        return v;
    }

    private void setViews(View v) {
        textView = (TextView)v. findViewById(R.id.text);
        textview1=(TextView)v. findViewById(R.id.text1);
        textview1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment=new emailus();
                FragmentTransaction fragmentTransaction=getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.MyFrameLayout,fragment);
                fragmentTransaction.commit();
            }
        });


        textView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:8374211970"));
                startActivity(callIntent);

            }

        });

    }

}


