import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Fibonacci2 extends JPanel {
	ArrayList<Integer> termes;
	int premierTerme;
	int deuxiemeTerme;
	int nbTerme;
	int origineX;
	int origineY;
	int zoom;
	boolean afficherCourbe;
	boolean afficherTermes;

	public Fibonacci2(int premierTerme, int deuxiemeTerme, int w, int h) {
		this.termes = new ArrayList<Integer>();
		this.premierTerme = premierTerme;
		this.deuxiemeTerme = deuxiemeTerme;
		this.nbTerme = 1;
		this.zoom = 10;
		this.setSize(w, h);
		this.origineX = this.getWidth() / 2;
		this.origineY = this.getHeight() / 2;
	}

	public void calculerSuite(int etapes) {
		this.termes = new ArrayList<Integer>();
		this.termes.add(this.premierTerme);
		this.termes.add(this.deuxiemeTerme);
		if (etapes > 2 || this.nbTerme > 1) {
			for (int i = 2; i < etapes; i++) {
				this.termes.add(this.termes.get(i - 1) + this.termes.get(i - 2));
			}
		} else {
			if (this.nbTerme > 0) {
				this.termes = new ArrayList<Integer>();
				this.termes.add(this.premierTerme);
			} else {
				this.termes = new ArrayList<Integer>();
			}
		}

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int X = this.origineX;
		int Y = this.origineY;
		this.calculerSuite(this.nbTerme);
		int incr = 1;
		g.setColor(Color.black);
		for (int i = 0; i < this.termes.size(); i++) {

			if (afficherTermes) {
				g.setColor(Color.BLACK);

				g.drawString(String.valueOf(this.termes.get(i)), X + (this.termes.get(i) * this.zoom / 2),
						Y + (this.termes.get(i) * this.zoom / 2));

			}
			g.setColor(Color.BLACK);
			g.drawRect(X, Y, this.termes.get(i) * this.zoom, this.termes.get(i) * this.zoom);
			g.setColor(Color.BLUE);
			switch (incr) {
			case 1:
				X += this.termes.get(i) * this.zoom;
				if (afficherCourbe) {

					g.drawArc(X - this.termes.get(i) * this.zoom, Y, 2 * this.termes.get(i) * this.zoom,
							2 * this.termes.get(i) * this.zoom, 180, -90);
				}
				break;
			case 2:
				X -= this.termes.get(i - 1) * this.zoom;
				Y += this.termes.get(i) * this.zoom;
				if (afficherCourbe) {

					g.drawArc(X - this.termes.get(i) * this.zoom + this.termes.get(i - 1) * this.zoom,
							Y - this.termes.get(i) * this.zoom, 2 * this.termes.get(i) * this.zoom,
							2 * this.termes.get(i) * this.zoom, 0, 90);

				}
				break;
			case 3:
				X -= this.termes.get(i) * this.zoom + this.termes.get(i - 1) * this.zoom;
				Y -= this.termes.get(i - 1) * this.zoom;
				if (afficherCourbe) {
					g.drawArc(X + this.termes.get(i - 1) * this.zoom, Y - this.termes.get(i - 2) * this.zoom,
							2 * this.termes.get(i) * this.zoom, 2 * this.termes.get(i) * this.zoom, 0, -90);
				}
				break;
			case 4:
				Y -= this.termes.get(i) * this.zoom + this.termes.get(i - 1) * this.zoom;
				if (afficherCourbe) {
					g.drawArc(X, Y + this.termes.get(i - 1) * this.zoom, 2 * this.termes.get(i) * this.zoom,
							2 * this.termes.get(i) * this.zoom, 180, 90);
				}
				incr = 0;
				break;

			}
			incr++;

		}

	}

	public static void main(String[] args) {
		int w = 500;
		int h = 500;
		Fibonacci2 f = new Fibonacci2(1, 1, w, h);
		BoutonsFibonacci b = new BoutonsFibonacci();
		JFrame fen = new JFrame();
		ListenerFibonacci l = new ListenerFibonacci(f, b);
		// f.setBackground(Color.BLACK);
		// b.setBackground(Color.BLACK);
		fen.setLayout(new BorderLayout());
		fen.getContentPane().add(f, BorderLayout.CENTER);
		fen.getContentPane().add(b, BorderLayout.NORTH);
		fen.getContentPane().add(b.curseur, BorderLayout.EAST);
		fen.setSize(w, h);
		fen.setVisible(true);
	}

}
