package UndirectedGenericGraph;
import java.util.*;

public class myGraph<T>{
    
    public Map<T, List<T>> map = new HashMap<>();
    
    /*
    * Add Vertex
    */
    public void addVertex(T data){
        map.put(data, new LinkedList<T>());
    }

    public List<T> getAdjList(T key){
        return map.get(key);
    }

    /*
    * Adds an edge to the graph by adding the nodes to each respective adjencency list element. 
    */
    public void addEdge(T source, T destination){
        if(!map.containsKey(source)) addVertex(source);
        if(!map.containsKey(destination)) addVertex(destination);

        map.get(source).add(destination);
        map.get(destination).add(source); 
    }
    /*s
    * Check to see if two nodes are connected via an edge
    */
    public boolean isConnected(Object source, Object destination){
        for(T entry : map.get(source)){
            if(entry == destination) return true;
        }
        return false;
    }

    @Override
    public String toString(){
        String result = "";
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            result += pair.getKey() + "-->" + pair.getValue()+  '\n';
    }
        return result;
    }
}