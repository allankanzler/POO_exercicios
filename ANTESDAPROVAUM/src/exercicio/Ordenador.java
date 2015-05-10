package exercicio;

import java.util.ArrayList;
import java.util.Collections;

public class Ordenador {

	protected ArrayList<Container> ordenarBL(ArrayList<Container> lista) {
		ComparadorDeLacre comparador = new ComparadorDeLacre();
		Collections.sort(lista, comparador);

		return lista;
	}

}
