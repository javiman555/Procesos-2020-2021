package com.example.pracprocesos;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;


public class MainActivity extends AppCompatActivity {

    ImageView ivBoton;
    ImageView botonAjustes;
    ImageView ajustesFondo;
    //ImageView fondoinfo;
    Button botonJugar;
    ImageView botonInfo;
    Button botonhelp;
    TextView txtView;
    MediaPlayer mp;
    MediaPlayer mp2;
    Switch Sonido;
    ToggleButton Musica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        ivBoton = (ImageView) findViewById(R.id.ivBoton);
        botonAjustes = (ImageView) findViewById(R.id.botonAjustes);
        botonInfo =  (ImageView) findViewById(R.id.botonInfo);
        botonJugar = (Button) findViewById(R.id.botonjugar);
        botonhelp = (Button) findViewById(R.id.botonhelp);
        Sonido = (Switch) findViewById(R.id.sonido);
        Musica = (ToggleButton) findViewById(R.id.musica);
        mp = MediaPlayer.create(this, R.raw.sonidoboton);
        mp2 = MediaPlayer.create(this, R.raw.sonidofondo);


        //mp2.setLooping(true);
        mp2.start();
        ivBoton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                finish();
            }
        });
        botonAjustes.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                mp.start();
                startActivity(new Intent(MainActivity.this,ajustes_popup.class));
            }
        });
        Musica.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                if (Musica.isChecked()) {
                    mp2.start();
                } else {
                    mp2.stop();
                }
            }
        });


        /*ajustesFondo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ajustesFondo.setVisibility(View.INVISIBLE);
            }
        });*/
        botonInfo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                mp.start();
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
                mp.start();
                startActivity(new Intent(MainActivity.this,Help_popup.class));

            }
        });
        botonJugar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mp.start();
                Intent intent = new Intent(MainActivity.this,SelectVirusActivity.class);
                setContentView(R.layout.activity_select_virus);
                startActivity(intent);
                finish();
            }
        });

    }

    /*public void onClick(View src) {
        if(Musica.isChecked()) {
            mp2.start();
        }
        else{
            mp2.stop();
        }
    }*/
}