package exemplo1;

import java.util.ArrayList;

public class Contato{
	
	private String nome;
	private ArrayList<String> telefone = new ArrayList<String>();
	private String eMail;
	
	public Contato (String nome){
		super();
		this.nome = nome;
	}
	
	public Contato(String nome, String telefone) {
		super();
		this.nome = nome;
		this.telefone.add(telefone);
	}

	public Contato(String nome, String telefone, String eMail) {
		super();
		this.nome = nome;
		this.telefone.add(telefone);
		this.eMail = eMail;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<String> getTelefone() {
		return telefone;
	}
	public String telefonesToString(){
		return telefone.toString();
	}
	
	public void setTelefone(int i, String novoNumero){
		this.telefone.add( this.telefone.indexOf(this.telefone.get(i)), novoNumero);
		this.telefone.remove(i+1);
		
		
		
	}

	public void addTelefone(String telefone) {
		this.telefone.add(telefone);
	}
	
	public void removerTelefone(int i){
		this.telefone.remove(i);
	}
	

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	@Override
	public String toString() {
		return "Contato [nome=" + nome + ", telefone=" + telefone.toString() + ", eMail="
				+ eMail + "]";
	}


	
	
	

}
