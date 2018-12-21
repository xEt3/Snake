
public class Snake {

	private int X ;
	private int Y ;
	
	public Snake() {
		setX(0);
		setY(1);
		
	}
	
	public Snake(int X, int Y) {
	
		setX(X);
		setY(Y);
	}
	
	public int getX() {
		return X;
	}
	
	public void setX(int x) {
		X = x;
	}
	
	public int getY() {
		return Y;
	}
	
	public void setY(int y) {
		Y = y;
	}
	
	

	
}
