package org.jgrapht.alg;


import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import org.jgrapht.Graph;
import org.jgrapht.WeightedGraph;
import org.jgrapht.graph.Multigraph;

public class ListeDeKChemins<V, E> {
	
	List<RankingPathElement<V, E>> lesChemins;
	Graph<V, E> graph;
	V vDepart;
	V vArrivee;
	
	public ListeDeKChemins(Graph<V, E> g, V vDepart, V vArrivee, int nbChemins){
		graph = g;
		this.vDepart=vDepart;
		this.vArrivee=vArrivee;
		KShortestPaths<V, E> algoDeChemin=new KShortestPaths<V, E>(g, vDepart, nbChemins);
		lesChemins = algoDeChemin.getPathElements(vArrivee);
	}
	
	public ListeDeKChemins(Multigraph<V, E> g, V vDepart, V vArrivee, int nbChemins){
		graph = g;
		this.vDepart=vDepart;
		this.vArrivee=vArrivee;
		KShortestPaths<V, E> algoDeChemin=new KShortestPaths<V, E>(g, vDepart, nbChemins);
		lesChemins = algoDeChemin.getPathElements(vArrivee);
	}
	
	public List<E> getEdgesDuChemin(int k){
		return lesChemins.get(k).createEdgeListPath();
	}
	
	public double getWeightDuChemin(int k){
		return lesChemins.get(k).getWeight();
	}
	
	@SuppressWarnings("unchecked")
	public List<V> getVertexDuChemin(int k){
		List<V> verticles = new Vector<V>();
		verticles.add(vDepart);
		
		V v1;
		V v2;
		V vP = vDepart;
		List<E> edges = lesChemins.get(k).createEdgeListPath();
		if(edges.isEmpty())
			return null;
		
		for (Iterator iter = edges.iterator(); iter.hasNext();) {
			E unEdge = (E) iter.next();
			v1=graph.getEdgeSource(unEdge);
			v2=graph.getEdgeTarget(unEdge);
			if(v1.equals(vP)){
				verticles.add(v2);
				vP=v2;
			}else{
				verticles.add(v1);
				vP=v1;
			}
		}
		return verticles;
	}
	
	public int size(){
		return lesChemins.size();
	}

	public void seDecrire(){
		for (int i = 0; i < this.size(); i++) {
			System.out.println("Chemin : "+(i+1)+" cout : "+this.getWeightDuChemin(i));
			List<V> villes = this.getVertexDuChemin(i);
			for (Iterator iter = villes.iterator(); iter.hasNext();) {
				V uneVille = (V) iter.next();
				System.out.println("Ville : "+uneVille.toString());
			}
		}
		
	}
}
