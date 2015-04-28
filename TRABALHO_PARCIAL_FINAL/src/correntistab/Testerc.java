package correntistab;

import java.io.IOException;

public class Testerc {
	public static void main(String[]args) throws IOException{
		
		Correntista a = new Correntista("Allan", "1554613246");
		ContaCorrente ac = new ContaCorrenteGold("001", "1111", a, 100);
		
		ac.sacar(100);
		
		System.out.println(ac);
		
		
	}
}
