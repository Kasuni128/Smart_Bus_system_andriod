package com.example.smart_bus_system.TimeKeeper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.smart_bus_system.R;
import com.example.smart_bus_system.TimeKeeper.Screens.Home.TimeKeeperHomeFragment;
import com.example.smart_bus_system.TimeKeeper.Screens.TimeKeeperProfile;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class TimeKeeperMainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.time_keeper_main);
        bottomNavigation = findViewById(R.id.nav_view);
        bottomNavigation.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
        // Passing each menu ID as a set of Ids because each
        openFragment(new TimeKeeperHomeFragment());
//        openFragment(new AvailablelBusFragment());


    }

    BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.navigation_home:
                            //Log.d("menu event","Home");
                            openFragment(new TimeKeeperHomeFragment());
                            return true;
                        case R.id.navigation_profile:
                            // Log.d("menu event","Home");
                            openFragment(new TimeKeeperProfile());

                            return true;
                    }
                    return false;
                }
            };


    public void openFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}