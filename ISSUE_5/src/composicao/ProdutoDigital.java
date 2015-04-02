package composicao;

public class ProdutoDigital{
	private Formato formato;
	private double tamanhoEmKm;
	private Produto produto;
	
	
	public ProdutoDigital(int id, String descricao, double preco,
			Categoria categoria, Formato formato, double tamanhoEmKm) {
		
		setProduto(id, descricao, preco, categoria);
		this.formato = formato;
		this.tamanhoEmKm = tamanhoEmKm;
	}
	
	

	public Produto getProduto() {
		return produto;
	}



	public void setProduto(int id, String descricao, double preco,
			Categoria categoria) {
		Produto temp = new Produto(id,descricao,preco,categoria);
		
		this.produto = temp;
	}



	public Formato getFormato() {
		return formato;
	}

	public void setFormato(Formato formato) {
		this.formato = formato;
	}

	public double getTamanhoEmKm() {
		return tamanhoEmKm;
	}

	public void setTamanhoEmKm(double tamanhoEmKm) {
		this.tamanhoEmKm = tamanhoEmKm;
	}

	
	public String toString() {
		return produto.toString()+"formato= " + formato + ", tamanho em kb= "
				+ tamanhoEmKm + ", Produto digital";
	}
	
	
	
	

}
