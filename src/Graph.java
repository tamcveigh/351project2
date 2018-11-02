import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;

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
     * The constructor for the Graph. Takes a list containing edges, and
     * creates a vertex list, adjacency list and adjacency matrix out of the
     * list of edges
     * 
     * @param nums An ArrayList containing where numbers are paired in even-odd slots (i.e. 0 and 1, 2 and 3, 4 and 5, etc.)
     * 			   as edges
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
     * Entry point to run operations specified in the hand-out.
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
            System.out.println(depthFirstSearch(start, end));
            System.out.println(cycleSearch(start, end));
    	}catch(InputMismatchException e) {
    		System.out.println("Please input a number");
    	}
        
       
    }

    /**
     * Performs a depth-first search from source to destination or until the 
     * search is exhausted
     * 
     * @param Vertex start - The first vertex to be used to find a path to the end vertex
     * @param Vertex end - The vertex being searched for  
     * @return A string of the path between the start and end vertices if one exists.
     */
    public String depthFirstSearch(Vertex start, Vertex end){
    	
    	//Initializes all needed variables and then sets up the stack with the start vertex
    	Vertex vertex = this.vertexList.get(start.getID());
    	ArrayList<Integer> edges;
    	String returnOutput = "";
    	String path = "";
    	Stack<Vertex> search = new Stack<Vertex>();
    	Vertex verToCheck;
    	boolean hasNewVer = false;
    	
    	search.push(vertex);
    	vertex.changeColor();
    	returnOutput = "[DFS Discovered Vertices: " + start.getID() + ", " + end.getID() + "] Vertex " + vertex.getID();
    	path = "[DFS Path: " + start.getID() + ", " + end.getID() + "] Vertex " + vertex.getID();
    	
    	//While loop starts the depth first search and loops until the stack 
    	//has been emptied or a path has been found
    	while(search.peek()!=null){
    		edges = this.adjList.get(vertex.getID());
    		hasNewVer = false;
    		
    		//For loop takes the edges of the vertex at the top of the stack and uses them to determine
    		//the next step in the path or if we've found the end of the path
    		for(int i = 0; i < edges.size(); i++) {
    			verToCheck = this.vertexList.get(edges.get(i));
    			
    			//Using a boolean to see if there's already a new vertex on the stack, this else if statement determines if the 
    			//vertex we are looking at is the vertex the user wanted to find
    			if(end.getID() == verToCheck.getID() && hasNewVer == false){
    				returnOutput += ", Vertex " + verToCheck.getID();
    				path += " -> Vertex " + verToCheck.getID();
    				//System.out.println(path);
    				return returnOutput + "\n" + path;
    			}//end if statement
    			
    			//Using a boolean to see if there's already a new vertex on the stack, this else if statement determines if the 
    			//vertex we are looking at is new to the stack and pushes the new vertex so we can look at its edges in the next loop
    			else if(verToCheck.getColor() == "white" && hasNewVer == false) {
    				vertex = verToCheck;
    				vertex.changeColor();
    				search.push(vertex);
    				returnOutput += ", Vertex " + vertex.getID();
    				path += " -> Vertex " + vertex.getID();
    				hasNewVer = true;
    			}
    		}
    		
    		//Using a boolean to see if there were no new vertices connected to the currently being looked at vertex, 
    		//this if statement fixes our output and then takes the vertex off of the stack 
    		if(hasNewVer == false){
    			vertex.changeColor();
    			//returnOutput = returnOutput.replace(", Vertex " + vertex.getID(), "") ;
    			path = path.replace(" -> Vertex " + vertex.getID(), "");
    			search.pop();
    		}//end if statement
    		
    		//If statement determines if the stack has objects in it and then makes our current vertex the top of the stack 
    		if(!(search.empty())) {
    			vertex = search.peek();
    		}//end if statement
    		
    		//Else determines if the stack has no objects in it, if it is empty, then returns a statement telling the user
    		else{
    			return "No way to connect these vertices";
    		}//end else
    		
    	}//end while loop
    	return "No way to connect these vertices"; 	
    }

    /**
     * Performs a search for cycles
     * 
     * @param Vertex start - The starting vertex
     * @param Vertex end - The vertex being searched for
     * @return String - Whether or not there was a cycle in the path
     */
    public String cycleSearch(Vertex start, Vertex end){
    	Vertex vertex = this.vertexList.get(start.getID());
    	ArrayList<Integer> edges;
    	Stack<Vertex> search = new Stack<Vertex>();
    	Vertex verToCheck;
    	boolean cycle = false;
    	boolean hasNewVer = false;
    	search.push(vertex);
    	vertex.changeColor();
    	
    	//While loop starts the depth first search and loops until the stack 
    	//has been emptied or a path has been found
    	while(search.peek()!=null){
    		edges = this.adjList.get(vertex.getID());
    		hasNewVer = false;
    		
    		for(int i = 0; i < edges.size(); i++) {
    			if(!(this.vertexList.get(edges.get(i)).getColor() == "white")) {
    				cycle = true;
    			}
    		}
    		//For loop takes the edges of the vertex at the top of the stack and uses them to determine
    		//the next step in the path or if we've found the end of the path
    		for(int i = 0; i < edges.size(); i++) {
    			
    			verToCheck = this.vertexList.get(edges.get(i));
    			//Using a boolean to see if there's already a new vertex on the stack, this else if statement determines if the 
    			//vertex we are looking at is the vertex the user wanted to find and then says if there is a cycle or not.
    			if(end.getID() == verToCheck.getID() && hasNewVer == false){
    				if(cycle) {
    					return "[Cycle]: Cycle detected";
    				}
    				else {
    					return "[Cycle]: No cycle detected";
    				}
    			}//end if statement
    			
    			//Using a boolean to see if there's already a new vertex on the stack, this else if statement determines if the 
    			//vertex we are looking at is new to the stack and pushes the new vertex so we can look at its edges in the next loop
    			if(verToCheck.getColor() == "white" && hasNewVer == false) {
    				vertex = verToCheck;
    				vertex.changeColor();
    				search.push(vertex);
    				hasNewVer = true;
    			}
    		}
    		
    		//Using a boolean to see if there were no new vertices connected to the currently being looked at vertex, 
    		//this if statement says if there's been a discovered cycle and if not pops the stack 
    		if(hasNewVer == false){
    			if(cycle) {
    				return "[Cycle]: Cycle detected";
    			}
    			else {
    				vertex.changeColor();
        			search.pop();
    			}
    		}//end if statement
    		
    		//If statement determines if the stack has objects in it and then makes our current vertex the top of the stack 
    		if(!(search.empty())) {
    			vertex = search.peek();
    		}//end if statement
    		
    		//Else determines if the stack has no objects in it, if it is empty, then returns a statement telling the user
    		//there were no cycles
    		else{
    			return "[Cycle]: No cycle detected";
    		}//end else
    		
    	}//end while loop
    	return "[Cycle]: No cycle detected";
    }

    /**
     * Performs the transitive closure algorithm
     */
    public boolean[][] transitiveClosure(){
    	boolean[][] transClos = new boolean[this.adjMatrix.length][this.adjMatrix.length];
    	boolean ijPair;
    	
    	//Sets up the matrix to perform transitive closure
    	for(int i = 0; i < this.adjMatrix.length; i++) {
    		for(int j = 0; j < this.adjMatrix.length; j ++) {
    			transClos[i][j] = this.adjMatrix[i][j];
    		}
    	}
    	
    	//Performs the Transitive Closure
    	//h is the row and column currently selected
    	for(int h = 0; h < this.adjMatrix.length; h++) {
    		//i is the starting vertex
    		for(int i = 0; i < this.adjMatrix.length; i++) {
    			//j is the destination vertex
    			for(int j = 0; j < this.adjMatrix.length; j++) {
    				
    				ijPair = this.adjMatrix[h][j] && this.adjMatrix[i][h];
    				this.adjMatrix[i][j] = this.adjMatrix[i][j] || ijPair;
    				
    			}
    		}
    	}
    	
    	return transClos;
    	
    }

    /**
     * Prints the information as specified in the hand-out.
     *
     * @return String - Information to be returned
     */
    public void printGraphStats(){
    	
        return;
    }

}

