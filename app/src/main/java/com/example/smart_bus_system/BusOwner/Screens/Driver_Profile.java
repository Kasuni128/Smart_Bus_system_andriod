package com.example.smart_bus_system.BusOwner.Screens;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.smart_bus_system.LoginActivity;
import com.example.smart_bus_system.R;

import static android.content.Context.MODE_PRIVATE;

public class Driver_Profile extends Fragment {

    View view;

    Button logo_out;



    //session for get values
    SharedPreferences sharedpreferences;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view=inflater.inflate(R.layout.driver_profile_fragment, container, false);
        init();

        return view;
    }

    private void init() {



        logo_out=view.findViewById(R.id.logo_out);
        logo_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                LogOut();
            }
        });

    }

    private void LogOut() {

        //declare a session
        sharedpreferences=getContext().getSharedPreferences("user_details",MODE_PRIVATE);
        //sessions clear when user log out
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putBoolean("isLoggedIn",false);
        editor.putString("usertype","");
        editor.putString("uid","");
        editor.putString("bus_number","");
        editor.putString("route_id","");


        editor.clear();
        editor.commit();


        startActivity(new Intent(getActivity(), LoginActivity.class));
        getActivity().finish();
    }

}