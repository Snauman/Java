import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Panneau extends JPanel {
	JSlider rougeS;
	JSlider vertS;
	JSlider bleuS;
	JLabel rougeN;
	JLabel vertN;
	JLabel bleuN;
	JLabel rougeV;
	JLabel vertV;
	JLabel bleuV;

	public Panneau() {

		rougeS = new JSlider(0, 255, 0);
		vertS = new JSlider(0, 255, 0);
		bleuS = new JSlider(0, 255, 0);
		rougeS.setName("r");
		vertS.setName("v");
		bleuS.setName("b");
		rougeN = new JLabel("Rouge");
		vertN = new JLabel("Vert");
		bleuN = new JLabel("Bleu");
		rougeV = new JLabel(String.valueOf(rougeS.getValue()));
		vertV = new JLabel(String.valueOf(vertS.getValue()));
		bleuV = new JLabel(String.valueOf(bleuS.getValue()));
		this.setLayout(new GridLayout(3, 3));
		this.add(rougeN);
		this.add(vertN);
		this.add(bleuN);
		this.add(rougeV);
		this.add(vertV);
		this.add(bleuV);
		this.add(rougeS);
		this.add(vertS);
		this.add(bleuS);

	}

}
