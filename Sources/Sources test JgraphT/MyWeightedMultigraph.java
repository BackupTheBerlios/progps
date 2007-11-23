
import org.jgrapht.EdgeFactory;
import org.jgrapht.WeightedGraph;
import org.jgrapht.graph.ClassBasedEdgeFactory;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;



public class MyWeightedMultigraph<V, E> extends WeightedMultigraph<V, E> {

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
//        	Méthode du plus rapide
            return ((Integer)((Troncon) e).getLongueur()).doubleValue()/((Integer)((Troncon) e).getVitesse()).doubleValue();
        } else {
        	// TODO levée d'exceptions !
            return Double.MAX_VALUE;
        }
    }
}
