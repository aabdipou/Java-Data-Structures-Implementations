package UndirectedGenericGraph;

import java.util.*;

public class main {
    public static void main(String[] args){
        
        /*
        * Creating Graph with form:
        *
        *    Arshia - Justin - Zenen - Ryan
        *    |                          | 
        *    Kooks - - - - - - - - - - Ali
        */

        myGraph testGraph = new myGraph();
        
        Person arshia = new Person(23, "Arshia", "Abdipour");
        Person justin = new Person(23, "Justin", "Bardino");
        Person zenen = new Person(23, "Zenen", "Hornst");
        Person ali = new Person(23, "Ali", "Abdipour");
        Person kooks = new Person(23, "Kooks", "Fooks");
        Person ryan = new Person(23, "Ryan", "Schmi");

        testGraph.addEdge(arshia, kooks);
        testGraph.addEdge(arshia, justin);
        testGraph.addEdge(justin, zenen);
        testGraph.addEdge(ryan, zenen);
        testGraph.addEdge(kooks, ali);
        testGraph.addEdge(ryan, ali);

        System.out.println(testGraph.toString());
        System.out.println(testGraph.isConnected(arshia, zenen));
        
        graphSearchClass searchAlgorithims = new graphSearchClass(testGraph);

        //performing a bfs
        Map<Person, Person> bfs = searchAlgorithims.performBreadthFirstSearch(arshia);
        System.out.println(bfs.toString());
        
        //getting the shortest path from two nodes after the bfs
        List<Person> shortestPath = searchAlgorithims.getShortestPath(bfs, arshia, ali);
        System.out.println(shortestPath.toString()); 

        List<Integer> dfs = searchAlgorithims.performDepthFirstSearch(arshia);
        System.out.println(dfs.toString()); 
    }
}
