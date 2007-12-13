package noyau;


import java.awt.Frame;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Vector;

import parser.XmlParser;
import progps_ihm.FenetreChargement;
import progps_ihm.FenetrePrincipale;
import sun.awt.windows.ThemeReader;
import exceptions.ExceptionGraph;
import exceptions.ExceptionRecherche;


/*
 * Lancer avec -Xmx512M -Xms512M dans les arguments de la VM
 */
public class SingletonProgps {

	// Objet qui contient la représentation du graph  
	MyWeightedMultigraph graph;
	private List<Route> sesRoutes = new Vector<Route>();
	private static SingletonProgps instance=null;
	private int lastIdVille;
	private int lastIdRoute;
	private Admin sonAdmin;
	private User sonUser;
	
	private SingletonProgps() {
		lastIdVille = 0;
		lastIdRoute = 0;
		sesRoutes = new LinkedList<Route>();
		graph=new MyWeightedMultigraph(Troncon.class);
	}

	public synchronized static SingletonProgps getInstance() {
		if (instance==null) {
			instance = new SingletonProgps();
		}
		return instance;
	}

	private void initialiseGraphComplet(int nbVilles) throws ExceptionGraph{
		sesRoutes = new Vector<Route>();
		graph = new MyWeightedMultigraph( Troncon.class );

		// Creation de 1 route
		Route laRoute = new Route("A6", 5);
		sesRoutes.add(laRoute);

		// Crée les N villes
		for (int i = 0; i < nbVilles; i++) {
			Ville nouvelleVille = new Ville("Ville"+i,1,false);
			graph.addVertex(nouvelleVille);

			// On relie la nouvelle ville à toutes les autres
			for (Iterator iter = graph.vertexSet().iterator(); iter.hasNext();) {
				Ville uneVille = (Ville) iter.next();
//				Test pour vérifier qu'on essaie pas d'ajouter une route qui parte
//				et arrive à la même ville
				if(!uneVille.equals(nouvelleVille)){
					Troncon nouveauTr = graph.ajouterUnTroncon(uneVille, nouvelleVille);
//					On attribue la route au tronçon
					nouveauTr.setSaRoute(laRoute);
//					On indique les 2 villes qui encadrent le troncon
					nouveauTr.setSesVilles(uneVille, nouvelleVille);
					
//					On génère des valeurs aléatoires pour le troncon
					nouveauTr.genererValeursAleatoires();
				}
			}
		}
	}
	

	private List<Ville> prendreDeuxVillesAuHasard(){
		List<Ville> res = new Vector<Ville>();

		Random rand = new Random();
		Ville tab[]=new Ville[graph.vertexSet().size()];
		graph.vertexSet().toArray(tab);
		
		while(res.size()==0){
			res.clear();
			res.add(tab[rand.nextInt(graph.vertexSet().size())]);
			res.add(tab[rand.nextInt(graph.vertexSet().size())]);
			if (res.get(0).equals(res.get(1))) res.clear();
		}
		return res;
	}

	
	public static void main(String[] args) throws Exception {
		SingletonProgps me = getInstance();
		String urlFichier;

		if (args.length==0){ urlFichier = new String("parser/network.xml");}
		else{urlFichier=args[0];}
		
		// Etape 1 : Création de la fenêtre de loading...
		FenetreChargement chargement = new FenetreChargement(new Frame());
		chargement.setVisible(true);
		chargement.setAlwaysOnTop(true);
		
		// Etape 2 : Création du thread de parsing
		XmlParser threadDeParsing = new XmlParser(me, urlFichier);
		threadDeParsing.start();

		// Etape 3 : Boucle de mise à jour de la barre de progression
		while((threadDeParsing.isAlive())
				&&!(threadDeParsing.isExceptionLevee())
				&&!(threadDeParsing.isParsingtermine())){
			chargement.setProgressbarValue(threadDeParsing.getAvancement());
			// Pause de 500ms
			Thread.sleep(1000);
		}
		chargement.setProgressbarValue(100);
		// Teste si le thread a bien terminé
		if(threadDeParsing.isExceptionLevee()){
			threadDeParsing.setStop(true);
			chargement.dispose();
			throw new Exception("La lecture du fichier XML a échouée.");
		}
		// On ferme le thread
		threadDeParsing.setStop(true);
		
//		// Etape 4 : destruction de la fenetre de chargement
		chargement.dispose();
		me.graph.seDecrire();
//		
//		
//		// Etape 5 : Création de la fenêtre principale
		FenetrePrincipale laFenetre = new FenetrePrincipale(me);
		laFenetre.setVisible(true);
		
		// TESTS
		/*
		me.initialiseGraphComplet(5);
		List deuxVilles = me.prendreDeuxVillesAuHasard();
				
		try {
			List<Itineraire> lesIti = me.graph.trouver3Chemins((Ville)deuxVilles.get(0), (Ville)deuxVilles.get(1), null, null);
			for (Iterator iter = lesIti.iterator(); iter.hasNext();) {
				Itineraire unIti = (Itineraire) iter.next();
				System.out.println(unIti.toString());
				System.out.println();
			}
		} catch (ExceptionRecherche e) {
			// Error
			e.printStackTrace();
		}
		*/
		
	}
	
