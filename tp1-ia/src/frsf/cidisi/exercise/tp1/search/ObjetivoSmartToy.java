

package frsf.cidisi.exercise.tp1.search;

import frsf.cidisi.faia.agent.search.GoalTest;
import frsf.cidisi.faia.state.AgentState;

public class ObjetivoSmartToy extends GoalTest {

    @Override
    public boolean isGoalState (AgentState agentState) {
    	EstadoSmartToy estadoSmartToy = (EstadoSmartToy) agentState;
    	
    	// TODO: Complete Method
    	Boolean ninioArriba = estadoSmartToy.grafo.getTransicion(estadoSmartToy.nodoActual, "arriba").destino.hayNinio; 	
    	Boolean ninioAbajo = estadoSmartToy.grafo.getTransicion(estadoSmartToy.nodoActual, "abajo").destino.hayNinio;
    	Boolean ninioIzquierda = estadoSmartToy.grafo.getTransicion(estadoSmartToy.nodoActual, "izquierda").destino.hayNinio;
    	Boolean ninioDerecha = estadoSmartToy.grafo.getTransicion(estadoSmartToy.nodoActual, "derecha").destino.hayNinio;
    	if  (ninioArriba || ninioAbajo || ninioIzquierda || ninioDerecha) // si el ninio esta en el campo de vision (adyacentes) 
        	{
            return true;
        	}
        return false;
        //opcion 2 

        /*if(estadoSmartToy.getPosicionNinio() == null){
        	return true;
        }else{
        	return false;
        }*/
	}
}