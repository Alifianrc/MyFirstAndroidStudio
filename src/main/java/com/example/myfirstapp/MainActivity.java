package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button volumeButton, infoButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        volumeButton = findViewById(R.id.btn_volume);
        volumeButton.setOnClickListener(this);
        infoButton = findViewById(R.id.btn_info);
        infoButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_volume){
            openSecondActivity();
        }
        else if(view.getId() == R.id.btn_info){
            openInfoActivity1();
        }

    }

    public void openSecondActivity(){
        Intent intent = new Intent(this,SecondActivity.class);
        startActivity(intent);
    }

    public void openInfoActivity1(){
        Intent intent = new Intent(this,InfoActivity1.class);
        startActivity(intent);
    }


}