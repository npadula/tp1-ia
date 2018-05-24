package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Grafo {
	public HashMap<String,ArrayList<Nodo>> transiciones;
	public HashMap<String,Nodo> nodos;
	public int nodeSize = 25; //Tamaño del nodo en px
	public int colSize;
	public int rowSize;
	public ArrayList<String> escaleras;
	public HashMap<Par,Integer> costoEscaleras;
	
	
	public Grafo(int col, int row){
		colSize = col;
		rowSize = row;
		
		nodos = new HashMap<String,Nodo>();
		transiciones = new HashMap<String,ArrayList<Nodo>>();
		escaleras = new ArrayList<String>();
		costoEscaleras = new HashMap<Par,Integer>();
		
		crearNodos();
		crearTransiciones();
		crearEscaleras();
		
	}
	
	private void crearEscaleras(){
		crearEscalera("C2","D2");
		escaleras.add("C2");
		escaleras.add("D2");
	}
	
	
	private void crearEscalera(String arriba, String abajo) {
		Par arribaAbajo = new Par(arriba,abajo);
		Par abajoArriba = new Par(abajo,arriba);
		
		costoEscaleras.put(arribaAbajo,5);
		costoEscaleras.put(abajoArriba,20);
		
	}
	
	public int getCostoEscalera(String origen, String destino){
		return costoEscaleras.get(new Par(origen,destino));
	}
	
	public boolean escaleraEntre(String origen, String destino){
		return costoEscaleras.containsKey(new Par(origen,destino));
	}

	public Grafo(){
		colSize = 10;
		rowSize = 10;
		nodos = new HashMap<String,Nodo>();
		transiciones = new HashMap<String,ArrayList<Nodo>>();
		

		crearNodos();
		crearTransiciones();
	
	}

	
	
	public void crearTerrenos(){
	
	}
	
	

	public String generarLetra(int num){
		String letra = "";
		int codigoLetra = 64 + num;
		if(num > 26){
			codigoLetra -= 26;
			letra = "A" + Character.toString ((char) codigoLetra);
			
		}
		else
			letra = Character.toString ((char) codigoLetra);
		
		return letra;
	}
	
	
	protected void crearNodos(){
		for(int col = 1; col <= colSize; col++){
			String letra = generarLetra(col);
			
			for(int fila = 1; fila<= rowSize; fila++){
				String idNodo = letra + Integer.toString(fila);
				
				int posX = nodeSize * (col - 1);
				int posY = nodeSize * (fila - 1);
				

				 nodos.put(idNodo,new Nodo(idNodo,posX,posY,10));
				
			}
		}
		
	}
	
	
	private void crearTransicion(Nodo origen, Nodo destino){
		ArrayList<Nodo> salientes;
		if (!transiciones.containsKey(origen.Id)) {
			 salientes = new ArrayList<Nodo>();
			 salientes.add(destino);
			 transiciones.put(origen.Id, salientes);
			 
		 }
		else {
			salientes = transiciones.get(origen.Id);
			salientes.add(destino);
		}
	}
	
	protected void crearTransiciones(){
		
		String letraAnterior ="";
		
		for(int col = 1; col <= colSize; col++){
			String letra = generarLetra(col);
			
			for(int fila = 1; fila<= rowSize; fila++){
				
				String idNodoActual = letra + Integer.toString(fila);
				String idNodoSuperior = letra + Integer.toString(fila-1);
				String idNodoIzq = letraAnterior + Integer.toString(fila);
				
				Nodo nodoActual = nodos.get(idNodoActual);
				
				if ((fila-1) >= 1) {			 
					 Nodo nodoSuperior= nodos.get(idNodoSuperior);
					 crearTransicion(nodoActual,nodoSuperior);
					 crearTransicion(nodoSuperior,nodoActual);
					
				}
				if((col - 1) >= 1 ){
					Nodo nodoIzquierda= nodos.get(idNodoIzq);
					crearTransicion(nodoActual,nodoIzquierda);
					crearTransicion(nodoIzquierda,nodoActual);
				}
				
			}
		
			letraAnterior = letra;
			
		}
		
		
	}
	
	
	public static String getDireccion(Nodo origen, Nodo destino){
		String letrasOrigen = "";
		String numerosOrigen = "";
		
		String letrasDestino = "";
		String numerosDestino = "";
		
		
		
		for(char c: origen.Id.toCharArray()){
			if(!Character.isDigit(c))
				letrasOrigen += Character.toString(c);
			else
				numerosOrigen += Character.toString(c);
		}
		
		for(char c: destino.Id.toCharArray()){
			if(!Character.isDigit(c))
				letrasDestino += Character.toString(c);
			else
				numerosDestino += Character.toString(c);
		}
		
		Integer numOrigen = Integer.parseInt(numerosOrigen);
		Integer numDestino = Integer.parseInt(numerosDestino);
		
		if(numDestino > numOrigen){
			return "abajo";
		}
		else if(numDestino < numOrigen)
			return "arriba";
		
		if(letrasDestino.length() > letrasOrigen.length() || (letrasDestino.compareTo(letrasOrigen) > 0)){
				return "derecha";
		}
			else{
				return "izquierda";
			}
		
		
	}

	//Si hay nodo en la direccion, retorna el nodo, sino, null
	public Nodo getNodo(Nodo origen, String direccion) {
		ArrayList<Nodo> _transiciones = transiciones.get(origen.Id);
			for(Nodo destino : _transiciones){
				if(Grafo.getDireccion(origen, destino).equals(direccion))
					return destino;
			}

		return null;
	}



	public Grafo clone(){
		//logica clonar grafo
		Grafo grafoClonado = new Grafo(colSize, rowSize);
		
		for(Nodo unNodo: nodos.values()){
			Nodo nodoClon = grafoClonado.nodos.get(unNodo.Id);
			nodoClon.hayNinio = unNodo.hayNinio;
			nodoClon.costo = unNodo.costo;
			nodoClon.obstaculo = unNodo.obstaculo;
		}
		
		return grafoClonado; 
	  
		
	}

	//Si si no hay camino retorna null
	public Nodo transicionEntre(String idOrigen, String idDestino) {
		ArrayList<Nodo> transDeOrigen = transiciones.get(idOrigen);
		
		for(Nodo n : transDeOrigen){
			if(n.Id.equals(idDestino))
				return n;
		}
		return null;
	}
	

}
