import java.awt.*;
import javax.swing.*;

public class GraphDisplay extends JPanel {
    private Graph graph;

    public GraphDisplay(Graph graph) {
        this.graph = graph;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;


        for (Vertex vertex : graph.getVertecies()) {

            int x = vertex.getX();
            int y = vertex.getY();

            g2d.setColor(Color.BLACK);
            g2d.drawOval(x - 20, y - 20, 40, 40);


            Font font = new Font("Arial", Font.BOLD, 16);
            g2d.setFont(font);

            g2d.setColor(Color.BLACK);
            FontMetrics metrics = g2d.getFontMetrics(font);
            int textX = x - metrics.stringWidth(vertex.getData()) / 2;
            int textY = y + metrics.getAscent() / 2;
            g2d.drawString(vertex.getData(), textX, textY);
        
            for (Edge edge : vertex.getEdges()) {
                Vertex startVertex = edge.getStart();
                Vertex endVertex = edge.getEnd();

                int startX = startVertex.getX(); 
                int startY = startVertex.getY();
                int endX = endVertex.getX();
                int endY = endVertex.getY();

                g2d.drawLine(startX , startY , endX , endY);
                drawArrow(g2d, startX, startY, endX, endY);

                int weight = edge.getWeight();
                int labelX = (startX + endX) / 2;
                int labelY = (startY + endY) / 2;
                g2d.drawString(String.valueOf(weight), labelX, labelY);
            }
        }

    }

    private void drawArrow(Graphics2D g2d, int x1, int y1, int x2, int y2) {
        int arrowSize = 16; // Size of the arrowhead
        double angle = Math.atan2(y2 - y1, x2 - x1);
        int x3 = (int) (x2 - arrowSize * Math.cos(angle - Math.PI / 6));
        int y3 = (int) (y2 - arrowSize * Math.sin(angle - Math.PI / 6));
        int x4 = (int) (x2 - arrowSize * Math.cos(angle + Math.PI / 6));
        int y4 = (int) (y2 - arrowSize * Math.sin(angle + Math.PI / 6));
    
        g2d.setColor(Color.BLACK);
        g2d.drawLine(x2, y2, x3, y3);
        g2d.drawLine(x2, y2, x4, y4);
    }   

}

