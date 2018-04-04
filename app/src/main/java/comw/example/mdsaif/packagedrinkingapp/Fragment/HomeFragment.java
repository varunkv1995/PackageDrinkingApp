package comw.example.mdsaif.packagedrinkingapp.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import comw.example.mdsaif.packagedrinkingapp.R;
import comw.example.mdsaif.packagedrinkingapp.activity.ActivityFour;
import comw.example.mdsaif.packagedrinkingapp.activity.ActivityOne;
import comw.example.mdsaif.packagedrinkingapp.activity.ActivityThree;
import comw.example.mdsaif.packagedrinkingapp.activity.ActivityTwo;
import comw.example.mdsaif.packagedrinkingapp.activity.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private View rootView;
    ImageView img1, img2, img3, img4;
    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_home, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        img1 = (ImageView) view.findViewById(R.id.imageview1);
        img2 = (ImageView) view.findViewById(R.id.imageview2);
        img3 = (ImageView) view.findViewById(R.id.imageview3);
        img4 = (ImageView) view.findViewById(R.id.imageview4);
        img1.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick (View v)
            {
                Intent intent = new Intent(rootView.getContext(), ActivityOne.class);
                intent.putExtra("email", MainActivity.email);
                startActivity(intent);


            }
        });
 /*second card*/
        img2.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick (View v)
            {
                Intent intent = new Intent(rootView.getContext(), ActivityTwo.class);
                intent.putExtra("email", MainActivity.email);
                startActivity(intent);

//
            }
        });
        /*third card*/
        img3.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick (View v)
            {
                Intent intent = new Intent(rootView.getContext(), ActivityThree.class);
                intent.putExtra("email", MainActivity.email);
                startActivity(intent);


            }
        });
        /*fourth card*/
        img4.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick (View v)
            {
                Intent intent = new Intent(rootView.getContext(), ActivityFour.class);
                intent.putExtra("email", MainActivity.email);
                startActivity(intent);

            }
        });
    }
}
