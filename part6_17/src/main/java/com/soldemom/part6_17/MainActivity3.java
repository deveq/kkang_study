package com.soldemom.part6_17;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {

    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        viewPager = findViewById(R.id.view_pager);

        MyPagerAdapter2 pagerAdapter2 = new MyPagerAdapter2(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter2);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(
                this,
                2,
                GridLayoutManager.HORIZONTAL,
                false);


    }

    class MyPagerAdapter2 extends FragmentPagerAdapter {

        ArrayList<Fragment> fragments;

        public MyPagerAdapter2(FragmentManager fm) {
            super(fm);
            fragments = new ArrayList<Fragment>();
            fragments.add(new OneFragment());
            fragments.add(new ThreeFragment(getApplicationContext()));
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }
}