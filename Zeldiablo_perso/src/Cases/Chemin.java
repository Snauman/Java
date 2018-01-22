package Cases;
import java.awt.Color;

public class Chemin extends Case{

	public Chemin(int x, int y) {
		super(x, y);
		this.setId(Case.CHEMIN);
		this.setCouleur(Color.WHITE);
	}

}
