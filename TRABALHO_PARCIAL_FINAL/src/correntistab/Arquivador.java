package correntistab;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class Arquivador {
	
	protected int numLogs;
	
	protected Arquivador(){
		this.numLogs=0;
	}
	

	protected FileWriter criarArquivo(String usuario, String numero) throws IOException {

		FileWriter arquivo = new FileWriter("C:\\Users\\" + usuario + "\\"
				+ numero + ".txt");

		return arquivo;

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

	protected void registrar(String msg, FileWriter arquivo,
			String usuario, String numero) throws IOException {
		
			FileWriter fw = new FileWriter("C:\\Users\\" + usuario + "\\"
					+ numero + ".txt", true);
			BufferedWriter bw = new BufferedWriter(fw);
			
			if(this.numLogs!=0)
				bw.newLine();
			
			bw.write(getDataEHora() + " " + msg);
			bw.close();
			fw.close();
		
			numLogs++;
	}

}
