package comw.example.mdsaif.packagedrinkingapp.activity;

import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Md.Saif on 27-02-2018.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

import comw.example.mdsaif.packagedrinkingapp.Fragment.Contact;
import comw.example.mdsaif.packagedrinkingapp.Fragment.Help;
import comw.example.mdsaif.packagedrinkingapp.Fragment.HomeFragment;
import comw.example.mdsaif.packagedrinkingapp.Fragment.MyOrder;
import comw.example.mdsaif.packagedrinkingapp.Fragment.MyProfile;
import comw.example.mdsaif.packagedrinkingapp.Fragment.Offers;
import comw.example.mdsaif.packagedrinkingapp.R;

import static android.R.attr.key;
import static android.R.id.toggle;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public static String email;
    private int currentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        email = getIntent().getExtras().getString("email");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.opened, R.string.close);
        //drawer.setDrawerListener(toggle);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
      // getSupportActionBar().setDisplayHomeAsUpEnabled(true);




        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        DisplayFragment(R.layout.activity_main);



      /*first card*/

    }

    @Override
    protected void onStart() {
        super.onStart();
        DisplayFragment(R.id.home);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
           return super.onOptionsItemSelected(item);
       }


    @Override
   public void onBackPressed() {
     DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if(currentFragment != R.id.home) {
                DisplayFragment(R.id.home);
                return;
            }
            super.onBackPressed();
        }
    }
    private void DisplayFragment(int id){
        Fragment fragment=null;
        currentFragment = id;
        switch (id){
            case R.id.home:
                setTitle("Home");
                fragment = new HomeFragment();
                break;
            case R.id.myprofile:
               setTitle("My Profile");
               fragment= new MyProfile();
                break;
            case R.id.order:
                setTitle("MyOrder");
                fragment=new MyOrder();
                break;
            case R.id.offers:
                setTitle("Offers");
                fragment=new Offers();
                break;
            case R.id.contact:
               setTitle("Contact Us");
                fragment=new Contact();
                break;
            case R.id.helps:
                setTitle("Help");
                fragment=new Help();
                break;
        }
        if(fragment!=null){
            FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.MyFrameLayout,fragment);
            fragmentTransaction.commit();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer);
        drawer.closeDrawer(GravityCompat.START);

    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        DisplayFragment(item.getItemId());


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }











}
//{
//    ImageView img1,img2,img3,img4;
//    String email;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState)
//    {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        email=getIntent().getExtras().getString("email");
//        img1=(ImageView)findViewById(R.id.imageview1);
//        img2=(ImageView)findViewById(R.id.imageview2);
//        img3=(ImageView)findViewById(R.id.imageview3);
//        img4=(ImageView)findViewById(R.id.imageview4);
//
//        /*first card*/
//        img1.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View v)
//            {
//                Intent intent=new Intent(getApplicationContext(),ActivityOne.class);
//                intent.putExtra("email",email);
//                startActivity(intent);
//
//
//            }
//        });
//
//        /*second card*/
//
//        img2.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View v)
//            {
//                Intent intent=new Intent(getApplicationContext(),ActivityTwo.class);
//                intent.putExtra("email",email);
//                startActivity(intent);
//
//
//            }
//        });
//        /*third card*/
//        img3.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View v)
//            {
//                Intent intent=new Intent(getApplicationContext(),ActivityThree.class);
//                intent.putExtra("email",email);
//                startActivity(intent);
//
//
//            }
//        });
//        /*fourth card*/
//        img4.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View v)
//            {
//                Intent intent=new Intent(getApplicationContext(),ActivityFour.class);
//                intent.putExtra("email",email);
//                startActivity(intent);
//
//            }
//        });
//
//    }
//}
