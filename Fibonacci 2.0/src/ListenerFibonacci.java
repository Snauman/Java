import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.MouseInputAdapter;

public class ListenerFibonacci extends MouseInputAdapter implements ActionListener, ChangeListener {
	Fibonacci2 fibonacci;
	BoutonsFibonacci boutons;
	int lastX, lastY;

	public ListenerFibonacci(Fibonacci2 fibonacci, BoutonsFibonacci boutons) {
		this.fibonacci = fibonacci;
		this.boutons = boutons;
		this.fibonacci.addMouseMotionListener(this);
		this.fibonacci.addMouseListener(this);
		this.fibonacci.addMouseWheelListener(this);
		this.boutons.suivant.addActionListener(this);
		this.boutons.precedent.addActionListener(this);
		this.boutons.courbe.addActionListener(this);
		this.boutons.terme.addActionListener(this);
		this.boutons.zoomLevel.addChangeListener(this);
	}

	public void generationSuivante() {
		this.fibonacci.nbTerme++;
	}

	public void generationPrecedente() {
		this.fibonacci.nbTerme--;
	}

	public void zoomer() {
		this.fibonacci.zoom = this.fibonacci.zoom * 2;

	}

	public void dezoomer() {
		this.fibonacci.zoom = this.fibonacci.zoom / 2;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();
		switch (b.getName()) {
		case "suivant":
			this.generationSuivante();
			break;
		case "precedent":
			this.generationPrecedente();
			break;
		case "zoom":
			this.zoomer();
			break;
		case "dezoom":

			this.dezoomer();
			break;
		case "courbe":
			this.fibonacci.afficherCourbe = !this.fibonacci.afficherCourbe;
			break;
		case "terme":
			this.fibonacci.afficherTermes = !this.fibonacci.afficherTermes;
			break;
		}

		this.fibonacci.repaint();
	}

	@Override
	public void mouseDragged(MouseEvent e) {

		if (e.getX() < lastX) {
			this.fibonacci.origineX -= lastX - e.getX();
		} else {
			this.fibonacci.origineX += e.getX() - lastX;
		}

		if (e.getY() < lastY) {
			this.fibonacci.origineY -= lastY - e.getY();
		} else {
			this.fibonacci.origineY += e.getY() - lastY;
		}
		lastX = e.getX();
		lastY = e.getY();

		this.fibonacci.repaint();

	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		int notches = e.getWheelRotation();
		if (notches < 0) {

			this.zoomer();

		} else {

			this.dezoomer();

		}
		this.fibonacci.repaint();

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (SwingUtilities.isMiddleMouseButton(e)) {
			this.fibonacci.origineX = this.fibonacci.getWidth() / 2;
			this.fibonacci.origineY = this.fibonacci.getHeight() / 2;
			this.fibonacci.zoom = 10;
			this.fibonacci.repaint();
		}
		if (SwingUtilities.isRightMouseButton(e)) {
			JFrame f = new JFrame("Termes de la suite");
			String tmp = "";
			for (int i = 0; i < this.fibonacci.termes.size(); i++) {
				tmp = tmp + this.fibonacci.termes.get(i) + ",";
			}
			JLabel label = new JLabel(tmp);
			JPanel panel = new JPanel();
			f.setSize(10, 5);

			panel.add(label);
			f.setContentPane(panel);
			f.setVisible(true);

		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
		lastX = e.getX();
		lastY = e.getY();

	}

	@Override
	public void stateChanged(ChangeEvent e) {
		JSlider source = (JSlider) e.getSource();
		this.fibonacci.zoom = source.getValue();
		this.fibonacci.repaint();

	}

}
