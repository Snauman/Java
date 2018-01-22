import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Triangle extends JPanel implements ActionListener {
	int l;
	int[] tabInitX;
	int[] tabInitY;
	int nbPoints;
	int n;
	JButton precedent;
	JButton suivant;
	JButton zoom;
	JButton dezoom;
	JLabel etapes;
	int xCentre, yCentre;

	public Triangle(int l, int x, int y) {
		this.l = l;
		this.n = 0;
		this.xCentre = x;
		this.yCentre = y;
		tabInitX = new int[3];
		tabInitY = new int[3];
		etapes = new JLabel("0");
		this.precedent = new JButton("precedent");
		this.suivant = new JButton("suivant");
		this.zoom = new JButton("zoom");
		this.dezoom = new JButton("dezoom");
		this.add(precedent);
		this.add(suivant);
		this.add(zoom);
		this.add(dezoom);
		this.add(new JLabel("Etape n': "));
		this.add(etapes);
	}

	public int div_2(int a, int b) {
		return (a + b) / 2;
	}

	public void triangleSierpinski(int xA, int yA, int xB, int yB, int xC, int yC, int n, Graphics g) {
		//Color couleur = new Color((int) ((Math.random() * 255 + 1)), (int) ((Math.random() * 255 + 1)),
				//(int) ((Math.random() * 255 + 1)));
		Color couleur=Color.BLACK;
		if (n > 0) {
			int xE = div_2(xA, xB);
			int yE = div_2(yA, yB);
			int xF = div_2(xB, xC);
			int yF = div_2(yB, yC);
			int xG = div_2(xA, xC);
			int yG = div_2(yA, yC);
			int[] tabX = { xE, xF, xG };
			int[] tabY = { yE, yF, yG };
			g.drawPolygon(tabX, tabY, 3);
			g.setColor(couleur);
			triangleSierpinski(xA, yA, xE, yE, xG, yG, n - 1, g);
			triangleSierpinski(xE, yE, xB, yB, xF, yF, n - 1, g);
			triangleSierpinski(xG, yG, xF, yF, xC, yC, n - 1, g);

		}
	}

	public void init(int xCentre, int yCentre) {

		tabInitX[0] = xCentre - (this.l / 2);
		tabInitX[1] = xCentre + (this.l / 2);
		tabInitX[2] = xCentre;
		tabInitY[0] = yCentre;
		tabInitY[1] = yCentre;
		tabInitY[2] = yCentre - (int) (Math.sqrt((this.l * this.l) - ((this.l / 2) * (this.l / 2))));

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		init(this.xCentre, this.yCentre);
		g.drawPolygon(tabInitX, tabInitY, 3);
		triangleSierpinski(tabInitX[0], tabInitY[0], tabInitX[1], tabInitY[1], tabInitX[2], tabInitY[2], this.n, g);
	}

	public static void main(String[] args) {
		JFrame fen = new JFrame("Triangle de sierpinski");
		Triangle t = new Triangle(500, 500, 600);
		t.precedent.addActionListener(t);
		t.suivant.addActionListener(t);
		t.zoom.addActionListener(t);
		t.dezoom.addActionListener(t);
		
		fen.setLayout(new BorderLayout());
		fen.getContentPane().add(t, BorderLayout.CENTER);
		fen.setSize(1000, 1000);
		fen.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();
		switch (b.getText()) {
		case "suivant":
			n++;
			break;
		case "precedent":
			if (n > 0) {
				n--;
			}
			break;
		case "zoom":
			this.l=this.l*2;
			break;
		case "dezoom":
			this.l=this.l/2;
			break;

		}
		this.etapes.setText(String.valueOf(this.n));
		repaint();

	}

}
