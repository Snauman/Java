package Personnages;
import java.util.ArrayList;

import java.util.Iterator;

import Cases.Case;
import Cases.Chemin;
import Objets.Item;
import Principale.Jeu;

public class Personnage {
	public int x;
	public int y;
	int indexX;
	int indexY;
	Case place;
	Jeu donjon;
	ArrayList<Item> items;

	public Personnage(Case place, int indexX, int indexY, Jeu donjon) {

		this.donjon = donjon;
		this.place = place;
		this.indexX = indexX;
		this.indexY = indexY;
		this.x = this.place.getX();
		this.y = this.place.getY();
		this.items = new ArrayList<Item>();
	}

	public void deplacer(int uniteX, int uniteY) {
		if (this.indexX + uniteX > -1 && this.indexX + uniteX < Jeu.TAILLE_PLATEAU && this.indexY + uniteY > -1
				&& this.indexY + uniteY < Jeu.TAILLE_PLATEAU
				&& this.donjon.plateau[this.indexY + uniteY][this.indexX + uniteX].getId() != 0
				&& this.donjon.plateau[this.indexY + uniteY][this.indexX + uniteX].getId() != 3) {
			this.indexX += uniteX;
			this.indexY += uniteY;
			this.place = this.donjon.plateau[this.indexY][this.indexX];
			this.x = this.place.getX();
			this.y = this.place.getY();
			// System.out.println(this.items);
		}
		if (this.victoire()) {
			System.out.println("Victoire!");
			this.donjon.objets.removeAll(this.donjon.objets);
			this.donjon.plateauTemplate=Jeu.DEFAUT102;
			this.donjon.initialiserPlateau();
		}
		if (this.detecterItem()) {
			System.out.println("Item ramassé!");
			System.out.println(this.items);
		}

		if (this.indexX<Jeu.TAILLE_PLATEAU-1 && this.indexY<Jeu.TAILLE_PLATEAU-1 && this.indexX>0 && this.indexY>0) {
			if (this.donjon.plateau[this.indexY + uniteY][this.indexX + uniteX].getId() == 3) {
				System.out.println("porte");
				Iterator<Item> iter = this.items.iterator();

				while (iter.hasNext()) {
					Item i = iter.next();

					if (i.id == 1) {
						iter.remove();
						Chemin c = new Chemin(this.donjon.plateau[this.indexY + uniteY][this.indexX + uniteX].getX(),
								this.donjon.plateau[this.indexY + uniteY][this.indexX + uniteX].getY());
						this.donjon.plateau[this.indexY + uniteY][this.indexX + uniteX] = c;
						break;

					}

				}

			}
		}

	}

	public boolean victoire() {

		if (this.donjon.plateau[this.indexY][this.indexX].getId() == 2) {
			return true;
		}

		return false;

	}

	public void ramasser(Item i) {
		this.items.add(i);
		this.donjon.objets.remove(i);
	}

	public boolean detecterItem() {
		for (Item i : this.donjon.objets) {
			if (this.indexX == i.indexX && this.indexY == i.indexY) {
				this.ramasser(i);
				this.donjon.objets.remove(i);
				return true;
			}
		}
		return false;
	}

	public void deposer(Item i) {
		i.indexX = this.indexX;
		i.indexY = this.indexY;
		i.x = this.x;
		i.y = this.y;
		this.items.remove(i);
		this.donjon.objets.add(i);
	}

}
