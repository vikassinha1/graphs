package graphs;

import java.util.*;

class Edgeq {
    public String n1;
    public String n2;

    public Edgeq(String n1, String n2) {
        this.n1 = n1;
        this.n2 = n2;
    }
}

class Graphq {
    Map<String, LinkedList<Edgeq>> graph = new HashMap<>();
    /**
     * Method to add a given node to the graph
     * @param node
     */
    public void addNode(String node) {
        this.graph.put(node, new LinkedList<>());
    }

    /**
     * Method to add a node between two given nodes
     * @param n1
     * @param n2
     */
    public void addEdge(String n1, String n2) {
        if (!this.graph.containsKey(n1)) {
            addNode(n1);
        }
        if (!this.graph.containsKey(n2)) {
            addNode(n2);
        }
        Edgeq edge = new Edgeq(n1, n2);
        this.graph.get(n1).add(edge);

        edge = new Edgeq(n2, n1);
        this.graph.get(n2).add(edge);
    }

    /**
     * Method to get all the nodes in the graph
     * @return
     */
    public Set<String> getAllNodes() {
        return this.graph.keySet();
    }

    /**
     * Method to get all the edges connecting with the given node
     * @param node
     * @return
     */
    public LinkedList<Edgeq> getAllEdges(String node) {
        return this.graph.get(node);
    }

    /**
     * Method to get all the neighbours of the given node
     * @param node
     * @return
     */
    public LinkedList<String> getAllNeighbours(String node) {
        LinkedList<Edgeq> edgesList = getAllEdges(node);
        LinkedList<String> neighboursList = new LinkedList<>();
        for (Edgeq edge : edgesList) {
            neighboursList.add(edge.n2);
        }
        return neighboursList;
    }

    public int dfs(String node) {
        int nodeVisitCount = 0;
        Map<String,Boolean> visited = new HashMap<>();
        Iterator<String> itr = getAllNodes().iterator();
        while(itr.hasNext()){
            visited.put(itr.next(),false);
        }
        Stack<String> stack = new Stack<>();
        stack.push(node);
        System.out.println("visited size : "+visited.size());
        while(!stack.empty()) {
            String s = stack.peek();
            stack.pop();
            if(!visited.get(s)) {
                System.out.print(s + " ");
                nodeVisitCount++;
                visited.put(s, true);
            }
            itr  = getAllNeighbours(s).iterator();
            while (itr.hasNext()) {
                String n = itr.next();
                if(!visited.get(n))
                    stack.push(n);
            }
        }
        return nodeVisitCount;
    }

    public boolean isGraphConnected(String sourceNode){

        if((dfs(sourceNode) - getAllNodes().size()) != 0){
            return false;
        } else {
            return true;
        }
    }
}

public class IsConnected {
    static Graphq graph = new Graphq();
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
        graph.addEdge(n1, n2);
    }
    public static void main(String[] args) {
        /*Scanner sc = new Scanner(System.in);
        readMap(sc);
        // getting input from the user as the source node
        String sourceNode = sc.next();
        */
        graph.addEdge("Mumbai","Warangal");
        graph.addEdge("Warangal","Pennsylvania");
        graph.addEdge("Pennsylvania","California");
        //graph.addEdge("Montevideo","Jameka");


        String sourceNode = "Pennsylvania";

        if(graph.isGraphConnected(sourceNode)){
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
