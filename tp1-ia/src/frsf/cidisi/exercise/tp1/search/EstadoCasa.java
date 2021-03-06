package frsf.cidisi.exercise.tp1.search; 

import java.util.ArrayList;
import java.util.List;

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
    private int columna = 11;
    private int fila = 11;
	
    public EstadoCasa() {
        grafo= new Grafo(columna,fila);
        
        this.initState();
    }
    
    
    public void generarObstaculos(){
    	grafo.nodos.get("A4").obstaculo = true;//paredes
    	grafo.nodos.get("A8").obstaculo = true;
    	grafo.nodos.get("B4").obstaculo = true;
    	grafo.nodos.get("B8").obstaculo = true;
    	grafo.nodos.get("C4").obstaculo = true;
    	grafo.nodos.get("C8").obstaculo = true;
    	grafo.nodos.get("D4").obstaculo = true;
    	grafo.nodos.get("D8").obstaculo = true;//paredes
    	grafo.nodos.get("H1").obstaculo = true;
    	grafo.nodos.get("H2").obstaculo = true;
    	grafo.nodos.get("H3").obstaculo = true;
    	grafo.nodos.get("H4").obstaculo = true;//paredes
    	grafo.nodos.get("G8").obstaculo = true;
    	grafo.nodos.get("G9").obstaculo = true;
    	grafo.nodos.get("G10").obstaculo = true;
    	grafo.nodos.get("G11").obstaculo = true;
    	grafo.nodos.get("I7").obstaculo = true;
    	grafo.nodos.get("J7").obstaculo = true;
    	grafo.nodos.get("K7").obstaculo = true;
    	grafo.nodos.get("D5").obstaculo = true;
    	grafo.nodos.get("D6").obstaculo = true;
    	grafo.nodos.get("E4").obstaculo = true;
    	grafo.nodos.get("G4").obstaculo = true;
    	grafo.nodos.get("H5").obstaculo = true;
    	grafo.nodos.get("K7").obstaculo = true;
    	
    	
    	
    	//paredes
    	
    	grafo.nodos.get("D8").obstaculo = true;
    	grafo.nodos.get("G7").costo = 20;
    	grafo.nodos.get("G3").costo = 20;//lento
    	grafo.nodos.get("H10").costo = 5;//rapido
    }	

    /**
     * This method is used to setup the initial real world.
     */
    @Override
    public void initState() {
		ArrayList<Nodo> nodosObstaculo= new ArrayList<Nodo>();
	    ArrayList<Nodo> nodosLentos= new ArrayList<Nodo>();
	    ArrayList<Nodo> nodosRapidos= new ArrayList<Nodo>();
    	
	    String posAgente = "K1";
    	String posNinioAprox = "F4";
    	String posNinioReal = "A1";
        
    	this.posicionRealNinio = posNinioReal;
        grafo.nodos.get(posNinioReal).hayNinio = true; //posicion REAL del ni�o 
        this.setPosicionSmartToy(grafo.nodos.get(posAgente));
    	this.setPosicionNinio(grafo.nodos.get(posNinioAprox));
    	
    	//obstaculos para graficar
    	//agua para graficar C7
    	//lento en E7
        
    	 generarObstaculos();
    	 
    	 nodosLentos.add(grafo.nodos.get("G7"));
    	 nodosLentos.add(grafo.nodos.get("G3"));
    	 nodosRapidos.add(grafo.nodos.get("H10"));
     
        ventana = new Principal(columna, fila, this.PosicionSmartToy,this.grafo.nodos.get(this.posicionRealNinio) , this.grafo.nodos.get(posNinioAprox)  , grafo.nodos.values(),nodosRapidos,nodosLentos);
        
        ventana.agregarEscaleras(grafo.nodos.values(), grafo.escaleras);
        
    }

    /**
     * String representation of the real world state.
     */
    @Override
    public String toString() {
        /*String str = "Estado CASA: \n";
        
        str += "Posicion REAL Ninio: " + this.posicionRealNinio + "\n";
        str += "Pos SmartToy: " + this.getPosicionSmartToy().toString() + "\n";
        
        //TODO: Complete Method

        return str;*/
    	return "";
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

