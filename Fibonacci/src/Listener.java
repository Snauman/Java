import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JButton;

public class Listener implements ActionListener, MouseWheelListener,MouseMotionListener{
	
	Fibonacci f;
	Boutons b;
	int lastX, lastY;
	
	public Listener(Fibonacci f,Boutons b){
		super();
		this.f=f;
		this.b=b;
		this.f.addMouseWheelListener(this);
		f.addMouseMotionListener(this);
		this.b.suivant.addActionListener(this);
		this.b.precedent.addActionListener(this);
		this.b.courbe.addActionListener(this);
		this.b.terme.addActionListener(this);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();
		//Fibonacci f=(Fibonacci)e.;

		switch (b.getName()) {
		case "precedent":
			f.etapes--;
			break;
		case "suivant":
			f.etapes++;
			break;
		case "zoom":

			f.deuxiemeTerme = f.deuxiemeTerme * 2;

			break;
		case "dezoom":
			if (f.deuxiemeTerme > 1) {

				f.deuxiemeTerme = f.deuxiemeTerme / 2;
			}

			break;
		case "courbe":
			if (!f.afficherCourbe) {
				f.afficherCourbe = true;
			} else {
				f.afficherCourbe = false;
			}

			break;
		case "terme":
			if (!f.afficherTermes) {
				f.afficherTermes = true;
			} else {
				f.afficherTermes = false;
			}

			break;

		}

		f.repaint();

	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		int notches = e.getWheelRotation();
		if (notches < 0) {

			f.deuxiemeTerme = f.deuxiemeTerme * 2;

		} else {

			if (f.deuxiemeTerme > 1) {

				f.deuxiemeTerme = f.deuxiemeTerme / 2;
			}

		}
		f.repaint();

	}
	@Override
	public void mouseDragged(MouseEvent e) {
		int abs, ord;

		abs = e.getX();
		ord = e.getY();
		f.X = abs;
		f.Y = ord;
		f.repaint();
		System.out.println(""+f.X+f.Y+e.getX()+e.getY());
		
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
