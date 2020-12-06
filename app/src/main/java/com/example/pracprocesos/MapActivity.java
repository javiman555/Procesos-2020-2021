package com.example.pracprocesos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MapActivity extends AppCompatActivity {

    TextView lugar,sanos, infectados,muertos;
    Button botonVirus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_map);

        Virus  virus = (Virus) getIntent().getSerializableExtra("virus");
        botonVirus = (Button) findViewById(R.id.botonVirus);
        botonVirus.setText(virus.getNombre());
        mostrarVirus(virus);

        botonVirus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            mostrarVirus(virus);
            }
        });

    }

    public void mostrarVirus(Virus virus){
        lugar = (TextView) findViewById(R.id.lugar);
        lugar.setText("España");
        sanos = (TextView) findViewById(R.id.sanos);
        sanos.setText(Integer.toString(virus.getSanos()));
        infectados = (TextView) findViewById(R.id.infectados);
        infectados.setText(Integer.toString(virus.getInfectados()));
        muertos = (TextView) findViewById(R.id.muertos);
        muertos.setText(Integer.toString(virus.getMuertos()));

    }



}