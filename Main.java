import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class Main {
    public static void main(String[] args){
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("exo1");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 800);

            //creating an empty graph
            Graph graph = new Graph();

            //adding nodes to the graph
            Vertex s = graph.addVertex("S", 3.0, TypeVertex.Start, 400, 100);
            Vertex a = graph.addVertex("A", 3.0, null, 200, 200);
            Vertex b = graph.addVertex("B", 1.0, null, 600, 200);
            Vertex c = graph.addVertex("C", 0.0, null, 400, 300);
            Vertex g = graph.addVertex("G", 0.0, TypeVertex.Goal, 400, 400);


            //adding edges and their weights
            graph.addEdge(s, a, 1);
            graph.addEdge(s, b, 2);
            graph.addEdge(a, c, 1);
            graph.addEdge(b, c, 1);
            graph.addEdge(c, g, 2);

            

            //instantiating an object of type GraphDisplay for the created graph to display this last
            GraphDisplay graphDisplay = new GraphDisplay(graph);
           
            //initiating the A* algorithm object
            AStarAlgorithme astar = new AStarAlgorithme(graph);

            //calling the object and triggering the method to return an arraylist of the short path
            ArrayList<Vertex> shortPath = astar.findPath(s, g);

            //creating a graph from the arrayList and instantiating an object of type GraphDisplay to display the short path
            GraphDisplay shortPathFDisplay = new GraphDisplay(new Graph(shortPath));

            
            frame.add(graphDisplay);
            frame.add(shortPathFDisplay);
            frame.setVisible(true);
        });
    }
}
