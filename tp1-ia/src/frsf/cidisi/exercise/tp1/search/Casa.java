package frsf.cidisi.exercise.tp1.search;

import domain.Nodo;
import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

public class Casa extends Environment {

    public Casa() {
        // Create the environment state
        this.environmentState = new EstadoCasa();
    }

    public EstadoCasa getEnvironmentState() {
        return (EstadoCasa) super.getEnvironmentState();
    }

    /**
     * This method is called by the simulator. Given the Agent, it creates
     * a new perception reading, for example, the agent position.
     * @param agent
     * @return A perception that will be given to the agent by the simulator.
     */
    @Override
    public  SmartToyPerception getPercept() {
        // Create a new perception to return
         SmartToyPerception p = new SmartToyPerception();
		
         EstadoCasa estadoCasa = getEnvironmentState();
         
         Nodo nodoActual = estadoCasa.getPosicionSmartToy();
         p.posicionAproximadaNinio = estadoCasa.getPosicionNinio();
         
         Nodo arriba = estadoCasa.getNodo(nodoActual, "arriba");
         if(arriba != null){
        	 p.obstaculoArriba = arriba.obstaculo;
         	 if(arriba.costo > 10)
         		 p.terrenoArriba = "LENTO";
         	if(arriba.costo < 10)
         		p.terrenoArriba = "RAPIDO";
         	}
         else{
        	p.obstaculoArriba = false;
         	p.hayArriba = false;
         	}
         	
         
         Nodo abajo = estadoCasa.getNodo(nodoActual, "abajo");
         if(abajo != null){
        	p.obstaculoAbajo = abajo.obstaculo;
        	 if(abajo.costo > 10)
         		 p.terrenoAbajo = "LENTO";
         	if(abajo.costo < 10)
         		p.terrenoAbajo = "RAPIDO";
         	}
         else{
        	 	p.obstaculoAbajo = false;
            	p.hayAbajo = false;
            	}

         Nodo derecha = estadoCasa.getNodo(nodoActual, "derecha");
         if(derecha != null){
        	p.obstaculoDerecha = derecha.obstaculo;
		       	 if(derecha.costo > 10)
		     		 p.terrenoDer = "LENTO";
		     	if(derecha.costo < 10)
		     		p.terrenoDer = "RAPIDO";
         	}
     	else{
     		p.obstaculoDerecha = false;
     		p.hayDerecha = false;
     		}
         
         Nodo izq = estadoCasa.getNodo(nodoActual, "izquierda");
         if(izq != null){
        	 p.obstaculoIzquierda = izq.obstaculo;
	       	 if(izq.costo > 10)
	     		 p.terrenoIzq = "LENTO";
	     	if(izq.costo < 10)
	     		p.terrenoIzq = "RAPIDO";
         	}
     	else{
     		p.obstaculoIzquierda = false;
     		p.hayIzquierda = false;
     	}
         
         p.ninioCerca = (
        		 (izq != null && izq.hayNinio)
        		 || (derecha != null && derecha.hayNinio) 
        		 || (arriba != null && arriba.hayNinio)
        		 || (abajo != null && abajo.hayNinio) 
        		 || nodoActual.hayNinio
        		 );
      
         
		return p;
    }

    
    public String toString() {
        return environmentState.toString();
    }

    
    public boolean agentFailed(Action actionReturned) {

       
        
        // TODO: Complete Method        

        return false;
    }

	//TODO: Complete this section with agent-specific methods
    // The following methods are agent-specific:
    
    
}
