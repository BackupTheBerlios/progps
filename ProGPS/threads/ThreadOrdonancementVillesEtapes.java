package threads;

import java.util.*;

import exceptions.ExceptionGraph;
import exceptions.ExceptionRecherche;

import noyau.*;

public class ThreadOrdonancementVillesEtapes<V, T> extends Thread implements Comparator<Double> {
	private MyWeightedMultigraph graph=null;
	private Ville villeDep = null;
	private Ville villeArr = null;
	private Set<Ville> nonOrdonnees = null;
	private List<Ville> ordonnees = null;
	private List cles = null;
	private boolean upToDate = false;
	private TreeMap<Double, Ville> collection;
	
	public ThreadOrdonancementVillesEtapes(
			MyWeightedMultigraph graph,
			Ville villeDep,
			Ville villeArr, 
			Set<Ville> nonOrd){
		this.graph=graph;
		this.villeDep = villeDep;
		this.villeArr = villeArr;
		nonOrdonnees=nonOrd;
	}

	/**
	 * Méthode pour lire le retour du thread
	 * @return null si le calcul n'est pas fini, 
	 *  	sinon les villes dans le meilleur ordre 
	 */
	public List<Ville> getVillesOrdonnees(){
		if (upToDate) {
			return ordonnees;
		} else {
			return null;
		}
	}
	
	/**
	 * Méthode pour modifier les paramètres du thread
	 * @param villeDep : La ville de départ de l'iti
	 * @param villeArr : Villeille d'arrivée de l'iti
	 * @param nonOrdonnees : un Set de villes étapes (peut être null)
	 */
	public void setVillesEtapes(
			Ville villeDep,
			Ville villeArr, 
			Set<Ville> nonOrdonnees) {
		this.villeDep = villeDep;
		this.villeArr = villeArr;
		this.nonOrdonnees = nonOrdonnees;
		upToDate=false;
	}
	
	public void ordonne(){
		
	}

	public void run() {
		while( !isInterrupted()) {
			if (!upToDate && graph!=null && villeDep!=null && villeArr!=null && nonOrdonnees!=null) {
				ordonnees = new ArrayList<Ville>();

				collection = new TreeMap<Double, Ville>();
				// Liste toutes les villes etape
				for (Iterator<Ville> iter = nonOrdonnees.iterator(); iter.hasNext();) {
					Ville uneVilleEtape = (Ville) iter.next();

					Itineraire leChemin;
					try {
						leChemin = graph.trouverLeChemin(villeDep, uneVilleEtape, null, null);
						collection.put((double)leChemin.getLongueurTotal(), uneVilleEtape);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				//Collections.sort(collection, collection.comparator());
				

		
			}
		}
		

	}
	public int compare(Double d1, Double d2) {
		List<Double> cles = new ArrayList<Double>(collection.keySet());
		Double v1, v2;
		v1=cles.get(d1.intValue());
		v2=cles.get(d2.intValue());
		if (v1>v2)
			return 1;
		else if (v2==v1)
			return 0;
		else return -1;
	}
	
}
