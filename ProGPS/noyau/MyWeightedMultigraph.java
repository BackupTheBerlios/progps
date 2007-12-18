package noyau;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import org.jgrapht.EdgeFactory;
import org.jgrapht.alg.DijkstraShortestPath;
import org.jgrapht.alg.ListeDeKChemins;
import org.jgrapht.graph.ClassBasedEdgeFactory;
import org.jgrapht.graph.WeightedMultigraph;

import exceptions.ExceptionGraph;
import exceptions.ExceptionRecherche;


@SuppressWarnings("serial")
public class MyWeightedMultigraph extends WeightedMultigraph<Ville, Troncon> {
	// Constantes
	private static final double const_indispo=10000000;
	private static final double const_pref1=1000000;
	private static final double const_pref2=100000;
	private static final double const_pref3=10000;
	private static final double const_pref4=1000;
	private static final double const_pref5=100;
	private static final double const_pref6=10;
	private boolean plusCourt=true;
	private Set<Ville> aEviter=new HashSet<Ville>();
	private List<Ville> listeVillesEtapes=new ArrayList<Ville>();
	private List<Preference> preferences = new Vector<Preference>();
	private ArrayList<Double> tab_const = new ArrayList<Double>();
	private int vitesseMin=50;

	public void activerPref(Preference p){
		int k=this.preferences.indexOf(p);
		switch (k) {
		case 1:
			tab_const.set(1, const_pref1);
			break;
		case 2:
			tab_const.set(2, const_pref2);
			break;
		case 3:
			tab_const.set(3, const_pref3);
			break;
		case 4:
			tab_const.set(4, const_pref4);
			break;
		case 5:
			tab_const.set(5, const_pref5);
			break;
		case 6:
			tab_const.set(6, const_pref6);
			break;
		default:
			break;
		}
	}

	public ArrayList<Double> getPoidsPref() {
		return tab_const;
	}

	public void desactiverPref(Preference p){
		int k=this.preferences.indexOf(p);
		switch (k) {
		case 1:
			tab_const.set(1, 0.0);
			break;
		case 2:
			tab_const.set(2, 0.0);
			break;
		case 3:
			tab_const.set(3, 0.0);
			break;
		case 4:
			tab_const.set(4, 0.0);
			break;
		case 5:
			tab_const.set(5, 0.0);
			break;
		case 6:
			tab_const.set(6, 0.0);
			break;
		default:
			break;
		}
	}

	/** Inherited code
	 * Creates a new weighted multigraph.
	 *
	 * @param edgeClass class on which to base factory for edges
	 */
	public MyWeightedMultigraph(Class<? extends Troncon> edgeClass)
	{
		this(new ClassBasedEdgeFactory<Ville, Troncon>(edgeClass));
	}

	/** Inherited code
	 * Creates a new weighted multigraph with the specified edge factory.
	 *
	 * @param ef the edge factory of the new graph.
	 */
	public MyWeightedMultigraph(EdgeFactory<Ville, Troncon> ef)
	{
		super(ef);
		tab_const.add(0, const_pref1);
		tab_const.add(1, const_pref2);
		tab_const.add(2, const_pref3);
		tab_const.add(3, const_pref4);
		tab_const.add(4, const_pref5);
		tab_const.add(5, const_pref6);


		// On initialise les préférences
		preferences.add(Preference.Villes);
		preferences.add(Preference.VillesAEviter);
		preferences.add(Preference.Touristique);
		preferences.add(Preference.Vitesse);
		preferences.add(Preference.Payant);
		preferences.add(Preference.Radars);
	}

	public Ville ajouterUneVille(String nom) throws ExceptionGraph{
		// Teste si une ville ne porte pas déjà le même nom
		Set<Ville> lesVertex = this.vertexSet();
		for (Iterator iter = lesVertex.iterator(); iter.hasNext();) {
			Ville unVertex = (Ville) iter.next();
			Ville uneVille = (Ville) unVertex;
			if (uneVille.getNomVille().equals(nom))
				throw new ExceptionGraph("Le graph contient déjà une ville de nom : "+nom);
		}
		Ville nouvelleVille = new Ville(nom);
		this.addVertex((Ville)nouvelleVille);

		return nouvelleVille;
	}

	public Troncon ajouterUnTroncon(Ville ville1, Ville ville2){
		Troncon theEdge = this.addEdge(ville1, ville2);
		Troncon troncon=null;

		troncon = (Troncon) theEdge;
		return troncon;
	}

