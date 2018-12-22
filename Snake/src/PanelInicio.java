import javax.swing.JFrame;
import javax.swing.JSeparator;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JButton;

/**
 * Ventana Inicio
 * 
 * @author Ignacio Belmonte
 *
 */
public class PanelInicio extends JFrame {

	private static final long serialVersionUID = 1L;
	public JButton btnJugar = new JButton("jugar");
	public PanelInicio() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setTitle("Bienvenido a Snake");
		this.setBounds(500, 100, 850, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		this.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(1, 0, 0, 0));

		JSeparator separator = new JSeparator();
		panel.add(separator);

		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));

		JSeparator separator_2 = new JSeparator();
		panel_1.add(separator_2);
		btnJugar.setForeground(Color.WHITE);

		btnJugar.setBackground(Color.BLACK);
		panel_1.add(btnJugar);

		JSeparator separator_3 = new JSeparator();
		panel_1.add(separator_3);

		JSeparator separator_1 = new JSeparator();
		panel.add(separator_1);

	}

}
