package noyau;


public class Radar extends Etat {

	private static Radar instance;

	private Radar() {
	}

	public synchronized static Radar getInstance() {
		if (null == instance) {
			instance = new Radar();
		}
		return instance;
	}

	public String toString() {
		return "radar";
	}
	

}