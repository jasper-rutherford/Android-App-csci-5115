package com.example.tamogatchi.food;

import android.app.FragmentManager;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.tamogatchi.R;
import com.example.tamogatchi.databinding.FoodLayoutFrameBinding;
import com.example.tamogatchi.food.AddFoodFragment;
import com.example.tamogatchi.food.MyFoodFragment;
import com.example.tamogatchi.food.MyFoodItem;
import com.example.tamogatchi.food.SectionsPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class FoodActivityFrame extends AppCompatActivity {

    private FoodLayoutFrameBinding binding;

    FragmentManager fm = getFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.food_layout_frame);
        binding = FoodLayoutFrameBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = binding.tabs;
        tabs.setupWithViewPager(viewPager);

    }

    public void buyfood(View view) {
        switch (view.getId()) {
            case R.id.buyfood_item:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("Are you sure you want to buy this food?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //int x = 0;
                                //ActivityFrame.this.finish();
                                //x = view.getId();
                              //  MyFoodFragment.productList.remove(0);
                               // MyFoodFragment.adapter.notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("Nevermind", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
        }
    }

    public void addfood(View view) {
        switch (view.getId()) {
            case R.id.addfood:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("Are you sure you want to add this food?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                //ActivityFrame.this.finish();
                                dialog.cancel();
                            }
                        })
                        .setNegativeButton("Nevermind", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
        }
    }
}
