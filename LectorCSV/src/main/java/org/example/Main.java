package org.example;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.opencsv.bean.CsvToBeanBuilder;

import modelo.Partidos;
import modelo.Pronosticos;

public class Main {
    public static void main(String[] args) {
        //En la variable args va a viajar la ruta del archivo que queremos que abra el programa
        if(args.length == 0){
            System.out.println("ERROR: No ingresaste ningún archivo como argumento!");
            System.exit(88);
        }

        List <Partidos> listaDePartidos;
        List <Pronosticos> listaDePronosticos;
        
        try {
            // En esta primera línea definimos el archivos que va a ingresar
           listaDePartidos = new CsvToBeanBuilder(new FileReader(args[0]))
                      // Es necesario definir el tipo de dato que va a generar el objeto que estamos queriendo parsear a partir del CSV
                    .withType(Partidos.class)
                    .build()
                    .parse();

           listaDePronosticos = new CsvToBeanBuilder(new FileReader(args[0]))
        		   
        		   .withType(Pronosticos.class)
        		   .build()
        		   .parse();
           
              //El resultado de este método nos da una lita del objetos
           
            for (Partidos partidos : listaDePartidos) {
                String ganador = null;
                String ganador1 = null;
                int cont = 0;
                String gana = "gana";
                String empata = "empata";
                
                
                if (partidos.getGolesEquipoA() > partidos.getGolesEquipoB()) {
                	ganador = partidos.getEquipoA();
                    System.out.println ("El ganador es: " + ganador);
                    
                    for (Pronosticos pronosticos : listaDePronosticos) {                    
                        if (pronosticos.getPronosticoEquipoA().equals(gana)) {
                           	cont = cont +1;
                        }
                    }
                } else if (partidos.getGolesEquipoA() < partidos.getGolesEquipoB()){
                	ganador = partidos.getEquipoB ();
                    System.out.println ("El ganador es: " + ganador);
                    
                    for (Pronosticos pronosticos : listaDePronosticos) {                    
                        if (pronosticos.getPronosticoEquipoB().equals(gana)) {
                           	cont = cont + 1;
                        }
                    }
                } else {
                	ganador = partidos.getEquipoA();
                	ganador1 = partidos.getEquipoB();
                    System.out.println ("Empate entre: " + ganador + " y " + ganador1);
                    
                    for (Pronosticos pronosticos : listaDePronosticos) {                    
                        if (pronosticos.getPronosticoEquipoA().equals(empata)) {
                           	cont = cont + 1;
                        }
                    }
            }
                System.out.println("El puntaje obtenido por pronósticos correctos es: " + cont);
            }
                   
        } catch (IOException e) {
            e.printStackTrace();
	}
    }
}
    