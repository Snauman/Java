
public class Jeu {
	public static int affrontement(Joueur j1, Joueur j2) {
		if (j1.jouer() == j2.jouer()) {
			return 0;
		} else {
			if ((j1.jouer() == "R" && j2.jouer() == "C") || (j1.jouer() == "P" && j2.jouer() == "R")
					|| (j1.jouer() == "C" && j2.jouer() == "P")) {
				return 1;
			} else {
				if ((j1.jouer() == "P" && j2.jouer() == "C") || (j1.jouer() == "C" && j2.jouer() == "R")
						|| (j1.jouer() == "R" && j2.jouer() == "P")) {
					return 2;
				}
			}
			System.out.println("erreur"+j1.jouer()+j2.jouer());
			return 9;
		}
	}

	public static void Compte(int n, Joueur j1, Joueur j2) {
		int cj1 = 0;
		int cj2 = 0;
		int eg = 0;
		for (int i = 0; i < n; i++) {
			switch (Jeu.affrontement(j1, j2)) {
			case 0:
				eg++;
				break;
			case 1:
				cj1++;
				break;
			case 2:
				cj2++;
				break;

			default:
				break;
			}
		}
		System.out.println("Victoire de Joueur1:" + cj1);
		System.out.println("Victoire de Joueur2:" + cj2);
		System.out.println("Egalité:" + eg);

	}

	public static void main(String[] args) {
		Joueur j1 = new Hasard();
		Joueur j2 = new Hasard();
		Jeu.Compte(10, j1, j2);
	}
}
