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
	static PanelInicio panelInicio;

	public static void main(String[] args) {
		mostrarMenuInicio();
	}

	static public void mostrarMenuInicio() {
		panelInicio = new PanelInicio();
		panelInicio.setVisible(true);
	}

	static public void jugar() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					crearVentanaJuego();
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

	private static void mostrarVentanaJuego() {
		ventanaJuego.setVisible(true);
	}

	private static void crearVentanaJuego() {
		ventanaJuego = new VentanaJuego();
	}

}// classs
