
package graphs;

import java.util.*;

public class Traversals {

    public Traversals(){}

    public void dfs(Graph graph, Node s) {
        Map<Node,Boolean> visited = new HashMap<>();
        Iterator<Node> itr = graph.getAllNodes().iterator();
        while(itr.hasNext()){
            visited.put(itr.next(),false);
        }
        Stack<Node> stack = new Stack<>();
        stack.push(s);
        System.out.println("visited size : "+visited.size());
        while(!stack.empty()) {
            s = stack.peek();
            stack.pop();
            if(!visited.get(s)) {
                System.out.print(s + " ");
                visited.put(s, true);
            }
            itr  = graph.getAllNeighbours(s).iterator();
            while (itr.hasNext()) {
                Node n = itr.next();
                if(!visited.get(n))
                    stack.push(n);
            }
        }
    }
}

