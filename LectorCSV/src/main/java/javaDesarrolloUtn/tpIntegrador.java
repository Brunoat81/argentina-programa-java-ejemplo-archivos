package javaDesarrolloUtn;
		
import java.io.FileReader;		
import java.io.IOException;		
import java.util.List;
import com.opencsv.bean.CsvToBeanBuilder;
		
import modelo.Partidos;		
import modelo.Pronosticos;

		
public class tpIntegrador {
		    
	public static void main(String[] args) {
		       
		        if(args.length == 0){
		            System.out.println("ERROR: No ingresaste ningún archivo como argumento!");
		            System.exit(88);
		        }

		        List <Partidos> listaDePartidos;
		        List <Pronosticos> listaDePronosticos;
		        
		        try {
		          
		           listaDePartidos = new CsvToBeanBuilder(new FileReader(args[0]))		                 
		                    .withType(Partidos.class)
		                    .build()
		                    .parse();
		           
		           int sumatoria = 0;
		           String comparador = "x";
		           
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
		            
			        listaDePronosticos = new CsvToBeanBuilder(new FileReader(args[1]))		        		   
			        		 .withType(Pronosticos.class)
			        		 .build()
			        		 .parse(); 
		            
			        for (Pronosticos pronosticos : listaDePronosticos) { 
	                     int a = 0;
	                     int b = 0;
	                     int c = 0;
	                     int d = 0;
	                     
	                     if (pronosticos.getGanaEquipoB().equals(comparador) && pronosticos.getEquipoA().equals("Argentina") && pronosticos.getEquipoB().equals("Uruguay")) {
	                           	a = a +1;
	                           	sumatoria = sumatoria + a;
	                        } else if (pronosticos.getGanaEquipoB().equals(comparador) && pronosticos.getEquipoA().equals("Brasil") && pronosticos.getEquipoB().equals("Chile")) {
	                            b = b +1;
	                            sumatoria = sumatoria + b;
	                        } else if (pronosticos.getEmpateEquipos().equals(comparador) && pronosticos.getEquipoA().equals("Ecuador") && pronosticos.getEquipoB().equals("Bolivia")) {
	                            c = c + 1;
	                            sumatoria = sumatoria + c;
	                        } else if (pronosticos.getGanaEquipoA().equals(comparador) && pronosticos.getEquipoA().equals("Venezuela") && pronosticos.getEquipoB().equals("Colombia")) {
			                    d = d + 1;
			                    sumatoria = sumatoria + d;
	                        }
			        }
		            
	                System.out.println("El puntaje obtenido por pronósticos correctos es: " + sumatoria);
		            
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
	}
}


