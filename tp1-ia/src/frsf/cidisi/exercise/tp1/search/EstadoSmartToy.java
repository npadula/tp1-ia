package frsf.cidisi.exercise.tp1.search;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import Interfaces.Principal;

import domain.Grafo;
import domain.Nodo;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;

/**
 * Represent the internal state of the Agent.
 */
public class EstadoSmartToy extends SearchBasedAgentState {
	
    public Grafo grafo;
    private Nodo posicionNinio;//aproximado
    public Nodo nodoActual;
    public ArrayList<String> visitados;
    public ArrayList<String> obstaculos;
    public boolean aproxVisitado = false;
    public boolean hayNinio = false;
    public Principal ventanita;
    public double costoTotal = 0;
    private int columnas = 11;
    private int filas = 11;

    
    public EstadoSmartToy() {
    	
	    grafo= new Grafo(columnas,filas);
	    posicionNinio= new Nodo();
	    visitados = new ArrayList<String>();
	    obstaculos = new ArrayList<String>();
	   
        this.initState();
    }
    
    public EstadoSmartToy(boolean ventana){
	    grafo= new Grafo(columnas,filas);
	    posicionNinio= new Nodo();//posicion aproximada
	    visitados = new ArrayList<String>();
	    obstaculos = new ArrayList<String>();
        
        this.initState();
        
        if(ventana){
        	ventanita = new Principal(grafo.colSize, grafo.rowSize ,this.nodoActual,this.grafo.nodos.get(posicionNinio.Id),grafo.nodos.values()); 
            //ventana = new Principal(columna, fila, this.PosicionSmartToy,this.grafo.nodos.get(this.posicionRealNinio) , this.grafo.nodos.get(posNinioAprox)  , grafo.nodos.values(),nodosRapidos,nodosLentos);

    	}
    }
    
    
    public boolean hayObstaculo(String idNodo){
    	return obstaculos.contains(idNodo);
    }
     

    /**
     * This method clones the state of the agent. It's used in the search
     * process, when creating the search tree.
     */
    @Override
    public SearchBasedAgentState clone() {
        
		EstadoSmartToy nuevoEstado = new EstadoSmartToy(); 
		
		nuevoEstado.grafo = grafo.clone();
		nuevoEstado.nodoActual = nuevoEstado.grafo.nodos.get(nodoActual.Id); 
		nuevoEstado.aproxVisitado = aproxVisitado; 
		
		for(String id: visitados){
			nuevoEstado.visitados.add(id);
		}
		

		for(String id: obstaculos){
			nuevoEstado.obstaculos.add(id);
		}
		
		
		
		
		nuevoEstado.posicionNinio = posicionNinio.clone();
		nuevoEstado.hayNinio = this.hayNinio;
		
        return nuevoEstado;
    }

    /**
     * This method is used to update the Agent State when a Perception is
     * received by the Simulator.
     */
    @Override
    public void updateState(Perception perception) {
        SmartToyPerception p = (SmartToyPerception) perception;
        Nodo nodoActualizar;
        
        Nodo nodoActual = this.getNodoActual();
        //ARRIBA
        if(p.hayArriba){
        	nodoActualizar = grafo.getNodo(nodoActual, "arriba");
        	if(p.terrenoArriba.equals("RAPIDO")){
        		nodoActualizar.costo = 5;
        		this.ventanita.graficarRapido(nodoActualizar);
        	}
        	else if(p.terrenoArriba.equals("LENTO")){
        		nodoActualizar.costo = 20000;
        		this.ventanita.graficarLento(nodoActualizar);
        	}
        		
        	if(p.obstaculoArriba){
        		if(!obstaculos.contains(nodoActualizar.Id))
        			obstaculos.add(nodoActualizar.Id);
        		this.ventanita.graficarBloqueado(nodoActualizar);
        	}
        	
        }
        //ABAJO
        if(p.hayAbajo){
        	nodoActualizar = grafo.getNodo(nodoActual, "abajo");
        	if(p.terrenoAbajo.equals("RAPIDO")){
        		nodoActualizar.costo = 5; 
        		this.ventanita.graficarRapido(nodoActualizar);
        	}	
        	else if(p.terrenoAbajo.equals("LENTO")){
        		nodoActualizar.costo = 20000;
        		this.ventanita.graficarLento(nodoActualizar);
        	}
        	
        	
        	if(p.obstaculoAbajo){
        		if(!obstaculos.contains(nodoActualizar.Id))
        			obstaculos.add(nodoActualizar.Id);
        		this.ventanita.graficarBloqueado(nodoActualizar);
        	}
        }
        
        //IZQUIERDA
        if(p.hayIzquierda){
        	nodoActualizar = grafo.getNodo(nodoActual, "izquierda");
        	if(p.terrenoIzq.equals("RAPIDO")){
        		nodoActualizar.costo = 5; 
        		this.ventanita.graficarRapido(nodoActualizar);
        	}
        	else if(p.terrenoIzq.equals("LENTO")){
        		nodoActualizar.costo = 20000;	
        		this.ventanita.graficarLento(nodoActualizar);
        	}
        	
        	

        	if(p.obstaculoIzquierda){
        		if(!obstaculos.contains(nodoActualizar.Id))
        			obstaculos.add(nodoActualizar.Id);
        		this.ventanita.graficarBloqueado(nodoActualizar);
        	}
        }
        
        
        //DERECHA
        if(p.hayDerecha){
        	nodoActualizar = grafo.getNodo(nodoActual, "derecha");
        	if(p.terrenoDer.equals("RAPIDO")){
        		nodoActualizar.costo = 5;
        		this.ventanita.graficarRapido(nodoActualizar);
        	}
        	else if(p.terrenoDer.equals("LENTO")){
        		nodoActualizar.costo = 20000;
        		this.ventanita.graficarLento(nodoActualizar);
        	}
        		
        	
        	if(p.obstaculoDerecha){
        		if(!obstaculos.contains(nodoActualizar.Id))
        			obstaculos.add(nodoActualizar.Id);
        		this.ventanita.graficarBloqueado(nodoActualizar);
        	}
        	
        }
        
        
        hayNinio = p.ninioCerca;

    }

