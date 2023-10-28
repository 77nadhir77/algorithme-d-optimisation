import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class AStarAlgorithme {
    private Graph graph;
    
    public AStarAlgorithme(Graph graph) {
        this.graph = graph;
    }

    public ArrayList<Vertex> findPath(Vertex start, Vertex goal) {
        PriorityQueue<Vertex> openList = new PriorityQueue<>((v1, v2) -> Double.compare(v1.getF(), v2.getF()));
        HashMap<Vertex, Vertex> cameFrom = new HashMap<>();
        HashMap<Vertex, Double> gScores = new HashMap<>();
        

        
        openList.add(start);
        gScores.put(start, 0.0);
        
        while (!openList.isEmpty()) {
            for(Vertex v : openList){
                System.out.print(v.getData());
            }
            System.out.println("\n");
            Vertex current = openList.poll();
            
            
            
            for (Edge edge : current.getEdges()) {
                Vertex neighbor = edge.getEnd();
                double tentativeGScore = gScores.get(current) + edge.getWeight();
                cameFrom.put(neighbor, current);
                gScores.put(neighbor, tentativeGScore);
                double fScore = tentativeGScore + neighbor.getHeuristiqueCost();
                neighbor.setF(fScore);

                if(neighbor.equals(goal)){
                    return resurrectPath(cameFrom, neighbor);
                }

                if (!openList.contains(neighbor)) {
                    openList.add(neighbor);
                }
    
            }
        }
        
        return null;
    }
    
    private ArrayList<Vertex> resurrectPath(HashMap<Vertex, Vertex> cameFrom, Vertex current) {
        int cpt = 0;
        ArrayList<Vertex> path = new ArrayList<>();
        path.add(current);
        
        while (cameFrom.containsKey(current)) {
            current = cameFrom.get(current);
            path.add(cpt, current);
            cpt += 1;
        }
        
        return path;
    }

    public Graph getGraph() {
        return graph;
    }
}
