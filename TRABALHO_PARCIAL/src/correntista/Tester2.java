package correntista;

import java.io.IOException;

public class Tester2 {
	public static void main(String[]args) throws IOException{

		Correntista jao = new Correntista("João da Silva", "011222222-21");		
		ContaCorrenteRegular contajao = new ContaCorrenteRegular("001", "9901", jao);
		
		contajao.depositar(100, "18março2015", "02h44");
		contajao.sacar(50, "18março2015", "03h06");
		
		Correntista ze = new Correntista("José da Silva", "010111123-32");
		
	
		ContaCorrenteGold contaze = new ContaCorrenteGold("001", "2280", ze, 100);
		
		contaze.depositar(500, "18março2015", "03h13");
		
		contaze.sacar(100, "18março2015", "03h15");
		
		contaze.fazerTransferencia(contajao, 150,"18março2015", "03h19");
		
		contaze.emitirSaldo();
		contajao.emitirSaldo();
		contaze.sacar(200, "18março2015", "05h00");
		contaze.depositar(1000, "18março2015", "05h19");
		contaze.emitirSaldo();
		
		contaze.sacar(1100, "18março2015", "07h19");
		
		contaze.emitirExtrato();
		contajao.emitirExtrato();
		System.out.println(contaze);
	}
	

}
