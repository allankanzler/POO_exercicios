package issue09;

public class ClasseTesteB implements InterfaceTeste,InterfaceTesteB{
	String nome = "Gerso";
	
	
	@Override
    public void sayHi() {
        InterfaceTesteB.super.sayHi();
    }

	@Override
	public String toString() {
		return  nome;
	}
}
