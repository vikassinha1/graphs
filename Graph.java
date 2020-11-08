package graphs;

import java.util.*;

class Node<T> {
    private T value;

    public Node(T value) {
        this.value = value;
    }

    public String toString() {
        return this.value.toString();
    }
}

class Edge<T> {
    public final Node<T> n1;
    public final Node<T> n2;

    Edge(Node<T> n1, Node<T> n2) {
        this.n1 = n1;
        this.n2 = n2;
    }

    public String toString(){
        return "Node n1 = "+n1.toString()+" n2 = "+n2.toString();
    }
}

class Graph<T> {
    Map<Node<T>, LinkedList<Edge>> graph = new HashMap<>();

    /**
     * Method to add a given node to the graph
     *
     * @param node
     * @return
     */
    public void addNode(Node<T> node) {
        this.graph.put(node, new LinkedList<Edge>());
    }

    /**
     * Method to add an edge between two given nodes
     *
     * @param n1
     * @param n2
     */
    public void addEdge(Node<T> n1, Node<T> n2) {
        if(!graph.containsKey(n1)){
            addNode(n1);
            System.out.println("adding node n1 : "+n1.toString());
        }

        if(!graph.containsKey(n2)){
            addNode(n2);
            System.out.println("adding node n1 : "+n2.toString());
        }

        Edge edge = new Edge(n1, n2);
        System.out.println("new edge : "+edge.toString()+" : "+graph.containsKey(n1));
        this.graph.get(n1).add(edge);
        edge = new Edge(n2, n1);
        this.graph.get(n2).add(edge);
    }

    /**
     * Method to get all the nodes in the graph
     *
     * @return
     */
    public Set<Node<T>> getAllNodes() {
        return this.graph.keySet();
    }

    /**
     * Method to get all the nodes in the graph
     *
     * @return
     */
    public int getAllNodeCount() {
        return this.graph.keySet().size();
    }


    /**
     * Method to get all the edges in the graph
     *
     * @param node
     * @return
     */
    public LinkedList<Edge> getAllEdges(Node<T> node) {
        return this.graph.get(node);
    }

    /**
     * Method to get all the neighbours of the given node
     *
     * @param node
     * @return
     */
    public LinkedList<Node> getAllNeighbours(Node<T> node) {
        LinkedList<Node> neighbours = new LinkedList<>();
        Iterator<Edge> itr = this.graph.get(node).listIterator();
        while(itr.hasNext()){
            Edge e = itr.next();
            System.out.println(e.toString());
            neighbours.add(e.n2);
        }
        return neighbours;
    }

    /**
     * Method to print all the neighbours in the given list of neighbours
     *
     * @param neighboursList
     */
    public void printAllNeighbours(LinkedList<Node> neighboursList) {
        Iterator<Node> itr = neighboursList.iterator();
        while(itr.hasNext()){
            System.out.print(itr.next().toString()+" ");
        }
        System.out.println();
    }

    public boolean areAdjacent(String node1, String node2) {
        LinkedList<Edge> l1 = this.getAllEdges(new Node(node1));
        Iterator<Edge> itr = l1.iterator();
        while(itr.hasNext()){
            if(itr.next().n2.toString().compareTo(node2) == 0){
                return true;
            }
        }
        return false;
    }

    public boolean isGraphConnected(Node node){
        Traversals traversals = new Traversals();
        traversals.dfs(this,node);
        return false;
    }
}
