import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;

public class BoutonsFibonacci extends JPanel {
	JButton suivant;
	JButton precedent;
	JButton zoom;
	JButton dezoom;
	JButton courbe;
	JButton terme;
	JPanel curseur;
	JSlider zoomLevel;

	public BoutonsFibonacci() {
		precedent = new JButton("←");
		suivant = new JButton("→");
		courbe = new JButton("~");
		terme = new JButton("1");
		precedent.setToolTipText("Etape precedente");
		suivant.setToolTipText("Etape suivant");
		courbe.setToolTipText("Affiche/cache la courbe");
		terme.setToolTipText("Affiche/cache les termes de la suite");
		precedent.setName("precedent");
		suivant.setName("suivant");
		terme.setName("terme");
		courbe.setName("courbe");
		precedent.setBorderPainted(false);
		precedent.setFocusPainted(false);
		precedent.setContentAreaFilled(false);
		suivant.setBorderPainted(false);
		suivant.setFocusPainted(false);
		suivant.setContentAreaFilled(false);
		courbe.setBorderPainted(false);
		courbe.setFocusPainted(false);
		courbe.setContentAreaFilled(false);
		terme.setBorderPainted(false);
		terme.setFocusPainted(false);
		terme.setContentAreaFilled(false);
		this.add(precedent);
		this.add(suivant);
		this.add(courbe);
		this.add(terme);
		this.curseur=new JPanel();
		this.zoomLevel=new JSlider(SwingConstants.VERTICAL,1,100,1);
		this.curseur.add(this.zoomLevel);
	}
}
