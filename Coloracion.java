import java.util.Arrays;

public class Coloracion{
	
	private int[] coloracion;
	private Grafo grafo;

	public Coloracion(Grafo grafo){
		this.grafo = grafo;
		coloracion = new int[grafo.getNumVertices()];
		Arrays.fill(coloracion, -1);
	}

	public boolean esColoreable(){
		int i = 0;
		int longitud = grafo.getNumVertices();
		while (i < longitud){
			//Si no tiene color, le damos color 0
			if(coloracion[i] == -1){
				coloracion[i] = 0;
			}
			int j = 0;
			while(j < longitud){
				//Revisamos la adyacencia
				if(grafo.esAdyacente(i,j)){
					//Si tienen el mismo color, fallamos
					if(coloracion[i] == coloracion[j]){
						return false;
					//Si j no tiene color, lo coloreamos del opuesto
					}else if(coloracion[j] == -1){
						coloracion[j] = opuesto(coloracion[i]);
					}
					//Hay un caso extra en el que ya estan coloreados de
					//opuestos por lo que no es necesario hacer nada
				}
				j++;
			}
			i++;	
		}
		//Si llegamos aqui es que nunca fallamos, por lo que terminamos de colorear exitosamente
		String colores = Arrays.toString(coloracion);
		System.out.println("Coloracion: "+colores);
		return true;
	}

	private int opuesto(int color){
		if(color == 0){
			return 1;
		}else if(color == 1){
			return 0;
		}
		System.out.println("No deberias estar aqui");
		return -1;
	}
		
}
