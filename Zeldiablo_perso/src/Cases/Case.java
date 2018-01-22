package Cases;
import java.awt.Color;

public abstract class Case {
	private int x;
	private int y;
	private Color couleur;
	private int id;
	private boolean decouvert;
	public static final int TAILLE=50;
	public static final int MUR=0;
	public static final int CHEMIN=1;
	public static final int SORTIE=2;
	public static final int PORTE=3;
	
	
	public Case(int x,int y ){
		this.x=x;
		this.y=y;
		this.decouvert=true;
	}
	
	public void decouvrir(){
		if(!this.decouvert){
			this.decouvert=true;
		}
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Color getCouleur() {
		return couleur;
	}

	public void setCouleur(Color couleur) {
		this.couleur = couleur;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isDecouvert() {
		return decouvert;
	}

	
	
	
	
}
