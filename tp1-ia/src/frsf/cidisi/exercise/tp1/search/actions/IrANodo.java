package frsf.cidisi.exercise.tp1.search.actions;

import java.util.ArrayList;

import domain.Nodo;
import domain.Transicion;
import frsf.cidisi.exercise.tp1.search.*;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;

public class IrANodo extends SearchAction {

    /**
     * This method updates a tree node state when the search process is running.
     * It does not updates the real world state.
     */
    private String direccion;

	public IrANodo(String dir){
		direccion = dir;
	}


	@Override
    public SearchBasedAgentState execute(SearchBasedAgentState s) {
        EstadoSmartToy agState = (EstadoSmartToy) s;
        
        // TODO: Use this conditions
        // PreConditions: null
        // PostConditions: null
        
        
       Nodo nodoActual = agState.nodoActual;
       ArrayList<Transicion> caminosPosibles = agState.grafo.transiciones.get(nodoActual);
       
       for(Transicion t : caminosPosibles){
    	   if(getDireccion(nodoActual,t.destino) == direccion){
    		   agState.nodoActual = t.destino;
    		   return agState;
    		   
    		   
    	   }
       }
        
        return null;
    }
	
	private String getDireccion(Nodo origen, Nodo destino){
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
	

    /**
     * This method updates the agent state and the real world state.
     */
    @Override
    public EnvironmentState execute(AgentState ast, EnvironmentState est) {
        EstadoCasa environmentState = (EstadoCasa) est;
        EstadoSmartToy agState = ((EstadoSmartToy) ast);

        // TODO: Use this conditions
        // PreConditions: null
        // PostConditions: null
        
        if (true) {
            // Update the real world
            
            // Update the agent state
            
            return environmentState;
        }

        return null;
    }

    /**
     * This method returns the action cost.
     */
    @Override
    public Double getCost() {
        return new Double(0);
    }

    /**
     * This method is not important for a search based agent, but is essensial
     * when creating a calculus based one.
     */
    @Override
    public String toString() {
        return "IrANodo";
    }
}