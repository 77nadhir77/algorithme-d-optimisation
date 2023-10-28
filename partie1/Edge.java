public class Edge{
    private int weight;
    private Vertex start;
    private Vertex end;

    public Edge(Vertex start, Vertex end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }


    public Vertex getStart() {
        return start;
    }


    public Vertex getEnd() {
        return end;
    }





}