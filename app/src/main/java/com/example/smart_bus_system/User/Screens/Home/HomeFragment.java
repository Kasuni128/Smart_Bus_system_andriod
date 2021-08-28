package com.example.smart_bus_system.User.Screens.Home;

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
import com.example.smart_bus_system.User.Screens.Home.Adapters.RoutesAdapter;
import com.example.smart_bus_system.User.Screens.Home.Model.Routes_Model;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class HomeFragment extends Fragment {

 View view;

 RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view=inflater.inflate(R.layout.home_fragment, container, false);
        init();

        LoadData();
        return view;
    }

    private void LoadData() {

        Call<List<Routes_Model>> getRotues= RetroClient.getInstance().getApi().getRotues();


        getRotues.enqueue(new Callback<List<Routes_Model>>() {
            @Override
            public void onResponse(Call<List<Routes_Model>> call, Response<List<Routes_Model>> response) {

            List<Routes_Model>  routes_modelList=response.body();


                RoutesAdapter adapter= new RoutesAdapter(getContext(),routes_modelList);
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                recyclerView.setAdapter(adapter);

             }

            @Override
            public void onFailure(Call<List<Routes_Model>> call, Throwable t) {

                Log.e("error",t.getMessage());
            }
        });
    }

    private void init() {

        recyclerView=view.findViewById(R.id.recyclerView);
    }
}