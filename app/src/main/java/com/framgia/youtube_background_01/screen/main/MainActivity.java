package com.framgia.youtube_background_01.screen.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import com.framgia.youtube_background_01.R;
import com.framgia.youtube_background_01.screen.home.HomeFragment;

public class MainActivity extends AppCompatActivity
        implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.bottomNavigation).setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;
        switch (menuItem.getItemId()) {
            case R.id.navHome:
                fragment = HomeFragment.newInstance();
                break;
        }
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameLayoutContainer, fragment)
                .commit();
        return true;
    }
}
