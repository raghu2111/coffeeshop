package com.example.coffeshop;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class mycustom_adapter  extends FragmentStateAdapter {
    public mycustom_adapter(@NonNull MainActivity fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:return new Home_nav();
            case 1: return new cart_nav();
            case 2: return new wish_nav();
            default:return new Home_nav();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
