package frsf.cidisi.exercise.tp1.search; 

import java.util.ArrayList;

import javax.swing.JFrame;

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
	private Nodo posicionNinio;//posicion aproximada del ninio 
	public String posicionRealNinio;
    private ArrayList<Nodo> ListaObstaculos;
    //private Other ListaSeniales;
    private Nodo PosicionSmartToy;
    Principal ventana;
	
    public EstadoCasa() {
        grafo= new Grafo(10,10);
        ListaObstaculos = new ArrayList<Nodo>();//Llenar 

        //ListaSeniales
        
        this.initState();
    }

    /**
     * This method is used to setup the initial real world.
     */
    @Override
    public void initState() {
    	String posAgente = "D7";
    	String posNinioAprox = "A2";
    	String posNinioReal = "F7";
        
    	this.posicionRealNinio = posNinioReal;
        grafo.nodos.get(posNinioReal).hayNinio = true; //posicion REAL del niño 
        this.setPosicionSmartToy(grafo.nodos.get(posAgente));
    	this.setPosicionNinio(grafo.nodos.get(posNinioAprox));
        ventana = new Principal(PosicionSmartToy,grafo.nodos.get(posAgente));
        
    }

    /**
     * String representation of the real world state.
     */
    @Override
    public String toString() {
        String str = "Estado CASA: \n";
        
        str += "Posicion REAL Ninio: " + this.posicionRealNinio + "\n";
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
     
     public Grafo getGrafo(){
    	 return this.grafo;
     }
     
     public void addObstaculo(Nodo n){
    	 this.ListaObstaculos.add(n);
     }

	public Nodo getNodo(Nodo origen, String direccion) {
		return grafo.getNodo(origen,direccion);
	}
	
	public void graficarEstadoCasa(){
		String str="";
		int colSize = grafo.colSize;
		int rowSize = grafo.rowSize;
		
		for(int col = 1; col <= colSize; col++){
			String letra = grafo.generarLetra(col);
			
			for(int fila = 1; fila<= rowSize; fila++){
				String idNodo = letra + Integer.toString(fila);
				Nodo aux = this.grafo.nodos.get(idNodo);
				if(idNodo.equals(this.PosicionSmartToy.Id)){
					str+= idNodo + ":" + 1;
				}	
				else if(aux.hayNinio == true){
					str+= idNodo + ":" + 2;
				}
				else {
					str+= idNodo + ":" + 0;
				}
					
				str+= " | ";
			}
			str+= "\n"; 
		}
		System.out.println(str);
	}

	public void modificarPosicionSmartToy(Nodo destino) {
		ventana.actualizarPosicionAuto(destino);
		
	}

	
}

