import java.util.ArrayList;

public class Graph {
    private ArrayList<Vertex> vertecies;

    public Graph(){
        this.vertecies = new ArrayList<Vertex>();
    }

    public Graph(ArrayList<Vertex> graph){
        this.vertecies = graph;
    }

    public Vertex addVertex(String data,double heuristiqueCost, TypeVertex type, int x, int y){
        Vertex vertex = new Vertex(data,heuristiqueCost, type, x, y);
        this.vertecies.add(vertex);
        return vertex;
    } 

    public void removeVertex(Vertex vertex){
        this.vertecies.remove(vertex);
    }

    public void addEdge(Vertex startVertex, Vertex endVertex, int weight) {
        startVertex.addEdge(endVertex, weight);
    }   

    public void removeEdge(Vertex startVertex, Vertex EndVertex){
        startVertex.removeEdge(EndVertex);
    }


    public ArrayList<Vertex> getVertecies() {
        return vertecies;
    }

    public Vertex getVertexByType(TypeVertex type){
        for(Vertex v : this.vertecies){
            if(v.type == type){
                return v;
            }
        }
        return null;
    }

}
