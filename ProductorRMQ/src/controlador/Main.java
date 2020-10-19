package controlador;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		File directorioActual = new File("");
		String ayudante = directorioActual.getAbsolutePath() + "\\src\\recursos\\Csv_Archivo\\datas.csv";
		try {
			ArrayList<String> lista = (ArrayList<String>) Files.readAllLines(Paths.get(ayudante));
			lista.remove(0);
			String[] miArray = new String[lista.size()];
			miArray = lista.toArray(miArray);


			int tamano_bloque = 10;
			
			System.out.println(miArray.length);
			
			if(miArray.length >= tamano_bloque) {
				Convertidor c = new Convertidor(tamano_bloque, miArray);
				c.dividirRegistro();
			}else {
				System.out.println("El tamaño del bloque debe ser menor que el tamaño de la lista");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}

