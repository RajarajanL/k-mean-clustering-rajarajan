import java.io.Serializable;

public class Point implements Serializable{

	private static final long serialVersionUID = -7611757236487737038L;
	public Point() {

	}

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public String toString() {
		return "x:" + x + "\ty:" + y;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	

	private double x;
	private double y;
}
