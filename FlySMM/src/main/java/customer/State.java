package customer;

import java.io.Serializable;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public abstract class State implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected FidelityCustomer c;

	public State(FidelityCustomer c) {
		this.c = c;
	}

	public abstract void changeFidelity();

	public abstract String type();

	public static long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
		long diffInMillies = date1.getTime() - date2.getTime();
		long diff = timeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
		return diff;
	}
}
