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
	public Transicion tDerecha;
	public Transicion tIzquierda;
	public Transicion tArriba;
	public Transicion tAbajo;
	//private ArrayList<Nodo> seniales;
	//public ArrayList<Transicion> obstaculos;
	
 

    public  SmartToyPerception() {
    	//TODO: Complete Method
    	tDerecha = new Transicion();
    	tIzquierda = new Transicion();
    	tArriba = new Transicion();
    	tAbajo = new Transicion();
    	
    }

    public SmartToyPerception(Agent agent, Environment environment) {
        super(agent, environment);
    }

    /**
     * This method is used to setup the perception.
     */
    @Override
    public void initPerception(Agent agentIn, Environment environmentIn) {
    	
    	//TODO: Complete Method
        //ACA HAY QUE DARLE LA PRIMER PERCEPCION AL AGENTE 
        //SmartToy agent = (SmartToy) agentIn;
        Casa environment = (Casa) environmentIn;
        EstadoCasa estadoCasa = environment.getEnvironmentState();
        estadoCasa.initState();
        
        Nodo nodoAgente = estadoCasa.getPosicionSmartToy();
        posicionAproximadaNinio = estadoCasa.getPosicionAproximada();
        tDerecha = estadoCasa.getTransicion(nodoAgente, "derecha");
        tIzquierda = estadoCasa.getTransicion(nodoAgente,"izquierda");
        tAbajo = estadoCasa.getTransicion(nodoAgente,"abajo");
        tArriba = estadoCasa.getTransicion(nodoAgente,"arriba");
        
    }
    
    @Override
    public String toString() {
        String str = "";
        
        
        str += "Arriba: " + this.tArriba.destino.Id.toString() ;
        str += "Izquierda: " + this.tIzquierda.destino.Id.toString();
        str += "Derecha: " + this.tDerecha.destino.Id.toString();
        str += "Abajo: " + this.tAbajo.destino.Id.toString();
        //TODO: Complete Meth
        
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
