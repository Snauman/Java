package Objets;
import Cases.Case;

public abstract class Item {
	public int x;
	public int y;
	public int indexX;
	public int indexY;
	public int id;
	public static final int ID_EPEE=0;
	public static final int ID_CLE=1;
	
	public Item(int x,int y,int indexX,int indexY){
		this.indexX=indexX;
		this.indexY=indexY;
		this.x=x*Case.TAILLE+Case.TAILLE/2-5;
		this.y=y*Case.TAILLE+Case.TAILLE/2-5;
	}
}
