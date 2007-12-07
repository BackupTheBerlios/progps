
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import org.jgrapht.EdgeFactory;
import org.jgrapht.Graph;
import org.jgrapht.WeightedGraph;
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
    
    public ArrayList<Itineraire> trouver3Chemins(){
		return null;    	
    }
    
    public ListeDeKChemins<Ville, Troncon> chercheKItineraires(
												Ville villeDepart, 
												Ville villeArrivee,
												List<Ville> villesAEviter,
												int nbChemins){
    	// Initialisation
    	aEviter=villesAEviter;
    	
		long debut = System.currentTimeMillis();
		ListeDeKChemins<Ville, Troncon> liste = new ListeDeKChemins<Ville, Troncon>((Multigraph)this, villeDepart, villeArrivee, nbChemins);
		long fin = System.currentTimeMillis();
		System.out.println("Temps de calcul : "+(fin-debut)+"ms");

		return liste;
	}
}
