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
	public  String terrenoIzq;
	public  String terrenoDer;
	public  String terrenoAbajo;
	public  String terrenoArriba;
	
	public boolean hayArriba;
	public boolean hayAbajo;
	public boolean hayIzquierda;
	public boolean hayDerecha;
	
	
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
        
        str += "Arriba - CAMINO: " + Boolean.toString(hayArriba) + " TERRENO: " + terrenoArriba + "\n"; 
        str += "Abajo - CAMINO: " + Boolean.toString(hayAbajo) + " TERRENO: " + terrenoAbajo + "\n";
        str += "Izquierda - CAMINO: " + Boolean.toString(hayIzquierda) + " TERRENO: " + terrenoIzq + "\n";
        str += "Derecha - CAMINO: " + Boolean.toString(hayDerecha) + " TERRENO: " + terrenoDer + "\n";
        
        return str.toString();
    }

    // The following methods are agent-specific:
    //TODO: Complete this section with the agent-specific methods
	
     public Nodo getPosicionAproxNinio(){
        return posicionAproximadaNinio;
     }
     
/*     public void getPosicionAproxNinio(int arg){
        this.posicionaproxninio = arg;
     }
     public int getsSniales(){
        return seniales;
     }
     public void setsSniales(int arg){
        this.seniales = arg;
     }
     public int getObstaculos(){
        return obstaculos;
     }
     public void setObstaculos(int arg){
        this.obstaculos = arg;
     }*/
	
   
}
