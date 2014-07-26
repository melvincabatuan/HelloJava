public class Point2D {
	private double x_coord;
	private double y_coord;

	public Point2D(double x, double y) {
		setXCoordinate(x);
		setYCoordinate(y);
	}

	public double getXCoordinate() {
		return x_coord;
	}

	public void setXCoordinate(double x) {
		x_coord = x;
	}

	public double getYCoordinate() {
		return y_coord;
	}

	public void setYCoordinate(double y) {
		y_coord = y;
	}

	public String toString() {
		return "I am a 2 dimensional point.\n" + "My x coordinate is: "
				+ getXCoordinate() + "\n" + "My y coordinate is: "
				+ getYCoordinate();
	}
}
