package exemplo1;

import java.util.Comparator;

	public class NomeComparador implements Comparator<Contato> {
   
		public int compare(Contato contato, Contato outroContato) {
			return contato.getNome().
        		compareTo(outroContato.getNome());
		}
}
