package MyMath;

public class Point {
	
	public double x;
	public double y;
	
	public Point(double x1 , double y1) {
		setX(x1);
		setY(y1);
		
	}
	
	public void setX(double x1) {
		this.x = x1;
	}
	public void setY(double y1) {
		this.y = y1;
	}
	
	public void print() {
		System.out.println("x :                  "+this.x+" , "+this.y);
	}
}
