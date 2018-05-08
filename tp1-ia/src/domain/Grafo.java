package domain;

import java.util.ArrayList;
import java.util.HashMap;

public class Grafo {
	HashMap<Nodo,ArrayList<Transicion>> grafo;
	ArrayList<Nodo> nodos;
	int nodeSize = 25; //Tamaño del nodo en px
	
	
	
	
	public Grafo(){
		nodos = new ArrayList<Nodo>();
		grafo = new HashMap<Nodo,ArrayList<Transicion>>();
		
		crearNodos();
		
		for (Nodo n : nodos) {
		    System.out.println(n);
		}
		
	}
	
	
	private void crearNodos(){
		for(int col = 1; col <= 26; col++){
			int codigoLetra = 64 + col;
			String letra = Character.toString ((char) codigoLetra);
			
			for(int fila = 1; fila<= 33; fila++){
				String idNodo = letra + Integer.toString(fila);
				
				int posX = nodeSize * (col - 1);
				int posY = nodeSize * fila;
				
				nodos.add(new Nodo(idNodo,posX,posY));
				
			}
		}
	}
	
}
