import java.util.ArrayList;

public class Graph {
	ArrayList<Node> vertices = new ArrayList<Node>();
	ArrayList<Edge> edges = new ArrayList<Edge>();
	public Graph(){
		vertices = new ArrayList<Node>();
		edges = new ArrayList<Edge>();
		
	}
	public void getVertices(){
		for (Node node: vertices){
			System.out.println(node);
		}
	}
	public void getEdges(){
		for(Edge edge: edges)
			System.out.println(edge);
	}
	
}
