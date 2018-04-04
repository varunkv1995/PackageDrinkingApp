package comw.example.mdsaif.packagedrinkingapp.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import comw.example.mdsaif.packagedrinkingapp.R;

public class CancellationPolicy extends  Fragment {

    public CancellationPolicy() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.activity_cancellation_policy, container, false);
        return v;
    }
}
