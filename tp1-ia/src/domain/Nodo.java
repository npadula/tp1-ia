package domain;

public class Nodo {
	String Id;
	String sector;
	String tipoPiso;
	int posX;
	int posY;
	
	
	public Nodo(String id, int posX, int posY){
		this.posX = posX;
		this.posY = posY;
		this.Id = id;
	}
	
	
	@Override
	public String toString(){
		
		return "Nodo: " + Id + " X: " + Integer.toString(posX) + " Y: " + Integer.toString(posY) + "\n";
	}
}
