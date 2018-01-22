import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Fibonacci extends JPanel {
	public final int NBR = 2;
	int etapes;
	int[] fibo;
	int[] tab;
	int premierTerme;
	int deuxiemeTerme;
	boolean afficherCourbe;
	boolean afficherTermes;
	int X;
	int Y;

	public Fibonacci() {
		this.etapes = 4;
		this.fibo = new int[etapes];
		this.tab = new int[etapes];
		this.premierTerme = 0;
		this.deuxiemeTerme = 10;
		this.afficherCourbe = false;
		this.afficherTermes = false;
		X = 250;
		Y = 250;

	}

	public void calculerSuite(int un, int deux) {
		fibo = new int[etapes];
		fibo[0] = un;
		fibo[1] = deux;
		for (int i = 1; i < this.etapes - 1; i++) {
			this.fibo[i + 1] = this.fibo[i] + this.fibo[i - 1];
		}

	}

	public void calculerSuiteAffichage() {
		tab = new int[etapes];
		tab[0] = 0;
		tab[1] = 1;
		for (int i = 1; i < this.etapes - 1; i++) {
			this.tab[i + 1] = this.tab[i] + this.tab[i - 1];
		}

	}

	public void paintComponent(Graphics g) {
		System.out.println(this.X);
		X = 250;
		Y = 250;
		super.paintComponent(g);
		System.out.println(this.X);
		calculerSuite(premierTerme, deuxiemeTerme);
		calculerSuiteAffichage();
		int incr = 1;


		for (int i = 0; i < this.fibo.length - 2; i++) {

			g.setColor(Color.WHITE);

			g.drawRect(X, Y, fibo[i], fibo[i]);
			if (afficherTermes) {
				g.setColor(Color.GREEN);
				if (i != 0) {
					g.drawString(String.valueOf(tab[i]), X + (fibo[i] / 2), Y + (fibo[i] / 2));
				}
			}
			g.setColor(Color.WHITE);
			switch (incr) {
			case 1:
				X += fibo[i];
				if (afficherCourbe) {
					g.drawArc(X - fibo[i], Y, 2 * fibo[i], 2 * fibo[i], 180, -90);
				}

				break;
			case 2:
				X -= fibo[i + 1] - fibo[i];
				Y += fibo[i];
				if (afficherCourbe) {
					g.drawArc(X - fibo[i], Y - fibo[i], 2 * fibo[i], 2 * fibo[i], 90, -90);
				}

				break;
			case 3:
				X -= fibo[i + 1];
				Y -= fibo[i + 1] - fibo[i];
				if (afficherCourbe) {
					g.drawArc(X + fibo[i - 1], Y - fibo[i - 2], 2 * fibo[i], 2 * fibo[i], 0, -90);
				}

				break;
			case 4:
				Y -= fibo[i + 1];
				incr = 0;
				if (afficherCourbe) {
					g.drawArc(X, Y + fibo[i - 1], 2 * fibo[i], 2 * fibo[i], -90, -90);
				}

				break;
			}

			incr += 1;

		}

	}

	public static void main(String[] args) {
		Fibonacci f = new Fibonacci();
		Boutons b = new Boutons();
		JFrame fen = new JFrame();
		Listener l = new Listener(f, b);
		f.setBackground(Color.BLACK);
		b.setBackground(Color.BLACK);
		fen.setLayout(new BorderLayout());
		fen.getContentPane().add(f, BorderLayout.CENTER);
		fen.getContentPane().add(b, BorderLayout.SOUTH);
		fen.setSize(500, 500);
		fen.setVisible(true);
	}

}
