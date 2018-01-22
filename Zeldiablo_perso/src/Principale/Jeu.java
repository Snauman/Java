package Principale;
import java.awt.Color;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Cases.Case;
import Cases.Chemin;
import Cases.Mur;
import Cases.Porte;
import Cases.Sortie;
import Objets.Cle;
import Objets.Epee;
import Objets.Item;
import Personnages.ControlePerso;

import Personnages.Personnage;

@SuppressWarnings("serial")
public class Jeu extends JPanel {
	public char[][] plateauTemplate;
	public Case[][] plateau;
	public Personnage perso;
	public ArrayList<Item> objets;
	public static final int TAILLE_PLATEAU=10;
	public static final char[][] DEFAUT10={{'M','M','M','M','M','M','M','M','M','M'},
	 		   							   {'M','C','X','X','X','X','X','M','X','S'},
	 		   							   {'M','X','M','M','E','X','X','M','X','M'},
	 		   							   {'M','X','X','X','X','C','X','M','X','M'},
	 		   							   {'M','X','M','M','M','X','M','M','X','M'},
	 		   							   {'M','X','M','M','M','X','M','M','D','M'},
	 		   							   {'M','X','X','M','M','X','X','X','X','M'},
	 		   							   {'M','M','X','M','M','X','M','M','D','M'},
	 		   							   {'P','X','X','X','X','X','X','X','X','M'},
	 		   							   {'M','M','M','M','M','M','M','M','M','M'}};
	
	public static final char[][] DEFAUT102={{'M','M','M','M','M','M','M','M','M','M'},
	 		   								{'M','C','M','M','M','M','M','M','X','P'},
	 		   								{'M','X','M','M','X','M','M','M','X','M'},
	 		   								{'M','X','X','X','X','C','M','M','X','M'},
	 		   								{'M','X','M','M','M','X','M','M','X','M'},
	 		   								{'M','X','M','M','M','X','M','M','X','M'},
	 		   								{'M','X','X','M','M','X','M','M','X','M'},
	 		   								{'M','M','X','M','M','X','M','M','X','M'},
	 		   								{'S','D','X','D','X','X','X','X','X','M'},
	 		   								{'M','M','M','M','M','M','M','M','M','M'}};
	
	public static final char[][] DEFAUT5={{'M','M','M','M','M'},
			 							  {'M','X','X','X','S'},
			 							  {'M','X','M','M','M'},
			 							  {'P','X','X','X','M'},
			 							  {'M','M','M','M','M'}};

	public Jeu(char[][] plateauTemplate) {
		ControlePerso c = new ControlePerso();
		this.addKeyListener(c);
		this.plateauTemplate = plateauTemplate;
		this.plateau = new Case[Jeu.TAILLE_PLATEAU][Jeu.TAILLE_PLATEAU];
		this.objets = new ArrayList<Item>();
		this.initialiserPlateau();

	}

	public Jeu() {
		this.plateauTemplate = Jeu.DEFAUT10;
		this.plateau = new Case[Jeu.TAILLE_PLATEAU][Jeu.TAILLE_PLATEAU];
		this.objets = new ArrayList<Item>();
		this.initialiserPlateau();
		System.out.println(this.plateau[0][0].getClass().getName());
		if(this.plateau[0][0].getClass().getName()=="Cases.Mur"){
			System.out.println("prout");
		}else{
			System.out.println("prout2");
		}
		ControlePerso c = new ControlePerso();
		this.addKeyListener(c);

	}

