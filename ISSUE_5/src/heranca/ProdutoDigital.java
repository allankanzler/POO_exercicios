package heranca;

public class ProdutoDigital extends Produto {
	
	private Formato formato;
	private double tamanhoEmKm;
	
	public ProdutoDigital(int id, String descricao, double preco,
			Categoria categoria, Formato formato, double tamanhoEmKm) {
		super(id, descricao, preco, categoria);
		this.formato = formato;
		this.tamanhoEmKm = tamanhoEmKm;
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
		return super.toString()+"formato= " + formato + ", tamanho em kb= "
				+ tamanhoEmKm + ", Produto digital";
	}
	
	
	
	

}
