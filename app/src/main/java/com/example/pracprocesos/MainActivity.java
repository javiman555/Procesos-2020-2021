package com.example.pracprocesos;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView ivBoton;
    ImageView botonAjustes;
    ImageView ajustesFondo;
    //ImageView fondoinfo;
    Button botonJugar;
    ImageView botonInfo;
    Button botonhelp;
    TextView txtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        ivBoton = (ImageView) findViewById(R.id.ivBoton);
        botonAjustes = (ImageView) findViewById(R.id.botonAjustes);
        ajustesFondo = (ImageView) findViewById(R.id.ajustesFondo);
        //fondoinfo = (ImageView) findViewById(R.id.fondoInfo);
        botonInfo =  (ImageView) findViewById(R.id.botonInfo);
        botonJugar = (Button) findViewById(R.id.botonjugar);
        botonhelp = (Button) findViewById(R.id.botonhelp);


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
        botonInfo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this,info_popup.class));
            }
        });
        /*fondoinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fondoinfo.setVisibility(View.INVISIBLE);
            }
        });*/
        botonhelp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this,Help_popup.class));

            }
        });
        botonJugar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SelectVirusActivity.class);
                setContentView(R.layout.activity_select_virus);
                startActivity(intent);
                finish();
            }
        });
    }
}