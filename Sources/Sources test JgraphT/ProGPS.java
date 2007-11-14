import java.util.*;

import org.jgrapht.alg.DijkstraShortestPath;
import org.jgrapht.graph.WeightedMultigraph;


public class ProGPS {

	// Objet qui contient la représentation du graph  
	WeightedMultigraph<Ville, Troncon> graph;

	private List<Route> sesRoutes = new Vector<Route>();

	private void initialiseGraphComplet(int nbVilles){
		sesRoutes = new Vector<Route>();
		graph = new WeightedMultigraph<Ville, Troncon>( Troncon.class );

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
				if(uneVille!=nouvelleVille){
					Troncon nouveauTr = graph.addEdge(uneVille, nouvelleVille);
					// Pose le poids du tronçon
					graph.setEdgeWeight(nouveauTr, 10.0f);
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

		Ville villeDeParcours = villeDepart;
		for (Iterator iter = troncon.iterator(); iter.hasNext();) {
			Troncon unTroncon = (Troncon) iter.next();

			System.out.println("Partir de "+villeDeParcours.getNomVille()+" sur une distance de : "+unTroncon.getLongueur());

			Ville ville1 = graph.getEdgeSource(unTroncon);
			Ville ville2 = graph.getEdgeTarget(unTroncon);

			if (villeDeParcours==ville1) {
				villeDeParcours=ville2;
			} else {
				villeDeParcours=ville1;
			}

			System.out.println("Aller en direction de : "+villeDeParcours.getNomVille());
		}
	}

	private List<Ville> prendreDeuxVillesuHasard(){
		List<Ville> res = new Vector<Ville>();

		Random rand = new Random();
		
		while ((res.size()==0) || (res.get(0)==res.get(1))){
			res.clear();
			res.add(null);
			res.add(null);
			
			int nbr = (int)Math.round(rand.nextFloat()*graph.vertexSet().size());
			int i=0;
			Iterator iter = graph.vertexSet().iterator();
			while ( iter.hasNext() && i<nbr ) {
				res.set(0, (Ville) iter.next());
				i++;
			}

			nbr = (int)Math.round(rand.nextFloat()*graph.vertexSet().size());
			i=0;
			iter = graph.vertexSet().iterator();
			while ( iter.hasNext() && i<nbr ) {
				res.set(1, (Ville) iter.next());
				i++;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		ProGPS me = new ProGPS();
		me.initialiseGraphComplet(3000);

		List<Ville> deuxVilles = me.prendreDeuxVillesuHasard();
		me.chercheChemin(deuxVilles.get(0), deuxVilles.get(1));

		/*Demo dem = new Demo();
		dem.calcul();*/
	}

}
