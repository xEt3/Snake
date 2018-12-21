import java.awt.EventQueue;

public class ClasePrincipal {

	static VentanaJuego window = new VentanaJuego();
	static SimulacionJuego simulacio = new SimulacionJuego();
	
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

