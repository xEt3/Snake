import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.management.monitor.Monitor;
import javax.swing.JEditorPane;

public class VentanaJuego extends JFrame{

	public JPanel[][] celdasTablero = new JPanel[20][20];
	public int teclaPulsada = 40;
	public JTextPane indicadorLVL = new JTextPane();

	/**
	 * Create the application.
	 */
	public VentanaJuego() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setTitle("Snake");
		this.setBounds(500,100, 850, 700);
		this.setMaximizedBounds(new Rectangle(500,100, 850, 700));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent arg0) {
				teclaPulsada = arg0.getKeyCode();

			}
		});
		
//		JPanel tablero = new JPanel();
//		tablero.setLayout(new GridLayout(20, 20, 0, 0));
//
//		for (int x = 0; x < celdasTablero.length; x++) {
//			for (int y = 0; y < celdasTablero[0].length; y++) {
//
//				celdasTablero[x][y] = new JPanel();
//				celdasTablero[x][y].setBackground(Color.WHITE);
//				tablero.add(celdasTablero[x][y]);
//			}
//		}
		
		JPanel panelNivel = new JPanel();
		this.getContentPane().add(panelNivel, BorderLayout.PAGE_END);
		
		
		indicadorLVL.setEnabled(false);
		indicadorLVL.setEditable(false);
		panelNivel.add(indicadorLVL);
	
	}
}
