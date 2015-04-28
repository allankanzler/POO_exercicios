package correntistab;

public class Correntista {
	
	private String name;
	private String CPF;
	
	public Correntista(String name, String cPF) {
		super();
		this.name = name;
		CPF = cPF;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
	}
	
	
	@Override
	public String toString() {
		return "[name=" + name + ", CPF=" + CPF + "]";
	}
	
	
	
	

}
