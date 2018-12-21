import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

public class pruebas {

	JFrame frame;
	public JPanel[][] celdasTablero = new JPanel[20][20];
	

	/**
	 * Create the application.
	 */
	public pruebas() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(300, 300, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel tablero = new JPanel();
		tablero.setLayout(new GridLayout(20, 20, 1, 1));

		for (int x = 0; x < celdasTablero.length; x++) {
			for (int y = 0; y < celdasTablero[0].length; y++) {

				celdasTablero[x][y] = new JPanel();
				celdasTablero[x][y].setBackground(Color.WHITE);
				tablero.add(celdasTablero[x][y]);
			}
		}
		frame.getContentPane().add(tablero, BorderLayout.CENTER);
		
	}

}