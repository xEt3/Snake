
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Ventana donde se ejecuta el juego
 * 
 * @author Ignacio Belmonte
 *
 */
public class VentanaMultijugador extends JFrame {

	Tablero tableroJugador1;
	Tablero tableroJugador2;
	JPanel panelJuego ;
	JPanel panelIndicadorLVLs;
	PanelIndicadorLVL panelLVLJugador1;
	PanelIndicadorLVL panelLVLJugador2;
	private static final long serialVersionUID = 1L;
	public int teclaPulsada;

	public VentanaMultijugador() {
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
		this.setBounds(500, 100, 1700, 700);
		this.setMaximizedBounds(new Rectangle(500, 100, 1700, 700));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


	private void addTablero() {
		panelJuego = new JPanel();
		panelJuego.setLayout(new GridLayout(1, 0, 0, 0));
		
		tableroJugador1 = new Tablero();
		panelJuego.add(tableroJugador1);
//		JSeparator separator = new JSeparator();
//		this.getContentPane().add(separator, BorderLayout.CENTER);
		tableroJugador2 = new Tablero();
		panelJuego.add(tableroJugador2);
		
		this.getContentPane().add(panelJuego, BorderLayout.CENTER);
	}

	private void addIndicadorLVL() {
		panelIndicadorLVLs = new JPanel();
		panelIndicadorLVLs.setLayout(new GridLayout(1, 0, 0, 0));
		panelLVLJugador1 = new PanelIndicadorLVL();
		panelIndicadorLVLs.add(panelLVLJugador1);
		panelLVLJugador2 = new PanelIndicadorLVL();
		panelIndicadorLVLs.add(panelLVLJugador2);
		this.getContentPane().add(panelIndicadorLVLs, BorderLayout.PAGE_END);
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
