package composicao;

public class Produto {
	protected int id;
	protected String descricao;
	protected double preco;
	protected Categoria categoria;
	
	
	
	public Produto(int id, String descricao, double preco, Categoria categoria) {
		this.id = id;
		this.descricao = descricao;
		this.preco = preco;
		this.categoria = categoria;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
	public String toString() {
		return "id= " + id + ", descrição= " + descricao + ", preco= "
				+ preco + ", "+categoria+ ", " ;
	}
	
	

}
