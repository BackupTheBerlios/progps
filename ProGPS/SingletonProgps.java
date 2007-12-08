

import java.util.*;


import org.jgrapht.alg.DijkstraShortestPath;
import org.jgrapht.alg.ListeDeKChemins;

/*
 * Lancer avec -Xmx512M -Xms512M dans les arguments de la VM
 */
public class SingletonProgps {

	// Objet qui contient la repr�sentation du graph  
	MyWeightedMultigraph<Ville, Troncon> graph;
	private List<Route> sesRoutes = new Vector<Route>();

	private void initialiseGraphComplet(int nbVilles){
		sesRoutes = new Vector<Route>();
		graph = new MyWeightedMultigraph<Ville, Troncon>( Troncon.class );

		// Creation de 1 route
		Route laRoute = new Route("A6", 5);
		sesRoutes.add(laRoute);

		// Cr�e les N villes
		for (int i = 0; i < nbVilles; i++) {
			Ville nouvelleVille = new Ville("Ville"+i,1,false);
			graph.addVertex(nouvelleVille);

			// On relie la nouvelle ville � toutes les autres
			for (Iterator iter = graph.vertexSet().iterator(); iter.hasNext();) {
				Ville uneVille = (Ville) iter.next();
//				Test pour v�rifier qu'on essaie pas d'ajouter une route qui parte
//				et arrive � la m�me ville
				if(!uneVille.equals(nouvelleVille)){
					Troncon nouveauTr = graph.addEdge(uneVille, nouvelleVille);
//					On attribue la route au tron�on
					nouveauTr.setSaRoute(laRoute);
//					On indique les 2 villes qui encadrent le troncon
					nouveauTr.setSesVilles(uneVille, nouvelleVille);
					
//					On g�n�re des valeurs al�atoires pour le troncon
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
		// TODO Etape 3 : Ouverture de l'interface sur la fen�tre principale 
	}

}
