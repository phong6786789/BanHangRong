package com.subi.ailearn.view.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.subi.ailearn.R;

public class MainActivity extends AppCompatActivity {
    public static BottomNavigationView navigation;
    int startingPosition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("HÀNG RONG");
        navigation = (BottomNavigationView) findViewById(R.id.btMenu);
        navigation.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);
        if (savedInstanceState == null) {
            navigation.setSelectedItemId(R.id.home);
        }
    }

    //Menu bottom
    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment fragment = null;
            switch (menuItem.getItemId()) {
                case R.id.home:
                    fragment = new HomeFragment();
                    loadFragment(fragment, 1);
                    return true;

                case R.id.user:
                    fragment = new UserFragment();
                    loadFragment(fragment, 2);
                    return true;

            }
            return false;
        }
    };

    private boolean loadFragment(Fragment fragment, int newPosition) {
        if (fragment != null) {
            if (startingPosition > newPosition) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .setCustomAnimations(R.anim.from_left, R.anim.to_right)
                        .replace(R.id.frame, fragment).commit();

            }
            if (startingPosition < newPosition) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .setCustomAnimations(R.anim.from_right, R.anim.to_left)
                        .replace(R.id.frame, fragment).commit();

            }
            startingPosition = newPosition;
            return true;
        }

        return false;
    }
}