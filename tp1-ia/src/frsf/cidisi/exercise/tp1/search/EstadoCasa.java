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
    //private Other ListaSeniales;
    private Nodo PosicionSmartToy;
    Principal ventana;
	
    public EstadoCasa() {
        grafo= new Grafo(10,10);
        


        //ListaSeniales
        
        this.initState();
    }
    
    
    public void generarObstaculos(){
    	grafo.nodos.get("D6").obstaculo = true;
//    	grafo.nodos.get("C7").obstaculo = true;
    	grafo.nodos.get("D8").obstaculo = true;
    	grafo.nodos.get("E7").costo = 20;
    	grafo.nodos.get("C7").costo = 5;
    }

    /**
     * This method is used to setup the initial real world.
     */
    @Override
    public void initState() {
    	String posAgente = "D7";
    	String posNinioAprox = "A8";
    	String posNinioReal = "C3";
        
    	this.posicionRealNinio = posNinioReal;
        grafo.nodos.get(posNinioReal).hayNinio = true; //posicion REAL del niño 
        this.setPosicionSmartToy(grafo.nodos.get(posAgente));
    	this.setPosicionNinio(grafo.nodos.get(posNinioAprox));
        ventana = new Principal(this.PosicionSmartToy,this.grafo.nodos.get(this.posicionRealNinio));
        
        
        generarObstaculos();
        
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
        posicionNinio = arg;}

     public Nodo getPosicionSmartToy(){
        return PosicionSmartToy;
     }
     public void setPosicionSmartToy(Nodo arg){
        PosicionSmartToy = arg;
     }
     
     public Grafo getGrafo(){
    	 return this.grafo;
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

