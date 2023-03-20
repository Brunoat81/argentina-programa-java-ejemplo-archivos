package org.example;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.opencsv.bean.CsvToBeanBuilder;

import modelo.Partidos;

public class Main {
    public static void main(String[] args) {
        //En la variable args va a viajar la ruta del archivo que queremos que abra el programa
        if(args.length == 0){
            System.out.println("ERROR: No ingresaste ningún archivo como argumento!");
            System.exit(88);
        }

        List <Partidos> listaDePartidos;
        try {
            // En esta primera línea definimos el archivos que va a ingresar
           listaDePartidos = new CsvToBeanBuilder(new FileReader(args[0]))
                      // Es necesario definir el tipo de dato que va a generar el objeto que estamos queriendo parsear a partir del CSV
                    .withType(Partidos.class)
                    .build()
                    .parse();

              //El resultado de este método nos da una lita del objetos

            for (Partidos partidos : listaDePartidos) {
                String ganador = null;
                String ganador1 = null;
                
                if (partidos.getGolesEquipoA() > partidos.getGolesEquipoB()) {
                	ganador = partidos.getEquipoA();
                    System.out.println ("El ganador es: " + ganador);
                } else if (partidos.getGolesEquipoA() < partidos.getGolesEquipoB()){
                	ganador = partidos.getEquipoB ();
                    System.out.println ("El ganador es: " + ganador);
                } else {
                	ganador = partidos.getEquipoA();
                	ganador1 = partidos.getEquipoB();
                    System.out.println ("Empate entre: " + ganador + " y " + ganador1);
                }


            }
        } catch (IOException e) {
            e.printStackTrace();
	}
    }

}
    