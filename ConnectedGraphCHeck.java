package graphs;

import java.util.Scanner;

public class ConnectedGraphCHeck {
    static Graph graph = new Graph();

    /**
     * Method to get different pair of the cities from user input
     * @param scanner
     */
    public static void readMap(Scanner scanner) {

        // getting the pair of nodes from the input until an empty line is found
        while (true) {

            // read the current line of input
            String line = scanner.nextLine();

            // break the loop when the line is empty
            if (line.equals("")) {
                break;
            }

            readLine(line);
        }
    }

    /**
     * Method to read a line consisting of a pair of cities separated by comma
     * @param line
     */
    public static void readLine(String line) {
        String[] nodes = line.split(",");
        String n1 = nodes[0];
        String n2 = nodes[1];

        // add an edge between the two cities
        graph.addEdge(new Node(n1), new Node(n2));
    }

    public static void main(String[] args) {
        //Scanner sc = new Scanner(System.in);

        //readMap(sc);

        // getting input from the user as the source node
        //String sourceNode = sc.next();
        graph.addEdge(new Node("Mumbai"),new Node("Warangal"));
        graph.addEdge(new Node("Warangal"),new Node("Pennsylvania"));
        graph.addEdge(new Node("Pennsylvania"),new Node("California"));


        String sourceNode = "Pennsylvania";

        if(graph.isGraphConnected(new Node<>(sourceNode))){
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}