	public void initialiserPlateau() {
		for (int i = 0; i < plateauTemplate.length; i++) {
			for (int j = 0; j < plateauTemplate[i].length; j++) {
				switch (this.plateauTemplate[i][j]) {
				case 'M':
					this.plateau[i][j] = new Mur(Case.TAILLE * j, Case.TAILLE * i);

					break;
				case 'X':
					this.plateau[i][j] = new Chemin(Case.TAILLE * j, Case.TAILLE * i);

					break;
				case 'P':
					this.plateau[i][j] = new Chemin(Case.TAILLE * j, Case.TAILLE * i);
					this.perso = new Personnage(this.plateau[i][j], j, i, this);
					break;
				case 'S':
					this.plateau[i][j] = new Sortie(Case.TAILLE * j, Case.TAILLE * i);
					break;
				case 'E':
					this.plateau[i][j] = new Chemin(Case.TAILLE * j, Case.TAILLE * i);
					Epee epee = new Epee(j, i, j, i);
					this.objets.add(epee);
					break;
				case 'C':
					this.plateau[i][j] = new Chemin(Case.TAILLE * j, Case.TAILLE * i);
					Cle cle = new Cle(j, i, j, i);
					this.objets.add(cle);
					break;
				case 'D':
					this.plateau[i][j] = new Porte(Case.TAILLE * j, Case.TAILLE * i);
					break;

				}

			}
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		BufferedImage chemin = null;
		BufferedImage mur = null;
		BufferedImage porte = null;
		BufferedImage sortie = null;
		BufferedImage perso = null;
		
		try {
			chemin = ImageIO.read(new File("sol.jpg"));
			mur = ImageIO.read(new File("mur.gif"));
			porte = ImageIO.read(new File("porte.png"));
			sortie = ImageIO.read(new File("sortie.jpg"));
			perso = ImageIO.read(new File("perso2.png"));
		} catch (IOException e) {
		}
		// System.out.println(this.perso.indexX);
		// System.out.println(this.perso.indexY);
		for (int i = 0; i < plateau.length; i++) {
			for (int j = 0; j < plateau[i].length; j++) {
				switch (this.plateau[j][i].getId()) {
				case 0:
					// g.setColor(this.plateau[j][i].getCouleur());
					// g.fillRect(this.plateau[j][i].getX(),
					// this.plateau[j][i].getY(), Case.TAILLE, Case.TAILLE);
					g.drawImage(mur, this.plateau[j][i].getX(), this.plateau[j][i].getY(), null);

					break;
				case 1:

					// g.setColor(this.plateau[j][i].getCouleur());
					// g.fillRect(this.plateau[j][i].getX(),
					// this.plateau[j][i].getY(), Case.TAILLE, Case.TAILLE);
					g.drawImage(chemin, this.plateau[j][i].getX(), this.plateau[j][i].getY(), null);

					break;
				case 2:
					// g.setColor(this.plateau[j][i].getCouleur());
					// g.fillRect(this.plateau[j][i].getX(),
					// this.plateau[j][i].getY(), Case.TAILLE, Case.TAILLE);
					g.drawImage(sortie, this.plateau[j][i].getX(), this.plateau[j][i].getY(), null);

					break;
				case 3:
					// g.setColor(this.plateau[j][i].getCouleur());
					// g.fillRect(this.plateau[j][i].getX(),
					// this.plateau[j][i].getY(), Case.TAILLE, Case.TAILLE);
					g.drawImage(porte, this.plateau[j][i].getX(), this.plateau[j][i].getY(), null);

					break;

				}
				g.drawImage(perso, this.perso.x, this.perso.y, null);
			}
		}

		for (Item i : this.objets) {
			g.setColor(Color.BLACK);
			switch (i.id) {
			case 0:
				g.drawString("E", i.x, i.y);
				break;
			case 1:
				g.drawString("C", i.x, i.y);
				break;
			}

		}
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Zeldiablo");
		Jeu j = new Jeu();
		frame.setContentPane(j);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.setPreferredSize(new Dimension(Case.TAILLE * Jeu.TAILLE_PLATEAU, Case.TAILLE * Jeu.TAILLE_PLATEAU));
		
		frame.pack();
		frame.setVisible(true);
		j.setFocusable(true);
		j.requestFocusInWindow();

	}
}
