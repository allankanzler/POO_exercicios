package exercicio;

public class ContainerTanque extends Container {
	
	private Double volume;
	

	public ContainerTanque(String lacre, double valorFrete,
			double peso, double volume) {
		super(lacre, valorFrete, peso);
		this.volume = volume;
		this.valorFreteFinal = calcularValorFrete();
	}

	public Double getVolume() {
		return volume;
	}

	public void setVolume(Double volume) {
		this.volume = volume;
	}

	@Override
	public double calcularValorFrete() {
		double valorFreteFinal = volume * valorFrete * 1.25;
		return valorFreteFinal;
	}

	@Override
	public String toString() {
		return "\nContainerTanque [Lacre="+lacre+", volume=" + volume + ", valorFreteFinal="
				+ valorFreteFinal
				+ ", valorFrete=" + valorFrete + ", peso=" + peso + "]";
	}
	
	

}
