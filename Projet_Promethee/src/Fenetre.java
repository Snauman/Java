import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.*;

public class Fenetre extends JPanel {
	JLabel chat;
	JTextField messageEnCours;
	JButton envoyer;
	ArrayList<String> liste;
	
	
	
	
	public Fenetre() {
		
		this.chat = new JLabel("");
		this.messageEnCours = new JTextField("");
		this.liste=new ArrayList<String>();
		this.envoyer = new JButton("->");
		JPanel c=new JPanel();
		JPanel m=new JPanel();
		c.add(this.chat);
		m.add(this.messageEnCours);
		m.add(this.envoyer);
		this.setLayout(new BorderLayout());
		this.add(c, BorderLayout.CENTER);
		this.add(m, BorderLayout.SOUTH);
		envoyer.addActionListener(new EnvoyerMessage(this));
		this.messageEnCours.setPreferredSize(new Dimension(100,20));;
	}
	
	public void reinitialiserMessage(){
		this.messageEnCours.setText("");
	} 
	
	public void transfererMessage(String mess){
		this.liste.add(mess);
		this.reinitialiserMessage();
		this.repaint();
	}
	
	public void mettreAJour(){
		String temp="";
		for (String string : liste) {
			temp+=string+"<br>";
		}
		this.chat.setText("<html>"+temp+"</html>");
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		this.mettreAJour();
	}


	public static void main(String[] args) {
		JFrame fenetre = new JFrame("Promethée");
		int w=200;
		int h=200;
		Fenetre r=new Fenetre();
		fenetre.setContentPane(r);
		fenetre.setSize(w, h);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setVisible(true);
		fenetre.requestFocusInWindow();
		

	}

}
