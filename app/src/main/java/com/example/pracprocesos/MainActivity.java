package com.example.pracprocesos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView ivBoton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        ivBoton = (ImageView) findViewById(R.id.ivBoton);

        ivBoton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v){
                finish();
            }
        });
    }
}