package comw.example.mdsaif.packagedrinkingapp.Presenter;

/**
 * Created by Md.Saif on 24-02-2018.
 */

import android.content.Context;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;

import java.util.ArrayList;

import comw.example.mdsaif.packagedrinkingapp.Model.OrderTo;
import comw.example.mdsaif.packagedrinkingapp.R;

/**
 * Created by gunjit on 06/05/17.
 */

public class OrderPresenter {

    Context context;
    FetchAllOrdersInterface fetchAllOrdersInterface;
    PlaceOrderInterface placeOrderInterface;

    public OrderPresenter(Context context, FetchAllOrdersInterface fetchAllOrdersInterface)
    {
        this.context = context;
        this.fetchAllOrdersInterface = fetchAllOrdersInterface;
    }

    public interface FetchAllOrdersInterface{
        void onFetchOrdersSuccess(ArrayList<OrderTo> orderTos);
        void onFetchOrderFailed(String errorMsg);
    }

    public void fetchAllUserOrders(String emailId)
    {
        DatabaseReference mFirebaseRef = FirebaseDatabase.getInstance().getReference();
        Query mQueryRef = mFirebaseRef.child("orders").orderByChild("emailId").equalTo(emailId);

        mQueryRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.e("onDataChange",""+new Gson().toJson(dataSnapshot.getChildren()));
                ArrayList<OrderTo> orderTos = new ArrayList<>();
                for (DataSnapshot productSnapshot : dataSnapshot.getChildren()) {
                    OrderTo orderTo = productSnapshot.getValue(OrderTo.class);
                    orderTos.add(orderTo);
                }
                fetchAllOrdersInterface.onFetchOrdersSuccess(orderTos);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                if(databaseError!=null)
                {
                    fetchAllOrdersInterface.onFetchOrderFailed(databaseError.getMessage());
                    return;
                }
                fetchAllOrdersInterface.onFetchOrderFailed(context.getResources().getString(R.string.somethingwentwrong));
            }
        });
    }


    ///////////////////////////////////////////////////////////////////////////////


    public OrderPresenter(Context context, PlaceOrderInterface placeOrderInterface)
    {
        this.context = context;
        this.placeOrderInterface = placeOrderInterface;
    }

    public interface PlaceOrderInterface{
        void OnOrderPlacedSuccess(OrderTo order);
        void OnOrderPlacedFailed(String errorMsg);
    }

    public void placeOrder(final OrderTo order)
    {
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("orders");
        String users = mDatabase.push().getKey();
        mDatabase.child(users).setValue(order, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                if(databaseError!=null)
                {
                    placeOrderInterface.OnOrderPlacedFailed(databaseError.getMessage());
                    return;
                }
                placeOrderInterface.OnOrderPlacedSuccess(order);
            }
        });
    }

    ///////////////////////////////////////////////////////////////////////////////




}

