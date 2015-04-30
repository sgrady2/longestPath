import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args){
		Integer first_line = 0;
		Integer second_line = 0;
	   //create scanner object stdin and string for taking lines from our input
	   Scanner stdin = new Scanner(System.in);
	   //numhrases is the number of phrases to be analzyed
	   //so we create a results calling for this many positions to store the results
	   first_line = Integer.parseInt(stdin.nextLine());
	   
	   //need code to parse the space inbetween nodes and edges specifier
	   
	   ArrayList<Graph> results = new ArrayList<Graph>(first_line);
	   ArrayList<Node> emptyN = new ArrayList<Node>(100);
	   ArrayList<Edge> emptyE = new ArrayList<Edge>(100);
	   Integer currentECount = 0;
	   Integer currentVCount = 0;
	   Edge[][] adjMatrix = new Edge[100][100];
	   for (int i =0; i<first_line;i++){
		  //Scoring: sample output requires to print first the number of the graph
		  System.out.println("graph number:"+ (i+1));
		  //Graph graph = new Graph();
		  //results.add(graph);
		  //second_line = Integer.parseInt(stdin.nextLine());
		  String[] ints = stdin.nextLine().split(" ");
		  currentVCount = Integer.parseInt(ints[0]);
		  currentECount = Integer.parseInt(ints[1]);
		  //constructing an empty adjacency matrix
		  
		  for (int k = 1; k < currentVCount+1;k++){
			  for (int b=1;b<currentVCount+1;b++){
				  adjMatrix[b][k] = new Edge(b,k,0);
				  
			  }
		  }
		  
		  
		  //constructing edges using the next line which gives direction as well as weight
		  //
		  for (int l = 0; l<currentECount;l++){
			  String[] anEdge = stdin.nextLine().split(" ");
			  int start = Integer.parseInt(anEdge[0]);
			  int dest = Integer.parseInt(anEdge[1]);
			  int weight = Integer.parseInt(anEdge[2]);
			  adjMatrix[start][dest].weight = weight;
			  //Edge contstuctEdge = new Edge(one, two, three);
			  //graph.edges.add(contstuctEdge);
			  
			  
		  }
		  //creating empty nodes
		  for (int f=0; f<currentVCount;f++){
			  emptyN.add(new Node());
			  
		  }
		//testing purposes
		  for (int k = 1; k < currentVCount+1;k++){
			  for (int b = 1;b<currentVCount+1;b++){
				  System.out.println(adjMatrix[b][k].weight);
				  
			  }
		  }
		  int source = findSource(adjMatrix, currentVCount, currentECount);
		  int sink = findSink(adjMatrix, currentVCount, currentECount);
		  System.out.println(longestPath(adjMatrix, source, currentVCount)+"III");
		  }
	   
	   
	}
	//constructed a method to find the source of the adjacency matrix
	public static Integer findSource(Edge[][] graph, int verts, int edges){
		int count = 0;
		for (int k = 1; k < verts+1;k++){
			  for (int b=1;b<edges+1;b++){
				  if (graph[b][k].weight == 0)
					  count++;
				  else{
					  count = 0;
				  }
				  if (count == verts){
					  return k;
					  
				  }
					  
	 
			  }
		  }
		return 0;
	}
	//constructed a method to find the sink of the adjacency matrix
	public static Integer findSink(Edge[][] graph, int verts, int edges){
		int count = 0;
		for (int b = 1; b < verts+1;b++){
			  for (int k=1;k<edges+1;k++){
				  if (graph[k][b].weight == 0)
					  count++;
				  else{
					  count = 0;
				  }
				  if (count == verts){
					  return k;
					  
				  }
					  
	 
			  }
		  }
		return 0;
	}
	public static int[] longestPath(Edge[][] g, int source, int verts){
		int[] longest_path = new int[20];
		int[] num_paths = new int[20];
		//initializing both to be 0
		for (int i =0; i <20;i++)
			num_paths[i] = 0;
		for (int i =0; i <20;i++)
			num_paths[i] = 0;
		int result = 0;
		//calc longest path from source
		for (int i = 1;i<verts;i++) {
			for (int j=i+1; i<verts;i++){
				if (g[i][j].weight > 0){
					longest_path[j] = Math.max(longest_path[j],longest_path[i]+g[i][j].weight);
					if (longest_path[j] == longest_path[i]+g[i][j].weight)
						num_paths[j]+=num_paths[i];
					if (longest_path[j] < longest_path[i]+g[i][j].weight){
						longest_path[j] = longest_path[i]+g[i][j].weight;
						num_paths[j] = num_paths[i];
					}
				}
			}
		
			
		}	
		
		
		return longest_path;
	}
	 
}