	public List<Ville> getVilles(){
		return new ArrayList<Ville>(this.graph.vertexSet());
	}
	
	
	/*
	 * Début modifications pour le parseur
	 */
//	public boolean ajouterVille(Ville ville) throws Exception {
//		System.out.println("Add ville BAD");
//		if(!villeConnue(ville)){
//			for (Iterator i = sesVilles.iterator(); i.hasNext();) {
//				Ville villeAccontrole = (Ville) i.next();
//				if(ville.getIdVille()==villeAccontrole.getIdVille()){
//					throw new Exception("Impossible d'ajouter deux villes avec le même id : " + ville.getNomVille() + " : " + villeAccontrole.getNomVille());
//				}
//			}
//			sesVilles.add(ville);
//			return true;
//		}else throw new Exception("Ville déjà connue " + ville.getNomVille());
//	}
	/*
	 * Modifs d'Olivier pour prendre en compte JGraphT
	 */
	public boolean ajouterVille(String name, 
			boolean dispo, 
			int typeVille, 
			boolean touristique){
		try {
			Ville newVille = this.graph.ajouterUneVille(name);
			newVille.setDispoVille(dispo);
			newVille.setTypeVille(typeVille);
			newVille.setTouristique(touristique);
		} catch (ExceptionGraph e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean ajouterTroncon(String v1, 
			String v2, 
			Route route,
			int vitesse,
			int longueur,
			List<Etat> etats){
		Ville ville1;
		Ville ville2;
		try {
			ville1 = this.getVille(v1);
			ville2 = this.getVille(v2);
		} catch (Exception e) {
			return false;
		}
		
		Troncon newTroncon=this.graph.ajouterUnTroncon(ville1, ville2);
		newTroncon.setSaRoute(route);
		newTroncon.setSesVilles(ville1, ville2);
		newTroncon.setVitesse(vitesse);
		newTroncon.setLongueur(longueur);
		newTroncon.setSesEtats(etats);
		return true;
	}
	/*
	 * Fin modifs d'Olivier
	 */
	public void ajouterRoute(Route r)  {
			sesRoutes.add(r);
	}
	
	public void ajouterRoute(String nom, int type) {
		Route r = new Route(this.getNewIdRoute(), nom, type);
		this.ajouterRoute(r);
	}



	// Modif Olivier
	private boolean villeConnue(Ville ville) {
		return this.graph.containsVertex(ville);
//		if(sesVilles.contains(ville)){
//			return true;
//		}else {
//			for (Iterator i = sesVilles.iterator(); i.hasNext();) {
//				Ville villeAccontrole = (Ville) i.next();
//				if(ville.getNomVille()==villeAccontrole.getNomVille()){
//					return true;
//				}
//			}
//			return false;
//		}
	}
	
	//Modif Olivier
	public boolean villeConnue(String nomVille) {
		return this.graph.villeExiste(nomVille);
//		for (Iterator iter = sesVilles.iterator(); iter.hasNext();) {
//			Ville v = (Ville) iter.next();
//			if(v.getNomVille().equalsIgnoreCase(nomVille))
//				return true;
//		}
//		return false;
	}
	
	public List<Route> getRoutes() {
		return this.sesRoutes;
	}
	
	public boolean routeConnue(String s) {
		for (Route r: this.sesRoutes) {
			if (r.getNomRoute().equalsIgnoreCase(s))
				return true;
		}
		return false;
	}
	
	public boolean tronconConnu(String route, String v1, String v2) throws Exception {
		for (Route r : this.sesRoutes) {
			for (Troncon t : r.getSesTroncons()) {
				if (t.isRelieVille(this.getVille(v1)) && t.isRelieVille(this.getVille(v2)) && t.getSaRoute().getNomRoute().equalsIgnoreCase(route))
					return true;
			}
		}
		return false;
	}
	
	public Troncon getTroncon(String r, String v1, String v2) throws Exception {

		for (Route rou : this.sesRoutes) {
			if (rou.getNomRoute().equalsIgnoreCase(r)) {
				for (Troncon tr : rou.getSesTroncons()) {
					if (tr.isRelieVille(this.getVille(v1)) && tr.isRelieVille(this.getVille(v2)))
						return tr;
				}
			}
		}
		return null;
	}

	
	public Route getRoute(String s) {
		for (Route r : this.sesRoutes) {
			if (r.getNomRoute().equals(s))
				return r;
		}
		return null;
	}
	
	public int getNewIdVille(){
		lastIdVille++;
		return lastIdVille;
	}
	
	public int getNewIdRoute() {
		lastIdRoute++;
		return lastIdRoute;
	}
	public Ville getVille(String nomVille) throws Exception {
//		for(int i = 0; i < sesVilles.size(); i++){
//			if(sesVilles.get(i).getNomVille().equalsIgnoreCase(nomVille))
//				return sesVilles.get(i);
//		}throw new Exception("Ville " + nomVille + " is unknow by the système");
		return this.graph.getVille(nomVille);
	}

	public Admin getSonAdmin() {
		return sonAdmin;
	}

	public void setSonAdmin(Admin sonAdmin) {
		this.sonAdmin = sonAdmin;
	}

	public User getSonUser() {
		return sonUser;
	}

	public void setSonUser(User sonUser) {
		this.sonUser = sonUser;
	}
	
	public int getNbTronconsTotal() {
		int cpt=0;
		for (Route rou : this.sesRoutes) {
			cpt+=rou.getSesTroncons().size();
		}
		return cpt;
	}

	// Modif Olive : Renommée en villeConnue
//	public boolean existeVille(String nomVille) {
//		for (Iterator iter = sesVilles.iterator(); iter.hasNext();) {
//			Ville v = (Ville) iter.next();
//			if(v.getNomVille().equalsIgnoreCase(nomVille))
//				return true;
//		}
//		return false;
//	}
	/*
	 * Fin modifications pour le parseur
	 */
}
