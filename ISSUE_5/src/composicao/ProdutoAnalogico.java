package composicao;

public class ProdutoAnalogico{
	
	private double peso;
	private double dimencao;
	private Produto produto;
	
	public ProdutoAnalogico(int id, String descricao, double preco, Categoria categoria,double peso, double dimencao) {
		setProduto(id,descricao,preco,categoria);	
		this.peso = peso;
		this.dimencao = dimencao;
	}
	
	public Produto getProduto() {
			return produto;
	}

	public void setProduto(int id, String descricao, double preco, Categoria categoria) {
		Produto temp = new Produto(id,descricao,preco,categoria);
		
		this.produto = temp;
	}

	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public double getDimencao() {
		return dimencao;
	}
	public void setDimencao(double dimencao) {
		this.dimencao = dimencao;
	}
	
	
	public String toString() {
		return  produto.toString()+"peso= " + peso + ", dimençãoo= " + dimencao
				+ ", Produto analógico";
	}
	
	

}
