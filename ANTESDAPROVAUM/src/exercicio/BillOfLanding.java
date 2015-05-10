package exercicio;

import java.util.ArrayList;

public class BillOfLanding {

	private int numeroDoBL;
	private String descricao;
	private String agente;
	ArrayList<Container> containerBL = new ArrayList<Container>();
	private Ordenador ordenador;

	public BillOfLanding(int numeroDoBL, String descricao, String agente) {
		super();
		this.numeroDoBL = numeroDoBL;
		this.descricao = descricao;
		this.agente = agente;
		ordenador = new Ordenador();
	}

	//retorna os containers da BL em ordem crescente de lacre.
	public String listarBL() {
		ordenador.ordenarBL(containerBL);

		String msg = "\n" + toString()
				+ "\nLista de containeirs da BL"				
				+ containerBL.toString();

		return msg;
	}
	
	public int getNumeroDoBL() {
		return numeroDoBL;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getAgente() {
		return agente;
	}

	public void setAgente(String agente) {
		this.agente = agente;
	}

	@Override
	public String toString() {
		return "BillOfKLanding [numeroDoBL=" + numeroDoBL + ", descricao="
				+ descricao + ", agente=" + agente + ", " + "]";
	}
	
	//Adicionar containers a BL
	public void adicionarContainer(Container container) {
			
			if(verificarLacre(container)==false){
				containerBL.add(container);
				System.out.println("Container adicionado ao BL.");	
			}	
	}
	
	private boolean verificarLacre(Container container){
		Boolean existe = false;
		for (Container c : containerBL){
			if (container.lacre.equals(c.lacre)) {
				System.out.println("Erro!Lacre já consta no manifesto");	
				existe = true;
				break;
			}
		}
		return existe;
	}
}
