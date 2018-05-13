package frsf.cidisi.exercise.tp1.search;

import java.util.ArrayList;

import Interfaces.Principal;

import domain.Grafo;
import domain.Nodo;
import domain.Transicion;
import frsf.cidisi.faia.state.EnvironmentState;

/**
 * This class represents the real world state.
 */
public class EstadoCasa extends EnvironmentState {
	private Grafo grafo;
	private Nodo posicionNinio;//posicion actual del niño lo va a saber cuando este en un nodo adya
	private Nodo posicionAproximada;//posicion de la puerta 
    private ArrayList<Nodo> ListaObstaculos;
    public Principal ventana;
    //private Other ListaSeniales;
    private Nodo PosicionSmartToy;
	
    public EstadoCasa() {
        grafo= new Grafo(3,3);
    	//grafo = new Grafo3PorTres();
        ListaObstaculos = new ArrayList<Nodo>();//Llenar 
        //ListaSeniales
        
        this.initState();
    }

    /**
     * This method is used to setup the initial real world.
     */
    @Override
    public void initState() {
    	System.out.println("Inicializando estado casa");
    	System.out.println("Creando terrenos");
    	//grafo.crearTerrenos();
        

    	this.setPosicionNinio(grafo.nodos.get("A1")); 
        grafo.nodos.get("A1").hayNinio = true; //posicion actual del niño 
        this.setPosicionSmartToy(grafo.nodos.get("C3"));
    	
        graficarEstadoCasa();
        ventana = new Principal(PosicionSmartToy, posicionNinio );
    }

    /**
     * String representation of the real world state.
     */
    @Override
    public String toString() {
        String str = "Estado CASA: \n";
        
        str += "Posicion Ninio: " + this.getPosicionNinio().toString() + "\n";
        str += "Pos SmartToy: " + this.getPosicionSmartToy().toString() + "\n";
        
        
        

        //TODO: Complete Method

        return str;
    }

	//TODO: Complete this section with agent-specific methods
    // The following methods are agent-specific:
	
     public Nodo getPosicionNinio(){
        return posicionNinio;
     }
     public void setPosicionNinio(Nodo arg){
        posicionNinio = arg;
     }
     public  ArrayList<Nodo> getListaObstaculos(){
        return ListaObstaculos;
     }
     public void setListaObstaculos(ArrayList <Nodo> arg){
        ListaObstaculos = arg;
     }
     
     public Nodo getPosicionAproximada(){
    	 return posicionAproximada;
     }
     public void setPosicionAproximada(Nodo arg){
    	 posicionAproximada = arg;
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

	public Transicion getTransicion(Nodo origen, String direccion) {
		return grafo.getTransicion(origen,direccion);
	}
	
	public void graficarEstadoCasa(){
		String str="ESTADO CASA : \n";
		int colSize = grafo.colSize;
		int rowSize = grafo.rowSize;
		
		for(int col = 1; col <= colSize; col++){
			String letra = grafo.generarLetra(col);
			
			for(int fila = 1; fila<= rowSize; fila++){
				String idNodo = letra + Integer.toString(fila);
				Nodo aux = this.grafo.nodos.get(idNodo);
				if(idNodo.equals(this.PosicionSmartToy.Id))
					str+= idNodo + ":" + 1;
				else if(aux.hayNinio == true)
					str+= idNodo + ":" + 2;
				else
					str+= idNodo + ":" + 0;
				str+= " | ";
			}
			str+= "\n"; 
		}
		System.out.println(str);
	}
	
	public void actualizarPosiSmartToy(Nodo n){
		ventana.actualizarPosicionAuto(n);
	}

}

