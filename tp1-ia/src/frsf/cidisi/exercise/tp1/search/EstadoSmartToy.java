package frsf.cidisi.exercise.tp1.search;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import domain.Grafo;
import domain.Nodo;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;

/**
 * Represent the internal state of the Agent.
 */
public class EstadoSmartToy extends SearchBasedAgentState {
	
    public Grafo grafo;
    private ArrayList<Nodo> listaObstaculos;
    private Nodo posicionNinio;
    private Nodo posicionAproximadaNinio;
    public Nodo nodoActual;
	//private Other listaSeniales;
	//private Other ListaVisitados;

    public EstadoSmartToy() {
    	System.out.println("Constructor Estado Agente");
    grafo = new Grafo();
    listaObstaculos = new ArrayList<Nodo>();
    posicionAproximadaNinio = new Nodo();
    posicionNinio= new Nodo();
    
    //TODO: Complete Method
    	/*
			// ListaNodos = initData0;
			// ListaArcos = initData1;
			// ListaObstaculos = initData2;
			// ListaVisitados = initData3;
			// PosicionNinio = initData4;
			// ListaSeniales = initData5;
			// NodoActual = initData6;
        */
        this.initState();
    }
    
     

    /**
     * This method clones the state of the agent. It's used in the search
     * process, when creating the search tree.
     */
    @Override
    public SearchBasedAgentState clone() {
        
		EstadoSmartToy nuevoEstado = new EstadoSmartToy(); // 
		nuevoEstado.nodoActual = nodoActual; 
		nuevoEstado.grafo = grafo.clone();
		nuevoEstado.listaObstaculos = listaObstaculos;
		nuevoEstado.posicionAproximadaNinio = posicionAproximadaNinio;
		nuevoEstado.posicionNinio = posicionNinio;
		
        return nuevoEstado;
    }

    /**
     * This method is used to update the Agent State when a Perception is
     * received by the Simulator.
     */
    @Override
    public void updateState(Perception p) {
        SmartToyPerception perception = (SmartToyPerception) p;
        System.out.print(perception.toString());

        //Actualiza la informacion sobre si hay niño o no en los nodos cercanos
        grafo.update(perception.tAbajo);
        grafo.update(perception.tArriba);
        grafo.update(perception.tIzquierda);
        grafo.update(perception.tDerecha);
        if(perception.tAbajo.destino.hayNinio)
        	posicionNinio = perception.tAbajo.destino;
        if(perception.tArriba.destino.hayNinio)
        	posicionNinio = perception.tArriba.destino;
        if(perception.tIzquierda.destino.hayNinio)
        	posicionNinio = perception.tIzquierda.destino;
        if(perception.tDerecha.destino.hayNinio)
        	posicionNinio = perception.tDerecha.destino;
        //if(perception)
    }

    /**
     * This method is optional, and sets the initial state of the agent.
     */
    @Override
    public void initState() {
    	//inicializar lo que conoce el agento al inicio 
    	//listaObstaculos.add(new Nodo("A22")); 
    	posicionNinio = null;
    	nodoActual =  grafo.nodos.get("F7");
    }

    /**
     * This method returns the String representation of the agent state.
     */
    @Override
    public String toString() {
        String str = "Estado AGENTE: \n";
        
        //str += "Posicion Ninio: " + this.getPosicionNinio().toString() + "\n";
        str += "Pos SmartToy: " + this.nodoActual.toString() + "\n";
        
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
    	        if((Nodo)pair.getValue() == grafo.nodos.get(pair.getKey()))
    	        	mismoMundo = false;
    	        //System.out.println(pair.getKey() + " = " + pair.getValue());
    	        it.remove(); // avoids a ConcurrentModificationException
    	    }
    	  
    	 return mismaPosicion && mismoMundo;
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
//     public Other getNodoActual(){
//        return NodoActual;
//     }
//     public void setNodoActual(Other arg){
//        NodoActual = arg;
//     }
	
}

