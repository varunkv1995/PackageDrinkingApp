package comw.example.mdsaif.packagedrinkingapp.activity;

/**
 * Created by Md.Saif on 24-02-2018.
 */

import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.graphics.drawable.DrawerArrowDrawable;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import comw.example.mdsaif.packagedrinkingapp.Fragment.Contact;
import comw.example.mdsaif.packagedrinkingapp.Fragment.Help;
import comw.example.mdsaif.packagedrinkingapp.Fragment.MyOrder;
import comw.example.mdsaif.packagedrinkingapp.Fragment.MyProfile;
import comw.example.mdsaif.packagedrinkingapp.Fragment.MyWallet;
import comw.example.mdsaif.packagedrinkingapp.R;



public class NavigationActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private DrawerArrowDrawable drawerArrowDrawable;
    private Toolbar toolbar;
    private int currentIndex = 0;
    public static NavigationActivity mainActivity;
    private final String TAG_PROFILE = "My Profile";
    private final String TAG_ORDER = "My Order";
    private final String TAG_OFFERS = "Offers";
    private final String TAG_CONTACT = "Contact Us";
    private final String TAG_HELP = "Help";
    private final String TAG_WALLET = "My Wallet";
    private String CURRENT_TAG;
    private Handler handler;


    private NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        drawerLayout=(DrawerLayout)findViewById(R.id.drawer);
        toolbar=(Toolbar)findViewById(R.id.tool);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setHomeButtonEnabled(true);
        mainActivity = this;
        CURRENT_TAG = TAG_PROFILE;
        handler = new Handler();
        loadFragment(android.R.anim.fade_in,android.R.anim.fade_out,true);
        actionBarDrawerToggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.opened,R.string.close);
        actionBarDrawerToggle.setDrawerArrowDrawable(new DrawerArrowDrawable(this));
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        navigationView=(NavigationView)findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                drawerLayout.closeDrawers();
                switch (item.getItemId()){
                    case R.id.myprofile:
                        loadfragment(R.layout.fragment_my_profile);
                        break;
                    case R.id.order:
                        loadfragment(R.layout.fragment_my_order);
                        break;
                    case R.id.offers:
                        loadfragment(R.layout.fragment_offers);
                        break;
                    case R.id.contact:
                        loadfragment(R.layout.fragment_contact);
                        break;
                    case R.id.helps:
                        loadfragment(R.layout.fragment_help);
                        break;
                }
                if(item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);
                return true;
            }
        });
    }

    private void loadFragment(final int leftAnim, final int rightAnim, final boolean showAnim) {
        if(getSupportFragmentManager().findFragmentByTag(CURRENT_TAG)!= null){
            drawerLayout.closeDrawers();
            return;
        }
        getSupportActionBar().setTitle(CURRENT_TAG);
        Runnable pendingRunnable = new Runnable() {
            @Override
            public void run() {
                Fragment fragment = getFragment();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                if (showAnim)
                    fragmentTransaction.setCustomAnimations(leftAnim, rightAnim);
                fragmentTransaction.replace(R.id.frame, fragment, CURRENT_TAG);
                fragmentTransaction.commitAllowingStateLoss();
            }
        };

        if(pendingRunnable != null)
            handler.post(pendingRunnable);
        invalidateOptionsMenu();
    }

    private Fragment getFragment() {
        switch (currentIndex){
            case 0:
                MyProfile myprofile=new MyProfile();
                return myprofile;
            case 1:
                MyOrder myOrder=new MyOrder();
                return myOrder;
            case 2:
                MyWallet myWallet=new MyWallet();
                return myWallet;
            case 3:
                Help help=new Help();
                return help;
            case 4:
                Contact contact = new Contact();
                return contact;
        }
        return null;
    }

    private void loadfragment(int id) {
        switch (id){
            case R.layout.fragment_my_profile:
                currentIndex=0;
                CURRENT_TAG = TAG_PROFILE;
                break;
            case R.layout.fragment_my_order:
                currentIndex=1;
                CURRENT_TAG=TAG_ORDER;
                break;
            case R.layout.fragment_wallet:
                currentIndex=2;
                CURRENT_TAG=TAG_WALLET;
                break;
            case R.layout.fragment_help:
                currentIndex=3;
                CURRENT_TAG=TAG_HELP;
                break;
            case R.layout.fragment_contact:
                currentIndex=4;
                CURRENT_TAG=TAG_CONTACT;
                break;

        }
        this.loadfragment(R.anim.anim_fade_in_left);
    }
    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawers();
            return;
        }
        if(currentIndex != 0)
        {
            currentIndex = 0;
            CURRENT_TAG = TAG_PROFILE;
            loadFragment(R.anim.anim_right, R.anim.anim_left,true);
            return;
        }
        super.onBackPressed();
    }
}

