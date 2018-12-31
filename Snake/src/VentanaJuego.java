import java.awt.BorderLayout;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

/**
 * Ventana donde se ejecuta el juego
 * 
 * @author Ignacio Belmonte
 *
 */
public class VentanaJuego extends JFrame {

 Tablero tableroJugador;
	 PanelIndicadorLVL panelLVL;
	private static final long serialVersionUID = 1L;
	public int teclaPulsada;

	public VentanaJuego() {
		initialize();
	}

	private void initialize() {
		addPropiedadesVentana();
		addTablero();
		addIndicadorLVL();
		pulsarTeclaDefault();
		addPulsacionTeclas();
	}

	private void addPropiedadesVentana() {
		this.setTitle("Snake");
		this.setBounds(500, 100, 850, 700);
		this.setMaximizedBounds(new Rectangle(500, 100, 850, 700));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void addTablero() {
		tableroJugador = new Tablero();
		this.getContentPane().add(tableroJugador, BorderLayout.CENTER);
	}

	private void addIndicadorLVL() {
		panelLVL = new PanelIndicadorLVL();
		this.getContentPane().add(panelLVL, BorderLayout.PAGE_END);
	}

	private void pulsarTeclaDefault() {
		teclaPulsada = 40;
	}

	private void addPulsacionTeclas() {
		this.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent arg0) {
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
			}

			@Override
			public void keyPressed(KeyEvent arg0) {
				teclaPulsada = arg0.getKeyCode();
			}
		});
	}
}
