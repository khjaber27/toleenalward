package com.toleenalward.rasayel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.toleenalward.rasayel.Fragment.FavoriteFragment;
import com.toleenalward.rasayel.Fragment.HomeFragment;
import com.toleenalward.rasayel.Fragment.SettingsFragment;

public class MainActivity extends AppCompatActivity {


    BottomNavigationView bottomNavigationView;
    private AdView mAdView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId("ca-app-pub-9727225689727896/4916221857");


        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
                mAdView = findViewById(R.id.adView);
                AdRequest adRequest = new AdRequest.Builder().build();
                mAdView.loadAd(adRequest);
            }
        });

        bottomNavigationView = findViewById(R.id.bottomnavigation_view);
        updateFragmentContainer(new HomeFragment());
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.home_item:
                        updateFragmentContainer(new HomeFragment());
                        break;
                    case R.id.favorite_item:
                        updateFragmentContainer(new FavoriteFragment());
                        break;
                    case R.id.settings_item:
                        updateFragmentContainer(new SettingsFragment());
                        break;
                }
                return true;
            }
        });

    }

    private void updateFragmentContainer(Fragment fragment) {


        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.framelayout_view, fragment).commit();
    }


}


