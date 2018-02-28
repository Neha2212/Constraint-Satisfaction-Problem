import java.util.HashSet;


public class Util {
	public boolean solveCSP(){
		return solveCspRecur(getMaxDegreeNode());
	}
	
	//backtracking!!!
	/*
	public boolean solveCspRecur(int num){
		if(allNodesColoured()){
			return true;
		}
		if(main_class.Graph.get(num).getDomainSize()!=0){
			System.out.println("colouring vertex : "+num);
			System.out.println("degree is "+main_class.Graph.get(num).getDegree());
			System.out.println("its domain size "+main_class.Graph.get(num).getDomainSize());
			main_class.Graph.get(num).setCurrentColor();
			System.out.println("colour set to "+main_class.Graph.get(num).getCurrentColor());
			return solveCspRecur(getNextNode());
		}
		else
			return false;
			
	}*/
	
	//backtracking recursive one step forward checking algo.
	public boolean solveCspRecur(int num){
		if(allNodesColoured()){
			return true;
		}
		while(main_class.Graph.get(num).getDomainSize()!=0){
			System.out.println("***************\ncolouring vertex : "+num);
			System.out.println("degree is "+main_class.Graph.get(num).getDegree());
			System.out.println("its domain size "+main_class.Graph.get(num).getDomainSize());
			main_class.Graph.get(num).setCurrentColor();
			System.out.println("colour set to "+main_class.Graph.get(num).getCurrentColor());
			boolean retval=solveCspRecur(getNextNode());
			if(retval)
				return true;
			else{
				int currColor=main_class.Graph.get(num).getCurrentColor();
				for(int n:main_class.Graph.get(num).getNeighbours()){
					main_class.Graph.get(n).addToDomain(currColor);
				}
			}
				
		}
		return false;
	}
	
	public boolean allNodesColoured() {
		// TODO Auto-generated method stub
		for(Node n : main_class.Graph){
			if(n.getCurrentColor()==-1)
				return false;
		}
		return true;
	}

	public int getNextNode() {
		// TODO Auto-generated method stub
		HashSet<Integer> sameDomainNodes=new HashSet<Integer>();
		int min=main_class.colours;
		for(Node n : main_class.Graph){
			// find only the vertices that are not coloured.
			if((n.getCurrentColor()==-1)&&(n.getDomainSize()<min)){
				min=n.getDomainSize();
			}
		}
		int minDomainAndMaxDegree=-1;//main_class.Graph.size();
		int max=0;
		for(Node n : main_class.Graph){
			if((n.getCurrentColor()==-1)&&(n.getDomainSize()==min)){
				if(n.getDegree()>max){
					minDomainAndMaxDegree=n.getVertex();
					max=n.getDegree();
				}
			}
		}
		
		return minDomainAndMaxDegree;
	}

	public int getMaxDegreeNode(){
		int n=-1;
		int max=0;
		for(int i=0;i<main_class.Graph.size();i++){
			if(main_class.Graph.get(i).getDegree() > max){
				max=main_class.Graph.get(i).getDegree();
				n=main_class.Graph.get(i).getVertex();
			}
		}
		return n;
	}
	
	public void printColours(){
		for(Node n:main_class.Graph){
			System.out.println("Vertex number: "+n.getVertex()+" Colour given: "+n.getCurrentColor());
		}
	}
}
