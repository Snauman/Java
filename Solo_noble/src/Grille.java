
public class Grille {

	private boolean[][] tab;
	private char[][] tab_char;

	public Grille(){
		tab = new boolean[7][7];
		tab_char = new char[7][7];
		for(int i=0;i<tab.length;i++){
			for(int j=0;j<tab[i].length;j++){
				if((i<2 && j<2) ||(i>4 && j<2)||(i<2 && j>4)||(i>4 && j>4) ){
					tab[i][j] = false;
					tab_char[i][j] = ' ';
				}else{
					tab[i][j] = true;
					tab_char[i][j] = 'o';
				}
			}
		}
		tab[3][3] = false;
		tab_char[3][3] = '.';
	}
	
	public Grille(char[][] t) {
		super();
		this.tab_char = t;
		this.tab = new boolean[t.length][t[0].length];
		for (int i = 0; i < t.length; i++) {
			for (int j = 0; j < t[i].length; j++) {
				this.tab[i][j] = (t[i][j]=='o');
			}
		}
	}

	public boolean[][] getTab() {
		return tab;
	}

	public void setTab(boolean[][] tab) {
		this.tab = tab;
	}
	
	public void placerBille(int i,int j){
		this.tab[i][j] = true;
	}
	
	public void enleverBille(int i, int j){
		this.tab[i][j] = false;
	}
	
	public boolean deplacementValide(int i,int j, int x, int y){
		boolean res = false;
		if(0<=i && 0<=j && 0<=x && 0<=y && i<this.tab.length && x<this.tab.length && j<this.tab[i].length && y<this.tab[i].length){
			//il y a bien une bille a ij et un vide VALIDE a xy
			if(this.tab[i][j] && !this.tab[x][y] && (tab_char[x][y]=='.' || tab_char[x][y] == 'o') ){
				//xy bien a deux cases de ij
				if((Math.abs(x-i)==2 && j==y)||(Math.abs(j-y)==2 && x==i)){
					// bien une bille entre les deux cases
					res = this.tab[(i+x)/2][(j+y)/2];
				}
			}
		}
		return res;
	}
	
	public int compterBilles(){
		int n = 0;
		for (int i = 0; i < tab.length; i++) {
			for (int j = 0; j < tab[i].length; j++) {
				if(tab[i][j]){
					n++;
				}
			}
		}
		return n;
	}
	
	public String toString(){
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < tab.length; i++) {
			for (int j = 0; j < tab[i].length; j++) {
				if(this.tab[i][j]){
					sb.append('o');
				}else{
					if(this.tab_char[i][j]==' '){
						sb.append(' ');
					}else{
						sb.append('.');
					}
				}
			}
			sb.append('\n');
		}
		return sb.toString();
	}
	
}