	public Ville getVille(String nom) throws ExceptionGraph{
		for (Iterator iter = this.vertexSet().iterator(); iter.hasNext();) {
			Ville uneVille = (Ville) iter.next();
			if(uneVille.getNomVille().equalsIgnoreCase(nom))
				return uneVille;
		}
		throw new ExceptionGraph("La ville "+nom+" n'est pas dans le graph.");
	}

	//En parametre : soit les préférences courantes, soit globales
	public void setPreferences(List<Preference> p) {
		this.preferences=p;
	}

	public List<Preference> getPreferences(){
		return this.preferences;
	}

	public boolean villeExiste(String nom){
		for (Ville uneVille : this.vertexSet()) {
			if(uneVille.getNomVille().equalsIgnoreCase(nom))
				return true;
		}
		return false;
	}

	public void setVitesseMin(int v){
		this.vitesseMin=v;
	}
	public double getEdgeWeight(Troncon t)
	{
//		Méthode de calcul
		double poids;

		if (!this.plusCourt)
			poids=((double)t.getLongueur()/t.getVitesse())/Troncon.getTempsMaxi();
		else
			poids=(double)t.getLongueur()/Troncon.getLongeurMaxi();

		if ( !t.isDispo() || t.isRelieVilleIndispo())
			poids+=const_indispo;

		int cpt=0;
		for (Preference p : this.preferences) {
			if (p.name().equalsIgnoreCase("Radar") || p.name().equalsIgnoreCase("Payant") || p.name().equalsIgnoreCase("Touristique")) {
				for (Etat e : t.getSesEtats()) {
					if (e.name().equalsIgnoreCase(p.name()) || (p.name().equalsIgnoreCase("Touristique") && !e.name().equalsIgnoreCase("Touristique")))
						poids+=this.tab_const.get(cpt);
				}
			}
			else if (p.name().equalsIgnoreCase("VillesAEviter")) {
				if (t.isRelieVille(this.aEviter))
					poids+=this.tab_const.get(cpt);
			}else if(p.name().equalsIgnoreCase("Vitesse"))
				if(t.getVitesse()<vitesseMin)
					poids+=this.tab_const.get(cpt);
			cpt++;
		}
		return poids;
	}

	public void seDecrire(){
		System.out.println("Nombre de villes : "+this.vertexSet().size());
		Set<Troncon> lesTroncons=this.edgeSet();
		for (Troncon theEdge : lesTroncons) {
			Troncon troncon = (Troncon) theEdge;
			System.out.println("**************");
			System.out.println("De :"+this.getEdgeSource(theEdge).toString());
			System.out.println("A :"+this.getEdgeTarget(theEdge).toString());
			System.out.println("Dist:"+troncon.getLongueur()+"km");
			System.out.println("Vit:"+troncon.getVitesse()+"km/h");
		}
	}

