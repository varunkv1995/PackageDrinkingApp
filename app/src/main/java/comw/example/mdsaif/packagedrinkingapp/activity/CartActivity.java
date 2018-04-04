package comw.example.mdsaif.packagedrinkingapp.activity;

/**
 * Created by Md.Saif on 24-02-2018.
 */
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import comw.example.mdsaif.packagedrinkingapp.R;
import comw.example.mdsaif.packagedrinkingapp.utils.CartUtils;
import comw.example.mdsaif.packagedrinkingapp.utils.ToolbarUtils;


public class CartActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    TextView subtotalTv;
    View proceedBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        ToolbarUtils.setToolbar((ViewGroup) ((ViewGroup) this
                .findViewById(android.R.id.content)), CartActivity.this, getResources().getString(R.string.my_cart));

        setViews();
        initViews();

    }

    private void initViews() {
        subtotalTv.setText(getResources().getString(R.string.subtotal_text)+""+ CartUtils.CartHelper.instance.getSubtotal());
    }

    private void setViews() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        subtotalTv = (TextView) findViewById(R.id.subtotal_view);
        proceedBtn = findViewById(R.id.proceed_btn);
        proceedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if(CartUtils.CartHelper.instance.getSubtotal()<1)
                {
                    Toast.makeText(CartActivity.this, getResources().getString(R.string.add_something), Toast.LENGTH_SHORT).show();
                }
               else
               {
                    startActivity(new Intent(CartActivity.this,CheckoutActivity.class));
                }
            }
        });
    }

}


