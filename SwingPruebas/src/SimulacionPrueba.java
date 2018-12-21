import java.awt.Color;
import java.util.ArrayList;

public class SimulacionPrueba {

	byte[][] mundo = new byte[20][20];
	ArrayList<SnakePrueba> snake = new ArrayList<SnakePrueba>();

	int posicionXAux;
	int posicionYAux;

	public SimulacionPrueba() {
		snake.add(new SnakePrueba());
		mundo [8][1] = 2;
		mundo [10][1] = 2;

	}

	public void iniciarMundo() {
		new Thread(new Runnable() {

			@Override
			public void run() {

				for (int i = 0; i < 20; i++) {
					System.out.println("\n----- Tiempo " + i + " --------\n");
					actualizarMundo();
					mostrarMundo();

					try {
						Thread.sleep(300);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}).start();

	}

	private void actualizarMundo() {
		actualizarSnake();
		if (comeFruta()) {
		snake.add(new SnakePrueba(snake.get(snake.size()-1).getX(),snake.get(snake.size()-1).getY()));
		}
		actualizarCuerpo();
		for (int i = 0; i < snake.size(); i++) {

			//System.out.println(i + "   longX = " + snake.get(i).getX() + " longy= " + snake.get(i).getY());
			 mundo[snake.get(i).getX()][snake.get(0).getY()] = 1;
		}

	}

	private boolean comeFruta() {
		
		return mundo[snake.get(0).getX()][snake.get(0).getY()] == 2;
	}

	private void actualizarCuerpo() {
		
		for (int i = 1; i < snake.size(); i++) {
			int xAux = posicionXAux;
			int yAux = posicionYAux;
			
			guardarPosicion(snake.get(i));
			ponerPosicionAnteriorEnBlanco(snake.get(i));

			snake.get(i).setX(xAux);
			snake.get(i).setY(yAux);
			}
		}

	

	void actualizarSnake() {
		 moverAbajo();
		//moverArriba();
	}

	private void moverArriba() {
		guardarPosicion(snake.get(0));
		ponerPosicionAnteriorEnBlanco(snake.get(0));
		int posicionX = snake.get(0).getX();
		if (posicionX == 0) {
			posicionX = mundo.length;
		}
		posicionX--;
		snake.get(0).setX(posicionX);
	}

	private void moverAbajo() {

		guardarPosicion(snake.get(0));
		ponerPosicionAnteriorEnBlanco(snake.get(0));
		int posicionX = snake.get(0).getX();
		if (posicionX == mundo.length - 1) {
			posicionX = -1;
		}
		posicionX++;
		snake.get(0).setX(posicionX);

	}

	private void ponerPosicionAnteriorEnBlanco(SnakePrueba snake) {
		mundo[snake.getX()][snake.getY()] = 0;
	}

	private void guardarPosicion(SnakePrueba snake) {
		posicionXAux = snake.getX();
		posicionYAux = snake.getY();
	}

	private void mostrarMundo() {
		for (int i = 0; i < mundo.length; i++) {
			for (int j = 0; j < mundo[0].length; j++) {
				if (mundo[i][j] == 1) {
					PrincipalPruebas.window.celdasTablero[i][j].setBackground(Color.BLACK);
				} else if(mundo[i][j] == 0){
					PrincipalPruebas.window.celdasTablero[i][j].setBackground(Color.WHITE);
				} else if (mundo [i][j] == 2) {
					PrincipalPruebas.window.celdasTablero[i][j].setBackground(Color.RED);
				}
			}
		}

	}

}
