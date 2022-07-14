package com.example.tamogatchi.friends.main;
import com.example.tamogatchi.R;

import android.content.DialogInterface;
import androidx.appcompat.app.AlertDialog;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.example.tamogatchi.databinding.FriendsLayoutFrameBinding;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityFrame extends AppCompatActivity {

    private FriendsLayoutFrameBinding binding;

    FragmentManager fm = getFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.friends_layout_frame);
        binding = FriendsLayoutFrameBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = binding.tabs;
        tabs.setupWithViewPager(viewPager);

    }

    public void unfriend(View view) {
        switch (view.getId()) {
            case R.id.unfriend:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("Are you sure you want to unfriend?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //int x = 0;
                                //ActivityFrame.this.finish();
                                //x = view.getId();
                                MyFriendsFragment.productList.remove(0);
                                MyFriendsFragment.adapter.notifyDataSetChanged();
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

    public void addFriend(View view) {
        switch (view.getId()) {
            case R.id.addfriend:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("Are you sure you want to add this friend?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                MyFriendsFragment.productList.add(new MyFriendsItem(4, "Mickey", "screentime up 65%", 15, R.drawable.avatar1));
                                AddFriendsFragment.productList.remove(0);
                                MyFriendsFragment.adapter.notifyDataSetChanged();
                                AddFriendsFragment.adapter.notifyDataSetChanged();

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
