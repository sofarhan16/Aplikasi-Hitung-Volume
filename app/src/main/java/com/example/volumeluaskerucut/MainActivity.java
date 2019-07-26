package com.example.volumeluaskerucut;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnvolumeC = findViewById(R.id.btnvolume);
        btnvolumeC.setOnClickListener(this);

        Button btnLuasC = findViewById(R.id.btnluas);
        btnLuasC.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnvolume:
                Intent volumeIntent = new Intent(MainActivity.this, VolumeActivity.class);
                startActivity(volumeIntent);
                        break;
            case R.id.btnluas:
                Intent luasIntent = new Intent(MainActivity.this, LuasActivity.class);
                startActivity(luasIntent);
                break;
        }
    }
}
