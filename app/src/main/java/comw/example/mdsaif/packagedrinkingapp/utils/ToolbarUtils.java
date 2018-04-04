package comw.example.mdsaif.packagedrinkingapp.utils;

/**
 * Created by Md.Saif on 24-02-2018.
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import comw.example.mdsaif.packagedrinkingapp.activity.CartActivity;
import comw.example.mdsaif.packagedrinkingapp.R;


/**
 * Created by gunjit on 20/05/17.
 */

public class ToolbarUtils {

    public static void setToolbar(View v, final AppCompatActivity context, String title) {
        Toolbar toolbar = (Toolbar) v.findViewById(R.id.toolbar);
        TextView toolbarTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        ImageView cartBtn = (ImageView) toolbar.findViewById(R.id.cart_btn);
        if(cartBtn!=null) {
            cartBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(context, CartActivity.class);
                    context.startActivity(i);
                }
            });
        }
        toolbarTitle.setText(title);
        context.setSupportActionBar(toolbar);
        context.getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}

