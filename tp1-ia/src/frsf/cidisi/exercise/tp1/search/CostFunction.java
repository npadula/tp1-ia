package frsf.cidisi.exercise.tp1.search;


import domain.Nodo;
import frsf.cidisi.exercise.tp1.search.actions.IrANodo;
import frsf.cidisi.faia.solver.search.IStepCostFunction;
import frsf.cidisi.faia.solver.search.NTree;

/**
 * This class can be used in any search strategy like
 * Uniform Cost.
 */
public class CostFunction implements IStepCostFunction {

    /**
     * This method calculates the cost of the given NTree node.
     */
    @Override
    public double calculateCost(NTree node) {
        
        //TODO: Complete Method
        
    	String dir;
		IrANodo accion = (IrANodo)node.getAction();
    	
		if(accion == null)
			return 0;
		
		
		dir = accion.direccion;
		EstadoSmartToy estado = (EstadoSmartToy) node.getParent().getAgentState();
		Nodo proxNodo = estado.grafo.getNodo(estado.nodoActual, dir);
		
		if(estado.grafo.escaleraEntre(estado.nodoActual.Id, proxNodo.Id))
			return estado.grafo.getCostoEscalera(estado.nodoActual.Id, proxNodo.Id);
		else
			return proxNodo.costo;
    }
}
