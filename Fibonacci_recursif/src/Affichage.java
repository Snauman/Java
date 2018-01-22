import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Affichage extends JPanel {
	Suite suite;
	int dernierTermeAffiche;
	int origineX, origineY;
	int zoom;
	boolean courbe;

	public Affichage(int w, int h, Suite s,int lim) {
		this.setSize(w, h);
		suite = s;
		this.origineX = this.getWidth() / 2;
		this.origineY = this.getHeight() / 2;
		this.zoom = 10;
		this.dernierTermeAffiche=lim;
		courbe=true;
		Glissage g=new Glissage(this);
		this.addMouseMotionListener(g);
		this.addMouseListener(g);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int incr = 1;
		int X = this.origineX;
		int Y = this.origineY;
		g.setColor(Color.black);
		for (int i = 0; i < dernierTermeAffiche; i++) {

			g.setColor(Color.BLACK);
			g.drawRect(X, Y, this.suite.suite.get(i) * this.zoom, this.suite.suite.get(i) * this.zoom);
			g.setColor(Color.BLUE);
			switch (incr) {
			case 1:
				X += this.suite.suite.get(i) * this.zoom;
				if (courbe) {

					g.drawArc(X - this.suite.suite.get(i) * this.zoom, Y, 2 * this.suite.suite.get(i) * this.zoom,
							2 * this.suite.suite.get(i) * this.zoom, 180, -90);
				}
				break;
			case 2:
				X -= this.suite.suite.get(i - 1) * this.zoom;
				Y += this.suite.suite.get(i) * this.zoom;
				if (courbe) {

					g.drawArc(X - this.suite.suite.get(i) * this.zoom + this.suite.suite.get(i - 1) * this.zoom,
							Y - this.suite.suite.get(i) * this.zoom, 2 * this.suite.suite.get(i) * this.zoom,
							2 * this.suite.suite.get(i) * this.zoom, 0, 90);

				}
				break;
			case 3:
				X -= this.suite.suite.get(i) * this.zoom + this.suite.suite.get(i - 1) * this.zoom;
				Y -= this.suite.suite.get(i - 1) * this.zoom;
				if (courbe) {
					g.drawArc(X + this.suite.suite.get(i - 1) * this.zoom, Y - this.suite.suite.get(i - 2) * this.zoom,
							2 * this.suite.suite.get(i) * this.zoom, 2 * this.suite.suite.get(i) * this.zoom, 0, -90);
				}

				break;
			case 4:
				Y -= this.suite.suite.get(i) * this.zoom + this.suite.suite.get(i - 1) * this.zoom;
				if (courbe) {
					g.drawArc(X, Y + this.suite.suite.get(i - 1) * this.zoom, 2 * this.suite.suite.get(i) * this.zoom,
							2 * this.suite.suite.get(i) * this.zoom, 180, 90);
				}
				incr = 0;
				break;

			}
			incr++;

		}
	}
	
	public void basculerCourbe() {
		courbe=!courbe;
	}
	
	public static void main(String[] args) {
		int w = 500;
		int h = 500;
		Suite s=new Suite();
		Affichage a=new Affichage(w,h,s,5);
		
		JFrame fen = new JFrame();
	
		fen.setContentPane(a);

		fen.setSize(w, h);
		fen.setVisible(true);
		//System.out.println(s);
	}

}
