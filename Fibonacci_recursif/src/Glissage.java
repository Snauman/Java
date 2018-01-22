import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputAdapter;

public class Glissage extends MouseInputAdapter {

	int lastX, lastY;
	Affichage affichage;

	public Glissage(Affichage a) {
		affichage = a;
	}

	@Override
	public void mouseDragged(MouseEvent e) {

		if (e.getX() < lastX) {
			this.affichage.origineX -= lastX - e.getX();
		} else {
			this.affichage.origineX += e.getX() - lastX;
		}

		if (e.getY() < lastY) {
			this.affichage.origineY -= lastY - e.getY();
		} else {
			this.affichage.origineY += e.getY() - lastY;
		}
		lastX = e.getX();
		lastY = e.getY();

		this.affichage.repaint();
	}
	
	
	@Override
	public void mousePressed(MouseEvent e) {
		lastX = e.getX();
		lastY = e.getY();

	}

}
