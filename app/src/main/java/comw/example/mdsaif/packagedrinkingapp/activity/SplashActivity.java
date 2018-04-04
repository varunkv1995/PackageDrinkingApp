package comw.example.mdsaif.packagedrinkingapp.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import comw.example.mdsaif.packagedrinkingapp.R;

/**
 * Created by Md.Saif on 24-02-2018.
 */

public class SplashActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //for font in hindi
      /*  TextView tv = (TextView) findViewById(R.id.hindi);
        Typeface fontHindi = Typeface.createFromAsset(getAssets(),
                "fonts/Ananda Lipi Bold Cn Bt.ttf");
        tv.setTypeface(fontHindi);*/
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {

            // Using handler with postDelayed called runnable run method

            @Override
            public void run() {
                FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
                if (currentUser == null) {
                    Intent i = new Intent(SplashActivity.this, LoginActivity1.class);
                    startActivity(i);
                } else {
                    Intent i = new Intent(SplashActivity.this, MainActivity.class);
                    i.putExtra("email",currentUser.getEmail());
                    startActivity(i);
                }

                // close this activity
                finish();
            }
        }, 5 * 1000); // wait for 5 seconds

    }

    @Override
    protected void onDestroy() {

        super.onDestroy();

    }
}

