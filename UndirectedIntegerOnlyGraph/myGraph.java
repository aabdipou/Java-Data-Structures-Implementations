package UndirectedIntegerOnlyGraph;
import java.util.*;

public class myGraph{
    
    List<Integer> adjList[]; 
    
    /*
    * Constructor 
    */
    public myGraph(int numOfNodes){
        adjList = new LinkedList[numOfNodes];
        for(int i = 0; i < numOfNodes; i++){
            adjList[i] = new LinkedList<Integer>();
        }
    }

    /*
    * Adds an edge to the graph by adding the nodes to each respective adjencency list element. 
    */
    public void addEdge(int u, int v){
        adjList[u].add(v);
        adjList[v].add(u);
    }
    /*
    * Check to see if two nodes are connected via an edge
    */
    public boolean isConnected(int u, int v){
        for(int entry : adjList[u]){
            if(entry == v) return true;
        }
        return false;
    }

    @Override
    public String toString(){
        String result = "";
        for(int i = 0; i < adjList.length; i ++){
            result += i + "-->" +adjList[i] + '\n';
        }
        return result;
    }
}