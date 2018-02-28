import java.util.HashSet;


public class Node {
	
	private int vertex;
	private int degree;
	private int currentColor=-1;
	
	
	HashSet<Integer> domain = new HashSet<Integer>();
	HashSet<Integer> neighbours = new HashSet<Integer>();
	public Node(int v){
		this.vertex=v;
	}
	public void addToDomain(int color){
		domain.add(color);
	}
	public void removeFromDomain(int color){
		domain.remove(color);
	}
	public HashSet<Integer> getDomain() {
		return domain;
	}
	public void setDomain(HashSet<Integer> domain) {
		this.domain = domain;
	}
	public void addToNeighbours(int neighbour){
		neighbours.add(neighbour);
	}
	public void removeFromNeighbours(int neighbour){
		neighbours.remove(neighbour);
	}
	public int getDomainSize(){
		return domain.size();
	}
	public int getDegree() {
		return degree;
	}
	public void setDegree(int degree) {
		this.degree = degree;
	}
	public int getVertex() {
		return vertex;
	}
	public void setVertex(int vertex) {
		this.vertex = vertex;
	}
	public int getCurrentColor() {
		return currentColor;
	}
	public void setCurrentColor() {
		// forward checking for least constraining value.
		int min=main_class.Graph.size();
		for(int c: domain){
			int colorInNeighbours=0;
			for(int n:neighbours){
				if(main_class.Graph.get(n).getDomain().contains(c)){
					colorInNeighbours++;
				}
			}
			if(colorInNeighbours<min){
				this.currentColor=c;
				min=colorInNeighbours;
			}
		}
		
		//assign color and clear that from neighbours.
		for(int n:neighbours){
			if(main_class.Graph.get(n).getDomain().contains(this.currentColor)){
				main_class.Graph.get(n).removeFromDomain(this.currentColor);
			}
		}
		//remove current assignment from current domain.
		this.domain.remove(this.currentColor);
	}
	
	public void printNode(){
		System.out.println("vertex number "+vertex);
		System.out.println("domain ");
		for(int c: domain){
			System.out.print(c+", ");
		}
		System.out.println("\nneighbours ");
		for(int n: neighbours){
			System.out.print(n+", ");
		}
		System.out.println("degree: "+degree);
		System.out.println("current colour "+currentColor);
	}
	public HashSet<Integer> getNeighbours() {
		return neighbours;
	}
	public void setNeighbours(HashSet<Integer> neighbours) {
		this.neighbours = neighbours;
	}
	public void setCurrentColor(int currentColor) {
		this.currentColor = currentColor;
	}
	
	
}

