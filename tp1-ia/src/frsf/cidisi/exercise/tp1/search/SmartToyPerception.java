package frsf.cidisi.exercise.tp1.search;

import java.util.ArrayList;

import domain.Nodo;
import domain.Transicion;

import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

public class SmartToyPerception extends Perception {

	//TODO: Setup Statics
    //public static int UNKNOWN_PERCEPTION = -1;   
	
	
	//TODO: Setup Sensors
	public Nodo posicionAproximadaNinio;//recibe Habitacion
	
	//Terreno
	public  String terrenoIzq;
	public  String terrenoDer;
	public  String terrenoAbajo;
	public  String terrenoArriba;
	
	//Hay ninio
	public boolean hayArriba;
	public boolean hayAbajo;
	public boolean hayIzquierda;
	public boolean hayDerecha;
	
	
	// Obstaculos
	public boolean obstaculoArriba;
	public boolean obstaculoAbajo;
	public boolean obstaculoIzquierda;
	public boolean obstaculoDerecha;
	
	
	public boolean ninioCerca;
	//private ArrayList<Nodo> seniales;
	//public ArrayList<Transicion> obstaculos;
	
 

    public  SmartToyPerception() {
    	//TODO: Complete Method
    	terrenoIzq = "NORMAL";
    	terrenoDer = "NORMAL";
    	terrenoAbajo = "NORMAL";
    	terrenoArriba = "NORMAL";
    	
    	hayArriba = true;
    	hayAbajo = true;
    	hayIzquierda = true;
    	hayDerecha = true;
    	
    	
    	obstaculoArriba = false;
    	obstaculoAbajo= false;
    	obstaculoIzquierda= false;
    	obstaculoDerecha= false;
    	
    }

    public SmartToyPerception(Agent agent, Environment environment) {
        super(agent, environment);
    }

    /**
     * This method is used to setup the perception.
     */
    //No es primer percepcion, sino cada vez que el agente percibe
    @Override
    public void initPerception(Agent agentIn, Environment environmentIn) {

        Casa environment = (Casa) environmentIn;
        EstadoCasa estadoCasa = environment.getEnvironmentState();
       
    }
    
    @Override
    public String toString() {
        String str = "";
        
        str += "Arriba - CAMINO: " + Boolean.toString(hayArriba) + " TERRENO: " + terrenoArriba + " OBSTACULO: " + Boolean.toString(obstaculoArriba) + "\n"; 
        str += "Abajo - CAMINO: " + Boolean.toString(hayAbajo) + " TERRENO: " + terrenoAbajo +  " OBSTACULO: " + Boolean.toString(obstaculoAbajo) + "\n";
        str += "Izquierda - CAMINO: " + Boolean.toString(hayIzquierda) + " TERRENO: " + terrenoIzq +   " OBSTACULO: " + Boolean.toString(obstaculoIzquierda) + "\n";
        str += "Derecha - CAMINO: " + Boolean.toString(hayDerecha) + " TERRENO: " + terrenoDer +  " OBSTACULO: " + Boolean.toString(obstaculoDerecha) +  "\n";
        
        return str.toString();
    }

    // The following methods are agent-specific:
    //TODO: Complete this section with the agent-specific methods
	
     public Nodo getPosicionAproxNinio(){
        return posicionAproximadaNinio;
     }
     

   
}
