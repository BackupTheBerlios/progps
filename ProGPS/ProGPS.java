

import java.util.*;


import org.jgrapht.alg.DijkstraShortestPath;
import org.jgrapht.alg.ListeDeKChemins;

/*
 * Lancer avec -Xmx512M -Xms512M dans les arguments de la VM
 */
public class ProGPS {

	// Objet qui contient la représentation du graph  
	MyWeightedMultigraph<Ville, Troncon> graph;
	private List<Route> sesRoutes = new Vector<Route>();

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
	

	private void chercheChemin(Ville villeDepart, Ville villeArrivee){
		System.out.println("Recherche chemin de : "+villeDepart.getNomVille()+" à "+villeArrivee.getNomVille());
		System.out.println("-----------------------------------");
		
		long debut = System.currentTimeMillis();
		List<Troncon> troncon = DijkstraShortestPath.findPathBetween(graph, villeDepart, villeArrivee);
		long fin = System.currentTimeMillis();

		System.out.println("Temps de calcul : "+(fin-debut)+"ms");

		double coutTotal=0;
		Ville villeDeParcours = villeDepart;
		for (Iterator iter = troncon.iterator(); iter.hasNext();) {
			Troncon unTroncon = (Troncon) iter.next();

			System.out.println("Partir de "+villeDeParcours.getNomVille());

			Ville ville1 = graph.getEdgeSource(unTroncon);
			Ville ville2 = graph.getEdgeTarget(unTroncon);

			if (villeDeParcours.equals(ville1)) {
				villeDeParcours=ville2;
			} else {
				villeDeParcours=ville1;
			}

			coutTotal+=graph.getEdgeWeight(unTroncon);
			System.out.println("Aller en direction de : "+villeDeParcours.getNomVille()+" sur une distance de : "+unTroncon.getLongueur());
		}
		System.out.println("========= Cout total de l'iti : "+coutTotal);
	}
	
	private void chercheKChemins(Ville villeDepart, Ville villeArrivee, int nbChemins){
		System.out.println("Recherche chemin de : "+villeDepart.getNomVille()+" à "+villeArrivee.getNomVille());
		System.out.println("-----------------------------------");
		
		long debut = System.currentTimeMillis();
		ListeDeKChemins<Ville, Troncon> liste = new ListeDeKChemins<Ville, Troncon>(graph, villeDepart, villeArrivee, nbChemins);
		long fin = System.currentTimeMillis();
		System.out.println("Temps de calcul : "+(fin-debut)+"ms");

		for (int i = 0; i < liste.size(); i++) {
			System.out.println("Chemin : "+(i+1)+" cout : "+liste.getWeightDuChemin(i));
			List<Ville> villes = liste.getVertexDuChemin(i);
			for (Iterator iter = villes.iterator(); iter.hasNext();) {
				Ville uneVille = (Ville) iter.next();
				System.out.println("Ville : "+uneVille.getNomVille());
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

	private void decrireRoutesGraph(){
		Set<Troncon> lesTroncons=graph.edgeSet();
		for (Troncon troncon : lesTroncons) {
			System.out.println("**************");
			System.out.println("De :"+graph.getEdgeSource(troncon).getNomVille());
			System.out.println("A :"+graph.getEdgeTarget(troncon).getNomVille());
			System.out.println("Dist:"+troncon.getLongueur()+"km");
			System.out.println("Vit:"+troncon.getVitesse()+"km/h");
		}
	}
	
	public static void main(String[] args) {
		ProGPS me = new ProGPS();
		me.initialiseGraphComplet(10);
		
//		me.decrireRoutesGraph();
		List<Ville> deuxVilles = me.prendreDeuxVillesAuHasard();
		List<Ville> villesAEviter;
		do {
			villesAEviter = me.prendreDeuxVillesAuHasard();
		} while (villesAEviter.contains(deuxVilles.get(0)) || villesAEviter.contains(deuxVilles.get(1)));
		
		
		System.out.println("******************************");
		System.out.println("Méthode 1");
		me.chercheChemin(deuxVilles.get(0), deuxVilles.get(1));
		

		System.out.println("");
		System.out.println("******************************");
		System.out.println("Méthode 2");
		me.chercheKChemins(deuxVilles.get(0), deuxVilles.get(1), 4);
		
		System.out.println("");
		System.out.println("******************************");
		System.out.println("Méthode 3");
		System.out.println("Eviter : "+villesAEviter.get(0).getNomVille()+", "+villesAEviter.get(1).getNomVille());
		ListeDeKChemins<Ville, Troncon> lesChemins = me.graph.chercheKItineraires(deuxVilles.get(0), deuxVilles.get(1),villesAEviter, 4);
		lesChemins.seDecrire();
	}

}
