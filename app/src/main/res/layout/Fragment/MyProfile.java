package comw.example.mdsaif.waterpackageapp.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import comw.example.mdsaif.waterpackageapp.R;


public class MyProfile extends Fragment {
private View rootView;

    public MyProfile() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
      rootView=inflater.inflate(R.layout.fragment_my_profile,container,false);
        return rootView;
    }

}
