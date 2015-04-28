package correntistab;

import java.io.IOException;

public class testerb {
	public static void main(String[]args) throws IOException{
		
		
		Correntista allan = new Correntista("Allan", "001212845");
		
		ContaCorrente contaallan = new ContaCorrenteRegular("001", "1232", allan);
		
		System.out.println(contaallan.extratoToString());
		
		contaallan.depositar(100);
		contaallan.sacar(50);
		contaallan.sacar(100);
		contaallan.depositar(-10);
		
		System.out.println(contaallan.emitirSaldo());
		System.out.println(contaallan.extratoToString());
		
		
		Correntista ximbinha = new Correntista("Ximbinha", "01322110");
		ContaCorrente contaximbinha = new ContaCorrenteGold("002", "9999", ximbinha, 200);
		
		contaallan.fazerTransferencia(contaximbinha, 40);
		
		contaximbinha.sacar(50);
		
		contaximbinha.depositar(100);
		
		System.out.println(contaximbinha);
		contaximbinha.fazerTransferencia(contaallan, 150);
		System.out.println(contaximbinha);
		
		
		contaallan.emitirExtrato();
		
		contaximbinha.fazerTransferencia(contaallan, 200);
		contaallan.emitirSaldo();		
		
		System.out.printf(contaximbinha.extratoToString());
		System.out.printf(contaallan.extratoToString());
		
	}

}
