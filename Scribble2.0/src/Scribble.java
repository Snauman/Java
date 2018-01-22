import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Scribble extends JPanel implements MouseMotionListener{
	ArrayList<Point> points;

	public Scribble() {
		this.points=new ArrayList<Point>();
		this.addMouseMotionListener(this);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		for(int i=0;i<this.points.size();i++){
			g.setColor(Color.RED);
			g.fillOval(this.points.get(i).x, this.points.get(i).y, 2, 2);
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		this.points.add(new Point(e.getX(),e.getY()));
		repaint();
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] args) {
		Scribble s = new Scribble();
		s.setBackground(Color.black);
		JFrame fen = new JFrame("scribble 2.0");
		fen.setContentPane(s);
		fen.setSize(500, 500);	
		fen.setVisible(true);
	}
}
