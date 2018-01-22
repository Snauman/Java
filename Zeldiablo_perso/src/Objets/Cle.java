package Objets;
public class Cle extends Item{

	public Cle(int x, int y, int indexX, int indexY) {
		super(x, y, indexX, indexY);
		this.id=Item.ID_CLE;
	}
	
	public String toString(){
		return "Cle";
	}

}
