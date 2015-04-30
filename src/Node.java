import java.util.ArrayList;
//Since Vertices can have multiple incoming or outgoing edges
//it is essential for the class node (an instance of a vertice) to be 
//lists of edges that are leaving and coming to a vertext
//GRADER NOTE: i ended up not using this class or the graph class for requirement specification reasons, ie i didnt need them to construct an adjacency matrix.


public class Node {
	Edge[] incoming = new Edge[100];
	Edge[] outgoing = new Edge[100];
	
	
	public Node() {
		
        
	}
}

