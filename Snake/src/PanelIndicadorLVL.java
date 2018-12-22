import javax.swing.JPanel;
import javax.swing.JTextPane;

/**
 * Panel que se encuentra abajo indicando el lvl
 * 
 * @author Ignacio Belmonte
 *
 */
public class PanelIndicadorLVL extends JPanel {

	private static final long serialVersionUID = 1L;
	public JTextPane indicadorLVL = new JTextPane();

	public PanelIndicadorLVL() {
		indicadorLVL.setEnabled(false);
		indicadorLVL.setEditable(false);
		this.add(indicadorLVL);
	}

}
