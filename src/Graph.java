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

    public Graph(int[] adjInt){
        Vertex vertex;
        int count = 0;
        int index;
        ArrayList<Integer> inside;
                //Vertex List//
                
               

                /*while(sc.hasNextInt()){
                    count++;
                    sc.nextInt();
                }*/


                //Initializes all the elements to null so the vertices can be
                //set in order
                sc = new Scanner(input);
                this.vertexList = new ArrayList<Vertex>(count);
                for(int i = 0; i < count; i++){
                    this.vertexList.add(null);
                }
                //Puts the elements in order and then changes the capacity to 
                //the list's size
                while(sc.hasNextInt()){
                    vertex = new Vertex(sc.nextInt());
                    if(!(this.vertexList.contains(vertex))){
                        this.vertexList.set(vertex.getID(), vertex);
                    }
                }
                this.vertexList.trimToSize();
                

                //Adjacency List//
                

                this.adjList = new ArrayList(this.vertexList.size());
                
                for(ArrayList<Integer> i in adjList){
                    i = new ArrayList(this.vertexList.size());
                }

                sc = new Scanner(input);
                
                //Need to convert all scanners to take characters
                while(sc.hasNext()){
                    
                    int origin = sc.next();

                    if(sc.hasNext()){
                        int destination = sc.next();
                        adjList.get(origin).add(destination);
                    }else{
                        throw inputexception
                    }
                }

                
                /**for(int i = 0; i < this.adjList.size(); i++){
                    this.adjList.add(null);
                }
                for(int i = 0; i < this.vertexList.size(); i++){
                    sc = new Scanner(input);
                    count = 0;
                    inside = new ArrayList();
                    while(sc.hasNextInt()){
                        if(count%2 != 0){
                            vertex = new Vertex(sc.nextInt());
                            index = this.vertexList.indexOf(vertex);
                            inside.add(count+1);
                        }




                        if(adjList.get(index) == null)
                            adjList.set(index, inside);
                }**/
        
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

