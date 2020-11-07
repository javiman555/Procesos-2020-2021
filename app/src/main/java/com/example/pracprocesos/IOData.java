package com.example.pracprocesos;

import java.io.*;
import java.util.*;

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
            int muertos = sc.nextInt();
            int totalsanitario = sc.nextInt();
            int hospitalizados = sc.nextInt();
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
    }

    public ArrayList<String> stringToList(String s){
        ArrayList<String> lista = new ArrayList<String>();
        String[] array = s.split(", ");
        for (int i = 0; i < array.length; i++){
            lista.add(array[i]);
        }
        return lista;
    }
}
