import java.awt.BorderLayout;
import java.awt.EventQueue;

public class ClasePrincipal {

	static VentanaJuego ventanaJuego = new VentanaJuego();
	static SimulacionJuego simulacion; 
	static Tablero tablero = new Tablero();
	static PanelIndicadorLVL panelLVL = new PanelIndicadorLVL();
	
	public static void main(String[] args) {
	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
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
		simulacion.iniciarMundo();
	}
	
	private static void crearPartidaNueva() {
		simulacion = new SimulacionJuego();
	}
	
	private static void addTablero(){
		ventanaJuego.getContentPane().add(tablero, BorderLayout.CENTER);
	}
	private static void addIndicadorLVL() {
		ventanaJuego.getContentPane().add(panelLVL, BorderLayout.PAGE_END);
	}
	static void mostrarVentanaJuego() {
		ventanaJuego.setVisible(true);
	}
	
	
	
}// classs

