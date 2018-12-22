import java.awt.BorderLayout;
import java.awt.EventQueue;

/**
 * Clase principal
 * 
 * @author Ignacio Belmonte
 *
 */
public class ClasePrincipal {

	static VentanaJuego ventanaJuego;
	static SimulacionJuego simulacion;
	static Tablero tablero;
	static PanelIndicadorLVL  panelLVL;

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					crearVentanaJuego();
					addTablero();
					addIndicadorLVL();
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
		simulacion.iniciarJuego();
	}

	private static void crearPartidaNueva() {
		simulacion = new SimulacionJuego();
	}

	private static void addTablero() {
		tablero = new Tablero();
		ventanaJuego.getContentPane().add(tablero, BorderLayout.CENTER);
	}

	private static void addIndicadorLVL() {
		 panelLVL = new PanelIndicadorLVL();
		ventanaJuego.getContentPane().add(panelLVL, BorderLayout.PAGE_END);
	}

	private static void mostrarVentanaJuego() {
		ventanaJuego.setVisible(true);
	}
	
	private static void crearVentanaJuego() {
		ventanaJuego = new VentanaJuego();
	}
}// classs
