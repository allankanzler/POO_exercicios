package correntista;

import java.io.IOException;

public class ContaCorrenteGold extends ContaCorrente{
	
	private double limite;
	private double limiteUsado=0;

	public ContaCorrenteGold(String agencia, String numero,
			Correntista correntista, double limite) throws IOException {
		
		super(agencia, numero, correntista);
		this.limite = limite;
		
	}

	public double getLimite() {
		return limite;
	}
	
	public double getLimiteUsado() {
		return limiteUsado;
	}
	
	public void depositar(double valor,String data,String hora) throws IOException{
		if (limiteUsado>0){
			limiteUsado-=valor;
				if(limiteUsado<0){
					saldo+=(limiteUsado*(-1));
					limiteUsado=0;
					String msg = "Deposito: +R$"+valor;
					
					registrar(data, hora, msg);
				}			
		}else
			super.depositar(valor,data,hora);		
	}
	

	public void sacar(double valor,String data,String hora) throws IOException{
		if(super.existeSaldoSuficiente(valor)==false){
			if(temLimite(valor)){				
			saldo=0;
			String msg="Saque: -R$"+valor;
			registrar(data, hora, msg);
			}
		}else
			super.sacar(valor,data,hora);
	}		
	
	public void fazerTransferencia(ContaCorrente destino, double valor,String data,String hora) throws IOException{
		if (existeSaldoSuficiente(valor)==false){
			if(temLimite(valor)){				
				saldo=0;
				destino.saldo+=valor;
				String msg = "Transferência: "+destino.getNumero()+" -R$"+valor;
				String msgdestino = "Recebido de: "+this.correntista.getName()+" +R$"+valor;
				registrar(data, hora, msg);
				destino.registrar(data, hora, msgdestino);
			}
		}else
			super.fazerTransferencia(destino, valor,data,hora);
	}
	
	private boolean temLimite(double valor){
		double temp = (saldo-valor)*(-1);
		
		if(limiteUsado+temp <= limite){
			limiteUsado+=temp;
			return true;
		}else{
			return false;
	}
		
		
	}
	
		@Override
	public String toString() {
		return "Conta CorrenteGold [agencia=" + agencia
				
				+ ", numero=" + numero + ", saldo=" + saldo+", limite=" + limite + ", Limite usado="+limiteUsado
				+ "] , Correntista=" + correntista;
				
	}

	protected String[] emitirExtrato(){	
		String[] extrato = super.emitirExtrato();
		System.out.println("Limite usado: "+limiteUsado+" de: "+limite);
		
		return extrato;
	}
	

}
