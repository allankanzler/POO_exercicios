package exercicio;

public abstract class Container {
	
	protected String lacre;
	protected double valorFrete;
	protected double peso;
	protected double valorFreteFinal;
	
	
	public Container(String lacre, double valorFrete,
			double peso) {
		super();
		
		this.lacre = lacre;
		this.valorFrete = valorFrete;
		this.peso = peso;
		
	}


	public String getLacre() {
		return lacre;
	}


	public void setLacre(String lacre) {
		this.lacre = lacre;
	}


	public double getValorFrete() {
		return valorFrete;
	}


	public void setValorFrete(double valorFrete) {
		this.valorFrete = valorFrete;
	}


	public double getPeso() {
		return peso;
	}


	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	public abstract double calcularValorFrete();


	@Override
	public String toString() {
		return "container [lacre=" + lacre + ", valorFrete="
				+ valorFrete + ", peso=" + peso + "]\n";
	}
	
	

	

}
