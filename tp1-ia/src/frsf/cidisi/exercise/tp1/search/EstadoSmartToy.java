package frsf.cidisi.exercise.tp1.search;

import java.util.ArrayList;

import domain.Grafo;
import domain.Nodo;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;

/**
 * Represent the internal state of the Agent.
 */
public class EstadoSmartToy extends SearchBasedAgentState {
	
	//TODO: Setup Variables
    public Grafo grafo;
	
    private ArrayList<Nodo> listaObstaculos;
    //private Other ListaVisitados;
    private Nodo posicionNinio;
    private String posicionAproximadaNinio;
    //private Other listaSeniales;
    public Nodo nodoActual;
	

    public EstadoSmartToy() {
    
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
        
		//TODO: Complete Method
		
        return null;
    }

    /**
     * This method is used to update the Agent State when a Perception is
     * received by the Simulator.
     */
    @Override
    public void updateState(Perception p) {
        SmartToyPerception perception = (SmartToyPerception) p;
        
        
        
        if(perception.)
    }

    /**
     * This method is optional, and sets the initial state of the agent.
     */
    @Override
    public void initState() {
        
	//TODO: Complete Method

    }

    /**
     * This method returns the String representation of the agent state.
     */
    @Override
    public String toString() {
        String str = "";

        //TODO: Complete Method

        return str;
    }

    /**
     * This method is used in the search process to verify if the node already
     * exists in the actual search.
     */
    @Override
    public boolean equals(Object obj) {
       
       //TODO: Complete Method
        
        return true;
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
//     public Other getPosicionNinio(){
//        return PosicionNinio;
//     }
//     public void setPosicionNinio(Other arg){
//        PosicionNinio = arg;
//     }
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

