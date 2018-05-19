package frsf.cidisi.exercise.tp1.search;

import frsf.cidisi.faia.solver.search.IEstimatedCostFunction;
import frsf.cidisi.faia.solver.search.NTree;

/**
 * This class allows to define a function to be used by any
 * informed search strategy, like A Star or Greedy.
 */
public class Heuristic implements IEstimatedCostFunction {

    /**
     * It returns the estimated cost to reach the goal from a NTree node.
     */
    @Override
    public double getEstimatedCost(NTree node) {
        EstadoSmartToy agState = (EstadoSmartToy) node.getAgentState();
		
      //Si se visito el aprox. entonces el costo es cero porque ya no se conoce el objetivo
        if(agState.aproxVisitado)
        	return 0; //si h=0 entonces un A* pasa a ser un Dijkstra, y encontraria el optimo igual
        else{
        	String actual = agState.nodoActual.Id;
        	String objetivo = agState.getPosicionNinio().Id;
        	
        	//Caso contrario devuelve la distancia entre el actual y el aproximado
        	return manhattan(actual,objetivo);
        }
        
    }
    
    //Calcula norma L1 (Distancia Manhattan)
    private double manhattan(String desde, String hasta){
    	int letraDesde = (int) desde.charAt(0);
    	int letraHasta = (int) hasta.charAt(0);
    	int numDesde = (int) (desde.charAt(1) - '0');
    	int numHasta = (int) (desde.charAt(1) - '0');
    	
    	double distancia = Math.abs(letraDesde - letraHasta) + Math.abs(numDesde - numHasta);
    	
    	return 10*distancia; //10 es el costo "normal" de un nodo, se podria tambien tomar 5 o 1?
    	
    	
    	
    }
}
