package comw.example.mdsaif.packagedrinkingapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import comw.example.mdsaif.packagedrinkingapp.R;

public class emailus extends Fragment {
    TextView textView;EditText editText1,editText2;Button button;
    public emailus() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_contact, container, false);
        setViews(v);
        return v;
    }

    private void setViews(View v) {


        textView = (TextView)v. findViewById(R.id.text);
        editText1 = (EditText)v. findViewById(R.id.edit1);
        editText2 = (EditText)v. findViewById(R.id.edit2);
        button = (Button)v. findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String subS = editText1.getText().toString();
                String mesS = editText2.getText().toString();
                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{"viswadhareddy14@gmail.com"});
                email.putExtra(Intent.EXTRA_SUBJECT, subS);
                email.putExtra(Intent.EXTRA_TEXT, mesS);
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email, "Choose an Email client :"));

            }
        });
    }
}

