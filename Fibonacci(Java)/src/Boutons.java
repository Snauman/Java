import javax.swing.*;

public class Boutons extends JPanel {
	JButton precedent;
	JButton suivant;
	JButton zoom;
	JButton dezoom;
	JButton courbe;

	public Boutons() {
		precedent = new JButton("precedent");
		suivant = new JButton("suivant");
		zoom = new JButton("zoom");
		dezoom = new JButton("dezoom");
		courbe = new JButton("afficher la courbe");
		this.add(precedent);
		this.add(suivant);
		this.add(zoom);
		this.add(dezoom);
		this.add(courbe);

	}

}
