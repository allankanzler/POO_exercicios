package exemplo1;

public class Tester {
	
	public static void main(String[]args){
	
		Contato c1 = new Contato("Ornivio", "3373458");
		c1.addTelefone("91999981");
		
		System.out.println(c1.telefonesToString());
		
		Contato c2 = new Contato("Zélio", "44552212");
		Contato c3 = new Contato("Allan", "55661527", "orniviocosta@bol.com.br");
		
		ListaDeContato lista1 = new ListaDeContato("Amigos");
		lista1.addContato(c1);
		lista1.addContato(c2);
		lista1.addContato(c3);
		
		System.out.println(lista1);
		
		c1.setTelefone(0, "33332222");
		
		System.out.println(lista1.toString());
		
		c2.addTelefone("4528656");
		c2.addTelefone("5558888");
		System.out.println(c2);
		c2.removerTelefone(1);
		System.out.println(c2);
		
		
		System.out.println(lista1);
		lista1.ordenarPorNome();
		System.out.println(lista1);
		
		Contato c4 = new Contato("Ervino");
		lista1.addContato(c4);
		System.out.println(lista1);
		lista1.ordenarPorNome();
		System.out.println(lista1);
		
	
	}
}
