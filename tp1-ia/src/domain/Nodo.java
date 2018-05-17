package domain;

public class Nodo {
	public String Id;
	public String habitacion;
	public String tipoPiso;
	public int posX;
	public int posY;
	public boolean hayNinio;
	public int visitado;
	public int costo;
	
	
	public Nodo(){

		this.Id= "";

	}
	
	public Nodo(String id, int posX, int posY, int costo){
		this.posX = posX;
		this.posY = posY;
		this.Id = id;
		this.hayNinio = false;
		this.costo = costo;
		this.visitado = 0;
	}
	
	
	public Nodo clone(){
		Nodo nuevo = new Nodo();
		nuevo.Id = this.Id;
		nuevo.hayNinio = this.hayNinio;
		nuevo.posX = this.posX;
		nuevo.posY = this.posY;
		nuevo.habitacion = this.habitacion;
		nuevo.tipoPiso = this.tipoPiso;
		nuevo.visitado = this.visitado;
		nuevo.costo = this.costo;
		return nuevo;
	}
	
	@Override
	public String toString(){
		return "Nodo: " + Id + "\n";
	}
	
	@Override
	public boolean equals(Object n){
			
		Nodo nodo = (Nodo) n;
		
		return nodo.Id.equals(this.Id) && (nodo.hayNinio == this.hayNinio) && nodo.visitado == this.visitado ;
	}
}
