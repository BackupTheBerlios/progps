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
import org.jgrapht.graph.Multigraph;
import org.jgrapht.graph.WeightedMultigraph;

import exceptions.ExceptionGraph;
import exceptions.ExceptionRecherche;


public class MyWeightedMultigraph extends WeightedMultigraph<Ville, Troncon> {
	// Constantes
	private static final double const_indispo=Double.MAX_VALUE;
	private static final double const_pref1=1000000;
	private static final double const_pref2=100000;
	private static final double const_pref3=10000;
	private static final double const_pref4=1000;
	private static final double const_pref5=100;
	private static final double const_pref6=10;
	private boolean plusCourt=true;
	private Set<Ville> aEviter=new HashSet<Ville>();
	private Set<Ville> etapes=new HashSet<Ville>();
	private List<Preference> preferences = new Vector<Preference>();
	private ArrayList<Double> tab_const = new ArrayList<Double>();

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
    
    public void setAEviter(Set<Ville> sv) {
    	this.aEviter=sv;
    }
    
    public void setEtapes(Set<Ville> sv) {
    	this.etapes=sv;
    }
    
    
    public boolean villeExiste(String nom){
    	for (Ville uneVille : this.vertexSet()) {
			if(uneVille.getNomVille().equalsIgnoreCase(nom))
				return true;
		}
    	return false;
    }
    
    public double getEdgeWeight(Troncon t)
    {
//  		Méthode de calcul
    		double poids=t.getLongueur();
    		if (!this.plusCourt)
    			poids/=t.getVitesse();
    		int cpt=0;
    		if (!t.isDispo())
    			poids=const_indispo;
    		else {
    			for (Preference p : this.preferences) {
    				if (p.name().equalsIgnoreCase("Radar") || p.name().equalsIgnoreCase("Payant") || p.name().equalsIgnoreCase("Touristique")) {
	    				for (Etat e : t.getSesEtats()) {
	    					if (e.name().equalsIgnoreCase(p.name()) && !e.name().equalsIgnoreCase("Touristique"))
	    						poids+=this.tab_const.get(cpt);
	    				}
    				}
    				else if (p.name().equalsIgnoreCase("VillesAEviter")) {
    					if (t.isRelieVille(this.aEviter))
    						poids+=this.tab_const.get(cpt);
    				}
    				cpt++;
    			}
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
			Set<Ville> villesEtapes) throws ExceptionRecherche{
    	
//    	Vérification qu'une ville étape n'est pas à éviter
    	if (villesEtapes!=null && villesAEviter!=null) {

    		for (Iterator iter = villesEtapes.iterator(); iter.hasNext();) {
    			Ville uneEtape = (Ville) iter.next();
    			if(villesAEviter.contains(uneEtape)){
    				throw new ExceptionRecherche("Impossible de trouver des chemins quand une ville étape est une ville à éviter");
    			}
    		}
    	}

//    	 Initialisation
    	aEviter=villesAEviter;
    	List<Itineraire> result = new ArrayList<Itineraire>();
    	
    	ListeDeKChemins<Ville, Troncon> liste = new ListeDeKChemins<Ville, Troncon>((Multigraph)this, villeDepart, villeArrivee, 3);
    	
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
    		
    		result.add(unIti);
		}
    	return result;
    }
    

	public Itineraire trouverLeChemin(
    		Ville villeDepart, 
			Ville villeArrivee,
			Set<Ville> villesAEviter,
			Set<Ville> villesEtapes) throws Exception{
    	
//    	Vérification qu'une ville étape n'est pas à éviter
    	if (villesEtapes!=null && villesAEviter!=null) {
    		for (Iterator iter = villesEtapes.iterator(); iter.hasNext();) {
    			Ville uneEtape = (Ville) iter.next();
    			if(villesAEviter.contains(uneEtape)){
    				throw new ExceptionRecherche("Impossible de trouver des chemins quand une ville étape est une ville à éviter");
    			}
    		}
    	}
    	
//    	 Initialisation
    	aEviter=villesAEviter;
    	Itineraire theResult = new Itineraire();
    	theResult.setVilleDepart(villeDepart);
    	theResult.setVilleArrivee(villeArrivee);
    	
    	List<Troncon> listOfEdges = DijkstraShortestPath.findPathBetween(this, (Ville)villeDepart, (Ville)villeArrivee);
    	
    	for (Iterator iter = listOfEdges.iterator(); iter.hasNext();) {
    		Troncon anEdge = (Troncon) iter.next();
    		Troncon unTroncon = (Troncon) anEdge;
    		theResult.addUnTroncon(unTroncon);
		}
    	return theResult;
    }
}
