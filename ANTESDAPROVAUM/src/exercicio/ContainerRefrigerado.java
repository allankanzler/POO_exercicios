package exercicio;

public class ContainerRefrigerado extends Container {

	public ContainerRefrigerado(String lacre,
			double valorFrete, double peso) {
		super(lacre, valorFrete, peso);
		this.valorFreteFinal = calcularValorFrete();
	}

	@Override
	public double calcularValorFrete() {
		double valorFreteFinal = valorFrete;
		return valorFreteFinal;
	}

	@Override
	public String toString() {
		return "\nContainerRefrigerado [lacre=" + lacre
				+ ", valorFrete=" + valorFrete + ", peso=" + peso
				+ ", valorFreteFinal=" + valorFreteFinal + "";
	}
	
	
}
