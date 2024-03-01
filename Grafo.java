import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Grafo {
    private boolean[][] matrizAdyacencia;
    // Constructor que recibe el nombre de un archivo
    public Grafo(String archivo) throws FileNotFoundException {
        try {
            // Lee el contenido del archivo y lo convierte a una cadena de texto
            byte[] contenidoBytes = Files.readAllBytes(Paths.get(archivo));
            String contenidoTexto = new String(contenidoBytes, Charset.defaultCharset());

            // Divide el contenido en partes utilizando el carácter '#'
            String[] partes = contenidoTexto.split("#");

            // Crea una matriz booleana basada en las partes del archivo
            matrizAdyacencia = new boolean[partes.length][partes[0].length()];
            for (int i = 0; i < matrizAdyacencia.length; i++) {
                for (int j = 0; j < matrizAdyacencia[i].length; j++) {
                    matrizAdyacencia[i][j] = partes[i].charAt(j) == '1';
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    // Método para verificar si dos vértices son adyacentes
    public boolean esAdyacente(int vertice1, int vertice2) {
        return this.matrizAdyacencia[vertice1][vertice2];
    }

    // Método para obtener la matriz de adyacencia completa
    public boolean[][] getMatrizAdyacencia() {
        return matrizAdyacencia;
    }


    public void verticeMayorGrado() {
    
        int itemVerticeMayorGrado = 0;
        int maximoGrado = 0; 
        for (int i = 0; i < this.matrizAdyacencia.length; i++) {
            int contador = 0;

            for (int j = 0; j < this.matrizAdyacencia[0].length; j++) {
                contador = this.matrizAdyacencia[i][j] ? contador+=1 : contador;
            }

            int temp = maximoGrado;
            maximoGrado = temp < contador ? contador : temp;
            itemVerticeMayorGrado = temp < contador ? i + 1 : itemVerticeMayorGrado;

        }

        System.out.println("El vertice con mayor grado es el vertice "+itemVerticeMayorGrado+" y tiene grado "+maximoGrado);
    }

    public int getNumAristas(){
        int numAristas = 0;
        for (int i = 0; i < matrizAdyacencia.length; i++) {
            for (int j = 0; j < matrizAdyacencia[0].length; j++) {
                if (matrizAdyacencia[i][j] && i < j) {
                    numAristas+=1;
                }
            }
        }

        return numAristas;
    }


    public int getNumVertices(){
	    return matrizAdyacencia.length;
    } 
    
    
    // public static void main(String[] args) throws FileNotFoundException {
    //     Grafo g = new Grafo("Ejemplar1.txt");
    //     g.verticeMayorGrado();
    //     System.out.println("Numero de aristas: "+g.getNumAristas());
    //     System.out.println(g.esAdyacente(0, 1));
    //     boolean[][] matrizAdyacencia = g.getMatrizAdyacencia();
    //     System.out.println("Matriz de adyacencia:");
    //         for (int i = 0; i < matrizAdyacencia.length; i++) {
    //           for (int j = 0; j < matrizAdyacencia[i].length; j++) {
    //               System.out.print(matrizAdyacencia[i][j] ? "1 " : "0 ");
    //            }
    //            System.out.println();
    //        }
    // }
    
}
