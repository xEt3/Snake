import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 * Codigo que se ejecuta cuando se pierde la partida
 * 
 * @author Ignacio Belmonte
 *
 */
public class GameOver {

	VentanaJuego ventanaGameOver = new VentanaJuego();
	JButton btnVolverJugar = new JButton("Volver a Jugar");
	PanelIndicadorLVL panelLVL = new PanelIndicadorLVL();
	Tablero tablero = new Tablero();

	protected void mostrarPantallaGameOver(int lvl) {
		addTablero();
		addFuncionBotonVolverJugar();
		panelLVL.indicadorLVL.setEnabled(true);
		panelLVL.indicadorLVL.setText("LVL : " + lvl);
		addBtnVolverJugar();
		addIndicadorLVL();
		ventanaGameOver.setTitle("GAME OVER");
		ventanaGameOver.setVisible(true);
		pintarGameOver();

	}

	private void addBtnVolverJugar() {
		panelLVL.add(btnVolverJugar);
	}

	private void addFuncionBotonVolverJugar() {
		btnVolverJugar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				ClasePrincipal.main(null);
				ventanaGameOver.dispose();
			}
		});
	}

	private void addIndicadorLVL() {
		ventanaGameOver.getContentPane().add(panelLVL, BorderLayout.PAGE_END);
	}

	private void addTablero() {
		ventanaGameOver.getContentPane().add(tablero, BorderLayout.CENTER);
	}

	private void pintarGameOver() {

		tablero.celdasTablero[1][0].setBackground(Color.RED);
		tablero.celdasTablero[1][1].setBackground(Color.RED);
		tablero.celdasTablero[1][2].setBackground(Color.RED);
		tablero.celdasTablero[1][3].setBackground(Color.RED);
		tablero.celdasTablero[1][5].setBackground(Color.RED);
		tablero.celdasTablero[1][6].setBackground(Color.RED);
		tablero.celdasTablero[1][7].setBackground(Color.RED);
		tablero.celdasTablero[1][8].setBackground(Color.RED);
		tablero.celdasTablero[1][10].setBackground(Color.RED);
		tablero.celdasTablero[1][11].setBackground(Color.RED);
		tablero.celdasTablero[1][13].setBackground(Color.RED);
		tablero.celdasTablero[1][14].setBackground(Color.RED);
		tablero.celdasTablero[1][16].setBackground(Color.RED);
		tablero.celdasTablero[1][17].setBackground(Color.RED);
		tablero.celdasTablero[1][18].setBackground(Color.RED);
		tablero.celdasTablero[1][19].setBackground(Color.RED);

		tablero.celdasTablero[2][0].setBackground(Color.RED);
		tablero.celdasTablero[2][5].setBackground(Color.RED);
		tablero.celdasTablero[2][8].setBackground(Color.RED);
		tablero.celdasTablero[2][10].setBackground(Color.RED);
		tablero.celdasTablero[2][11].setBackground(Color.RED);
		tablero.celdasTablero[2][13].setBackground(Color.RED);
		tablero.celdasTablero[2][14].setBackground(Color.RED);
		tablero.celdasTablero[2][16].setBackground(Color.RED);

		tablero.celdasTablero[3][0].setBackground(Color.RED);
		tablero.celdasTablero[3][5].setBackground(Color.RED);
		tablero.celdasTablero[3][8].setBackground(Color.RED);
		tablero.celdasTablero[3][10].setBackground(Color.RED);
		tablero.celdasTablero[3][12].setBackground(Color.RED);
		tablero.celdasTablero[3][14].setBackground(Color.RED);
		tablero.celdasTablero[3][16].setBackground(Color.RED);

		tablero.celdasTablero[4][0].setBackground(Color.RED);
		tablero.celdasTablero[4][2].setBackground(Color.RED);
		tablero.celdasTablero[4][3].setBackground(Color.RED);
		tablero.celdasTablero[4][5].setBackground(Color.RED);
		tablero.celdasTablero[4][6].setBackground(Color.RED);
		tablero.celdasTablero[4][7].setBackground(Color.RED);
		tablero.celdasTablero[4][8].setBackground(Color.RED);
		tablero.celdasTablero[4][10].setBackground(Color.RED);
		tablero.celdasTablero[4][14].setBackground(Color.RED);
		tablero.celdasTablero[4][16].setBackground(Color.RED);
		tablero.celdasTablero[4][17].setBackground(Color.RED);
		tablero.celdasTablero[4][18].setBackground(Color.RED);

		tablero.celdasTablero[5][0].setBackground(Color.RED);
		tablero.celdasTablero[5][3].setBackground(Color.RED);
		tablero.celdasTablero[5][5].setBackground(Color.RED);
		tablero.celdasTablero[5][8].setBackground(Color.RED);
		tablero.celdasTablero[5][10].setBackground(Color.RED);
		tablero.celdasTablero[5][14].setBackground(Color.RED);
		tablero.celdasTablero[5][16].setBackground(Color.RED);

		tablero.celdasTablero[6][0].setBackground(Color.RED);
		tablero.celdasTablero[6][3].setBackground(Color.RED);
		tablero.celdasTablero[6][5].setBackground(Color.RED);
		tablero.celdasTablero[6][8].setBackground(Color.RED);
		tablero.celdasTablero[6][10].setBackground(Color.RED);
		tablero.celdasTablero[6][14].setBackground(Color.RED);
		tablero.celdasTablero[6][16].setBackground(Color.RED);

		tablero.celdasTablero[7][0].setBackground(Color.RED);
		tablero.celdasTablero[7][1].setBackground(Color.RED);
		tablero.celdasTablero[7][2].setBackground(Color.RED);
		tablero.celdasTablero[7][3].setBackground(Color.RED);
		tablero.celdasTablero[7][5].setBackground(Color.RED);
		tablero.celdasTablero[7][8].setBackground(Color.RED);
		tablero.celdasTablero[7][10].setBackground(Color.RED);
		tablero.celdasTablero[7][14].setBackground(Color.RED);
		tablero.celdasTablero[7][16].setBackground(Color.RED);
		tablero.celdasTablero[7][17].setBackground(Color.RED);
		tablero.celdasTablero[7][18].setBackground(Color.RED);
		tablero.celdasTablero[7][19].setBackground(Color.RED);

		tablero.celdasTablero[9][1].setBackground(Color.RED);
		tablero.celdasTablero[9][3].setBackground(Color.RED);
		tablero.celdasTablero[9][5].setBackground(Color.RED);
		tablero.celdasTablero[9][7].setBackground(Color.RED);
		tablero.celdasTablero[9][9].setBackground(Color.RED);
		tablero.celdasTablero[9][11].setBackground(Color.RED);
		tablero.celdasTablero[9][13].setBackground(Color.RED);
		tablero.celdasTablero[9][15].setBackground(Color.RED);
		tablero.celdasTablero[9][17].setBackground(Color.RED);
		tablero.celdasTablero[9][19].setBackground(Color.RED);

		tablero.celdasTablero[10][0].setBackground(Color.RED);
		tablero.celdasTablero[10][2].setBackground(Color.RED);
		tablero.celdasTablero[10][4].setBackground(Color.RED);
		tablero.celdasTablero[10][6].setBackground(Color.RED);
		tablero.celdasTablero[10][8].setBackground(Color.RED);
		tablero.celdasTablero[10][10].setBackground(Color.RED);
		tablero.celdasTablero[10][12].setBackground(Color.RED);
		tablero.celdasTablero[10][14].setBackground(Color.RED);
		tablero.celdasTablero[10][16].setBackground(Color.RED);
		tablero.celdasTablero[10][18].setBackground(Color.RED);

		tablero.celdasTablero[12][0].setBackground(Color.RED);
		tablero.celdasTablero[12][1].setBackground(Color.RED);
		tablero.celdasTablero[12][2].setBackground(Color.RED);
		tablero.celdasTablero[12][3].setBackground(Color.RED);
		tablero.celdasTablero[12][5].setBackground(Color.RED);
		tablero.celdasTablero[12][9].setBackground(Color.RED);
		tablero.celdasTablero[12][11].setBackground(Color.RED);
		tablero.celdasTablero[12][12].setBackground(Color.RED);
		tablero.celdasTablero[12][13].setBackground(Color.RED);
		tablero.celdasTablero[12][14].setBackground(Color.RED);
		tablero.celdasTablero[12][16].setBackground(Color.RED);
		tablero.celdasTablero[12][17].setBackground(Color.RED);
		tablero.celdasTablero[12][18].setBackground(Color.RED);
		tablero.celdasTablero[12][19].setBackground(Color.RED);

		tablero.celdasTablero[13][0].setBackground(Color.RED);
		tablero.celdasTablero[13][3].setBackground(Color.RED);
		tablero.celdasTablero[13][5].setBackground(Color.RED);
		tablero.celdasTablero[13][9].setBackground(Color.RED);
		tablero.celdasTablero[13][11].setBackground(Color.RED);
		tablero.celdasTablero[13][16].setBackground(Color.RED);
		tablero.celdasTablero[13][19].setBackground(Color.RED);

		tablero.celdasTablero[14][0].setBackground(Color.RED);
		tablero.celdasTablero[14][3].setBackground(Color.RED);
		tablero.celdasTablero[14][5].setBackground(Color.RED);
		tablero.celdasTablero[14][9].setBackground(Color.RED);
		tablero.celdasTablero[14][11].setBackground(Color.RED);
		tablero.celdasTablero[14][16].setBackground(Color.RED);
		tablero.celdasTablero[14][19].setBackground(Color.RED);

		tablero.celdasTablero[15][0].setBackground(Color.RED);
		tablero.celdasTablero[15][3].setBackground(Color.RED);
		tablero.celdasTablero[15][5].setBackground(Color.RED);
		tablero.celdasTablero[15][9].setBackground(Color.RED);
		tablero.celdasTablero[15][11].setBackground(Color.RED);
		tablero.celdasTablero[15][12].setBackground(Color.RED);
		tablero.celdasTablero[15][13].setBackground(Color.RED);
		tablero.celdasTablero[15][16].setBackground(Color.RED);
		tablero.celdasTablero[15][17].setBackground(Color.RED);
		tablero.celdasTablero[15][18].setBackground(Color.RED);
		tablero.celdasTablero[15][19].setBackground(Color.RED);

		tablero.celdasTablero[16][0].setBackground(Color.RED);
		tablero.celdasTablero[16][3].setBackground(Color.RED);
		tablero.celdasTablero[16][6].setBackground(Color.RED);
		tablero.celdasTablero[16][8].setBackground(Color.RED);
		tablero.celdasTablero[16][11].setBackground(Color.RED);
		tablero.celdasTablero[16][16].setBackground(Color.RED);
		tablero.celdasTablero[16][17].setBackground(Color.RED);

		tablero.celdasTablero[17][0].setBackground(Color.RED);
		tablero.celdasTablero[17][3].setBackground(Color.RED);
		tablero.celdasTablero[17][6].setBackground(Color.RED);
		tablero.celdasTablero[17][8].setBackground(Color.RED);
		tablero.celdasTablero[17][11].setBackground(Color.RED);
		tablero.celdasTablero[17][16].setBackground(Color.RED);
		tablero.celdasTablero[17][18].setBackground(Color.RED);

		tablero.celdasTablero[18][0].setBackground(Color.RED);
		tablero.celdasTablero[18][1].setBackground(Color.RED);
		tablero.celdasTablero[18][2].setBackground(Color.RED);
		tablero.celdasTablero[18][3].setBackground(Color.RED);
		tablero.celdasTablero[18][6].setBackground(Color.RED);
		tablero.celdasTablero[18][7].setBackground(Color.RED);
		tablero.celdasTablero[18][8].setBackground(Color.RED);
		tablero.celdasTablero[18][11].setBackground(Color.RED);
		tablero.celdasTablero[18][12].setBackground(Color.RED);
		tablero.celdasTablero[18][13].setBackground(Color.RED);
		tablero.celdasTablero[18][14].setBackground(Color.RED);
		tablero.celdasTablero[18][16].setBackground(Color.RED);
		tablero.celdasTablero[18][19].setBackground(Color.RED);

	}

}
