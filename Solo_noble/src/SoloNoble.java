import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class SoloNoble {

	private static Grille tableau;
	private static ArrayList<String> solution;

	public static void main(String[] args) {
		
		
		char[][] t = new char[][]{ {' ','o','o','.','o'},{' ',' ',' ',' ',' '} };//validé
		char[][] t2 = new char[][]{ {' ', ' ', ' ', '.', ' ', ' '},{' ','o','o','.',' ',' '},{' ',' ',' ','o',' ',' '} };//validé
		char[][] t3 = new char[][]{ {' ', ' ', 'o', ' ', ' ', ' ',' '}, {' ',' ','.','o','o','.',' '}, {' ','o', '.','.',' ',' ',' '}, {' ',' ',' ','o',' ',' ',' '} };//validé
		char[][] t4 = new char[][]{ {'.','o','.'}, {'o','.','o'},{'o','o','.'}};//validé
		char[][] t5 = new char[][]{ {'o','o','o','.', ' '},{'o','o','o','.', ' '},{'o','o','o','o', ' '},{'o','o','o','o', ' '} };//validé
		char[][] t6 = new char[][]{ {'o','o','o','o', ' '},{'o','o','o','.', ' '},{'o','o','o','o', ' '},{'o','o','o','o', ' '} };
		char[][] t8 = new char[][]{ {'o','o','o','o','o'},{'o','o','o','o','o'},{'o','o','.','o','.'},{'o','o','o','o','o'},{'o','o','o','o','o'} };
		//char[][] t7 =new Grille().getTab().toString();//pas valide
		char[][] t9= {{'.','o','o','o','.'}};
		tableau = new Grille();
		solution = new ArrayList<String>();
		solution.add(tableau.toString());
		//System.out.println(tableau.compterBilles());
		long t1=System.currentTimeMillis();
		boolean res = resoudreSoloNoble(tableau.compterBilles());
		
		//System.out.println(tableau.compterBilles());
		if(!res){
			ecrireSolution();
			System.out.println(System.currentTimeMillis()-t1);
		}else{
			System.out.println("Aucune solution n'a ete trouvee");
			//ecrireSolution();
		}
	}

	public static boolean resoudreSoloNoble(int billes) {
		boolean inf;
		if (billes <= 1) {
			inf = false;
		} else {
			inf = true;
			ArrayList<int[]> candidats = new ArrayList<int[]>();
			for (int i = 0; i < tableau.getTab().length; i++) {
				for (int j = 0; j < tableau.getTab()[i].length; j++) {
					//vers le haut
					if (tableau.deplacementValide(i, j, i, j-2)) {
						candidats.add(new int[] {i,j,i,j-1,i,j-2});
					}
					//vers la droite
					if (tableau.deplacementValide(i, j, i + 2, j)) {
						candidats.add(new int[] {i,j,i+1,j,i+2,j});
					}
					//vers la gauche
					if (tableau.deplacementValide(i, j, i - 2, j)) {
						candidats.add(new int[] {i,j,i-1,j,i-2,j});
					}
					
					//vers le bas
					if (tableau.deplacementValide(i, j, i, j+2)) {
						candidats.add(new int[] {i,j,i,j+1,i,j+2});
					}
					
					
					
					
					
				}
			}
			Iterator<int[]> iter = candidats.iterator();
			int[] c;
			while(iter.hasNext() && inf){
				c = iter.next();
				tableau.enleverBille(c[0], c[1]);
				tableau.enleverBille(c[2], c[3]);
				tableau.placerBille(c[4], c[5]);
				solution.add(tableau.toString());
				inf = resoudreSoloNoble(billes-1);
				//System.out.println(solution.get(solution.size()-1));
				if(inf){
					tableau.placerBille(c[0], c[1]);
					tableau.placerBille(c[2], c[3]);
					tableau.enleverBille(c[4], c[5]);
					solution.remove(solution.size()-1);
				}
			}
		}
		return inf;
	}
	
	public static void ecrireSolution(){
		System.out.println("Le resultat est:");
		for(String i : solution){
			System.out.println(i);
		}
	}
}
