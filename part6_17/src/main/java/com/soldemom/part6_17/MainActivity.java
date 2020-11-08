package com.soldemom.part6_17;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {

    Button frag1;
    Button frag2;
    Button frag3;
    LinearLayout lila;
    FragmentTransaction ft;

    OneFragment oneFragment;
    TwoFragment twoFragment;
    ThreeFragment threeFragment;
    FragmentManager manager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        frag1 = findViewById(R.id.frag_1);
        frag2 = findViewById(R.id.frag_2);
        frag3 = findViewById(R.id.frag_3);
        lila = findViewById(R.id.lila);
        frag1.setOnClickListener(this);
        frag2.setOnClickListener(this);
        frag3.setOnClickListener(this);

        manager = getSupportFragmentManager();
        oneFragment = new OneFragment();
        twoFragment = new TwoFragment();
        threeFragment = new ThreeFragment(getApplicationContext());

        FragmentTransaction ft = manager.beginTransaction();
        ft.addToBackStack(null);
        ft.add(R.id.lila,oneFragment);
        ft.commit();







    }

    @Override
    public void onClick(View v) {
        if (v == frag1) {
            if(!oneFragment.isVisible()) {
                FragmentTransaction ft = manager.beginTransaction();
                ft.addToBackStack(null);
                ft.replace(R.id.lila,oneFragment);
                ft.commit();
            }
        } else if (v == frag2) {
            if(!twoFragment.isVisible()) {
                twoFragment.show(manager,null);
            }

        } else if (v == frag3) {
            if(!threeFragment.isVisible()) {
                FragmentTransaction ft = manager.beginTransaction();
                ft.addToBackStack(null);
                ft.replace(R.id.lila, threeFragment);
                ft.commit();
            }
        }
    }
}
