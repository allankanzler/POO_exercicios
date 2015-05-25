package issue09;

import javax.swing.JOptionPane;

public interface InterfaceTesteB {
	
	default public void sayHi(){
		JOptionPane.showMessageDialog(null, "OLAR "+this+"!!!","~o~", JOptionPane.INFORMATION_MESSAGE);
	}

}
