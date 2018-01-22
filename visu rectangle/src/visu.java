import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;

import javax.swing.JPanel;

public class visu extends JPanel implements MouseListener, MouseMotionListener {

	int abs, ord, x, y, c;
	boolean cliqué, cont;

	public visu() {
		this.cliqué = false;
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.c = 0;
		this.cont = true;

	}

	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);

		if (this.cliqué) {
			g.setColor(Color.BLACK);
			if (x > abs) {
				if (y > ord) {
					g.drawRect(abs, ord, x - abs, y - ord);
				} else {
					g.drawRect(abs, y, x - abs, ord - y);
				}
			} else {
				if (y > ord) {
					g.drawRect(x, ord, abs - x, y - ord);
				} else {
					g.drawRect(x, y, abs - x, ord - y);
				}
			}

		}

	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		if (cont) {
			abs = arg0.getX();
			ord = arg0.getY();
			repaint();
		}

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getButton() == arg0.BUTTON1) {
			this.cont = true;
			cliqué = true;
			x = arg0.getX();
			y = arg0.getY();

			repaint();
		}
		if (arg0.getButton() == arg0.BUTTON3) {
			this.cont = false;
			repaint();
		}

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
