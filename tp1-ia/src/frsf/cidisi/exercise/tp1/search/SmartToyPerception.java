package frsf.cidisi.exercise.tp1.search;

import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

public class SmartToyPerception extends Perception {

	//TODO: Setup Statics
    //public static int UNKNOWN_PERCEPTION = -1;   
	
	
	//TODO: Setup Sensors
	private int posicionaproxninio;
	private int seniales;
	private int obstaculos;
	
 

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
	
     public int getposicionaproxninio(){
        return posicionaproxninio;
     }
     public void setposicionaproxninio(int arg){
        this.posicionaproxninio = arg;
     }
     public int getseniales(){
        return seniales;
     }
     public void setseniales(int arg){
        this.seniales = arg;
     }
     public int getobstaculos(){
        return obstaculos;
     }
     public void setobstaculos(int arg){
        this.obstaculos = arg;
     }
	
   
}
