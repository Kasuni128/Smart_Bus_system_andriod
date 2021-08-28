package com.example.smart_bus_system.TimeKeeper.Screens.Home;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.smart_bus_system.BusOwner.Screens.Home.Model.Driver_Time_Model;
import com.example.smart_bus_system.Conection.RetroClient;
import com.example.smart_bus_system.R;
import com.example.smart_bus_system.TimeKeeper.Screens.Home.Adapter.TimeKeeperAdapter;
import com.example.smart_bus_system.User.Screens.AvailableBuses.Model.Bus_info_model;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.MODE_PRIVATE;


public class TimeKeeperHomeFragment extends Fragment {

    View view;

    RecyclerView recyclerview;
    SwipeRefreshLayout swipeRefreshLayout;


    String Current_user_route_id="1";



    //session for get values
    SharedPreferences sharedpreferences;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.time_keeper_home_fragment, container, false);

        //declare a session
        sharedpreferences=getContext().getSharedPreferences("user_details",MODE_PRIVATE);
        Current_user_route_id=sharedpreferences.getString("route_id","");



        init();
        LoadData();


        return view;
    }


    private void init() {

//

        recyclerview=view.findViewById(R.id.recyclerview);


        swipeRefreshLayout=view.findViewById(R.id.swipeMenu);

        //when swiped the top it will automatically refresh
        swipeRefreshLayout.setOnRefreshListener( new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                LoadData();
                swipeRefreshLayout.setRefreshing( false );
            }
        } );

    }


    private void LoadData() {


        HashMap<String, String> params= new HashMap<>();
        params.put("route_id",Current_user_route_id);


        Call<List<Bus_info_model>> TimekeepergetBusInfo= RetroClient.getInstance().getApi().TimekeepergetBusInfo(params);

        TimekeepergetBusInfo.enqueue(new Callback<List<Bus_info_model>>() {
            @Override
            public void onResponse(Call<List<Bus_info_model>> call, Response<List<Bus_info_model>> response) {
                List<Bus_info_model> result= response.body();

                TimeKeeperAdapter timeKeeperAdapter= new TimeKeeperAdapter(getContext(),result);
                recyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
                recyclerview.setAdapter(timeKeeperAdapter);



            }

            @Override
            public void onFailure(Call<List<Bus_info_model>> call, Throwable t) {

            }
        });

    }
}