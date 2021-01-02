package com.example.pracprocesos;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.*;

import static java.lang.Math.random;

public class MapActivity extends AppCompatActivity {

    TextView lugar,sanos, infectados,muertos;
    Button botonVirus, botonInfectar;
    ImageView imagen_mapa, mapa_zonas;
    HashMap<String, Ciudad> grafo = new HashMap<>();

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_map);

        Virus virus = (Virus) getIntent().getSerializableExtra("virus");
        botonVirus = (Button) findViewById(R.id.botonVirus);
        botonVirus.setText(virus.getNombre());
        mostrarVirus(virus);

        grafo = InputData("newGameData.txt");

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

        botonInfectar = (Button) findViewById(R.id.infectar);

        botonInfectar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lugar = (TextView) findViewById(R.id.lugar);
                String ciudad = (String) lugar.getText();
                if (grafo.get(ciudad) != null){
                    grafo.get(ciudad).sumSanos(-1);
                    grafo.get(ciudad).sumInfectados(1);
                    botonInfectar.setEnabled(false);
                    botonInfectar.setVisibility(View.INVISIBLE);
                    cambiarDatosLateral(ciudad,
                            grafo.get(ciudad).getSanos(),
                            grafo.get(ciudad).getInfectados(),
                            grafo.get(ciudad).getMuertos());
                }
            }
        });
    }

    public void cambiarDatosLateral(String sLugar, int numSanos, int numInfectados, int numMuertos){
        lugar = (TextView) findViewById(R.id.lugar);
        lugar.setText(sLugar);
        sanos = (TextView) findViewById(R.id.sanos);
        sanos.setText(Integer.toString(numSanos));
        infectados = (TextView) findViewById(R.id.infectados);
        infectados.setText(Integer.toString(numInfectados));
        muertos = (TextView) findViewById(R.id.muertos);
        muertos.setText(Integer.toString(numMuertos));
    }

    public void mostrarVirus(Virus virus){
        cambiarDatosLateral("España", virus.getSanos(), virus.getInfectados(), virus.getMuertos());
    }

    /* Zona para interactividad del mapa */
    /*
        Tutorial de uso: https://blahti.wordpress.com/2012/06/26/images-with-clickable-areas/
        La idea clave: tenemos una imagen transparente con colores, comprobamos si al tocar esa
        imagen, el píxel que toca es de cierto color. Cada color corresponde a una autonomía.
     */

    public void clickMapa(int coord_x, int coord_y) {

        int color = colorDePunto(coord_x,coord_y);
        String sitio = null;

        if (colorSimilar(color, Color.parseColor("#A24FFF"))) {
            sitio = "Valladolid";
        }
        else if (colorSimilar(color, Color.parseColor("#FFCB7F"))) {
            sitio = "Santiago de Compostela";
        }
        else if (colorSimilar(color, Color.parseColor("#D2A9CB"))) {
            sitio = "Oviedo";
        }
        else if (colorSimilar(color, Color.parseColor("#F07995"))) {
            sitio = "Santander";
        }
        else if (colorSimilar(color, Color.parseColor("#8AC277"))) {
            sitio = "Vitoria";
        }
        else if (colorSimilar(color, Color.parseColor("#FF9700"))) {
            sitio = "Pamplona";
        }
        else if (colorSimilar(color, Color.parseColor("#4D72FF"))) {
            sitio = "Logroño";
        }
        else if (colorSimilar(color, Color.parseColor("#BBC19F"))) {
            sitio = "Zaragoza";
        }
        else if (colorSimilar(color, Color.parseColor("#A59794"))) {
            sitio = "Barcelona";
        }
        else if (colorSimilar(color, Color.parseColor("#BD5858"))) {
            sitio = "Madrid";
        }
        else if (colorSimilar(color, Color.parseColor("#FFD8BB"))) {
            sitio = "Mérida";
        }
        else if (colorSimilar(color, Color.parseColor("#FFF24D"))) {
            sitio = "Toledo";
        }
        else if (colorSimilar(color, Color.parseColor("#FEA98C"))) {
            sitio = "Valencia";
        }
        else if (colorSimilar(color, Color.parseColor("#669BA1"))) {
            sitio = "Palma de Mallorca";
        }
        else if (colorSimilar(color, Color.parseColor("#009D78"))) {
            sitio = "Murcia";
        }
        else if (colorSimilar(color, Color.parseColor("#FF3A3A"))) {
            sitio = "Sevilla";
        }
        else if (colorSimilar(color, Color.parseColor("#D46CD3"))) {
            sitio = "Málaga";
        }
        else if (colorSimilar(color, Color.parseColor("#FFA6FE"))) {
            sitio = "Algeciras";
        }
        else if (colorSimilar(color, Color.parseColor("#D5D5D5"))) {
            sitio = "Ceuta";
        }
        else if (colorSimilar(color, Color.parseColor("#434343"))) {
            sitio = "Melilla";
        }
        else if (colorSimilar(color, Color.parseColor("#DFFF74"))) {
            sitio = "Las Palmas de Gran Canaria";
        }
        else if (colorSimilar(color, Color.parseColor("#728926"))) {
            sitio = "Santa Cruz de Tenerife";
        }
        else {
            sitio = "No se reconoce la zona";
        }
        System.out.println(sitio);
        if (grafo.get(sitio) != null){
        System.out.println("Sanos: " + grafo.get(sitio).getSanos());
        System.out.println("Infectados: " + grafo.get(sitio).getInfectados());
        System.out.println("Muertos: " + grafo.get(sitio).getMuertos());
            cambiarDatosLateral(sitio,
                    grafo.get(sitio).getSanos(),
                    grafo.get(sitio).getInfectados(),
                    grafo.get(sitio).getMuertos());
        } else cambiarDatosLateral(sitio, 0, 0,0);

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

    /***************
     * CARGAR DATOS
     */

    public HashMap<String, Ciudad> InputData(String archivo) {
        HashMap<String, Ciudad> mapa = new HashMap<>();
        try {
            InputStream is = getAssets().open(archivo);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            String allData = new String(buffer, StandardCharsets.UTF_8);
            //System.out.println(allData);
            Scanner sc = new Scanner(allData);

            while (sc.hasNextLine()) {
                String nombre = sc.nextLine();
                String comunidad = sc.nextLine();
                float densidad = Float.parseFloat(sc.nextLine());
                int poblacion = Integer.parseInt(sc.nextLine());
                int sanos = Integer.parseInt(sc.nextLine());
                int infectados = Integer.parseInt(sc.nextLine());
                int muertos = 0;
                int totalsanitario = Integer.parseInt(sc.nextLine());
                int hospitalizados = Integer.parseInt(sc.nextLine());
                String colindantes = sc.nextLine();
                String puertos = sc.nextLine();
                String aeropuertos = sc.nextLine();

                ArrayList<String> listaColindantes = stringToList(colindantes);
                ArrayList<String> listaPuertos = stringToList(puertos);
                ArrayList<String> listaAeropuertos = stringToList(aeropuertos);

                Ciudad ciu = new Ciudad(nombre,
                        comunidad,
                        densidad,
                        poblacion,
                        sanos,
                        infectados,
                        muertos,
                        totalsanitario,
                        hospitalizados,
                        listaColindantes,
                        listaPuertos,
                        listaAeropuertos);
                mapa.put(nombre, ciu);
            }
        } catch (IOException ex){
            ex.printStackTrace();
        }
        return mapa;
    }

    public ArrayList<String> stringToList(String s){
        ArrayList<String> lista = new ArrayList<String>();
        String[] array = s.split(", ");
        for (int i = 0; i < array.length; i++){
            lista.add(array[i]);
        }
        return lista;
    }

    /***********************
     * ECUACIONES DEL VIRUS Y DE LOS VIAJES (Y SUS MÉTODOS)
     */
    Random rand = new Random();
    float d_min = Float.MAX_VALUE;
    HashMap<String, Ciudad> propagacion(@NotNull HashMap<String, Ciudad> grafo, String nomCiudad){ //Devuelve el grafo
        Ciudad ciudad = grafo.remove(nomCiudad);
        int old_inf = ciudad.getInfectados();
        float densidad = ciudad.getPoblacion()/ciudad.getSuperficie();
        d_min = Math.min(densidad, d_min);
        float deathline = 1.0f;
        if (ciudad.getInfectados() > ciudad.getHospitalizados()) deathline = 1.5f;
        int infNuevos = (int) Math.round(Math.pow((2*Math.log(densidad) - 2*Math.log(Math.max(100, d_min)) + 1) * old_inf, deathline));
        int muertos = (int) Math.pow((old_inf * Math.abs(rand.nextGaussian())), deathline);
        int infTotales = infNuevos - muertos;
        ciudad.sumInfectados(infTotales - old_inf);
        ciudad.sumSanos(old_inf - infNuevos);
        ciudad.sumMuertos(muertos);
        ciudad.sumPoblacion(-muertos);
        grafo.put(nomCiudad, ciudad);
        return grafo;
    }

    HashMap<String, Ciudad> viajes(@NotNull HashMap<String, Ciudad> grafo, String nomOrigen){
        Ciudad origen = grafo.remove(nomOrigen);
        int poblacion = origen.getPoblacion();
        int viajaTierra = (int) Math.round(Math.random() * 0.035 * poblacion);
        int viajaMar = (int) Math.round(Math.random() * 0.003 * poblacion);
        int viajaAire = (int) Math.round(Math.random() * 0.012 * poblacion);

        float sigmaInf = origen.getInfectados()/origen.getSanos();
        int infTierra = (int) Math.round(sigmaInf * viajaTierra);
        int infMar = (int) Math.round(sigmaInf * viajaMar);
        int infAire = (int) Math.round(sigmaInf * viajaAire);

        int infAcumulado = 0, sanAcumulado = 0;
        int nTierra = origen.getTierra().size();
        int nMar = origen.getMar().size();
        int nAire = origen.getAire().size();

        for (int i = 0; i < nTierra - 1; i++){
            String nomDestino = origen.getTierra().get(i);
            Ciudad destino = grafo.remove(nomDestino);
            int viajaInfectados = (int) Math.round(infTierra / nTierra);
            int viajaSanos = (int) Math.round(viajaTierra / nTierra) - viajaInfectados;
            infAcumulado += viajaInfectados;
            sanAcumulado += viajaSanos;
            origen.sumSanos(-viajaSanos);
            origen.sumInfectados(-viajaInfectados);
            origen.sumPoblacion(-viajaSanos - viajaInfectados);
            destino.sumSanos(viajaSanos);
            destino.sumInfectados(viajaInfectados);
            destino.sumPoblacion(viajaSanos + viajaInfectados);
            grafo.put(nomDestino, destino);
        };
        String nomDestino = origen.getTierra().get(nTierra-1);
        Ciudad destino = grafo.remove(nomDestino);
        int viajaInfectados = infTierra - infAcumulado;
        int viajaSanos = viajaTierra - infTierra - sanAcumulado;
        origen.sumSanos(-viajaSanos);
        origen.sumInfectados(-viajaInfectados);
        destino.sumSanos(viajaSanos);
        destino.sumInfectados(viajaInfectados);
        grafo.put(nomDestino, destino);

        for (int i = 0; i < nTierra - 1; i++){
            String nomDestino = origen.getTierra().get(i);
            Ciudad destino = grafo.remove(nomDestino);
            int viajaInfectados = (int) Math.round(infTierra / nTierra);
            int viajaSanos = (int) Math.round(viajaTierra / nTierra) - viajaInfectados;
            infAcumulado += viajaInfectados;
            sanAcumulado += viajaSanos;
            origen.sumSanos(-viajaSanos);
            origen.sumInfectados(-viajaInfectados);
            origen.sumPoblacion(-viajaSanos - viajaInfectados);
            destino.sumSanos(viajaSanos);
            destino.sumInfectados(viajaInfectados);
            destino.sumPoblacion(viajaSanos + viajaInfectados);
            grafo.put(nomDestino, destino);
        };
        String nomDestino = origen.getTierra().get(nTierra-1);
        Ciudad destino = grafo.remove(nomDestino);
        int viajaInfectados = infTierra - infAcumulado;
        int viajaSanos = viajaTierra - infTierra - sanAcumulado;
        origen.sumSanos(-viajaSanos);
        origen.sumInfectados(-viajaInfectados);
        destino.sumSanos(viajaSanos);
        destino.sumInfectados(viajaInfectados);
        grafo.put(nomDestino, destino);

        for (int i = 0; i < nTierra - 1; i++){
            String nomDestino = origen.getTierra().get(i);
            Ciudad destino = grafo.remove(nomDestino);
            int viajaInfectados = (int) Math.round(infTierra / nTierra);
            int viajaSanos = (int) Math.round(viajaTierra / nTierra) - viajaInfectados;
            infAcumulado += viajaInfectados;
            sanAcumulado += viajaSanos;
            origen.sumSanos(-viajaSanos);
            origen.sumInfectados(-viajaInfectados);
            origen.sumPoblacion(-viajaSanos - viajaInfectados);
            destino.sumSanos(viajaSanos);
            destino.sumInfectados(viajaInfectados);
            destino.sumPoblacion(viajaSanos + viajaInfectados);
            grafo.put(nomDestino, destino);
        };
        String nomDestino = origen.getTierra().get(nTierra-1);
        Ciudad destino = grafo.remove(nomDestino);
        int viajaInfectados = infTierra - infAcumulado;
        int viajaSanos = viajaTierra - infTierra - sanAcumulado;
        origen.sumSanos(-viajaSanos);
        origen.sumInfectados(-viajaInfectados);
        destino.sumSanos(viajaSanos);
        destino.sumInfectados(viajaInfectados);
        grafo.put(nomDestino, destino);

        grafo.put(nomOrigen, origen);

    }

}