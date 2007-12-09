package noyau;



import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.jgrapht.EdgeFactory;
import org.jgrapht.alg.DijkstraShortestPath;
import org.jgrapht.alg.ListeDeKChemins;
import org.jgrapht.graph.ClassBasedEdgeFactory;
import org.jgrapht.graph.Multigraph;
import org.jgrapht.graph.WeightedMultigraph;

import exceptions.ExceptionGraph;
import exceptions.ExceptionRecherche;



public class MyWeightedMultigraph<V, E> extends WeightedMultigraph<V, E> {
	// Constantes
	private double const_indispo=1000000;
	private double const_ville_a_eviter=1000;
	
	private Set<Ville> aEviter=new HashSet<Ville>();
	private Set<Ville> etapes=new HashSet<Ville>();

    /** Inherited code
     * Creates a new weighted multigraph with the specified edge factory.
     *
     * @param ef the edge factory of the new graph.
     */
    public MyWeightedMultigraph(EdgeFactory<V, E> ef)
    {
        super(ef);
    }

    /** Inherited code
     * Creates a new weighted multigraph.
     *
     * @param edgeClass class on which to base factory for edges
     */
    public MyWeightedMultigraph(Class<? extends E> edgeClass)
    {
        this(new ClassBasedEdgeFactory<V, E>(edgeClass));
    }

    public Ville ajouterUneVille(String nom) throws ExceptionGraph{
    	// Teste si une ville ne porte pas déjà le même nom
    	Set<V> lesVertex = this.vertexSet();
    	for (Iterator iter = lesVertex.iterator(); iter.hasNext();) {
			V unVertex = (V) iter.next();
			if (unVertex instanceof Ville) {
				Ville uneVille = (Ville) unVertex;
				if (uneVille.getNomVille().equals(nom))
					throw new ExceptionGraph("Le graph contient déjà une ville de nom : "+nom);
			} else {
				throw new ExceptionGraph("Le graph contient des objets inconnus : "+unVertex.getClass()+" au lieu de Ville");
			}
			
		}
    	Ville nouvelleVille = new Ville(nom);
    	this.addVertex((V)nouvelleVille);
    	
    	return nouvelleVille;
    }
    
    public Troncon ajouterUnTroncon(V ville1, V ville2) throws ExceptionGraph{
    	E theEdge = this.addEdge(ville1, ville2);
    	Troncon troncon=null;
    	if (theEdge instanceof Troncon) {
			troncon = (Troncon) theEdge;
		}else{
    		throw new ExceptionGraph("Tentative d'ajouter un objet non Troncon pour les arcs");
    	}
    	return troncon;
    }
    
    public double getEdgeWeight(E e)
    {
    	if (e instanceof Troncon) {
//  		Méthode de calcul
    		double poids=0.0;

    		if (!((Troncon) e).isDispo()) poids+=const_indispo;
    		if (aEviter!=null && ((Troncon) e).isRelieVille(aEviter)){
    			poids+=const_ville_a_eviter;
    		}
    		poids+=((Integer)((Troncon) e).getLongueur()).doubleValue()/((Integer)((Troncon) e).getVitesse()).doubleValue();
    		return poids;
    	} else {
    		return Double.MAX_VALUE;
    	}
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
    	
    	List<E> listOfEdges = DijkstraShortestPath.findPathBetween(this, (V)villeDepart, (V)villeArrivee);
    	
    	for (Iterator iter = listOfEdges.iterator(); iter.hasNext();) {
			E anEdge = (E) iter.next();
			if (anEdge instanceof Troncon) {
				Troncon unTroncon = (Troncon) anEdge;
				theResult.addUnTroncon(unTroncon);
			}else{
				throw new ExceptionGraph("Le graph contient des objets inconnus : "+anEdge.getClass()+" au lieu de Troncon");
			}
		}
    	return theResult;
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
    

	public void seDecrire() throws ExceptionGraph{
		Set<E> lesTroncons=this.edgeSet();
		for (E theEdge : lesTroncons) {
			if (theEdge instanceof Troncon) {
				Troncon troncon = (Troncon) theEdge;
				System.out.println("**************");
				System.out.println("De :"+this.getEdgeSource(theEdge).toString());
				System.out.println("A :"+this.getEdgeTarget(theEdge).toString());
				System.out.println("Dist:"+troncon.getLongueur()+"km");
				System.out.println("Vit:"+troncon.getVitesse()+"km/h");
			}else
				throw new ExceptionGraph("Le graph contient des objets inconnus : "+theEdge.getClass()+" au lieu de Troncon");
		}
	}
}
