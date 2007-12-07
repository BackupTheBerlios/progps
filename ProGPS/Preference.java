
public enum Preference {
	Radars, TypeRoute, Villes, VillesAEviter, Vitesse, Payante, Touristique;
	
	private static User user;
	private static int nb_preferences = 7;
	
	private Preference() {}
	
	public static int getNbPreferences () {
		return nb_preferences;
	}
	
	public static void setUser(User u) {
		user=u;
	}

}