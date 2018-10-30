/**
 * @author Tyler McVeigh and Mi'Quel Muldrow
 * @version October 25, 2018 Version 1.0
 */
public class Vertex{
    /** Unique integer corresponding to a vertex's id number.*/
    public int id;

    /** 
     * Color of the vertex: white = unvisited, gray = currently being viewed,
     * black = visisted
     */
    public String color;
    
    /**
     * Constructs a vertex with an id that the user passes through, also gives
     * the vertex a default color of white.
     *
     * @param int id - ID of the new vertex
     */
    public Vertex(int id){
        this.id = id;
        this.color = "white";
    }

    /**
     * Changes the color of the vertex depending on its current color.
     */
    public void changeColor(){
        if(this.color == "white")
            this.color = "gray";
        else if(this.color == "gray")
            this.color = "black";
        else if(this.color == "black")
            System.out.println("color is black, something is wrong");
    }

    /**
     * Returns the ID of the vertex.
     *
     * @return vertex ID
     */
    public int getID(){
        return this.id;
    }

    /**
     * Returns the color of the vertex.
     *
     * @return vertex color
     */
    public String getColor(){
        return this.color;
    }
    
}

