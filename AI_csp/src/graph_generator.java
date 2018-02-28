import java.util.Random;
public class graph_generator {
	
	int[][] graph = new int[100][100];
	private int density;
	private int nodes;
	private int colours;
	
	public graph_generator(int n,int d,int c){
		this.density=d;
		this.nodes=n;
		this.colours=c;
	}
	
	public void initGraph(){
		for(int i=0;i<nodes;i++){
			Node n = new Node(i);
			main_class.Graph.add(n);
			for(int k=0;k<colours;k++){
				n.addToDomain(k);
			}
		}
	}
	
	public int[][] generateGraph(){
		Random r=new Random();
		for(int i=0;i<nodes;i++){
			int deg=0;
			for(int j=i+1;j<nodes;j++){
				int d=r.nextInt(10);
				//System.out.println(d);
				if(d<this.density){
					main_class.Graph.get(i).addToNeighbours(j);
					main_class.Graph.get(j).addToNeighbours(i);
					main_class.Graph.get(i).setDegree(main_class.Graph.get(i).getDegree()+1);
					main_class.Graph.get(j).setDegree(main_class.Graph.get(j).getDegree()+1);
					graph[i][j]=graph[j][i]=1;
					deg++;
				}
			}
		}
		return graph;
	}
	
	public void printGraph(){
		for(int i=0;i<nodes;i++){
			for(int j=0;j<nodes;j++){
				System.out.print(graph[i][j]+" ");
			}
			System.out.print("\n");
		}
		System.out.println("no of nodes generated: "+main_class.Graph.size());
	}

}
