import java.util.ArrayList;

public class Vertex{
    private String data;
    private ArrayList<Edge> edges;
    private double heuristiqueCost;
    public TypeVertex type = null;
    private double f;
    private int x;
    private int y;   

    public Vertex(String data, double heuristiqueCost, TypeVertex type, int x, int y) {
        this.data = data;
        this.edges = new ArrayList<Edge>();
        this.heuristiqueCost = heuristiqueCost;
        this.type = type;
        this.x = x;
        this.y = y;
    }


    public void setF(double fScore) {
        this.f = fScore;
    }

    public double getF() {
        return f;
    }


    public double getHeuristiqueCost() {
        return heuristiqueCost;
    }


    public ArrayList<Edge> getEdges() {
        return edges;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public TypeVertex getType() {
        return type;
    }
    
    

    public void addEdge(Vertex endVertex ,int weight){
        this.edges.add(new Edge(this, endVertex, weight));
    }

    public void removeEdge(Vertex endVertex){
        this.edges.removeIf(edge -> edge.getEnd().equals(endVertex));
    }


    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }



}
