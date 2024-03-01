import java.util.Scanner;
import java.io.FileNotFoundException;

public class Prueba{
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scr = new Scanner(System.in);
		System.out.println("Cual es el nombre del archivo?");
		String nombre = scr.nextLine();
		Grafo grafo = new Grafo(nombre);
		System.out.println("Numero de Verices: " + grafo.getNumVertices());
		grafo.verticeMayorGrado();
        System.out.println("Numero de aristas: "+grafo.getNumAristas());
		Coloracion c = new Coloracion(grafo);
		boolean resultado = c.esColoreable();
		System.out.println(resultado);
	}

}
