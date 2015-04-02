package heranca;

public class ProdutoAnalogico extends Produto {
	
	private double peso;
	private double dimencao;
	
	
	
	public ProdutoAnalogico( int id, String descricao, double preco, Categoria categoria,double peso, double dimencao) {
		super(id,descricao,preco,categoria);		
		this.peso = peso;
		this.dimencao = dimencao;
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
		return  super.toString()+"peso= " + peso + ", dimencao= " + dimencao
				+ ", Produto analógico";
	}
	
	

}
