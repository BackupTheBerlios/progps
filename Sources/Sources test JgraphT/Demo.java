
import java.util.Date;
import java.util.List;

import org.jgrapht.alg.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

/**
 * A demo applet that shows how to use JGraph to visualize JGraphT graphs.
 *
 * @author Barak Naveh
 *
 * @since Aug 3, 2003
 */
public  class Demo {
	
    /**
     * @see java.applet.Applet#init().
     */
    public void calcul() {
        // create a JGraphT graph
    	WeightedMultigraph<String, DefaultWeightedEdge> g = new WeightedMultigraph<String, DefaultWeightedEdge>( DefaultWeightedEdge.class );

        long creat = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
        	g.addVertex("Vwk"+i);
		}
        DefaultWeightedEdge e;
        for (int i = 1; i < 1000; i++) {
        	e = (DefaultWeightedEdge) g.addEdge( ("Vwk"+(i-1)), ("Vwk"+i) );
        	g.setEdgeWeight(g.getEdge(("Vwk"+(i-1)), ("Vwk"+i)), Math.random()*100);
            for (int j = 2; j < i; j++) {
                	e = (DefaultWeightedEdge) g.addEdge( ("Vwk"+(i-j)), ("Vwk"+i) );
                	g.setEdgeWeight(g.getEdge(("Vwk"+(i-j)), ("Vwk"+i)), (Math.random()*100));
                if (j>20) j=i+4;
			}
        }
        
        // Dijkstra
        System.out.println("lancement Dij");
        
        
        long debut = System.currentTimeMillis();
        List<DefaultWeightedEdge> villes = DijkstraShortestPath.findPathBetween(g, "Vwk1", "Vwk999");
        
        long fin = System.currentTimeMillis();
        
        for (DefaultWeightedEdge edge : villes) {
			System.out.println("Depart : "+g.getEdgeSource(edge)+" - Arrivée : "+g.getEdgeTarget(edge)+" Distance : "+g.getEdgeWeight(edge));
		}
        System.out.println("----------------------------------------");
        System.out.println("Tps de creat° : "+(debut-creat)+"ms");
        System.out.println("Tps de calcul : "+(fin-debut)+"ms");
        
        
    }
}
