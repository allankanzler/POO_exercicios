package composicao;

public class Tester {
	public static void main(String[]args){
		
		//Criando nova categoria: brinquedo.
		Categoria brinquedos = new Categoria("brinquedos");		
		System.out.println(brinquedos.toString());
		
		
		//criando produto analógico com construtor.
		ProdutoAnalogico prod1 = new ProdutoAnalogico(1, "saco bola de gude", 2.5, brinquedos, 0.25, 0.4);		
		System.out.println(prod1.toString());
		
		Categoria livraria = new Categoria("livraria");		
		
		//Criando produto digital com construtor.
		ProdutoDigital prod2 = new ProdutoDigital(2, "As aventuras do cachorrinho Samba", 17.50, livraria, Formato.ebook, 50000);		
		System.out.println(prod2.toString());
		
		
		System.out.println(prod1.getProduto().toString());
		
	}

}
