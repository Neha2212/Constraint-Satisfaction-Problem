import java.util.ArrayList;
import java.util.HashSet;

public class main_class {
	public static ArrayList<Node> Graph = new ArrayList<Node>();
	public static int colours=3;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//arguments to graph_generator: no of nodes, density(x/10), no of colours.
		graph_generator g=new graph_generator(6,6,3);
		g.initGraph();
		g.generateGraph();
		g.printGraph();
		Util util=new Util();
		util.solveCSP();
		util.printColours();	
	}	
}
