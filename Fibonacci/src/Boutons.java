import java.awt.GridLayout;

import javax.swing.*;

public class Boutons extends JPanel {
	JButton precedent;
	JButton suivant;
	JButton zoom;
	JButton dezoom;
	JButton courbe;
	JButton terme;

	public Boutons() {

		precedent = new JButton("←");
		suivant = new JButton("→");
		// zoom = new JButton("+");
		// dezoom = new JButton("-");
		courbe = new JButton("~");
		terme = new JButton("1");
		precedent.setToolTipText("Etape precedente");
		suivant.setToolTipText("Etape suivant");
		// zoom.setToolTipText("zoom");
		// dezoom.setToolTipText("dezoom");
		courbe.setToolTipText("Affiche/cache la courbe");
		terme.setToolTipText("Affiche/cache les termes de la suite");
		precedent.setName("precedent");
		suivant.setName("suivant");
		// zoom.setName("zoom");
		// dezoom.setName("dezoom");
		terme.setName("terme");
		courbe.setName("courbe");
		this.add(precedent, precedent);
		this.add(suivant);
		// this.add(zoom);
		// this.add(dezoom);
		this.add(courbe);
		this.add(terme);

		// zoom.addActionListener(new Fibonacci());
		// dezoom.addActionListener(new Fibonacci());

	}

}
