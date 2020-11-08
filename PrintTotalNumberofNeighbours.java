package graphs;

import java.util.LinkedList;
import java.util.Scanner;

public class PrintTotalNumberofNeighbours {
    public static void main(String args[]){
        // instantiating Graph class
        Graph graph = new Graph();

        // adding nodes to the graph
        Node<Integer> n1 = new Node(1);
        Node<Integer> n2 = new Node(2);
        Node<Integer> n3 = new Node(3);
        Node<Integer> n4 = new Node(4);
        Node<Integer> n5 = new Node(5);

        // adding edges to the graph
        graph.addEdge(n1, n2);
        graph.addEdge(n1, n3);
        graph.addEdge(n1, n4);
        graph.addEdge(n1, n5);
        graph.addEdge(n2, n4);
        graph.addEdge(n4, n5);

        // list to store all the neighbours of a given node
        LinkedList<Node> neighboursList = new LinkedList<>();

        Scanner sc = new Scanner(System.in);

        // getting input from the user to get the value of the node for which the neighbours are to be found
        int n = sc.nextInt();
        switch (n) {
            case 1:
                neighboursList = graph.getAllNeighbours(n1);
                break;
            case 2:
                neighboursList = graph.getAllNeighbours(n2);
                break;
            case 3:
                neighboursList = graph.getAllNeighbours(n3);
                break;
            case 4:
                neighboursList = graph.getAllNeighbours(n4);
                break;
            case 5:
                neighboursList = graph.getAllNeighbours(n5);
                break;
        }

        // printing all the neighbours of the given node
        graph.printAllNeighbours(neighboursList);
    }
}