	public List<Itineraire> trouver3Chemins(
			Ville villeDepart, 
			Ville villeArrivee,
			Set<Ville> villesAEviter,
			List<Ville> villesEtapes) throws ExceptionRecherche{


//		Vérification qu'une ville étape n'est pas à éviter
		if (villesEtapes!=null && villesAEviter!=null) {
			for (Iterator iter = villesEtapes.iterator(); iter.hasNext();) {
				Ville uneEtape = (Ville) iter.next();
				if(villesAEviter.contains(uneEtape)){
					throw new ExceptionRecherche("Impossible de trouver des chemins quand une ville étape est une ville à éviter");
				}
			}
		}

//		Initialisation
		aEviter=villesAEviter;
		listeVillesEtapes=new ArrayList<Ville>();
		if(villesEtapes!=null)
			listeVillesEtapes.addAll(villesEtapes);

		listeVillesEtapes.add(villeArrivee);
		List<Itineraire> result = new ArrayList<Itineraire>();

		boolean premiereEtape=true;
		List<Itineraire> itineraireDeEtape = new ArrayList<Itineraire>();
		Ville villePrecedente=villeDepart;
		for (Ville villeSuivante : listeVillesEtapes) {
			itineraireDeEtape=new ArrayList<Itineraire>();
			for (Itineraire itineraire : itineraireDeEtape) {
				itineraire.setVilleArrivee(villeSuivante);
			}

			ListeDeKChemins<Ville, Troncon> liste = new ListeDeKChemins<Ville, Troncon>(this, villePrecedente, villeSuivante, 3);

			Itineraire unIti;
			// On liste des 3 chemins (il se peut qu'il y ait moins de 3 chemins
			for (int i = 0; i < liste.size(); i++) {
				// On liste tous les troncons
				unIti = new Itineraire();
				unIti.setVilleDepart(villeDepart);
				unIti.setVilleArrivee(villeArrivee);

				List<Troncon> lesTroncons = liste.getEdgesDuChemin(i);
				for (Iterator iter = lesTroncons.iterator(); iter.hasNext();) {
					Troncon unTroncon = (Troncon) iter.next();
					unIti.addUnTroncon(unTroncon);
				}

				itineraireDeEtape.add(unIti);
			}

			if(premiereEtape){
				premiereEtape=false;
				if(itineraireDeEtape.size()==0)
					throw new ExceptionRecherche("Impossible de trouver des chemins");
				result=itineraireDeEtape;
			}else{
				if(result.size()>itineraireDeEtape.size()){
					int i=0;
					for (Itineraire unItineraire : itineraireDeEtape) {
						result.get(i).concat(unItineraire);
						i++;
					}
					if(i==1 && result.size()>1){
						result.get(1).concat(itineraireDeEtape.get(0));
						if(result.size()>2)
							result.get(2).concat(itineraireDeEtape.get(0));
					}
					if(i==2 && result.size()>2){
						result.get(2).concat(itineraireDeEtape.get(1));
					}
				}else if(result.size()<itineraireDeEtape.size()){
					Itineraire partieFixe=result.get(0);
					int i=0;
					for (Itineraire unItineraire : result) {
						unItineraire.concat(itineraireDeEtape.get(i));
						i++;
					}
					if(i==1 && itineraireDeEtape.size()>1){
						result.add(partieFixe);
						result.get(1).concat(itineraireDeEtape.get(1));
						if(itineraireDeEtape.size()>2){
							result.add(partieFixe);
							result.get(2).concat(itineraireDeEtape.get(2));
						}
					}else if(i==2 && itineraireDeEtape.size()>2){
						result.add(partieFixe);
						result.get(2).concat(itineraireDeEtape.get(2));

					}
				}else if(result.size()==itineraireDeEtape.size()){
					int i=0;
					for (Itineraire unItineraire : result) {
						unItineraire.concat(itineraireDeEtape.get(i));
						i++;
					}
				}
			}
			villePrecedente=villeSuivante;
		}
		for (Itineraire itineraire : result) {
			if(itineraire.getLesTroncons()!=null && itineraire.getLesTroncons().size()>0)
				itineraire.setTronconCourant(itineraire.getLesTroncons().get(0));
		}
		
		return result;
	}


	public Itineraire trouverLeChemin(
			Ville villeDepart, 
			Ville villeArrivee,
			Set<Ville> villesAEviter,
			List<Ville> villesEtapes) throws Exception{
		
//		Vérification qu'une ville étape n'est pas à éviter
		if (villesEtapes!=null && villesAEviter!=null) {
			for (Iterator iter = villesEtapes.iterator(); iter.hasNext();) {
				Ville uneEtape = (Ville) iter.next();
				if(villesAEviter.contains(uneEtape)){
					throw new ExceptionRecherche("Impossible de trouver des chemins quand une ville étape est une ville à éviter");
				}
			}
		}

//		Initialisation
		aEviter=villesAEviter;

		listeVillesEtapes=new ArrayList<Ville>();
		if(villesEtapes!=null)
			listeVillesEtapes.addAll(villesEtapes);
		listeVillesEtapes.add(villeArrivee);

		Itineraire result = new Itineraire();
		result.setVilleDepart(villeDepart);
		result.setVilleArrivee(villeArrivee);

		Ville villePrecedente=villeDepart;
		for (Ville villeSuivante : listeVillesEtapes) {
			Itineraire unItineraireDeEtape = new Itineraire();
			unItineraireDeEtape.setVilleArrivee(villeSuivante);

			List<Troncon> listOfEdges = DijkstraShortestPath.findPathBetween(this, (Ville)villePrecedente, (Ville)villeSuivante);

			for (Iterator iter = listOfEdges.iterator(); iter.hasNext();) {
				Troncon anEdge = (Troncon) iter.next();
				Troncon unTroncon = (Troncon) anEdge;
				unItineraireDeEtape.addUnTroncon(unTroncon);
			}
			result.concat(unItineraireDeEtape);
			villePrecedente=villeSuivante;
		}
		if(result.getLesTroncons()!=null && result.getLesTroncons().size()>0)
			result.setTronconCourant(result.getLesTroncons().get(0));
		
		return result;
	}

	public boolean addVilleAEviter(Ville v){
		return aEviter.add(v);
	}

	public boolean removeVilleAEviter(Ville v){
		return aEviter.remove(v);
	}

	public void setPlusCourt(boolean plusCourt) {
		this.plusCourt = plusCourt;
	}
}
