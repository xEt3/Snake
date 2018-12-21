import java.awt.EventQueue;

public class PrincipalPruebas {

	static pruebas window = new pruebas();
	static SimulacionPrueba simulacio = new SimulacionPrueba();
	
	public static void main(String[] args) {
	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window.frame.setVisible(true);
					simulacio.iniciarMundo();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
}// classs

