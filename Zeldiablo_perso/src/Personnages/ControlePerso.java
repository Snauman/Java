package Personnages;

import java.awt.event.KeyEvent;

import java.awt.event.KeyListener;
import Principale.Jeu;

public class ControlePerso implements KeyListener {

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		Jeu j = (Jeu) e.getSource();
		switch (e.getKeyChar()) {
		case 'z':
			j.perso.deplacer(0, -1);
			break;
		case 's':
			j.perso.deplacer(0, 1);
			break;
		case 'd':
			j.perso.deplacer(1, 0);
			break;
		case 'q':
			j.perso.deplacer(-1, 0);
			break;
		case '&':
			j.perso.deposer(j.perso.items.get(0));
			break;
		case 'é':
			j.perso.deposer(j.perso.items.get(1));
			break;
		}
		j.repaint();

	}

}
