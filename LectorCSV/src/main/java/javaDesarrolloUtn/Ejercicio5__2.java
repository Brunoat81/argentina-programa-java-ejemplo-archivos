package javaDesarrolloUtn;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.opencsv.bean.CsvToBeanBuilder;
import modelo.productosEjercicio;


public class Ejercicio5__2 {

	public static void main(String[] args) {
		 if(args.length == 0){
	            System.out.println("ERROR: No ingresaste ningún archivo como argumento!");
	            System.exit(88);
	        }

	        List <productosEjercicio> listaDeProductos;
	 	        
	        try {
	          
	           listaDeProductos = new CsvToBeanBuilder<productosEjercicio>(new FileReader(args[0]))
	                      
	                    .withType(productosEjercicio.class)
	                    .build()
	                    .parse();           
	           
	            for (productosEjercicio productos : listaDeProductos) {
	            	double multi = 0;
	            	double suma = 0;
	             multi  = productos.getCantidad()*productos.getPrecioUnitario();
	             suma = suma + multi;
	             System.out.println("El total del monto a comprar en el carrito es de: " + suma);
	            }
	                   
	        } catch (IOException e) {
	            e.printStackTrace();
		}

	}

}
