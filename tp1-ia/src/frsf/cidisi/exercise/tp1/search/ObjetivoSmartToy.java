

package frsf.cidisi.exercise.tp1.search;

import domain.Nodo;
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
    	boolean visitadoIzq = true;
    	boolean visitadoDer = true;
    	boolean visitadoAbajo = true;
    	boolean visitadoArriba = true;
    	
    	
    	
    	
    	if(estadoSmartToy.grafo.getTransicion(estadoSmartToy.nodoActual, "arriba") != null){
    		Nodo arriba = estadoSmartToy.grafo.getTransicion(estadoSmartToy.nodoActual, "arriba").destino;
    		ninioArriba = arriba.hayNinio;
    		visitadoArriba = estadoSmartToy.fueVisitado(arriba.Id);
    	}
    	
    	if(estadoSmartToy.grafo.getTransicion(estadoSmartToy.nodoActual, "abajo") != null){
    		Nodo abajo = estadoSmartToy.grafo.getTransicion(estadoSmartToy.nodoActual, "abajo").destino;
    		ninioAbajo = abajo.hayNinio;
    		visitadoArriba = estadoSmartToy.fueVisitado(abajo.Id);
    		}
    	if(estadoSmartToy.grafo.getTransicion(estadoSmartToy.nodoActual, "izquierda") != null){
    		Nodo izquierda = estadoSmartToy.grafo.getTransicion(estadoSmartToy.nodoActual, "izquierda").destino;
    		ninioIzquierda = izquierda.hayNinio;
    		visitadoArriba = estadoSmartToy.fueVisitado(izquierda.Id);
    		}
    	if(estadoSmartToy.grafo.getTransicion(estadoSmartToy.nodoActual, "derecha") != null){
    		Nodo derecha = estadoSmartToy.grafo.getTransicion(estadoSmartToy.nodoActual, "derecha").destino;
    		ninioDerecha = derecha.hayNinio;
    		visitadoArriba = estadoSmartToy.fueVisitado(derecha.Id);
    		}
    	
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
    	else if(estadoSmartToy.todosVisitados())
    		return true;
    	else //Caso contrario, falla
    		return false;
    	
    	
    	
	}
}