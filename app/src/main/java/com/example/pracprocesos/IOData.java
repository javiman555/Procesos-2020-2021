package com.example.pracprocesos;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class IOData {

    public void InputNewData(HashMap<String, Ciudad> mapa) throws FileNotFoundException {
        if (!mapa.isEmpty()){
            mapa.clear();
        }

        Scanner sc = new Scanner(new File("java/newGameData.txt"));

        while (sc.hasNextLine()) {
            String nombre = sc.nextLine();
            String comunidad = sc.nextLine();
            float densidad = sc.nextFloat();
            int poblacion = sc.nextInt();
            int sanos = sc.nextInt();
            int infectados = sc.nextInt();
            int totalsanitario = sc.nextInt();
            int hospitalizados = sc.nextInt();
            String colindantes = sc.nextLine();

            ArrayList<String> listaColindantes = new ArrayList<String>();
            String[] arrayColindantes = colindantes.toString().split(", ");
            for (int i = 0; i < arrayColindantes.length; i++){
                listaColindantes.add(arrayColindantes[i]);
            }

            Ciudad ciu =
                new Ciudad(nombre, comunidad, densidad, poblacion, sanos, infectados, totalsanitario, hospitalizados, listaColindantes);
            mapa.put(nombre, ciu);
        }
    }
}
