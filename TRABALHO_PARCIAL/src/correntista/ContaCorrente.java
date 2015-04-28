package correntista;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader; 
import java.io.FileReader;



public abstract class ContaCorrente {
	
	protected String agencia;
	protected String numero;
	protected Correntista correntista;
	public double saldo;
	protected FileWriter arquivo;
	protected int numLogs=0;
	
	
	public ContaCorrente(String agencia, String numero, Correntista correntista) throws IOException {
		super();
		this.agencia = agencia;
		this.numero = numero;
		this.correntista = correntista;
		this.arquivo = new FileWriter("C:\\Users\\Allan\\workspace\\TRABALHO_PARCIAL\\txt\\"+numero+".txt");
	}

			
	public String getAgencia() {
		return agencia;
	}


	public String getNumero() {
		return numero;
	}


	public Correntista getCorrentista() {
		return correntista;
	}

	public double getSaldo() {
		return saldo;
	}

	protected void depositar(double valor,String data,String hora) throws IOException{
		if(valorPositivo(valor)){
			saldo+=valor;
			
			String msg = "Deposito: +R$"+valor;
			
			registrar(data, hora, msg);
		}	
	}
	
	protected void sacar(double valor,String data,String hora) throws IOException{
		if(existeSaldoSuficiente(valor)){
			saldo-=valor;
			String msg="Saque: -R$"+valor;
			registrar(data, hora, msg);
		}	
	}
	
	private boolean valorPositivo(double valor) {
		if (valor>0)
			return true;
		else
			return false;
	}
	
	protected boolean existeSaldoSuficiente(double valor){
		if(saldo>=valor )
			return true;
		else
			return false;
	}
	
	protected void emitirSaldo(){
		System.out.println("Conta: "+numero+" || Saldo:"+getSaldo());
		
	}
	
	protected String[] emitirExtrato(){
		String[] log = new String[numLogs+1];
		int i=0;	
				
		System.out.printf("\nExtrato Conta "+numero+"\n"); 
		
		try { FileReader arq = new FileReader("C:\\Users\\Allan\\workspace\\TRABALHO_PARCIAL\\txt\\"+numero+".txt"); 
		
		BufferedReader lerArq = new BufferedReader(arq); 
		
		String linha = lerArq.readLine();
		log[i]= linha;
		i++;
		while (linha != null) { 
			System.out.printf("%s\n", linha); 
			
			linha = lerArq.readLine();
			log[i]=linha;
			i++;
			} 
		
		arq.close(); 
		
		} catch (IOException e) 
			{ System.err.printf("Erro na abertura do arquivo: %s.\n", 
					e.getMessage());
			} System.out.println();
		System.out.println("Saldo: R$"+saldo);		

		
		return log;
	}
	
	protected void fazerTransferencia(ContaCorrente destino,double valor,String data,String hora) throws IOException{
		if (valorPositivo(valor)){
			if(existeSaldoSuficiente(valor)){
				saldo-=valor;
				destino.saldo+=valor;
				
				String msg = "Transferência: "+destino.getNumero()+" -R$"+valor;
				String msgdestino = "Recebido de: "+this.correntista.getName()+" +R$"+valor;
				registrar(data, hora, msg);
				destino.registrar(data, hora, msgdestino);
			}
		}
	}
	
	
	protected void registrar(String data,String hora,String msg)throws IOException {
					
		PrintWriter gravarArq = new PrintWriter(this.arquivo);	
		if(numLogs==0){
		
					
			gravarArq.print(data+" "+hora+" "+msg);
		arquivo.close();
		}
		else{
			FileWriter fw = new FileWriter("C:\\Users\\Allan\\workspace\\TRABALHO_PARCIAL\\txt\\"+numero+".txt", true);			 
			BufferedWriter bw = new BufferedWriter(fw);
			 
					
			FileReader reader = new FileReader( "C:\\Users\\Allan\\workspace\\TRABALHO_PARCIAL\\txt\\"+numero+".txt" );
			BufferedReader buffer = new BufferedReader( reader );
			bw.newLine();
			while( buffer.ready() ){
				buffer.readLine();								 				
			}
				bw.write(data+" "+hora+" "+msg);
				
				bw.close();
				fw.close();
				buffer.close();
				reader.close();
			
		} 
			
			
		
		numLogs++;
	}
	
			
	
	//C:\\Users\Allan\\workspace\\TRABALHO_PARCIAL\\txt\\

}