    /**
     * This method is optional, and sets the initial state of the agent.
     */
    @Override
    public void initState() {
    	String posAgente = "K1";
    	String posNinioAprox = "F4";
    	
    	posicionNinio = grafo.nodos.get(posNinioAprox);
    	nodoActual =  grafo.nodos.get(posAgente);
    	visitados.add(nodoActual.Id);
    	
    	
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
    	for(Nodo unNodo: grafo.nodos.values()){
    		if(unNodo.obstaculo){
    			obstaculos.add(unNodo.Id);
    		}
    	}
       	
    }

    /**
     * This method returns the String representation of the agent state.
     */
    @Override
    public String toString() {

        String str = "";
        str += "Pos SmartToy: " + this.nodoActual.toString();
  
      
	       /*
	 String str = "\n";
        
        str += "Pos SmartToy: " + this.nodoActual.toString() + "\n";
        str+= "Visitados: \n";
        for(String s : visitados){
        	str += s + ", ";
        }
        str+= "\n";
        
        str+= "Obstaculos: \n";
        for(String s : obstaculos){
        	str += s + ", ";
        }
        str+= "\n";
        
        str+= "Costo Total: " + Double.toString(costoTotal) + "\n";
        str+= "\n";
        
        
        for(Nodo n : grafo.nodos.values()){
        	if(n.obstaculo)
        		str+= n.Id + ", ";
        }
        str+= "\n";

	       */

       
        
        return str;
        
    }

    /**
     * This method is used in the search process to verify if the node already
     * exists in the actual search.
     */
    @Override
    public boolean equals(Object obj) {
    	
    	 EstadoSmartToy estadoComparado = (EstadoSmartToy) obj; 
    	 boolean mismaPosicion = estadoComparado.nodoActual.Id.equals(nodoActual.Id);
    	 //boolean mismoMundo = estadoComparado.grafo == grafo;
    	 boolean mismoVisitado = estadoComparado.aproxVisitado == this.aproxVisitado; 
    	 boolean mismoMundo = true;
    	 Iterator it = estadoComparado.grafo.nodos.entrySet().iterator();
    	    while (it.hasNext()) {
    	        Map.Entry pair = (Map.Entry)it.next();
    	        if(grafo.nodos.get(pair.getKey()).equals((Nodo)pair.getValue()))
    	        	mismoMundo = false;
    	        
    	        //System.out.println(pair.getKey() + " = " + pair.getValue());
    	        it.remove(); // avoids a ConcurrentModificationException
    	    }
    	  boolean ninio = hayNinio == estadoComparado.hayNinio;
    	  boolean mismosVisitados = true;
    	  
    	  for(String id : visitados){
    		  if(!estadoComparado.visitados.contains(id))
    			  mismosVisitados = false;
    	  }
    	  
    	  boolean mismosObstaculos = true;
    	  for(String id : obstaculos){
    		  if(!estadoComparado.obstaculos.contains(id))
    			  mismosObstaculos = false;
    	  }
    	  
    	 return mismaPosicion && mismoMundo && mismoVisitado && mismosVisitados && ninio && mismosObstaculos;
    }

    //TODO: Complete this section with agent-specific methods
    // The following methods are agent-specific:

     public Nodo getPosicionNinio(){
        return posicionNinio;
     }
     public void setPosicionNinio(Nodo arg){
        posicionNinio = arg;
     }

     public Nodo getNodoActual(){
      return nodoActual;
     }
     public boolean getAproxVisitado(){
    	 return aproxVisitado;
     }
     public void setAproxVisitado(boolean arg){
    	 aproxVisitado = arg;
     }
     
     public void setNodoActual(Nodo arg){
      nodoActual = arg;
    }
     
     
     
    public void graficarEstadoSmartToy(){
		String str="ESTADO SMART TOY: \n";
		int rowSize = this.grafo.rowSize;
    	int colSize = this.grafo.colSize;
		for(int col = 1; col <= colSize; col++){
			String letra = grafo.generarLetra(col);
			
			for(int fila = 1; fila<= rowSize; fila++){
				String idNodo = letra + Integer.toString(fila);
				Nodo aux = this.grafo.nodos.get(idNodo);
				if(idNodo.equals(this.nodoActual.Id))
					str+= idNodo + ":" + 1;
				else if(aux.hayNinio == true)
					str+= idNodo + ":" + 2;
				else if (idNodo.equals(this.posicionNinio.Id))
					str+= idNodo + ": X";
				else
					str+= idNodo + ":" + 0;
				str+= " | ";
			}
			str+= "\n"; 
		}
		System.out.println(str);
    }
    
    public void addVisitado(String id){
    	this.visitados.add(id);
    }
    
    public ArrayList<String> getVisitados(){
    	return visitados;
    }
    
    
    public boolean fueVisitado(String idNodo){
    	
    	
    	return visitados.contains(idNodo);
    	
    }
    
    
    public boolean todosVisitados(){
    	boolean result = true;
    	
    	for(Nodo n : grafo.nodos.values()){
    		if(!visitados.contains(n.Id))
    			result = false;
    	}
    	
    	return result;
    }
    
	public void modificarPosicionSmartToy(Nodo destino) {
		ventanita.actualizarPosicionAuto(destino);
		
	}

}

