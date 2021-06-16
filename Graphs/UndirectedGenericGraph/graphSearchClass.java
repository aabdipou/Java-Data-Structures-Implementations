package Graphs.UndirectedGenericGraph;
import java.util.*;

public class graphSearchClass<T> {
    myGraph graph;
    public graphSearchClass(myGraph graph){
        this.graph = graph;
    }
    /*
    * Method to peform a BFS search of a given graph from a specified start node 
    */
    public Map<Object, Object> performBreadthFirstSearch(T start){
        Queue<T> queue = new LinkedList<>();
        queue.add(start);       
        Map<Object, Boolean> visited = new HashMap<>();
        Map<Object, Object> prev = new HashMap<>();        
        for (Object key : graph.map.keySet()) {
            visited.put(key, Boolean.FALSE);
            prev.put(key, null);
        }      
        visited.replace(start, Boolean.TRUE);     
        while(!queue.isEmpty()){
            T node = queue.poll();
            List<T> neighbors = graph.getAdjList(node);          
            for(T next : neighbors){
                if(visited.get(next) == Boolean.FALSE){
                    queue.add(next);
                    visited.replace((Object)next, Boolean.TRUE);
                    prev.replace((Object)next, node);
                }
            }
        }
        return prev;
    }   

    /*
    * Method takes in the Integer array supplied by running the above BFS algorithim and returns the shortest
    * path between two nodes, if possible at all. if not possible (i.e the graph is disjoint) it will return
    * an empty list. 
    */
    public List getShortestPath(Map<T, T> prevMap, T start, T end){
        List<T> path = new ArrayList<>();
        T current = end;
        path.add(end);
        while(prevMap.get(current) != null){
            path.add(prevMap.get(current));
            current = prevMap.get(current);
        }
        reverseListInPlace(path);
        if(path.get(0) == start) return path;
        return Collections.emptyList();
    }
    
    /*
    * Method to reverse a list in place to save on space complexity when using built in function. 
    * Simply has two pointers on each side and swaps the two elements until the pointers meet at the mid point 
    * of the passed through list. 
    */
    private void reverseListInPlace(List<T> list){
        System.out.println(list);
        int i = 0;
        int j = list.size()-1;
        while(i != j){
            T temp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, temp);
            i++;
            j--;
        }
    }

    public List performDepthFirstSearch(T currentNode){
        Map<Object, Boolean> visited = new HashMap<>();
        for(Object key : graph.map.keySet()){
            visited.put(key, Boolean.FALSE);
        }
        List<Object> dfs = new ArrayList<>();
        dfsHelper(currentNode, dfs, visited);
        return dfs;
    }

    private void dfsHelper(Object currentNode, List<Object> list, Map<Object, Boolean> visited){
        if(visited.get(currentNode) == Boolean.TRUE) return;
        visited.replace(currentNode, Boolean.TRUE);
        list.add(currentNode);
        List<T> neighbors = graph.getAdjList(currentNode);  
        for(T next: neighbors){
            dfsHelper(next, list, visited);
        }
    }
}
