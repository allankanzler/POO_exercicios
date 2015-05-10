package exemplo1;

import java.util.ArrayList;
import java.util.Collections;


public class ListaDeContato {
	
	private String nomeLista;
	private ArrayList<Contato> contato = new ArrayList<Contato>();
	
	public ListaDeContato(String nomeLista) {
		super();
		this.nomeLista = nomeLista;
	}
	
	public void addContato(Contato contato){
		this.contato.add(contato);
	}
	
	public String toString(){
		String msg= "\nListaDeContato nome: "+nomeLista+"\n";
		
		for (Contato c : contato){
			msg+= c.toString()+"\n";
		}
		return msg;
	}

	public String getNomeLista() {
		return nomeLista;
	}
	
	
	public void ordenarPorNome(){
		NomeComparador comparator = new NomeComparador();
		
		Collections.sort(contato, comparator);
		
	}
	
	

}
