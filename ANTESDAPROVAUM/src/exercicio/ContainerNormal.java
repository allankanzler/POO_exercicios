package exercicio;

public class ContainerNormal extends Container {
	
	private String infoMercadoria;
	private double valorDeAjuste;
	
	
	public ContainerNormal(String lacre, double valorFrete,
			double peso, String infoMercadoria, double valorDeAjuste) {
		super( lacre, valorFrete, peso);
		this.infoMercadoria = infoMercadoria;
		this.valorDeAjuste = valorDeAjuste;
		this.valorFreteFinal = calcularValorFrete();
	}

	public String getInfoMercadoria() {
		return infoMercadoria;
	}

	public void setInfoMercadoria(String infoMercadoria) {
		this.infoMercadoria = infoMercadoria;
	}

	public double getValorDeAjuste() {
		return valorDeAjuste;
	}

	public void setValorDeAjuste(double valorDeAjusta) {
		this.valorDeAjuste = valorDeAjusta;
	}
	
	public double calcularValorFrete(){
		double valorFreteFinal = valorFrete * valorDeAjuste;
		
		return valorFreteFinal;
	}

	@Override
	public String toString() {
		return "\nContainerNormal [Lacre="+lacre+", infoMercadoria=" + infoMercadoria
				+ ", valorDeAjuste=" + valorDeAjuste + ", valorFreteFinal="
				+ valorFreteFinal
				+ ", valorFrete=" + valorFrete + ", peso=" + peso + "]";
	}
	
	
	

}
