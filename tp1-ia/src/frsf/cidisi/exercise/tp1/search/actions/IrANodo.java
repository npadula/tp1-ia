package frsf.cidisi.exercise.tp1.search.actions;

import java.util.ArrayList;

import domain.Grafo;
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
		System.out.println("Execute pensar");
        EstadoSmartToy agState = (EstadoSmartToy) s;
        // METODO QUE PIENSA 
        // TODO: Use this conditions
        // PreConditions: null
        // PostConditions: null
        
        
       Nodo nodoActual = agState.nodoActual;
       ArrayList<Transicion> caminosPosibles = agState.grafo.transiciones.get(nodoActual.Id);
       
       for(Transicion t : caminosPosibles){
    	   if(Grafo.getDireccion(nodoActual,t.destino).equals(direccion)){
    		   agState.nodoActual = t.destino;
    		   System.out.println("IrAnodo - " + direccion + " - DESDE: " + t.origen + "HACIA: " + t.destino);
    		   //agState.grafo.graficarGrafo(t.destino.Id);
    		   System.out.println(agState.nodoActual.Id.equals(t.destino.Id)); 
    		   //agState.graficarEstadoSmartToy();
    		   return agState;
    	   }
       }
        
        return null;
    }
	
    /**
     * This method updates the agent state and the real world state.
     */
    @Override
    public EnvironmentState execute(AgentState ast, EnvironmentState est) {
    	System.out.println("Execute actuar" + direccion);
        EstadoCasa environmentState = (EstadoCasa) est;
        EstadoSmartToy agState = ((EstadoSmartToy) ast);
        
        
        Nodo nodoActual = agState.nodoActual;
        ArrayList<Transicion> caminosPosibles = agState.grafo.transiciones.get(nodoActual.Id);
        
        for(Transicion t : caminosPosibles){
     	   if(Grafo.getDireccion(nodoActual,t.destino).equals(direccion)){
     		   agState.nodoActual = t.destino;
     		   System.out.println("IrAnodo - " + direccion + " - DESDE: " + t.origen + "HACIA: " + t.destino);
     		  environmentState.setPosicionSmartToy(t.destino);
     		 return environmentState;
     	   }
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
        return "IrANodo" + direccion + "\n";
    }
}