package correntistab;

import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public abstract class ContaCorrente {

	protected String agencia;
	protected String numero;
	protected Correntista correntista;
	public double saldo;
	protected FileWriter arquivo;
	protected String usuario;
	protected Arquivador arquivador = new Arquivador();

	public ContaCorrente(String agencia, String numero, Correntista correntista)
			throws IOException {
		super();
		this.agencia = agencia;
		this.numero = numero;
		this.correntista = correntista;
		this.usuario = System.getProperty("user.name");
		arquivador.criarArquivo(usuario, numero);
		
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

	protected void depositar(double valor) throws IOException {
		if (valorPositivo(valor)) {
			saldo += valor;

			String msg = "Deposito: +R$" + valor;

			arquivador.registrar(msg, arquivo, usuario, numero);

		}
	}

	protected void sacar(double valor) throws IOException {
		if (existeSaldoSuficiente(valor)) {
			saldo -= valor;
			String msg = "Saque: -R$" + valor;
			arquivador.registrar(msg, arquivo, usuario, numero);
		}
	}

	private boolean valorPositivo(double valor) {
		if (valor > 0)
			return true;
		else
			return false;
	}

	protected boolean existeSaldoSuficiente(double valor) {
		if (saldo >= valor)
			return true;
		else
			return false;
	}

	protected String emitirSaldo() {
		String msg = "Conta: " + numero + " || Saldo:" + getSaldo();
		return msg;
	}

	protected String[] emitirExtrato() {
		String[] log = new String[arquivador.numLogs];
		int i = 0;

		try {
			FileReader arq = new FileReader("C:\\Users\\" + usuario + "\\"
					+ numero + ".txt");
			BufferedReader lerArq = new BufferedReader(arq);
			String linha = lerArq.readLine();

			while (linha != null) {
				log[i] = linha;
				i++;
				linha = lerArq.readLine();
			}

			arq.close();

		} catch (IOException e) {
			System.err.printf("Erro na abertura do arquivo: %s.\n",
					e.getMessage());
		}

		return log;
	}

	protected void fazerTransferencia(ContaCorrente destino, double valor)
			throws IOException {
		if (valorPositivo(valor)) {
			if (existeSaldoSuficiente(valor)) {
				saldo -= valor;
				destino.saldo += valor;

				String msg = "Transferência: " + destino.getNumero() + " -R$"
						+ valor;
				String msgdestino = "Recebido de: "
						+ this.correntista.getName() + " +R$" + valor;
				arquivador.registrar(msg,  arquivo, usuario, numero);
				destino.arquivador.registrar(msgdestino,  destino.arquivo, destino.usuario,
						destino.numero);
			}
		}
	}

	public String extratoToString() {
		String extrato = "\nExtrato Conta " + numero + "\n";

		for (int i = 0; i < arquivador.numLogs; i++) {
			extrato += emitirExtrato()[i] + "\n";
		}
		extrato += emitirSaldo() + "\n";

		return extrato;
	}

}
