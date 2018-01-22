package Cases;
import java.awt.Color;

public class Mur extends Case{

	public Mur(int x, int y) {
		super(x, y);
		this.setId(Case.MUR);
		this.setCouleur(Color.BLACK);
	}

}
