package frsf.cidisi.exercise.tp1.search;

import domain.Grafo;
import frsf.cidisi.faia.state.EnvironmentState;

/**
 * This class represents the real world state.
 */
public class EstadoCasa extends EnvironmentState {
	private Grafo grafo;
	//TODO: Setup Variables
    //private Other PosicionNinio;
    //private Other ListaObstaculos;
    //private Other ListaSeniales;
    //private Other PosicionSmartToy;
	
    public EstadoCasa() {
        grafo = new Grafo();
        //TODO: Complete Method
    	/*
			// PosicionNinio = initData0;
			// ListaObstaculos = initData1;
			// ListaSeniales = initData2;
			// PosicionSmartToy = initData3;
        */
        this.initState();
    }

    /**
     * This method is used to setup the initial real world.
     */
    @Override
    public void initState() {

        //TODO: Complete Method
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
	
//     public Other getPosicionNinio(){
//        return PosicionNinio;
//     }
//     public void setPosicionNinio(Other arg){
//        PosicionNinio = arg;
//     }
//     public Other getListaObstaculos(){
//        return ListaObstaculos;
//     }
//     public void setListaObstaculos(Other arg){
//        ListaObstaculos = arg;
//     }
//     public Other getListaSeniales(){
//        return ListaSeniales;
//     }
//     public void setListaSeniales(Other arg){
//        ListaSeniales = arg;
//     }
//     public Other getPosicionSmartToy(){
//        return PosicionSmartToy;
//     }
//     public void setPosicionSmartToy(Other arg){
//        PosicionSmartToy = arg;
//     }
	

}

