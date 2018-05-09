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
	private String posicionAproximadaNinio;//recibe Habitacion 
	private ArrayList<Nodo> seniales;
	private ArrayList<Nodo> obstaculos;
	
 

    public  SmartToyPerception() {
    	//TODO: Complete Method
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
        
        //SmartToy agent = (SmartToy) agentIn;
        //Casa environment = (Casa) environmentIn;
        //EstadoCasa environmentState =
        //        environment.getEnvironmentState();
       
        
    }
    
    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();

        //TODO: Complete Method

        return str.toString();
    }

    // The following methods are agent-specific:
    //TODO: Complete this section with the agent-specific methods
	
     public String getPosicionAproxNinio(){
        return posicionaproxninio;
     }
     public void getPosicionAproxNinio(int arg){
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
     }
	
   
}
