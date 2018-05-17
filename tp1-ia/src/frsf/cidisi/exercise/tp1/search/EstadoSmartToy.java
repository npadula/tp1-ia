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
	
    public Grafo grafo;
    private Nodo posicionNinio;
    public Nodo nodoActual;
    public ArrayList<String> visitados;
    public boolean aproxVisitado = false;
    public boolean hayNinio = false;
    public Principal ventanita;

    
    public EstadoSmartToy() {
    	
	    grafo= new Grafo(10,10);
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
        
		EstadoSmartToy nuevoEstado = new EstadoSmartToy(); 
		
		nuevoEstado.grafo = grafo.clone();
		nuevoEstado.nodoActual = nuevoEstado.grafo.nodos.get(nodoActual.Id); 
		nuevoEstado.aproxVisitado = aproxVisitado; 
		for(String id: visitados){
			nuevoEstado.visitados.add(id);
		}
		nuevoEstado.posicionNinio = posicionNinio.clone();
		nuevoEstado.hayNinio = this.hayNinio;
		
        return nuevoEstado;
    }

    /**
     * This method is used to update the Agent State when a Perception is
     * received by the Simulator.
     */
    @Override
    public void updateState(Perception perception) {
        SmartToyPerception p = (SmartToyPerception) perception;
        Nodo nodoActualizar;
        
        Nodo nodoActual = this.getNodoActual();
        
        if(p.hayArriba){
        	nodoActualizar = grafo.getNodo(nodoActual, "arriba");
        	if(p.terrenoArriba == "RAPIDO")
        		nodoActualizar.costo = 5; 
        	else if(p.terrenoArriba == "LENTO")
        		nodoActualizar.costo = 20;
        }
        
        if(p.hayAbajo){
        	nodoActualizar = grafo.getNodo(nodoActual, "abajo");
        	if(p.terrenoAbajo == "RAPIDO")
        		nodoActualizar.costo = 5; 
        	else if(p.terrenoAbajo == "LENTO")
        		nodoActualizar.costo = 20;
        }
        
        
        if(p.hayIzquierda){
        	nodoActualizar = grafo.getNodo(nodoActual, "izquierda");
        	if(p.terrenoIzq == "RAPIDO")
        		nodoActualizar.costo = 5; 
        	else if(p.terrenoIzq == "LENTO")
        		nodoActualizar.costo = 20;
        }
        
        
        
        if(p.hayDerecha){
        	nodoActualizar = grafo.getNodo(nodoActual, "derecha");
        	if(p.terrenoDer == "RAPIDO")
        		nodoActualizar.costo = 5; 
        	else if(p.terrenoDer == "LENTO")
        		nodoActualizar.costo = 20;
        }
        
        
        hayNinio = p.ninioCerca;
        
       

    }

    /**
     * This method is optional, and sets the initial state of the agent.
     */
    @Override
    public void initState() {
    	String posAgente = "D7";
    	String posNinioAprox = "A2";
    	
    	posicionNinio = grafo.nodos.get(posNinioAprox);
    	nodoActual =  grafo.nodos.get(posAgente);
    	visitados.add(nodoActual.Id);
    	
    	
    	//ventanita = new Principal(nodoActual,posicionNinio);
        
    	
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
    	 boolean mismoVisitado = estadoComparado.aproxVisitado == this.aproxVisitado; 
    	 boolean mismoMundo = true;
    	 Iterator it = estadoComparado.grafo.nodos.entrySet().iterator();
    	    while (it.hasNext()) {
    	        Map.Entry pair = (Map.Entry)it.next();
    	        if(grafo.nodos.get(pair.getKey()).equals((Nodo)pair.getValue()))
    	        	mismoMundo = false;
    	        
    	        //System.out.println(pair.getKey() + " = " + pair.getValue());
    	        it.remove(); // avoids a ConcurrentModificationException
    	    }
    	  
    	 return mismaPosicion && mismoMundo && mismoVisitado;
    }

    //TODO: Complete this section with agent-specific methods
    // The following methods are agent-specific:

     public Nodo getPosicionNinio(){
        return posicionNinio;
     }
     public void setPosicionNinio(Nodo arg){
        posicionNinio = arg;
     }

     public Nodo getNodoActual(){
      return nodoActual;
     }
     public boolean getAproxVisitado(){
    	 return aproxVisitado;
     }
     public void setAproxVisitado(boolean arg){
    	 aproxVisitado = arg;
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
				else if (idNodo.equals(this.posicionNinio.Id))
					str+= idNodo + ": X";
				else
					str+= idNodo + ":" + 0;
				str+= " | ";
			}
			str+= "\n"; 
		}
		System.out.println(str);
    }
    
    public void addVisitado(String id){
    	this.visitados.add(id);
    }
    
    public ArrayList<String> getVisitados(){
    	return visitados;
    }
    
    
    public boolean fueVisitado(String idNodo){
    	return visitados.contains(idNodo);
    }
    
    
    public boolean todosVisitados(){
    	boolean result = true;
    	
    	for(Nodo n : grafo.nodos.values()){
    		if(!visitados.contains(n.Id))
    			result = false;
    	}
    	
    	return result;
    }
}

