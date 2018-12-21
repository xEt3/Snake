import java.awt.Color;
import java.util.ArrayList;

public class SimulacionJuego {

	byte[][] mundo = new byte[20][20];
	ArrayList<Snake> snake = new ArrayList<Snake>();
	private int lvl = 0;
	private Thread ejecucion = new Thread(new Runnable() {

		@Override
		public void run() {

			for (int i = 0; true; i++) {
				System.out.println("\n----- Tiempo " + i + " --------\n");
				mostrarMundo();

				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				actualizarMundo();
			}
		}
	});

	int posicionXAux;
	int posicionYAux;

	public SimulacionJuego() {
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
		// System.out.println(mundo [0][0]);
		actualizarArrayMundo();

	}

	private void mostrarMundo() {
		for (int i = 0; i < mundo.length; i++) {
			for (int j = 0; j < mundo[0].length; j++) {
				if (mundo[i][j] == 1) {
					ClasePrincipal.window.celdasTablero[i][j].setBackground(Color.BLACK);
				} else if (mundo[i][j] == 0) {
					ClasePrincipal.window.celdasTablero[i][j].setBackground(Color.WHITE);
				} else if (mundo[i][j] == 2) {
					ClasePrincipal.window.celdasTablero[i][j].setBackground(Color.RED);
				}
			}
		}

	}

	void actualizarSnake() {

		if (ClasePrincipal.window.teclaPulsada == 37) {
			moverIzquierda();
		} else if (ClasePrincipal.window.teclaPulsada == 38) {
			moverArriba();
		} else if (ClasePrincipal.window.teclaPulsada == 39) {
			moverDerecha();
		} else if (ClasePrincipal.window.teclaPulsada == 40) {
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
		ClasePrincipal.window.indicadorLVL.setText("LVL: " + lvl);
	}

	private void pintarGameOver() {

		for (int i = 0; i < mundo.length; i++) {
			for (int j = 0; j < mundo[0].length; j++) {
				ClasePrincipal.window.celdasTablero[i][j].setBackground(Color.WHITE);
			}
		}
		ClasePrincipal.window.celdasTablero[1][0].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[1][1].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[1][2].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[1][3].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[1][5].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[1][6].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[1][7].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[1][8].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[1][10].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[1][11].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[1][13].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[1][14].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[1][16].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[1][17].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[1][18].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[1][19].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[2][0].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[2][5].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[2][8].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[2][10].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[2][11].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[2][13].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[2][14].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[2][16].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[3][0].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[3][5].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[3][8].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[3][10].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[3][12].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[3][14].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[3][16].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[4][0].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[4][2].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[4][3].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[4][5].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[4][6].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[4][7].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[4][8].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[4][10].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[4][14].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[4][16].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[4][17].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[4][18].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[5][0].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[5][3].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[5][5].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[5][8].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[5][10].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[5][14].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[5][16].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[6][0].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[6][3].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[6][5].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[6][8].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[6][10].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[6][14].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[6][16].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[7][0].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[7][1].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[7][2].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[7][3].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[7][5].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[7][8].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[7][10].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[7][14].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[7][16].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[7][17].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[7][18].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[7][19].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[9][1].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[9][3].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[9][5].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[9][7].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[9][9].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[9][11].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[9][13].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[9][15].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[9][17].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[9][19].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[10][0].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[10][2].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[10][4].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[10][6].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[10][8].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[10][10].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[10][12].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[10][14].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[10][16].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[10][18].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[12][0].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[12][1].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[12][2].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[12][3].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[12][5].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[12][9].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[12][11].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[12][12].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[12][13].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[12][14].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[12][16].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[12][17].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[12][18].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[12][19].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[13][0].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[13][3].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[13][5].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[13][9].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[13][11].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[13][16].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[13][19].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[14][0].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[14][3].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[14][5].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[14][9].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[14][11].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[14][16].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[14][19].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[15][0].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[15][3].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[15][5].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[15][9].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[15][11].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[15][12].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[15][13].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[15][16].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[15][17].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[15][18].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[15][19].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[16][0].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[16][3].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[16][6].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[16][8].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[16][11].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[16][16].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[16][17].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[17][0].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[17][3].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[17][6].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[17][8].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[17][11].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[17][16].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[17][18].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[18][0].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[18][1].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[18][2].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[18][3].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[18][6].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[18][7].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[18][8].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[18][11].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[18][12].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[18][13].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[18][14].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[18][16].setBackground(Color.RED);
		ClasePrincipal.window.celdasTablero[18][19].setBackground(Color.RED);

	}

}
