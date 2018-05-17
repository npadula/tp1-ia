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
	
	
	public Grafo(int col, int row){
		colSize = col;
		rowSize = row;
		
		nodos = new HashMap<String,Nodo>();
		transiciones = new HashMap<String,ArrayList<Nodo>>();
		
		crearNodos();
		crearTransiciones();
		
		if(rowSize >= 33 || colSize >= 27)
		crearParedes();
	}
	
	
	public Grafo(){
		colSize = 10;
		rowSize = 10;
		nodos = new HashMap<String,Nodo>();
		transiciones = new HashMap<String,ArrayList<Nodo>>();
		

		crearNodos();
		crearTransiciones();
		crearParedes();
		
	
	}
	
	//TODO: Ahora modificar un costo implica modificar un unico nodo
	private void modificarCosto(String idOrigen, String idDestino, int nuevoCosto, boolean bidireccional){
	/*	Nodo origen = nodos.get(idOrigen);
		Nodo destino = nodos.get(idDestino);
		ArrayList<Transicion> transOrigen = transiciones.get(origen.Id);
		ArrayList<Transicion> transDestino = transiciones.get(destino.Id);
		
		
		for(Transicion t : transOrigen){
			if(t.destino.equals(destino)){
				t.costo = nuevoCosto;
				break;
			}
		}
		
		if(bidireccional){
			for(Transicion t : transDestino){
				if(t.destino.equals(origen)){
					t.costo = nuevoCosto;
					break;
				}
			}
		}
		*/
		
		
	}
	
	
	public void crearTerrenos(){
	
		
		
		
	}
	
	
	private void paredEntre(String idOrigen, String idDestino){
		//Las paredes impiden el paso entre un nodo y otro, por lo cual se implementa borrando las transiciones entre dichos nodos
		Nodo origen = nodos.get(idOrigen);
		Nodo destino = nodos.get(idDestino);
		
		ArrayList<Nodo> transicionesDeOrigen = transiciones.get(origen.Id);
		
		for(int i = 0; i < transicionesDeOrigen.size(); i++){
			Nodo n = transicionesDeOrigen.get(i);
			
			if(n.equals(destino)){
				transicionesDeOrigen.remove(n);
				break;
			}
		}
		
		ArrayList<Nodo> transicionesDeDestino = transiciones.get(destino.Id);
		
		for(int i = 0; i < transicionesDeDestino.size(); i++){
			Nodo n = transicionesDeDestino.get(i);
			
			if(n.equals(origen)){
				transicionesDeDestino.remove(n);
				break;
			}
		}
		
		
	}
	
	protected void crearParedes(){
	


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
				int posY = nodeSize * fila;
				

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


	//Actualiza la data recibida desde la percepcion
	public void update(Nodo nuevoNodo) {
		
		//nodo_grafo.visitado = nodoDestino.visitado;

		if(nuevoNodo != null){
			
			
			Nodo nodoGrafo = this.nodos.get(nuevoNodo.Id); 
			
			if(nodoGrafo != null){
				nodoGrafo.hayNinio = nuevoNodo.hayNinio;
				nodoGrafo.costo = nuevoNodo.costo;
			
			}
		}
		


	}
	
	public Grafo clone(){
		//logica clonar grafo
		Grafo grafoClonado = new Grafo(colSize, rowSize);
		
		for(Nodo unNodo: this.nodos.values()){
			Nodo nodoClon = grafoClonado.nodos.get(unNodo.Id);
			nodoClon.hayNinio = unNodo.hayNinio;
			nodoClon.visitado = unNodo.visitado;
			nodoClon.costo = unNodo.costo;
			
		
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
