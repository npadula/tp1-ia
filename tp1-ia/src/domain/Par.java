package domain;

public class Par {

	public String arriba;
	public String abajo;
	
	public Par(String arriba, String abajo){
		this.arriba = arriba;
		this.abajo = abajo;
	}
	
	@Override
	public boolean equals(Object obj){
		Par p = (Par) obj;
		
		return p.arriba.equals(this.arriba) && p.abajo.equals(this.abajo);
	}
	
	
}
