package domain;

public class Nodo {
	public String Id;
	public String habitacion;
	public String tipoPiso;
	public int posX;
	public int posY;
	public boolean hayNinio;
	
	
	public Nodo(){

		this.Id= "";

	}
	
	public Nodo(String id, int posX, int posY){
		this.posX = posX;
		this.posY = posY;
		this.Id = id;
		this.hayNinio = false;
	}
	
	
	@Override
	public String toString(){
		
		return "Nodo: " + Id + " X: " + Integer.toString(posX) + " Y: " + Integer.toString(posY) + "\n";
	}
}
