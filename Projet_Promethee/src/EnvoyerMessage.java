import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class EnvoyerMessage implements ActionListener {

	private Fenetre f;
	private IA ordi;

	public EnvoyerMessage(Fenetre f) {
		this.f = f;
		this.ordi=new Pos_neg(this.f);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String temp=f.messageEnCours.getText();
		f.transfererMessage("Utilisateur: "+temp);
		ordi.analyser(temp);
	}

}
