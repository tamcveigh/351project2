import java.util.*;
import java.io.*;
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

    public Graph(ArrayList<Integer> nums){
        
        this.makeVertexList(nums);
		this.makeAdjList(nums);
		this.makeAdjMatrix();
    }


    private void makeAdjMatrix() {
    	this.adjMatrix = new boolean[vertexList.size()][vertexList.size]();		
	}


	/**
     * Helper function for main, creates the vertexList
     * field
     * 
     * @param nums
     */
    private void makeVertexList(ArrayList<Integer> nums) {
    	
    	this.vertexList = new ArrayList<Vertex>(nums.size());
    	
    	for(int i : nums) {
    		if( vertexList.get(i) == null ) {
    			vertexList.add(i, new Vertex(i));
    		}  		
    	}
    	this.vertexList.trimToSize();
    	
    }
    
    /**
     * Helper method for constructor. Creates the adjList field
     * 
     * @param nums the inputed edge list
     */
    private void makeAdjList(ArrayList<Integer> nums) {
		
		
		this.adjList = new ArrayList<ArrayList<Integer>>(this.vertexList.size());
		
		for(ArrayList<Integer> i : adjList){
		    i = new ArrayList<Integer>(this.vertexList.size());
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
     * Entry point to run operations specified in the handout.
     */
    public void go(){

    }

    /**
     * Finds the source and destination vertices. On invalid input, asks the
     * user to enter new vertices.
     *
     * @throws IllegalArgumentException if the source and destination vertices
     * are not found in the graph.
     */
    public void findSourceDest(){

    }

    /**
     * Performs a depth-first search from source to destination or until the 
     * search is exhausted
     */
    public void depthFirstSearch(){

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

    }

    /**
     * Prints the information as specified in the handout.
     *
     * @return String - Information to be returned
     */
    public String printGraphStats(){
        return "Hello World";
    }





}

