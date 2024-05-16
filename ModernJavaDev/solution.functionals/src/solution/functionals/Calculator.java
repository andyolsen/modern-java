package solution.functionals;

public class Calculator {

	public enum AngleType {
		DEGREES, RADIANS
	}
	
	private AngleType angleType;
	
	public Calculator(AngleType angleType) {
		this.angleType = angleType;
	}
	
	public double sin(double angle) {
		System.out.print("[sin] ");
		if (angleType == AngleType.DEGREES) {
			angle = degreesToRadians(angle);
		}
		return Math.sin(angle);
	}
	
	public double cos(double angle) {
		System.out.print("[cos] ");
		if (angleType == AngleType.DEGREES) {
			angle = degreesToRadians(angle);
		}
		return Math.cos(angle);
	}
	
	public double tan(double angle) {
		System.out.print("[tan] ");
		if (angleType == AngleType.DEGREES) {
			angle = degreesToRadians(angle);
		}
		return Math.tan(angle);
	}
	
	public double log(double value) {
		System.out.print("[log] ");
		return Math.log(value);
	}
	
	public double exp(double value) {
		System.out.print("[exp] ");
		return Math.exp(value);
	}
	
	private static final double DEGREES_TO_RADIANS = 0.0174532925;  // 1 degree = 0.0174532925 radians.
	
	private static double degreesToRadians(double angle) {
		return angle * DEGREES_TO_RADIANS;
	}
}
