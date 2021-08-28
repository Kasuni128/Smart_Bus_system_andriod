package com.example.smart_bus_system.User.Screens.AvailableBuses;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.smart_bus_system.Conection.RetroClient;
import com.example.smart_bus_system.R;
import com.example.smart_bus_system.User.Screens.AvailableBuses.Adapter.BusInfoAdpater;
import com.example.smart_bus_system.User.Screens.AvailableBuses.Model.Bus_info_model;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class AvailablelBusFragment extends Fragment {
View view;
RecyclerView recyclerView;

private  String Router_ID="1";

    public AvailablelBusFragment(String Router_ID) {

        this.Router_ID=Router_ID;
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        view=inflater.inflate(R.layout.user_availablel_buses, container, false);

        recyclerView=view.findViewById(R.id.recyclerView);
        LoadData();
        return view;
    }

    private void LoadData() {

        HashMap<String, String> params= new HashMap<>();

        params.put("route_id",Router_ID);


        //pass the parameters values to
        Call<List<Bus_info_model>> getBusInfo= RetroClient.getInstance().getApi().getBusInfo(params);

        getBusInfo.enqueue(new Callback<List<Bus_info_model>>() {
            @Override
            public void onResponse(Call<List<Bus_info_model>> call, Response<List<Bus_info_model>> response) {


                List<Bus_info_model> bus_info_models=response.body();
                BusInfoAdpater busInfoAdpater= new BusInfoAdpater(getContext(),bus_info_models);
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));



                recyclerView.setAdapter(busInfoAdpater);
            }

            @Override
            public void onFailure(Call<List<Bus_info_model>> call, Throwable t) {
                Log.e("error",t.getMessage());

            }
        });




    }
}