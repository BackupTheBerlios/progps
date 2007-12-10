

import java.util.*;


import noyau.Itineraire;
import noyau.MyWeightedMultigraph;
import noyau.Route;
import noyau.Troncon;

import org.jgrapht.alg.DijkstraShortestPath;
import org.jgrapht.alg.ListeDeKChemins;

import threads.ThreadOrdonancementVillesEtapes;

import exceptions.ExceptionRecherche;

import noyau.Ville;

/*
 * Lancer avec -Xmx512M -Xms512M dans les arguments de la VM
 */
public class SingletonProgps {

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
		SingletonProgps me = new SingletonProgps();

		// TODO Etape 1 : Lancement de l'interface
		// TODO Etape 2 : Lancement du chargement XML
		// TODO Etape 3 : Ouverture de l'interface sur la fenêtre principale
		
		me.initialiseGraphComplet(100);
		List deuxVilles = me.prendreDeuxVillesAuHasard();
		
		ThreadOrdonancementVillesEtapes<Ville, Troncon> leThread = new ThreadOrdonancementVillesEtapes<Ville, Troncon>(me.graph, (Ville)deuxVilles.get(0), (Ville)deuxVilles.get(1), new HashSet<Ville>(deuxVilles));
		leThread.start();
		
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

}
