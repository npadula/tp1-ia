package frsf.cidisi.exercise.tp1.search;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import Interfaces.Principal;

import domain.Grafo;
import domain.Nodo;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;

/**
 * Represent the internal state of the Agent.
 */
public class EstadoSmartToy extends SearchBasedAgentState {
	public ArrayList<String> visitados;
    public Grafo grafo;
    private ArrayList<Nodo> listaObstaculos;
    private Nodo posicionNinio;
    private Nodo posicionAproximadaNinio;
    public Nodo nodoActual;

    public boolean aproxVisitado = false;
	//private Other listaSeniales;
	//private Other ListaVisitados;

    public EstadoSmartToy() {
    	//System.out.println("Constructor Estado Agente");
    grafo= new Grafo(3,3);
    visitados = new ArrayList<String>();
    listaObstaculos = new ArrayList<Nodo>();
    posicionAproximadaNinio = new Nodo();
    posicionNinio= new Nodo();
    visitados = new ArrayList<String>();
    
    
    this.initState();
    }
    
     

    /**
     * This method clones the state of the agent. It's used in the search
     * process, when creating the search tree.
     */
    @Override
    public SearchBasedAgentState clone() {
        
		EstadoSmartToy nuevoEstado = new EstadoSmartToy(); // 
		nuevoEstado.grafo = grafo.clone();
		nuevoEstado.nodoActual = nuevoEstado.grafo.nodos.get(nodoActual.Id); 
		//nuevoEstado.posicionAproximadaNinio = posicionAproximadaNinio;
		nuevoEstado.posicionNinio = nuevoEstado.grafo.nodos.get(posicionNinio.Id);
		nuevoEstado.aproxVisitado = aproxVisitado;
		nuevoEstado.listaObstaculos = listaObstaculos;
		for(String idNodo : visitados){
			nuevoEstado.visitados.add(idNodo);
		}
		
		
		
        return nuevoEstado;
    }

    /**
     * This method is used to update the Agent State when a Perception is
     * received by the Simulator.
     */
    @Override
    public void updateState(Perception p) {
        SmartToyPerception perception = (SmartToyPerception) p;
        

        
        //Actualiza la informacion sobre si hay niño o no en los nodos cercanos
        grafo.update(perception.tAbajo);
        grafo.update(perception.tArriba);
        grafo.update(perception.tIzquierda);
        grafo.update(perception.tDerecha);
        
        if(perception.tAbajo != null){
        	//if(perception.tAbajo.destino.Id.equals(posicionNinio))
        		//aproxVisitado = true;
        	if(perception.tAbajo.destino.hayNinio)
        		posicionNinio = perception.tAbajo.destino;
        }
        if(perception.tArriba != null ){
        //	if(perception.tArriba.destino.equals(posicionNinio))
        	//	aproxVisitado = true;
        	if(perception.tArriba.destino.hayNinio)
        		posicionNinio = perception.tArriba.destino;
        	}
        if(perception.tIzquierda != null){
        	//if(perception.tIzquierda.destino.equals(posicionNinio))
        		//aproxVisitado = true;
        	if(perception.tIzquierda.destino.hayNinio)
        		posicionNinio = perception.tIzquierda.destino;
        	}
        if(perception.tDerecha != null){
        	//if(perception.tDerecha.destino.equals(posicionNinio))
        		//aproxVisitado = true;
        	
        	if(perception.tDerecha.destino.hayNinio)
        		posicionNinio = perception.tDerecha.destino;
        	}
        System.out.print(perception.toString());
        //graficarEstadoSmartToy();
    }

    /**
     * This method is optional, and sets the initial state of the agent.
     */
    @Override
    public void initState() {
    	//inicializar lo que conoce el agento al inicio 
    	//listaObstaculos.add(new Nodo("A22")); 
    	posicionNinio = new Nodo("C1",0,0);
    	nodoActual =  grafo.nodos.get("C3");
    	visitados.add(nodoActual.Id);
    }

    /**
     * This method returns the String representation of the agent state.
     */
    @Override
    public String toString() {
        
        String str = "";
        //str += "Posicion Ninio: " + this.getPosicionNinio().toString() + "\n";
        str += "Pos SmartToy: " + this.nodoActual.toString() + "\n";
        str += "Visitados: ";
        
        for(String v : visitados){
        	str+= v + ", ";
        }
        str += "\n";
        
        return str;
        
    }

