package comw.example.mdsaif.packagedrinkingapp.activity;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by Md.Saif on 27-02-2018.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import comw.example.mdsaif.packagedrinkingapp.R;

public class ActivityOne extends AppCompatActivity
{
    Spinner spinner1;
    ElegantNumberButton  elbtn;
    Button btn;
    ImageView image1;
    String email;
    TextView price;
    Toolbar toolbar;
    List<String> spinnerstate=new ArrayList<String>();

    String[ ] resarray=null;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);
        email=getIntent().getExtras().getString("email");
        /* edit text for price*/
        price=(TextView) findViewById(R.id.price);
        toolbar=(Toolbar)findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);
        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        image1=(ImageView) findViewById(R.id.imageView1);

        /*elegant number button*/
        elbtn=( ElegantNumberButton)findViewById(R.id.elbtn1);
        elbtn.setOnClickListener(new ElegantNumberButton.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String num="" +Integer.parseInt(elbtn.getNumber()) * 40;
                Log.e("Num",num);
                price.setText("Rs. "+num );
            }
        });
        /*spinner*/
        spinner1 = (Spinner)findViewById(R.id.spinner1);
        getItems();
        /*Place Order*/
        btn=(Button)findViewById(R.id.btn1);
        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String input=price.getText().toString();
                String input1=spinner1.getSelectedItem().toString();
                Intent intent=new Intent(getApplicationContext(),ProductDetailActivity.class);
                intent.putExtra("resId",R.drawable.image1);
                intent.putExtra("email",email);
                intent.putExtra("input",input);
                intent.putExtra("input1",input1);
                startActivity(intent);
            }
        });
    }
    /*spinner method*/
    private void getItems()
    {
        resarray=getResources().getStringArray(R.array.items);
        spinnerstate= Arrays.asList(resarray);
        ArrayAdapter<String> arrayadapter=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_item,spinnerstate);
        arrayadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(arrayadapter);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home)
            finish();

        return super.onOptionsItemSelected(item);
    }
}

