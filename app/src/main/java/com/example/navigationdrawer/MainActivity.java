package com.example.navigationdrawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStateManagerControl;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

import org.jetbrains.annotations.NotNull;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MaterialToolbar toolbar = findViewById(R.id.topAppBar);
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.navigation_view);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                drawerLayout.openDrawer(GravityCompat.START);

            }
        });
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
//            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {

                int id = item.getItemId();
                item.setChecked(true);
                drawerLayout.closeDrawer(GravityCompat.START);
                if (id == R.id.nav_home) {
                    replaceFragment(new HomeFragment());
                    Toast.makeText(MainActivity.this, "Home is Clicked", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.nav_message) {
                    replaceFragment(new MessageFragment());
                    Toast.makeText(MainActivity.this, "Message is Clicked", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.synch) {
//                    replaceFragment(Sync);
                    Toast.makeText(MainActivity.this, "Synch is Clicked", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.trash) {
//                    replaceFragment(new TrashFragment());
                    Toast.makeText(MainActivity.this, "Trash is Clicked", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.settings) {
                    replaceFragment(new SettingsFragment());
                    Toast.makeText(MainActivity.this, "Settings is Clicked", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.nav_login) {
//                    replaceFragment(new Log);
                    Toast.makeText(MainActivity.this, "Login is Clicked", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.nav_share) {
//                    replaceFragment(new ShareF);
                    Toast.makeText(MainActivity.this, "Share is clicked", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.nav_rate) {
                    Toast.makeText(MainActivity.this, "Rate us is Clicked", Toast.LENGTH_SHORT).show();
                } else {
                    return true;
                }


                /*final int navHomeId = R.id.nav_home;
                final int navMessageId = R.id.nav_message;
                final int synchId = R.id.synch;
                final int trashId = R.id.trash;
                final int settingsId = R.id.settings;
                final int navLoginId = R.id.nav_login;
                final int navShareId = R.id.nav_share;
                final int navRateId = R.id.nav_rate;
                switch (id) {
                    case navHomeId:
                        Toast.makeText(MainActivity.this, "Home is Clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case navMessageId:
                        Toast.makeText(MainActivity.this, "Message is Clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case synchId:
                        Toast.makeText(MainActivity.this, "Synch is Clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case trashId:
                        Toast.makeText(MainActivity.this, "Trash is Clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case settingsId:
                        Toast.makeText(MainActivity.this, "Settings is Clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case navLoginId:
                        Toast.makeText(MainActivity.this, "Login is Clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case navShareId:
                        Toast.makeText(MainActivity.this, "Share is clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case navRateId:
                        Toast.makeText(MainActivity.this, "Rate us is Clicked", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        return true;
                }*/

                return true;
            }
        });


    }
    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,fragment);
        fragmentTransaction.commit();
    }
}
