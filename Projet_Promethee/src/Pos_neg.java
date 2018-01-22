
public class Pos_neg extends IA{
	private final String[][] DICTIONNAIRE = { { "vie", "+1" }, { "love", "+1" }, { "adore", "+2" }, { "hate", "-1" }, { "deteste", "-2" }, { "llama", "-1" }, { "unicorn", "+1" }, { "llamacorn", "+1" }};

	public Pos_neg(Fenetre f) {
		super(f);
	}

	public void analyser(String message) {
		String[] an = message.split(" ");


		int res = 0;
		for (int i = 0; i < an.length; i++) {
			for (int j = 0; j < DICTIONNAIRE.length; j++) {
				if (an[i].equals(DICTIONNAIRE[j][0])) {
					res = res + Integer.parseInt(DICTIONNAIRE[j][1]);
				}
			}

		}

		if (res < 0) {
			f.transfererMessage("Ordinateur : negatif");
		}
		if (res == 0) {
			f.transfererMessage("Ordinateur : neutre");
		}
		if (res > 0) {
			f.transfererMessage("Ordinateur : positif");
		}
	}
}
