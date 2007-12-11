package noyau;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Vector;

import progps_ihm.FenetrePrincipale;
import exceptions.ExceptionRecherche;


/*
 * Lancer avec -Xmx512M -Xms512M dans les arguments de la VM
 */
public class SingletonProgps {

	// Objet qui contient la représentation du graph  
	MyWeightedMultigraph<Ville, Troncon> graph;
	private List<Route> sesRoutes = new Vector<Route>();
	private static LinkedList<Ville> sesVilles = new LinkedList<Ville>();
	private static SingletonProgps instance;
	private int lastIdVille;
	private int lastIdRoute;
	
	private SingletonProgps() {
		lastIdVille = 0;
		lastIdRoute = 0;
		sesVilles = new LinkedList<Ville>();
		sesRoutes = new LinkedList<Route>();
	}

	public synchronized static SingletonProgps getInstance() {
		if (null == instance) {
			instance = new SingletonProgps();
		}
		return instance;
	}

	private void initialiseGraphComplet(int nbVilles){
		sesRoutes = new Vector<Route>();
		graph = new MyWeightedMultigraph<Ville, Troncon>( Troncon.class );

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
					Troncon nouveauTr = graph.addEdge(uneVille, nouvelleVille);
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

	
	public static void main(String[] args) {
		SingletonProgps me = getInstance();

		// TODO Etape 1 : Lancement de l'interface
		new FenetrePrincipale();
		// TODO Etape 2 : Lancement du chargement XML
		// TODO Etape 3 : Ouverture de l'interface sur la fenêtre principale
		
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
		
		
	}
	
	public boolean ajouterVille(noyau.Ville ville) throws Exception {
		if(!villeConnu(ville)){
			for (Iterator i = sesVilles.iterator(); i.hasNext();) {
				Ville villeAccontrole = (Ville) i.next();
				if(ville.getIdVille()==villeAccontrole.getIdVille()){
					throw new Exception("Try to add too city with the same id : " + ville.getNomVille() + " : " + villeAccontrole.getNomVille());
				}
			}
			sesVilles.add(ville);
			return true;
		}else throw new Exception("City already know " + ville.getNomVille());
	  }
	  
	  public boolean ajouterRoute(Route r) throws Exception {
		if(!routeConnue(r)){
			for (Iterator i = sesRoutes.iterator(); i.hasNext();) {
				Route routeAccontrole = (Route) i.next();
				if(r.getIdRoute()==routeAccontrole.getIdRoute()){
					throw new Exception("Try to add too city with the same id : " + r.getNomRoute() + " : " + routeAccontrole.getNomRoute());
				}
			}
			sesRoutes.add(r);
			return true;
		}else throw new Exception("Road already know " + r.getNomRoute());
	  }

	private boolean routeConnue(Route r) {
		if(sesRoutes.contains(r)){
			return true;
		}else {
			for (Iterator i = sesRoutes.iterator(); i.hasNext();) {
				Route RouteAccontrole = (Route) i.next();
				if(r.getNomRoute()==RouteAccontrole.getNomRoute()){
					return true;
				}
			}
			return false;
		}
	}

	private boolean villeConnu(noyau.Ville ville) {
		if(sesVilles.contains(ville)){
			return true;
		}else {
			for (Iterator i = sesVilles.iterator(); i.hasNext();) {
				Ville villeAccontrole = (Ville) i.next();
				if(ville.getNomVille()==villeAccontrole.getNomVille()){
					return true;
				}
			}
			return false;
		}
	}
	
	public int getNewIdVille(){
		lastIdVille++;
		return lastIdVille;
	}
	
	public int getNewIdRoute() {
		lastIdRoute++;
		return lastIdRoute;
	}
	public static Ville getVille(String nomVille) throws Exception {
		for(int i = 0; i < sesVilles.size(); i++){
			if(sesVilles.get(i).getNomVille().equalsIgnoreCase(nomVille))
				return sesVilles.get(i);
		}throw new Exception("Ville " + nomVille + " is unknow by the système");
	}

	public boolean existeVille(String nomVille) {
		for (Iterator iter = sesVilles.iterator(); iter.hasNext();) {
			Ville v = (Ville) iter.next();
			if(v.getNomVille().equalsIgnoreCase(nomVille))
				return true;
		}
		return false;
	}
}
