package comw.example.mdsaif.packagedrinkingapp.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;

import comw.example.mdsaif.packagedrinkingapp.Adapter.OrderAdapter;
import comw.example.mdsaif.packagedrinkingapp.Model.OrderTo;
import comw.example.mdsaif.packagedrinkingapp.Presenter.OrderPresenter;
import comw.example.mdsaif.packagedrinkingapp.R;
import comw.example.mdsaif.packagedrinkingapp.utils.SharedPrefUtils;


public class MyOrder extends Fragment {
private View rootView;

    public MyOrder() {
        // Required empty public constructor
    }
    RecyclerView recyclerView;
    OrderAdapter adapter;
    LinearLayoutManager llm;
    ArrayList<OrderTo> orders = new ArrayList<>();
    ProgressBar progressBar;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView=inflater.inflate(R.layout.fragment_my_order, container, false);
        setViews(rootView);
        setAdapter();
        setUpRecyclerView();
        fetchMyOrders();
        return rootView;
    }
    private void fetchMyOrders() {
        progressBar.setVisibility(View.VISIBLE);
        new OrderPresenter(getContext(), fetchAllOrdersInterface).fetchAllUserOrders(SharedPrefUtils.getCurrentUser(getContext()).email);
    }

    private void setViews(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.my_order_recycler_view);
        progressBar = (ProgressBar) view.findViewById(R.id.progress_bar);
    }

    private void setAdapter() {
        adapter = new OrderAdapter(getActivity(), orders);
    }



    private void setUpRecyclerView() {

        llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);
        recyclerView.setHasFixedSize(false);
        recyclerView.setAdapter(adapter);
    }

    OrderPresenter.FetchAllOrdersInterface fetchAllOrdersInterface = new OrderPresenter.FetchAllOrdersInterface() {
        @Override
        public void onFetchOrdersSuccess(ArrayList<OrderTo> orderTos) {
            progressBar.setVisibility(View.GONE);
            orders.clear();
            orders.addAll(orderTos);
            adapter.notifyDataSetChanged();
        }

        @Override
        public void onFetchOrderFailed(String errorMsg) {
            Toast.makeText(getContext(), ""+errorMsg, Toast.LENGTH_SHORT).show();
            progressBar.setVisibility(View.GONE);
        }
    };

}
