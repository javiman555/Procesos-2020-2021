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

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ImageView ivBoton;
    ImageView botonAjustes;
    ImageView ajustesFondo;
    Button botonJugar;
    ImageView botonInfo;
    ImageView botonhelp;
    TextView txtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        ivBoton = (ImageView) findViewById(R.id.ivBoton);
        botonAjustes = (ImageView) findViewById(R.id.botonAjustes);
        ajustesFondo = (ImageView) findViewById(R.id.ajustesFondo);
        //infofondo = (ImageView) findViewById(R.id.infofondo);
        botonInfo =  (ImageView) findViewById(R.id.botonInfo);
        txtView = (TextView) findViewById(R.id.txtView);
        botonJugar = (Button) findViewById(R.id.botonjugar);
        botonhelp = (ImageView) findViewById(R.id.botonhelp);

        botonInfo.setOnClickListener(this);

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
                txtView.setVisibility(View.VISIBLE);
            }
        });
        txtView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtView.setVisibility(View.INVISIBLE);
            }
        });
        botonhelp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){ajustesFondo.setVisibility(View.VISIBLE);

            }
        });
        botonJugar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MapActivity.class);
                setContentView(R.layout.activity_map);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.botonInfo:
                txtView.append("Creado por A(jed)ile Knights");
                break;
        }
    }
}