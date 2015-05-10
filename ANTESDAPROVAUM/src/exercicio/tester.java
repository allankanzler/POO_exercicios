package exercicio;

import java.io.IOException;

public class tester {

	public static void main (String[]args) throws IOException{
		
		Container c1 = new ContainerNormal("a3", 200, 150, "Sandalias", 3);
		Container c2 = new ContainerRefrigerado("a7", 100, 400);
		Container c3 = new ContainerTanque("a1", 4, 150, 150);
		Container c4 = new ContainerNormal("a7", 100, 120, "Remédio pra dengue", 2);
		Container c5 = new ContainerRefrigerado("a0", 100, 400);
		
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		
		BillOfLanding bill1 = new BillOfLanding(1, "Teste", "Allan");
		
		bill1.adicionarContainer(c1);
		bill1.adicionarContainer(c2);
		bill1.adicionarContainer(c3);
		bill1.adicionarContainer(c4);
		bill1.adicionarContainer(c5);

		
		System.out.println(bill1);
		//System.out.println(bill1.listarBL());
		
		System.out.println(bill1.listarBL());
		
		MecanismoDePersistencia mecanismo = new MecanismoDePersistencia();
		
		mecanismo.armazenarBL(bill1);
		
		mecanismo.lerBL(1);
		
		
		
	}
}
