package hw0;

public class Router {

	private Point3D point;
	private int signal;
	
	public Router (Point3D point,int signal )
	{
		this.point=point;
		this.signal=signal;
	}

	public Point3D getPoint() {
		return point;
	}

	public void setPoint(Point3D point) {
		this.point = point;
	}

	public int getSignal() {
		return signal;
	}

	public void setSignal(int signal) {
		this.signal = signal;
	}
	
	
}
