import javax.swing.JFrame;

public class Principale {
	public static void main(String[] args) {
		JFrame fenetre = new JFrame("rectangle");
		visu r=new visu();
		fenetre.setContentPane(r);
		fenetre.setSize(500, 500);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setVisible(true);
		fenetre.requestFocusInWindow();
	}
}
