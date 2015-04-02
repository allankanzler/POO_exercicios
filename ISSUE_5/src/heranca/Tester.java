package heranca;

public class Tester {
	public static void main(String[]args){
		
		Categoria brinquedos = new Categoria("brinquedos");
		
		
		System.out.println(brinquedos.toString());
		
		ProdutoAnalogico prod1 = new ProdutoAnalogico(1, "bola de meia", 2.5, brinquedos, 0.25, 0.4);
		
		System.out.println(prod1.toString());
		
		Categoria livraria = new Categoria("livraria");
		
		ProdutoDigital prod2 = new ProdutoDigital(2, "As aventuras do cachorrinho Samba", 17.50, livraria, Formato.ebook, 50000);
		
		System.out.println(prod2.toString());		
		
	}

}
