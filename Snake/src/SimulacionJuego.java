import java.awt.Color;
import java.util.ArrayList;

/**
 * Clase donde se realiza el mecanismo del juego
 * 
 * @author Ignacio Belmonte
 *
 */
public class SimulacionJuego extends GameOver {

	byte[][] mundo;
	int posicionXAux;
	int posicionYAux;
	ArrayList<Snake> snake = new ArrayList<Snake>();
	private int lvl = 0;
	public int ultmTeclaValida = 40;

	public SimulacionJuego() {
		mundo = new byte[ClasePrincipal.ventanaJuego.tableroJugador
				.getLongX()][ClasePrincipal.ventanaJuego.tableroJugador.getLongY()];
	}

	public void iniciarJuego() {
		snake.add(new Snake());
		indicarLVL();
		generarFruta();
		ejecucion.start();
	}

	private void indicarLVL() {
		ClasePrincipal.ventanaJuego.panelLVL.indicadorLVL.setText("LVL: " + lvl);
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

	private Thread ejecucion = new Thread(new Runnable() {
		@Override
		public void run() {
			while (true) {
				mostrarMundo();
				esperar(ejecucion);
				actualizarMundo();
			}
		}
	});

	protected void mostrarMundo() {
		for (int i = 0; i < mundo.length; i++) {
			for (int j = 0; j < mundo[0].length; j++) {
				if (mundo[i][j] == 1) {
					pintarCelda(i, j, Color.BLACK);
				} else if (mundo[i][j] == 0) {
					pintarCelda(i, j, Color.WHITE);
				} else if (mundo[i][j] == 2) {
					pintarCelda(i, j, Color.RED);
				}
			}
		}
	}

	private void pintarCelda (int X, int Y, Color color) {
		ClasePrincipal.ventanaJuego.tableroJugador.celdasTablero[X][Y].setBackground(color);
	}
	
	@SuppressWarnings("static-access")
	private void esperar(Thread hilo) {
		try {
			hilo.sleep(200);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@SuppressWarnings("deprecation")
	protected void actualizarMundo() {
		actualizarSnake();
		if (comeFruta()) {
			agrandarSnake();
			lvl++;
			indicarLVL();
			generarFruta();
		}
		actualizarCuerpo();
		if (chocaConSerpiente()) {
			esperar(ejecucion);
			mostrarPantallaGameOver(lvl);
			ClasePrincipal.ventanaJuego.dispose();
			ejecucion.stop();
		}

		actualizarArrayMundo();
	}

	void actualizarSnake() {
		if (ClasePrincipal.ventanaJuego.teclaPulsada == 37 || ClasePrincipal.ventanaJuego.teclaPulsada == 65
				|| ClasePrincipal.ventanaJuego.teclaPulsada == 100) {
			moverIzquierda();
			ultmTeclaValida = 37;
		} else if (ClasePrincipal.ventanaJuego.teclaPulsada == 38 || ClasePrincipal.ventanaJuego.teclaPulsada == 87
				|| ClasePrincipal.ventanaJuego.teclaPulsada == 104) {
			moverArriba();
			ultmTeclaValida = 38;
		} else if (ClasePrincipal.ventanaJuego.teclaPulsada == 39 || ClasePrincipal.ventanaJuego.teclaPulsada == 68
				|| ClasePrincipal.ventanaJuego.teclaPulsada == 102) {
			moverDerecha();
			ultmTeclaValida = 39;
		} else if (ClasePrincipal.ventanaJuego.teclaPulsada == 40 || ClasePrincipal.ventanaJuego.teclaPulsada == 83
				|| ClasePrincipal.ventanaJuego.teclaPulsada == 98) {
			moverAbajo();
			ultmTeclaValida = 40;
		} else {
			actualizarSnakeConUltimaTeclaValida();
		}
	}

	private void actualizarSnakeConUltimaTeclaValida() {
		if (ultmTeclaValida == 37) {
			moverIzquierda();
		} else if (ultmTeclaValida == 38) {
			moverArriba();
		} else if (ultmTeclaValida == 39) {
			moverDerecha();
		} else if (ultmTeclaValida == 40) {
			moverAbajo();
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

	private boolean comeFruta() {
		return mundo[snake.get(0).getX()][snake.get(0).getY()] == 2;
	}

	private void agrandarSnake() {
		snake.add(new Snake(snake.get(snake.size() - 1).getX(), snake.get(snake.size() - 1).getY()));
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

}// class
