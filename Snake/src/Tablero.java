import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JPanel;

/**
 * Panel por donde se mueve la serpiente
 * 
 * @author Ignacio Belmonte
 *
 */
public class Tablero extends JPanel {

	private static final long serialVersionUID = 1L;

	public JPanel[][] celdasTablero;
	private int longX;
	private int longY;

	public Tablero() {

		setLongX(20);
		setLongY(20);
		setCeldasTablero(new JPanel[longX][longY]);
		this.setLayout(new GridLayout(longX, longY, 0, 0));

		generarCeldas();
	}

	public Tablero(int longX, int longY) {
		setLongX(longX);
		setLongY(longY);
		setCeldasTablero(new JPanel[longX][longY]);
		this.setLayout(new GridLayout(longX, longY, 0, 0));

		generarCeldas();
	}

	private void generarCeldas() {
		for (int x = 0; x < celdasTablero.length; x++) {
			for (int y = 0; y < celdasTablero[0].length; y++) {

				celdasTablero[x][y] = new JPanel();
				celdasTablero[x][y].setBackground(Color.WHITE);
				this.add(celdasTablero[x][y]);
			}
		}
	}

	public int getLongX() {
		return longX;
	}

	public void setLongX(int longX) {
		this.longX = longX;
	}

	public int getLongY() {
		return longY;
	}

	public void setLongY(int longY) {
		this.longY = longY;
	}

	public void setCeldasTablero(JPanel[][] celdasTablero) {
		this.celdasTablero = celdasTablero;
	}

}// class
