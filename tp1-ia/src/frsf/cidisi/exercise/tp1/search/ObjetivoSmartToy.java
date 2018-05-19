

package frsf.cidisi.exercise.tp1.search;

import frsf.cidisi.faia.agent.search.GoalTest;
import frsf.cidisi.faia.state.AgentState;

public class ObjetivoSmartToy extends GoalTest {

    @Override
    public boolean isGoalState (AgentState agentState) {
    	EstadoSmartToy estadoSmartToy = (EstadoSmartToy) agentState;
       	
    	
    	String idActual = estadoSmartToy.nodoActual.Id;
    	String idAproxNinio = estadoSmartToy.getPosicionNinio().Id;
    	
    	if(estadoSmartToy.hayNinio)
    		return true;
    	//Si no visito el nodo aprox, y esta en el nodo aprox
    	if(!estadoSmartToy.getAproxVisitado() && idActual.equals(idAproxNinio) ){
    		return true;
    	}
    	if(estadoSmartToy.aproxVisitado && !estadoSmartToy.fueVisitado(idActual)){ //Reflexionar: esta condicion deberia ser solo la segunda parte del && ?
    		return true;
    	}
    	else //Caso contrario, falla
    		return false;
    	
    	
    	
	}
}