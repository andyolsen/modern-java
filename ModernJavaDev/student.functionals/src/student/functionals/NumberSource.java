package student.functionals;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

public class NumberSource {

	private int nextNumber = 0;
	private Random generator = new Random();
	
	public int getSequentialNumber() {
		return ++nextNumber;
	}
	
	public int getRandomNumber() {
		return generator.nextInt();
	}
	
	public int getHourOfDay() {
		Calendar calendar = GregorianCalendar.getInstance();
		return calendar.get(Calendar.HOUR_OF_DAY);
	}
}
