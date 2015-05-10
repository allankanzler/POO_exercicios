package exercicio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MecanismoDePersistencia {

	public void armazenarBL(BillOfLanding bl) throws IOException {
		String log = bl.listarBL();
		
		FileWriter fw = new FileWriter("C:\\"+ bl.getNumeroDoBL()
				+ ".txt");
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(log);
		bw.close();
		fw.close();

	}

	public String lerBL(BillOfLanding bl) {
		String msg = "";
		
		try {
			FileReader arq = new FileReader("C:\\"
					+ bl.getNumeroDoBL() + ".txt");
			BufferedReader lerArq = new BufferedReader(arq);
			String linha = lerArq.readLine();
			
			while (linha != null) {
				msg = linha;
				System.out.println(linha);
				linha = lerArq.readLine();
				
			}

			arq.close();

		} catch (IOException e) {
			System.err.printf("Erro na abertura do arquivo: %s.\n",
					e.getMessage());
		}
		return msg;
		
	}
}
