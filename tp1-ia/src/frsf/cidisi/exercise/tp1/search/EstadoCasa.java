package frsf.cidisi.exercise.tp1.search;

import java.util.ArrayList;

import domain.Grafo;
import domain.Nodo;
import domain.Transicion;
import frsf.cidisi.faia.state.EnvironmentState;

/**
 * This class represents the real world state.
 */
public class EstadoCasa extends EnvironmentState {
	private Grafo grafo;
	private Nodo PosicionNinio;
    private ArrayList<Nodo> ListaObstaculos;
    //private Other ListaSeniales;
    private Nodo PosicionSmartToy;
	
    public EstadoCasa() {
        grafo = new Grafo();
        ListaObstaculos = new ArrayList<Nodo>();//Llenar 
        //ListaSeniales
        
        this.initState();
    }

    /**
     * This method is used to setup the initial real world.
     */
    @Override
    public void initState() {
    	grafo.crearTerrenos();
        this.setPosicionNinio(grafo.nodos.get("A1")); //posicion actual del niño 
        //ListaSeniales = new qseyo
        this.setPosicionSmartToy(grafo.nodos.get("G8"));
    	//Agregar obstaculos.
    	
    	 
    }

    /**
     * String representation of the real world state.
     */
    @Override
    public String toString() {
        String str = "";

        //TODO: Complete Method

        return str;
    }

	//TODO: Complete this section with agent-specific methods
    // The following methods are agent-specific:
	
     public Nodo getPosicionNinio(){
        return PosicionNinio;
     }
     public void setPosicionNinio(Nodo arg){
        PosicionNinio = arg;
     }
     public  ArrayList<Nodo> getListaObstaculos(){
        return ListaObstaculos;
     }
     public void setListaObstaculos(ArrayList <Nodo> arg){
        ListaObstaculos = arg;
     }
     
     
     /*public Other getListaSeniales(){
        return ListaSeniales;
     }
     
     public void setListaSeniales(Other arg){
        ListaSeniales = arg;
     }*/
     public Nodo getPosicionSmartToy(){
        return PosicionSmartToy;
     }
     public void setPosicionSmartToy(Nodo arg){
        PosicionSmartToy = arg;
     }
     
     public void addObstaculo(Nodo n){
    	 this.ListaObstaculos.add(n);
     }
	

}

