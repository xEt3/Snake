import java.awt.BorderLayout;
import java.awt.EventQueue;

public class ClasePrincipal {

	static VentanaJuego ventanaJuego = new VentanaJuego();
	static SimulacionJuego simulacion; 
	static Tablero tablero = new Tablero();
	
	public static void main(String[] args) {
	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addTablero();
					mostrarVentanaJuego();
					crearPartidaNueva();
					iniciarPartidaCreada();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}


		});
	}
	
	private static void iniciarPartidaCreada() {
		simulacion.iniciarMundo();
	}
	
	private static void crearPartidaNueva() {
		simulacion = new SimulacionJuego();
	}
	
	private static void addTablero(){
		ventanaJuego.getContentPane().add(tablero, BorderLayout.CENTER);
	}
	
	static void mostrarVentanaJuego() {
		ventanaJuego.setVisible(true);
	}
	
	
	
}// classs

