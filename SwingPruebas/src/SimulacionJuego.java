import java.awt.Color;
import java.util.ArrayList;

/**
 * Clase donde se realiza el mecanismo del juego
 * 
 * @author nacho
 *
 */
public class SimulacionJuego extends GameOver {

	byte[][] mundo;
	ArrayList<Snake> snake = new ArrayList<Snake>();
	private int lvl = 0;
	private Thread ejecucion = new Thread(new Runnable() {

		@Override
		public void run() {

			while (true) {
				mostrarMundo();

				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				actualizarMundo();
			}
		}
	});

	int posicionXAux;
	int posicionYAux;

	public SimulacionJuego() {
		mundo = new byte[ClasePrincipal.tablero.getLongX()][ClasePrincipal.tablero.getLongY()];
		snake.add(new Snake());
		generarFruta();
		indicarLVL();
	}

	/**
	 * Inicia el mundo
	 */
	public void iniciarMundo() {

		ejecucion.start();
	}

	@SuppressWarnings("deprecation")
	private void actualizarMundo() {
		actualizarSnake();

		if (comeFruta()) {
			agrandarSnake();
			lvl++;
			indicarLVL();
			generarFruta();
		}

		actualizarCuerpo();

		if (chocaConSerpiente()) {
			pintarGameOver();
			ejecucion.stop();
		}

		actualizarArrayMundo();
	}

	private void mostrarMundo() {

		for (int i = 0; i < mundo.length; i++) {

			for (int j = 0; j < mundo[0].length; j++) {

				if (mundo[i][j] == 1) {
					ClasePrincipal.tablero.celdasTablero[i][j].setBackground(Color.BLACK);

				} else if (mundo[i][j] == 0) {
					ClasePrincipal.tablero.celdasTablero[i][j].setBackground(Color.WHITE);

				} else if (mundo[i][j] == 2) {
					ClasePrincipal.tablero.celdasTablero[i][j].setBackground(Color.RED);
				}
			}
		}

	}

	void actualizarSnake() {

		if (ClasePrincipal.ventanaJuego.teclaPulsada == 37) {
			moverIzquierda();

		} else if (ClasePrincipal.ventanaJuego.teclaPulsada == 38) {
			moverArriba();

		} else if (ClasePrincipal.ventanaJuego.teclaPulsada == 39) {
			moverDerecha();

		} else if (ClasePrincipal.ventanaJuego.teclaPulsada == 40) {
			moverAbajo();
		}

	}

	private boolean comeFruta() {
		return mundo[snake.get(0).getX()][snake.get(0).getY()] == 2;
	}

	private void agrandarSnake() {
		snake.add(new Snake(snake.get(snake.size() - 1).getX(), snake.get(snake.size() - 1).getY()));
	}

	private void generarFruta() {
		int x = (int) (Math.random() * 20);
		int y = (int) (Math.random() * 20);

		while (true) {

			if (mundo[x][y] == 0) {
				mundo[x][y] = 2;
				break;

			} else {
				x = (int) (Math.random() * 20);
				y = (int) (Math.random() * 20);
			}
		}
	}

	private void actualizarCuerpo() {

		for (int i = 1; i < snake.size(); i++) {
			int xAux = posicionXAux;
			int yAux = posicionYAux;

			guardarPosicion(snake.get(i));
			if (i == snake.size() - 1) {
				ponerPosicionAnteriorEnBlanco(snake.get(i));
			}
			snake.get(i).setX(xAux);
			snake.get(i).setY(yAux);
		}
	}

	private void actualizarArrayMundo() {
		for (int i = 0; i < snake.size(); i++) {
			mundo[snake.get(i).getX()][snake.get(i).getY()] = 1;
		}
	}

	private void moverArriba() {
		guardarPosicion(snake.get(0));
		if (snake.size() == 1) {
			ponerPosicionAnteriorEnBlanco(snake.get(0));
		}
		int posicionX = snake.get(0).getX();
		if (posicionX == 0) {
			posicionX = mundo.length;
		}
		posicionX--;

		snake.get(0).setX(posicionX);
	}

	private void moverAbajo() {
		guardarPosicion(snake.get(0));

		if (snake.size() == 1) {
			ponerPosicionAnteriorEnBlanco(snake.get(0));
		}

		int posicionX = snake.get(0).getX();

		if (posicionX == mundo.length - 1) {
			posicionX = -1;
		}

		posicionX++;
		snake.get(0).setX(posicionX);
	}

	private void moverDerecha() {
		guardarPosicion(snake.get(0));

		if (snake.size() == 1) {
			ponerPosicionAnteriorEnBlanco(snake.get(0));
		}

		int posicionY = snake.get(0).getY();

		if (posicionY == mundo.length - 1) {
			posicionY = -1;
		}

		posicionY++;
		snake.get(0).setY(posicionY);
	}

	private void moverIzquierda() {
		guardarPosicion(snake.get(0));

		if (snake.size() == 1) {
			ponerPosicionAnteriorEnBlanco(snake.get(0));
		}

		int posicionY = snake.get(0).getY();

		if (posicionY == 0) {
			posicionY = mundo.length;
		}

		posicionY--;
		snake.get(0).setY(posicionY);
	}

	private void ponerPosicionAnteriorEnBlanco(Snake snake) {
		mundo[snake.getX()][snake.getY()] = 0;
	}

	private void guardarPosicion(Snake snake) {
		posicionXAux = snake.getX();
		posicionYAux = snake.getY();
	}

	private boolean chocaConSerpiente() {
		return mundo[snake.get(0).getX()][snake.get(0).getY()] == 1;
	}

	private void indicarLVL() {
		ClasePrincipal.panelLVL.indicadorLVL.setText("LVL: " + lvl);
	}

}// class
