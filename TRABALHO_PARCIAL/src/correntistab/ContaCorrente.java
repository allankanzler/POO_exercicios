package correntistab;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public abstract class ContaCorrente {

	protected String agencia;
	protected String numero;
	protected Correntista correntista;
	public double saldo;
	protected FileWriter arquivo;
	protected int numLogs;
	protected String usuario;

	public ContaCorrente(String agencia, String numero, Correntista correntista)
			throws IOException {
		super();
		this.agencia = agencia;
		this.numero = numero;
		this.correntista = correntista;
		this.usuario = System.getProperty("user.name");
		this.arquivo = new FileWriter("C:\\Users\\" + usuario + "\\" + numero
				+ ".txt");
		numLogs = 0;
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

			registrar(msg);
		}
	}

	protected void sacar(double valor) throws IOException {
		if (existeSaldoSuficiente(valor)) {
			saldo -= valor;
			String msg = "Saque: -R$" + valor;
			registrar(msg);
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
		String[] log = new String[numLogs];
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
				registrar(msg);
				destino.registrar(msgdestino);
			}
		}
	}

	protected void registrar(String msg) throws IOException {
		
		if (numLogs == 0) {
			PrintWriter gravador = new PrintWriter(this.arquivo);
			gravador.print(getDataEHora() + " " + msg);
			arquivo.close();
		} else {
			FileWriter fw = new FileWriter("C:\\Users\\" + usuario + "\\"
					+ numero + ".txt", true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.newLine();
			bw.write(getDataEHora() + " " + msg);
			bw.close();
			fw.close();
		}
		numLogs++;
	}

	protected String getDataEHora() {

		Calendar calendar = new GregorianCalendar();

		SimpleDateFormat out = new SimpleDateFormat("dd-MM-yyyy");

		Date date = new Date();

		calendar.setTime(date);

		Calendar calendara = new GregorianCalendar();
		SimpleDateFormat outa = new SimpleDateFormat("HH:mm:ss");
		Date hora = new Date();
		calendara.setTime(hora);

		String dataEHora = out.format(calendar.getTime()) + " "
				+ outa.format(calendara.getTime());

		return dataEHora;

	}

	public String extratoToString() {
		String extrato = "\nExtrato Conta " + numero + "\n";

		for (int i = 0; i < numLogs; i++) {
			extrato += emitirExtrato()[i] + "\n";
		}
		extrato += emitirSaldo() + "\n";

		return extrato;
	}
	// C:\\Users\Allan\\workspace\\TRABALHO_PARCIAL\\txt\\

}
