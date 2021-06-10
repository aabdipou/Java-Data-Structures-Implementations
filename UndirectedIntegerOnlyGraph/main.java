package UndirectedIntegerOnlyGraph;

import java.util.*;

public class main {
    public static void main(String[] args){
        
        /*
        * Creating Graph with form:
        *
        *    0 - 3 - 5 - 1
        *    |           |
        *    4 - - - - - 2
        */

        myGraph testGraph = new myGraph(6);
        
        testGraph.addEdge(0, 3);
        testGraph.addEdge(3, 5);
        testGraph.addEdge(5, 1);
        testGraph.addEdge(1, 2);
        testGraph.addEdge(0, 4);
        testGraph.addEdge(4, 2);

        System.out.println(testGraph.toString());
        System.out.println(testGraph.isConnected(5, 3));
        System.out.println(testGraph.isConnected(1, 3));
        
        graphSearchClass searchAlgorithims = new graphSearchClass(testGraph);

        //performing a bfs
        Integer[] bfs = searchAlgorithims.performBreadthFirstSearch(0);
        System.out.println(Arrays.toString(bfs));
        
        //getting the shortest path from two nodes after the bfs
        List<Integer> shortestPath = searchAlgorithims.getShortestPath(bfs, 0, 2);
        System.out.println(shortestPath.toString()); //returns [0, 4, 2] (the shortest path to 2 from 0)

        List<Integer> dfs = searchAlgorithims.performDepthFirstSearch(0);
        System.out.println(dfs.toString()); 


    }
}
