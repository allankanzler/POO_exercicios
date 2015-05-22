package issue09;

import javax.swing.JOptionPane;

public interface InterfaceTeste {
	
	default public void sayHi(){
		System.out.println("Olar!!!");
	}
	
	default public void correBerg(){
		JOptionPane.showMessageDialog(null, 
				"AI MEU DEUS! CORRE BERG!!",this+" CORRE!",JOptionPane.WARNING_MESSAGE);
	}

}
