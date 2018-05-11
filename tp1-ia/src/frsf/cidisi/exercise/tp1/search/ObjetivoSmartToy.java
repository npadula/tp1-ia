

package frsf.cidisi.exercise.tp1.search;

import frsf.cidisi.faia.agent.search.GoalTest;
import frsf.cidisi.faia.state.AgentState;

public class ObjetivoSmartToy extends GoalTest {

    @Override
    public boolean isGoalState (AgentState agentState) {
    	EstadoSmartToy estadoSmartToy = (EstadoSmartToy) agentState;
    	boolean ninioArriba = false;
    	boolean ninioAbajo = false;
    	boolean ninioIzquierda = false;
    	boolean ninioDerecha  = false;
    	
    	
    	
    	
    	// TODO: Complete Method
    	if(estadoSmartToy.grafo.getTransicion(estadoSmartToy.nodoActual, "arriba") != null)
    		ninioArriba = estadoSmartToy.grafo.getTransicion(estadoSmartToy.nodoActual, "arriba").destino.hayNinio;
    	
    	if(estadoSmartToy.grafo.getTransicion(estadoSmartToy.nodoActual, "abajo") != null)
    		ninioAbajo = estadoSmartToy.grafo.getTransicion(estadoSmartToy.nodoActual, "abajo").destino.hayNinio;
    	if(estadoSmartToy.grafo.getTransicion(estadoSmartToy.nodoActual, "izquierda") != null)
    		ninioIzquierda = estadoSmartToy.grafo.getTransicion(estadoSmartToy.nodoActual, "izquierda").destino.hayNinio;
    	if(estadoSmartToy.grafo.getTransicion(estadoSmartToy.nodoActual, "derecha") != null)
    		ninioDerecha = estadoSmartToy.grafo.getTransicion(estadoSmartToy.nodoActual, "derecha").destino.hayNinio;
    	
    	boolean hayNinioCerca = (ninioArriba || ninioAbajo || ninioIzquierda || ninioDerecha); // si el ninio esta en el campo de vision (adyacentes) 
        //opcion 2 

        /*if(estadoSmartToy.getPosicionNinio() != null){
        	return true;
        }else{
        	return false;
        }*/
    	
    	
    	
    	String idActual = estadoSmartToy.nodoActual.Id;
    	String idAproxNinio = estadoSmartToy.getPosicionNinio().Id;
    	
    	
    	
    	//Si no visito el nodo aprox, y esta en el nodo aprox
    	if(!estadoSmartToy.aproxVisitado && idActual.equals(idAproxNinio) )
    		return true;
    	//Si ya visito el nodo aprox y el niño esta cerca 
    	else if(estadoSmartToy.aproxVisitado && hayNinioCerca)
    		return true;
    	else //Caso contrario, falla
    		return false;
    	
    	
    	
	}
}