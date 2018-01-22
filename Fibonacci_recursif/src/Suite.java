import java.util.ArrayList;
import java.util.Iterator;

public class Suite {
	ArrayList<Integer> suite;
	static final int LIMITE=999999999;
	
	public Suite() {
		suite=new ArrayList<Integer>();
		suite.add(1);
		suite.add(1);
		this.construireSuite();
		
	}
	
	public void construireSuite() {
		if(suite.get(suite.size()-1)>=LIMITE) {
			
		}else{
			this.ajouterMembre();
			this.construireSuite();
		}
	}
	
	public void ajouterMembre() {
		suite.add(suite.get(suite.size()-1)+suite.get(suite.size()-2));
	}
	
	public void enleverMembre() {
		this.suite.remove(this.suite.size()-1);
	}
	
	public String toString() {
		String res="";
		for (Integer integer : suite) {
		res+=(integer+"\n");
		}
		return res;
	}
	
	public static void main(String[] args) {
		Suite s=new Suite();
		System.out.println(s);
	}
}
