import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Principale extends JPanel implements ActionListener{
	String[] sujet={"Le chien","Le chat","La chienne","La chatte","Le cheval","Le lion","Maeva","Claire","Bob","Florian","Laurent"};
	String[] verbe={"cour","marche","se repose","mange","boit","dort"};
	String[] complement={"dans la maison","dans la foret","dans l'herbe","dans la cuisine","dans le salon","sur le toit"};
	
	JButton n=new JButton("Nouvelle phrase");
	
	public Principale(){
		this.add(n);
		n.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button=(JButton)e.getSource();
		this.repaint();
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		int rand=(int)(Math.random() * (3 - 0) + 1);
		String phrase=sujet[(int)(Math.random() * (sujet.length-1))]+" "+verbe[(int)(Math.random() * (verbe.length-1))]+" "+complement[(int)(Math.random() * (complement.length-1))];
		g.setColor(Color.BLACK);
		g.drawString(phrase, 0, 50);
	}
	
	
	public static void main(String[] args){
		Principale p=new Principale();
		JFrame f=new JFrame();
		f.setContentPane(p);
		p.setPreferredSize(new Dimension(200,60));
		f.pack();
		f.setVisible(true);
	}
}