    /**
     * This method is used in the search process to verify if the node already
     * exists in the actual search.
     */
    @Override
    public boolean equals(Object obj) {
    	
    	 EstadoSmartToy estadoComparado = (EstadoSmartToy) obj; 
    	 boolean mismaPosicion = estadoComparado.nodoActual.Id.equals(nodoActual.Id);
    	 //boolean mismoMundo = estadoComparado.grafo == grafo;
    	 boolean mismoMundo = true;
    	 Iterator it = estadoComparado.grafo.nodos.entrySet().iterator();
    	    while (it.hasNext()) {
    	        Map.Entry pair = (Map.Entry)it.next();
    	        if(grafo.nodos.get(pair.getKey()).equals((Nodo)pair.getValue()))
    	        	mismoMundo = false;
    	        //System.out.println(pair.getKey() + " = " + pair.getValue());
    	        it.remove(); // avoids a ConcurrentModificationException
    	    }
    	    
    	    boolean mismosVisitados = this.visitadosIguales(estadoComparado.visitados);
    	  
    	 return mismaPosicion && mismoMundo && mismosVisitados && (aproxVisitado == estadoComparado.aproxVisitado);
    }

    public boolean fueVisitado(String idNodo){
    	return visitados.contains(idNodo);
    }
    
    public boolean todosVisitados(){
    	boolean result = true;
    	for(String idNodo : grafo.nodos.keySet()){
    		if(!visitados.contains(idNodo))
    			result = false;
    	}
    	
    	return result;
    }
    
    private boolean visitadosIguales(ArrayList<String> visitados2){
    	boolean result = true;

    	for(String v : visitados){
    		if(!visitados2.contains(v))
    			result = false;
    	}
    	
    	return result;
    }
    //TODO: Complete this section with agent-specific methods
    // The following methods are agent-specific:
   	
//     public Other getListaNodos(){
//        return ListaNodos;
//     }
//     public void setListaNodos(Other arg){
//        ListaNodos = arg;
//     }
//     public Other getListaArcos(){
//        return ListaArcos;
//     }
//     public void setListaArcos(Other arg){
//        ListaArcos = arg;
//     }
//     public Other getListaObstaculos(){
//        return ListaObstaculos;
//     }
//     public void setListaObstaculos(Other arg){
//        ListaObstaculos = arg;
//     }
//     public Other getListaVisitados(){
//        return ListaVisitados;
//     }
//     public void setListaVisitados(Other arg){
//        ListaVisitados = arg;
//     }
     public Nodo getPosicionNinio(){
        return posicionNinio;
     }
     public void setPosicionNinio(Nodo arg){
        posicionNinio = arg;
     }
//     public Other getListaSeniales(){
//        return ListaSeniales;
//     }
//     public void setListaSeniales(Other arg){
//        ListaSeniales = arg;
//     }
     public Nodo getNodoActual(){
      return nodoActual;
     }
     public void setNodoActual(Nodo arg){
      nodoActual = arg;
    }
	
     
    public void graficarEstadoSmartToy(){
		String str="ESTADO SMART TOY: \n";
		int rowSize = this.grafo.rowSize;
    	int colSize = this.grafo.colSize;
		for(int col = 1; col <= colSize; col++){
			String letra = grafo.generarLetra(col);
			
			for(int fila = 1; fila<= rowSize; fila++){
				String idNodo = letra + Integer.toString(fila);
				Nodo aux = this.grafo.nodos.get(idNodo);
				if(idNodo.equals(this.nodoActual.Id))
					str+= idNodo + ":" + 1;
				else if(aux.hayNinio == true)
					str+= idNodo + ":" + 2;
				else
					str+= idNodo + ":" + 0;
				str+= " | ";
			}
			str+= "\n"; 
		}
		System.out.println(str);
    }



	public void actualizarPosiSmartToy(Nodo destino) {
		{
			
			//ventana.actualizarPosicionAuto(destino);
		}
		
		// TODO Auto-generated method stub
		
	}
}

