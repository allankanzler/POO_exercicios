package exercicio;

import java.util.Comparator;

public class ComparadorDeLacre implements Comparator<Container> {
	   
			@Override
			public int compare(Container c, Container c1) {
				return c.getLacre().
		        		compareTo(c1.getLacre());
			}

}
