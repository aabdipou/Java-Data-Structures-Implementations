package UndirectedNonweightedIntegerOnlyGraph;
import java.util.*;

public class graphSearchClass {
    myGraph graph;
    public graphSearchClass(myGraph graph){
        this.graph = graph;
    }
    /*
    * Method to peform a BFS search of a given graph from a specified start index 
    */
    public Integer[] performBreadthFirstSearch(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        boolean[] visited = new boolean[graph.adjList.length];
        visited[start] = true;

        Integer[] prev = new Integer[graph.adjList.length];
        while(!queue.isEmpty()){
            int node = queue.poll();
            List<Integer> neighbors = graph.adjList[node];
            for(int next : neighbors){
                if(!visited[next]){
                    queue.add(next);
                    visited[next] = true;
                    prev[next] = node;
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
    public List getShortestPath(Integer[] arr, int start, int end){
        List<Integer> path = new ArrayList<>();
        for(Integer i = end; i != null; i = arr[i]){
            path.add(i);
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
    private void reverseListInPlace(List<Integer> list){
        int i = 0;
        int j = list.size()-1;
        while(i != j){
            Integer temp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, temp);
            i++;
            j--;
        }
    }

    public List performDepthFirstSearch(int currentNode){
        boolean[] visited = new boolean[graph.adjList.length];
        List<Integer> dfs = new ArrayList<>();
        dfsHelper(currentNode, dfs, visited);
        return dfs;
    }

    private void dfsHelper(int currentNode, List<Integer> list, boolean[] visited){
        if(visited[currentNode]) return;
        visited[currentNode] = true;
        list.add(currentNode);
        for(int next: graph.adjList[currentNode]){
            dfsHelper(next, list, visited);
        }
    }
}
