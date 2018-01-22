import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Melangeur extends JPanel implements ChangeListener{
	int rouge;
	int vert;
	int bleu;
	
	public Melangeur(){
		this.rouge=0;
		this.vert=0;
		this.bleu=0;
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Color couleur=new Color(this.rouge,this.vert,this.bleu);
		g.setColor(couleur);
		g.fillOval(getWidth()/2-100, getHeight()/2-100, 200, 200);
	}
	
	public static void main(String[] args){
		JFrame fen=new JFrame("Melangeur de couleur");
		Melangeur m=new Melangeur();
		Panneau p=new Panneau();
		p.rougeS.addChangeListener(m);
		p.vertS.addChangeListener(m);
		p.bleuS.addChangeListener(m);
		fen.setLayout(new BorderLayout());
		fen.getContentPane().add(m, BorderLayout.CENTER);
		fen.getContentPane().add(p, BorderLayout.NORTH);
		fen.setSize(500, 500);
		fen.setVisible(true);
		
		
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		JSlider s=(JSlider)e.getSource();
		Panneau p=(Panneau)s.getParent();
		switch(s.getName()){
			case "r":
				this.rouge=s.getValue();
				p.rougeV.setText(String.valueOf(s.getValue()));
				break;
			case "v":
				this.vert=s.getValue();
				p.vertV.setText(String.valueOf(s.getValue()));
				break;
			case "b":
				this.bleu=s.getValue();
				p.bleuV.setText(String.valueOf(s.getValue()));
				break;	
		}
		repaint();
		
	}
}
