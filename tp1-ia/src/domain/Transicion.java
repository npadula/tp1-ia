package domain;

public class Transicion {
	public Nodo origen;
	public Nodo destino;
	
	public int costo;
	
	
	public Transicion(Nodo o, Nodo d, int costo){
		origen = o;
		destino = d;
		this.costo = costo;
	}

}
