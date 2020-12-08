package com.example.pracprocesos;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MapActivity extends AppCompatActivity {

    TextView lugar,sanos, infectados,muertos;
    Button botonVirus;
    ImageView imagen_mapa, mapa_zonas;

    @SuppressLint("ClickableViewAccessibility")
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

        imagen_mapa = (ImageView) findViewById(R.id.imagen_mapa);
        mapa_zonas = (ImageView) findViewById(R.id.mapa_areas_colores);

        imagen_mapa.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                if (action == MotionEvent.ACTION_UP) {
                    clickMapa((int) event.getX(), (int) event.getY());
                }
                return true;
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

    /* Zona para interactividad del mapa */
    /*
        Tutorial de uso: https://blahti.wordpress.com/2012/06/26/images-with-clickable-areas/
        La idea clave: tenemos una imagen transparente con colores, comprobamos si al tocar esa
        imagen, el píxel que toca es de cierto color. Cada color corresponde a una autonomía.
     */

    public void clickMapa(int coord_x, int coord_y) {

        int color = colorDePunto(coord_x,coord_y);

        if (colorSimilar(color, Color.parseColor("#A24FFF"))) {
            System.out.println("Valladolid");
        }
        else if (colorSimilar(color, Color.parseColor("#FFCB7F"))) {
            System.out.println("Santiago de Compostela");
        }
        else if (colorSimilar(color, Color.parseColor("#D2A9CB"))) {
            System.out.println("Oviedo");
        }
        else if (colorSimilar(color, Color.parseColor("#F07995"))) {
            System.out.println("Santander");
        }
        else if (colorSimilar(color, Color.parseColor("#8AC277"))) {
            System.out.println("Vitoria");
        }
        else if (colorSimilar(color, Color.parseColor("#FF9700"))) {
            System.out.println("Pamplona");
        }
        else if (colorSimilar(color, Color.parseColor("#4D72FF"))) {
            System.out.println("Logroño");
        }
        else if (colorSimilar(color, Color.parseColor("#BBC19F"))) {
            System.out.println("Zaragoza");
        }
        else if (colorSimilar(color, Color.parseColor("#A59794"))) {
            System.out.println("Barcelona");
        }
        else if (colorSimilar(color, Color.parseColor("#BD5858"))) {
            System.out.println("Madrid");
        }
        else if (colorSimilar(color, Color.parseColor("#FFD8BB"))) {
            System.out.println("Mérida");
        }
        else if (colorSimilar(color, Color.parseColor("#FFF24D"))) {
            System.out.println("Toledo");
        }
        else if (colorSimilar(color, Color.parseColor("#FEA98C"))) {
            System.out.println("Valencia");
        }
        else if (colorSimilar(color, Color.parseColor("#669BA1"))) {
            System.out.println("Palma de Mallorca");
        }
        else if (colorSimilar(color, Color.parseColor("#FF9700"))) {
            System.out.println("Murcia");
        }
        else if (colorSimilar(color, Color.parseColor("#FF3A3A"))) {
            System.out.println("Sevilla");
        }
        else if (colorSimilar(color, Color.parseColor("#D46CD3"))) {
            System.out.println("Málaga");
        }
        else if (colorSimilar(color, Color.parseColor("#FFA6FE"))) {
            System.out.println("Algeciras");
        }
        else if (colorSimilar(color, Color.parseColor("#C4EBFC"))) {
            System.out.println("Ceuta");
        }
        else if (colorSimilar(color, Color.parseColor("#434343"))) {
            System.out.println("Melilla");
        }
        else if (colorSimilar(color, Color.parseColor("#DFFF74"))) {
            System.out.println("Las Palmas de Gran Canaria");
        }
        else if (colorSimilar(color, Color.parseColor("#728926"))) {
            System.out.println("Santa Cruz de Tenerife");
        }
        else {
            System.out.println("No se reconoce la zona");
        }
    }

    public int colorDePunto(int x, int y) {
        this.mapa_zonas.setDrawingCacheEnabled(true);
        Bitmap puntos = Bitmap.createBitmap(this.mapa_zonas.getDrawingCache());
        this.mapa_zonas.setDrawingCacheEnabled(false);
        return puntos.getPixel(x,y);
    }

    public boolean colorSimilar (int color1, int color2) {
        int tolerancia = 25;
        if (Math.abs (Color.red (color1) - Color.red (color2)) > tolerancia )
            return false;
        if (Math.abs (Color.green (color1) - Color.green (color2)) > tolerancia )
            return false;
        if (Math.abs (Color.blue (color1) - Color.blue (color2)) > tolerancia )
            return false;
        return true;
    }



}