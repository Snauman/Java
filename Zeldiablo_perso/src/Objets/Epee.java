package Objets;
public class Epee extends Item{
	int dommages;
	public Epee(int x, int y,int indexX,int indexY) {
		super(x, y,indexX,indexY);
		this.dommages=30;
		this.id=Item.ID_EPEE;
		
	}
	
	public String toString(){
		return "Epee";
	}
	
}
