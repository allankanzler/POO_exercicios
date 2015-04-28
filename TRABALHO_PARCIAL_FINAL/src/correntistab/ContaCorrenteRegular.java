package correntistab;

import java.io.IOException;

public class ContaCorrenteRegular extends ContaCorrente{

	public ContaCorrenteRegular(String agencia, String numero,
			Correntista correntista) throws IOException {
		super(agencia, numero, correntista);
	}

	@Override
	public String toString() {
		return "ContaCorrente Regular [agencia=" + agencia + ", numero="
				+ numero+ ", saldo=" + saldo + "], Correntista=" + correntista ;
	}
	
	
	
	

}
