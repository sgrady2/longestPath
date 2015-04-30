
public class Edge {
	Integer row;
	Integer col;
	Integer weight;
	public Edge(int in1, int in2, int w){
		this.row = in1;
		this.col = in2;
		this.weight = w;
		
	}
	//the row specfies where the edge came from
	//the col specfies where the edge is going directionally
	public boolean hasWeight(){
		return weight > 0;
	}
	public void getPast(){
		System.out.println(row);
		}
	public void getNext(){
		System.out.println(col);
		}
}
