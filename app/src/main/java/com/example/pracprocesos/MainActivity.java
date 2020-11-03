package com.example.pracprocesos;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView ivBoton;
    ImageView botonAjustes;
    ImageView ajustesFondo;
    ImageView botonJugar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        ivBoton = (ImageView) findViewById(R.id.ivBoton);
        botonAjustes = (ImageView) findViewById(R.id.botonAjustes);
        ajustesFondo = (ImageView) findViewById(R.id.ajustesFondo);

        ivBoton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                finish();
            }
        });
        botonAjustes.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                ajustesFondo.setVisibility(View.VISIBLE);
            }
        });
        ajustesFondo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ajustesFondo.setVisibility(View.INVISIBLE);
            }
        });
        /*botonJugar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                //EmperzarPartida()
            }
        });*/ //Comentado porque peta
    }
}