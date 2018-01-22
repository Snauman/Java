import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Fibonacci extends JPanel implements ActionListener {
	public final int NBR = 2;
	private int etapes;
	private int[] fibo;
	private int premierTerme;
	private int deuxiemeTerme;
	private boolean afficherCourbe;

	public Fibonacci() {
		this.etapes = 4;
		this.fibo = new int[etapes];
		this.premierTerme = 10;
		this.deuxiemeTerme = 10;
		this.afficherCourbe = false;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.WHITE);
		fibo = new int[etapes];
		fibo[0] = premierTerme;
		fibo[1] = deuxiemeTerme;
		for (int i = 1; i < this.etapes - 1; i++) {
			this.fibo[i + 1] = this.fibo[i] + this.fibo[i - 1];
		}
		int incr = 1;
		int X = getWidth() / 2;
		int Y = getHeight() / 2;
		for (int i = 0; i < this.fibo.length - 2; i++) {
			g.drawRect(X, Y, fibo[i], fibo[i]);
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
					g.drawArc(X - fibo[i] + fibo[i - 1], Y - fibo[i], 2 * fibo[i], 2 * fibo[i], 90, -90);
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
		//JFrame panneau=new JFrame();
		f.setBackground(Color.BLACK);
		b.setBackground(Color.BLACK);
		b.suivant.addActionListener(f);
		b.precedent.addActionListener(f);
		b.zoom.addActionListener(f);
		b.dezoom.addActionListener(f);
		b.courbe.addActionListener(f);
		fen.setLayout(new BorderLayout());
		fen.getContentPane().add(f, BorderLayout.CENTER);
		fen.getContentPane().add(b, BorderLayout.NORTH);
		//panneau.setContentPane(b);
		//panneau.setVisible(true);
		fen.setSize(1920, 1080);
		fen.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();

		switch (b.getText()) {
		case "precedent":
			this.etapes--;
			break;
		case "suivant":
			this.etapes++;
			break;
		case "zoom":
			this.premierTerme = this.premierTerme * 2;
			this.deuxiemeTerme = this.deuxiemeTerme * 2;
			break;
		case "dezoom":
			if (this.premierTerme > 1 && this.deuxiemeTerme > 1) {
				this.premierTerme = this.premierTerme / 2;
				this.deuxiemeTerme = this.deuxiemeTerme / 2;
			}
			break;
		case "afficher la courbe":
			if (!this.afficherCourbe) {
				this.afficherCourbe = true;
			} else {
				this.afficherCourbe = false;
			}

			break;

		}

		repaint();

	}

}
