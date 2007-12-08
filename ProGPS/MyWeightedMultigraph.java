
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import org.jgrapht.EdgeFactory;
import org.jgrapht.Graph;
import org.jgrapht.WeightedGraph;
import org.jgrapht.alg.DijkstraShortestPath;
import org.jgrapht.alg.ListeDeKChemins;
import org.jgrapht.graph.ClassBasedEdgeFactory;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.Multigraph;
import org.jgrapht.graph.WeightedMultigraph;



public class MyWeightedMultigraph<V, E> extends WeightedMultigraph<V, E> {
	// Constantes
	private double const_indispo=1000000;
	private double const_ville_a_eviter=1000;
	
	private List<Ville> aEviter=new Vector<Ville>();

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

    public double getEdgeWeight(E e)
    {
        if (e instanceof Troncon) {
//        	Méthode de calcul
        	double poids=0.0;
        	
        	if (!((Troncon) e).isDispo()) poids+=const_indispo;
        	if (((Troncon) e).isRelieVille(aEviter)){
        		poids+=const_ville_a_eviter;
        	}
        	poids+=((Integer)((Troncon) e).getLongueur()).doubleValue()/((Integer)((Troncon) e).getVitesse()).doubleValue();
            return poids;
        } else {
        	// TODO levée d'exceptions !
            return Double.MAX_VALUE;
        }
    }
    
    public Itineraire trouverLeChemin(
    		Ville villeDepart, 
			Ville villeArrivee,
			List<Ville> villesAEviter){
//    	 Initialisation
    	aEviter=villesAEviter;
    	Itineraire theResult = new Itineraire();
    	
    	List<E> listOfEdges = DijkstraShortestPath.findPathBetween(this, (V)villeDepart, (V)villeArrivee);
    	
    	for (Iterator iter = listOfEdges.iterator(); iter.hasNext();) {
			E anEdge = (E) iter.next();
			if (anEdge instanceof Troncon) {
				Troncon unTroncon = (Troncon) anEdge;
				theResult.addUnTroncon(unTroncon);
			}else{
				// TODO levée d'exception
			}
		}
    	return theResult;
    }
    
    public List<Itineraire> trouver3Chemins(
    		Ville villeDepart, 
			Ville villeArrivee,
			List<Ville> villesAEviter){
//    	 Initialisation
    	aEviter=villesAEviter;
    	List<Itineraire> result = new ArrayList<Itineraire>();
    	
    	ListeDeKChemins<Ville, Troncon> liste = new ListeDeKChemins<Ville, Troncon>((Multigraph)this, villeDepart, villeArrivee, 3);
    	
    	Itineraire unIti;
    	// On liste des 3 chemins (il se peut qu'il y ait moins de 3 chemins
    	for (int i = 0; i < liste.size(); i++) {
			// On liste tous les troncons
    		unIti = new Itineraire();
    		
    		List<Troncon> lesTroncons = liste.getEdgesDuChemin(i);
    		for (Iterator iter = lesTroncons.iterator(); iter.hasNext();) {
				Troncon unTroncon = (Troncon) iter.next();
				unIti.addUnTroncon(unTroncon);
			}
    		
    		result.add(unIti);
		}
    	return result;
    }
    
    public boolean ajouterUneVille(V uneVille){
    	return this.addVertex(uneVille);
    }
    
    public Troncon ajouterUnTroncon(V ville1, V ville2){
    	E theEdge = this.addEdge(ville1, ville2);
    	Troncon troncon=null;
    	if (theEdge instanceof Troncon) {
			troncon = (Troncon) theEdge;
		}else{
    		// TODO levée d'exception
    	}
    	return troncon;
    }

	private void seDecrire(){
		Set<E> lesTroncons=this.edgeSet();
		for (E theEdge : lesTroncons) {
			if (theEdge instanceof Troncon) {
				Troncon troncon = (Troncon) theEdge;
				System.out.println("**************");
				System.out.println("De :"+this.getEdgeSource(theEdge).toString());
				System.out.println("A :"+this.getEdgeTarget(theEdge).toString());
				System.out.println("Dist:"+troncon.getLongueur()+"km");
				System.out.println("Vit:"+troncon.getVitesse()+"km/h");
			}else{
				// TODO levée d'exception
				
			}
		}
	}
}
