package com.example.coffeshop; // Corrected the package name

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    ViewPager2 viewPager2;
    mycustom_adapter myCustomAdapter; // Corrected the variable name
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottomnavi);
        viewPager2 = findViewById(R.id.viewpager);
        myCustomAdapter = new mycustom_adapter(this); // Corrected the variable name
        viewPager2.setAdapter(myCustomAdapter);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id) {
                    case R.id.bottom_home:
                        viewPager2.setCurrentItem(0);
                        break;

                    case R.id.bottom_cart:
                        viewPager2.setCurrentItem(1);
                        break;

                    case R.id.bottom_love:
                        viewPager2.setCurrentItem(2);
                        break;
                }
                return true; // Return true to indicate that the item is selected.
            }
        });

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        bottomNavigationView.setSelectedItemId(R.id.bottom_home); // Use setSelectedItemId to set the selected item
                        break;
                    case 1:
                        bottomNavigationView.setSelectedItemId(R.id.bottom_cart);
                        break;
                    case 2:
                        bottomNavigationView.setSelectedItemId(R.id.bottom_love);
                        break;
                }
                super.onPageSelected(position);
            }
        });
    }
}