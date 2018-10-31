import java.util.ArrayList;

/**
 * @author Tyler McVeigh and Mi'Quel Muldrow
 * @version October 25, 2018 Version 1.0
 */
public class Graph{
    /** List of vertices in the graph where the index in corresponds to
     * vertex number.*/
    private ArrayList<Vertex> vertexList;

    /** List at each vertex corresponds to the vertices adjacent to vertex.*/
    private ArrayList<ArrayList<Integer>> adjList;

    /** Value of true represents an edge between two vertices.*/
    private boolean[][] adjMatrix;
    
    
    /**
     * 
     * @param nums
     */
    public Graph(ArrayList<Integer> nums){
        
        this.makeVertexList(nums);
        //System.out.println(this.vertexList);
		this.makeAdjList(nums);
		//System.out.println(this.adjList);
		this.makeAdjMatrix();
		//Prints the adjMatrix
    	/**for(boolean[] i : adjMatrix) {
    		for(boolean j : i) {
    			System.out.print(j + " ");
    		}
    		System.out.println("");
    	}
    	*/
    }

    


	/**
     * Helper function for main, creates the vertexList
     * field
     * 
     * @param nums
     */
    private void makeVertexList(ArrayList<Integer> nums) {
    	
    	this.vertexList = new ArrayList<Vertex>(nums.size());
    	this.vertexList.ensureCapacity(nums.size());
    	
    	for(int i : nums) {
    		Vertex newVertex = new Vertex(i);
    		if( !vertexList.contains(newVertex)) {
    			vertexList.add(newVertex);
    		}  		
    	}
    	this.vertexList.trimToSize();
    	this.vertexList.sort(null);;
    	
    }
    
    /**
     * Helper method for constructor. Creates the adjList field
     * 
     * @param nums the inputed edge list
     */
    private void makeAdjList(ArrayList<Integer> nums) {
		
		
		this.adjList = new ArrayList<ArrayList<Integer>>(this.vertexList.size());
		
		for(int i = 0; i < this.vertexList.size(); i++){
		    this.adjList.add(i, 
		    		new ArrayList<Integer>(this.vertexList.size() ) );
		}
		
		for(int i = 0; i < nums.size(); i++){
		    
		    int origin = nums.get(i);
		    int destination = nums.get(++i);
		    adjList.get(origin).add(destination);
		}
		
		for(ArrayList<Integer> i : adjList) {
			i.sort(null);
		}
    }
    
    /**
     * Helper method for constructor, creates adjMatrix field.
     * Leaves non-adjacent vertices null in the matrix
     */
    private void makeAdjMatrix() {
    	this.adjMatrix = new boolean[vertexList.size()][vertexList.size()];
    	
    	for(int i = 0; i < vertexList.size(); i++) {
    		
    		for(int j : adjList.get(i)) {
    			this.adjMatrix[i][j] = true;
    		}
    		
    	}
	}
    /**
     * Entry point to run operations specified in the handout.
     */
    public void go(){
    	
    	this.findSourceDest();
    	
    	
    	
    	this.printGraphStats();
    }

    /**
     * Finds the source and destination vertices. On invalid input, asks the
     * user to enter new vertices.
     *
     * @throws IllegalArgumentException if the source and destination vertices
     * are not found in the graph.
     */
    public void findSourceDest(){
    	Vertex start;
    	Vertex end;
    	System.out.print("Please enter valid source and destiniation vertices >> ");
    	Scanner input = new Scanner(System.in);
    	try {
    		int startNum = input.nextInt();
    		int  endNum = input.nextInt();
    		input.close();
    		if(startNum >= this.vertexList.size()||
    			endNum >= this.vertexList.size())
            	throw new IllegalArgumentException("One or both vertices not found");
    		start = this.vertexList.get(startNum);
            end = this.vertexList.get(endNum);
            depthFirstSearch(start, end);
    	}catch(InputMismatchException e) {
    		System.out.println("Please input a number");
    	}
        
       
    }

    /**
     * Performs a depth-first search from source to destination or until the 
     * search is exhausted
     */
<<<<<<< HEAD
    public String depthFirstSearch(Vertex start, Vertex end){
    	Vertex vertex = this.vertexList.get(start.getID());
    	ArrayList<Integer> edges;
    	String returnOutput = "";
    	Stack<Vertex> search = new Stack<Vertex>();
    	Vertex grayVer;
    	search.push(vertex);
    	vertex.changeColor();
    	returnOutput = "Vertex " + vertex.getID();
    	while(search.peek()!=null){
    		edges = this.adjList.get(vertex.getID());
    		if(edges.size() == 1){
    			System.out.println(end.getID() + " and " + edges.get(0));
    			if(end.getID() == edges.get(0)) {
    				vertex = this.vertexList.get(edges.get(0));
    				returnOutput += ", Vertex " + vertex.getID();
    				System.out.println(returnOutput);
    				return returnOutput;
    			}else if(this.vertexList.get(edges.get(0)).getColor() == "white") {
    				vertex = this.vertexList.get(edges.get(0));
    				vertex.changeColor();
    				returnOutput += ", Vertex " + vertex.getID() + " Size is " + edges.size();
    			}
    		//}else {
    			//if
    			//for(int i = 0; i < edges.size(); i++) {
    				
    			//
    		}
    		search.push(vertex);
    	}
    	return "No way to connect these vertices";
=======
    public void depthFirstSearch(){
    	
>>>>>>> branch 'master' of https://github.com/tamcveigh/351project2
    }

    /**
     * Performs a search for cycles
     */
    public void cycleSearch(){
    	
    }

    /**
     * Performs the transitive closure algorithm
     */
    public void transitiveClosure(){
    	boolean[][] transClos = new boolean[this.adjMatrix.length][this.adjMatrix.length];
    	
    	for(int i = 0; i < adjMatrix.length; i++) {
    		for(int j = 0; j < adjMatrix.length; j++) {
    			transClos[i][j] = this.adjMatrix[i][j];
    		}
    	}
    	
    	
    }

    /**
     * Prints the information as specified in the handout.
     *
     * @return String - Information to be returned
     */
    public String printGraphStats(){
        return "Hello";
    }

}

