package comw.example.mdsaif.packagedrinkingapp.activity;

/**
 * Created by Md.Saif on 25-02-2018.
 */

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import comw.example.mdsaif.packagedrinkingapp.Model.Cart;
import comw.example.mdsaif.packagedrinkingapp.Model.Product;
import comw.example.mdsaif.packagedrinkingapp.R;
import comw.example.mdsaif.packagedrinkingapp.utils.CartUtils;
import comw.example.mdsaif.packagedrinkingapp.utils.RootApp;
import comw.example.mdsaif.packagedrinkingapp.utils.SharedPrefUtils;
import comw.example.mdsaif.packagedrinkingapp.utils.ToolbarUtils;

import me.relex.circleindicator.CircleIndicator;

import static comw.example.mdsaif.packagedrinkingapp.R.id.date;

public class ProductDetailActivity extends AppCompatActivity {
    TextView textView;
    TextView textprice;
    TextView textsp;
    ImageView image;
    Toolbar toolbar;
    DateFormat formatDateTime=DateFormat.getDateTimeInstance();
    Calendar datetime=Calendar.getInstance();
    Button btn_date,btn_time;
    TextView textdt;
    TextView addToCartBtn;
    TextView buyNowBtn;
    String email;
    int resid;
   // ArrayList<String> pagerList;

    Product product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        email=getIntent().getExtras().getString("email");
        setContentView(R.layout.activity_product_detail);
        textprice = (TextView) findViewById(R.id.textprice);
        textsp = (TextView) findViewById(R.id.textsp);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        image = (ImageView) findViewById(R.id.img1);

        ToolbarUtils.setToolbar((ViewGroup) ((ViewGroup) this
                .findViewById(android.R.id.content)), ProductDetailActivity.this, getResources().getString(R.string.prduct_det));
        initViews();
//intent data
        Intent i = getIntent();
        String input = i.getStringExtra("input");
        textprice.setText("Total Amount  \n " + input);
        String input1 = i.getStringExtra("input1");
        textsp.setText(input1 + " use");
        Bundle bundle = getIntent().getExtras();
        if (bundle != null)
        {
             resid = bundle.getInt("resId");
            image.setImageResource(resid);
        }
        //date and time//
        btn_date=(Button)findViewById(date);
        btn_time=(Button)findViewById(R.id.time);
        textdt=(TextView)findViewById(R.id.textdt);
        btn_date.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                updateDate();
            }
        });
        btn_time.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                updateTime();
            }
        });
        updateTextlabel();
    }
    private void updateTime()
    {
        new TimePickerDialog(this,t,datetime.get(Calendar.HOUR_OF_DAY),datetime.get(Calendar.MINUTE),true).show();
    }
    private void updateDate()
    {
        new DatePickerDialog(this,d,datetime.get(Calendar.YEAR),datetime.get(Calendar.MONTH),datetime.get(Calendar.DAY_OF_MONTH)).show();
    }
    DatePickerDialog.OnDateSetListener d= new DatePickerDialog.OnDateSetListener()
    {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth)
        {
            datetime.set(Calendar.YEAR,year);
            datetime.set(Calendar.MONTH,month);
            datetime.set(Calendar.DAY_OF_MONTH,dayOfMonth);
            updateTextlabel();
        }
    };
    TimePickerDialog.OnTimeSetListener t= new TimePickerDialog.OnTimeSetListener()
    {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute)
        {
            datetime.set(Calendar.HOUR_OF_DAY,hourOfDay);
            datetime.set(Calendar.MINUTE,minute);
            updateTextlabel();

        }
    };
    private void updateTextlabel()
    {
        textdt.setText(formatDateTime.format(datetime.getTime()));

    }

        //getIntentData();

   /* private void getIntentData() {
        if (getIntent().getExtras() != null) {
            product = getIntent().getExtras().getParcelable("product");
            pagerList = product.imageArray;
            pagerList.add(0, product.productImage);
        }
    }*/

    private void initViews() {
        addToCartBtn = (TextView) findViewById(R.id.add_to_cart_btn);
        buyNowBtn=(TextView)findViewById(R.id.buy_now_btn);
        addToCartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                product = new Product();
                product.productName = "Product 1";
                product.productDescription = "Desc";
                product.productImage = "image";
                Toast.makeText(ProductDetailActivity.this, getResources().getString(R.string.added_to_cart), Toast.LENGTH_SHORT).show();
                CartUtils.CartHelper.instance.addToCart(new Cart(product.productName, product.productDescription, product.productImage));
                startActivity(new Intent(ProductDetailActivity.this, CartActivity.class));
            }
        });

        buyNowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              /* if(RootApp.getAuth().getCurrentUser() == null)
               {
                   startActivity(new Intent(ProductDetailActivity.this,LoginActivity.class));
               }
               else{*/
                   String input=textprice.getText().toString();
                   Intent intent=new Intent(getApplicationContext(),CheckoutActivity.class);
                intent.putExtra("email",email);
                intent.putExtra("image",resid);
                   intent.putExtra("input",input);
                intent.putExtra("date", datetime.getTime().toString());
                Date d = new Date();
                d.setTime(intent.getLongExtra("date", -1));
                   startActivity(intent);
              // }
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home)
            finish();

        return super.onOptionsItemSelected(item);
    }

}