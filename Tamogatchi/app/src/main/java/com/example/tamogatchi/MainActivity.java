package com.example.tamogatchi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.tamogatchi.food.FoodActivityFrame;
import com.example.tamogatchi.friends.main.ActivityFrame;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mButton;
    private Button fButton;
    private Button dressingroomButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /** Called when the user taps the Friends button */
        mButton = findViewById(R.id.friendsBtn);
        fButton = findViewById(R.id.food);
        dressingroomButton = findViewById(R.id.dressingroomBtn);
        
        mButton.setOnClickListener(this);
        fButton.setOnClickListener(this);
        dressingroomButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId()) 
        {
            case R.id.friendsBtn:
                startActivity(new Intent(this, ActivityFrame.class));
                break;
            case R.id.food:
                startActivity(new Intent(this, FoodActivityFrame.class));
                break;
            case R.id.dressingroomBtn:
                startActivity(new Intent(this, com.example.tamogatchi.dressingroom.ActivityFrame.class));
                break;
            case R.id.goalsBtn:
                startActivity(new Intent(this, com.example.tamogatchi.goals.main.ActivityFrame.class));
                break;
        }
    }
}