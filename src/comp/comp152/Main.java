package comp.comp152;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    static boolean dfsRecurFound = false;

    public static void main(String[] args) {
        String targetData = "Z";
        var E = buildGraph();

        System.out.println("BFS (Iterative)\n---------------");
        boolean bfsFound = bfs(E, targetData);

        E = buildGraph();
        System.out.println("search done\n\nDFS (Iterative)\n---------------");
        boolean dfsIterFound = dfsIterative(E, targetData);

        E = buildGraph();
        System.out.println("search done\n\nDFS (Recursive)\n---------------");
        dfsRecursive(E, targetData);

        System.out.println("search done\n\nRESULTS\n-------");
        String output = "";
        if (bfsFound)
            output = output + "BFS found " + targetData + ".";
        if (dfsIterFound)
            output = output + "DFS (Iterative) found " + targetData + ".\n";
        if (dfsRecurFound)
            output = output + "DFS (Recursive) found " + targetData + ".\n";

        if (!output.equalsIgnoreCase(""))
            System.out.println(output);
        else
            System.out.println("Searches did not find " + targetData + ".");
    }

    public static boolean bfs(comp.comp152.Node start, String targetData) {
        Queue<comp.comp152.Node> queue = new LinkedList<>();
        queue.add(start);
        while(queue.size()>0) {
            var current = queue.remove();
            if(current.data==targetData){
                return true;
            }
            else {
                current.visit();
                for(var n: current.neighbors){
                    if(!n.visited &&!queue.contains(n)) {
                        queue.add(n);
                    }
                }
            }
        }
            return false;
    }

    public static boolean dfsIterative(comp.comp152.Node start, String targetData) {
        Stack<comp.comp152.Node> stack = new Stack<>();
        stack.push(start);
        while(stack.size()>0) {
            var current = stack.pop();

            if(current.data==targetData){
                return true;
            } else {
                current.visit();
                for(var n: current.neighbors) {
                    if(!n.visited&&!stack.contains(n)) {
                        stack.push(n);
                    }
                }
            }
        }
        return false;
    }

    public static void dfsRecursive(comp.comp152.Node current, String targetData) {
        if(current.data==targetData) {
            dfsRecurFound = true;
        } else {
            current.visit();
            for(var n: current.neighbors){
                if(!n.visited&&!dfsRecurFound){
                    dfsRecursive(n, targetData);
                }
            }
        }
    }

    public static comp.comp152.Node buildGraph() {
        var A = new comp.comp152.Node("A");
        var B = new comp.comp152.Node("B");
        var C = new comp.comp152.Node("C");
        var D = new comp.comp152.Node("D");
        var E = new comp.comp152.Node("E");
        var F = new comp.comp152.Node("F");
        var G = new comp.comp152.Node("G");
        var H = new comp.comp152.Node("H");
        var I = new comp.comp152.Node("I");
        A.neighbors = new comp.comp152.Node[]{E};
        B.neighbors = new comp.comp152.Node[]{C, E, F, I};
        C.neighbors = new comp.comp152.Node[]{B};
        D.neighbors = new comp.comp152.Node[]{F};
        E.neighbors = new comp.comp152.Node[]{A, B, G};
        F.neighbors = new comp.comp152.Node[]{B, D, H};
        G.neighbors = new comp.comp152.Node[]{E};
        H.neighbors = new comp.comp152.Node[]{F, I};
        I.neighbors = new comp.comp152.Node[]{B, H};
        return E;
    }
}